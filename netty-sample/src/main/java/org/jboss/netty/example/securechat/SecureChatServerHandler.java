/*
 * Copyright 2009 Red Hat, Inc.
 *
 * Red Hat licenses this file to you under the Apache License, version 2.0
 * (the "License"); you may not use this file except in compliance with the
 * License.  You may obtain a copy of the License at:
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */
package org.jboss.netty.example.securechat;

import java.net.InetAddress;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelEvent;
import org.jboss.netty.channel.ChannelFuture;
import org.jboss.netty.channel.ChannelFutureListener;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ChannelPipelineCoverage;
import org.jboss.netty.channel.ChannelStateEvent;
import org.jboss.netty.channel.ExceptionEvent;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.channel.SimpleChannelUpstreamHandler;
import org.jboss.netty.handler.ssl.SslHandler;
import org.jboss.netty.util.internal.MapBackedSet;

/**
 * Handles a server-side channel.
 *
 * @author The Netty Project (netty-dev@lists.jboss.org)
 * @author Trustin Lee (tlee@redhat.com)
 *
 * @version $Rev: 1685 $, $Date: 2009-08-28 16:15:49 +0900 (금, 28 8 2009) $
 */
@ChannelPipelineCoverage("all")
public class SecureChatServerHandler extends SimpleChannelUpstreamHandler {

    private static final Logger logger = Logger.getLogger(
            SecureChatServerHandler.class.getName());

    static final Set<Channel> channels =
        new MapBackedSet<Channel>(new ConcurrentHashMap<Channel, Boolean>());

    @Override
    public void handleUpstream(
            ChannelHandlerContext ctx, ChannelEvent e) throws Exception {
        if (e instanceof ChannelStateEvent) {
            logger.info(e.toString());
        }
        super.handleUpstream(ctx, e);
    }

    @Override
    public void channelConnected(
            ChannelHandlerContext ctx, ChannelStateEvent e) throws Exception {

        // Get the SslHandler in the current pipeline.
        // We added it in SecureChatPipelineFactory.
        final SslHandler sslHandler = ctx.getPipeline().get(SslHandler.class);

        // Get notified when SSL handshake is done.
        ChannelFuture handshakeFuture = sslHandler.handshake(e.getChannel());
        handshakeFuture.addListener(new Greeter(sslHandler));
    }

    @Override
    public void channelDisconnected(
            ChannelHandlerContext ctx, ChannelStateEvent e) throws Exception {
        // Unregister the channel from the global channel list
        // so the channel does not receive messages anymore.
        channels.remove(e.getChannel());
    }

    @Override
    public void messageReceived(
            ChannelHandlerContext ctx, MessageEvent e) {

        // Convert to a String first.
        String request = (String) e.getMessage();

        // Send the received message to all channels but the current one.
        for (Channel c: channels) {
            if (c != e.getChannel()) {
                c.write("[" + e.getChannel().getRemoteAddress() + "] " +
                        request + '\n');
            } else {
                c.write("[you] " + request + '\n');
            }
        }

        // Close the connection if the client has sent 'bye'.
        if (request.toLowerCase().equals("bye")) {
            e.getChannel().close();
        }
    }

    @Override
    public void exceptionCaught(
            ChannelHandlerContext ctx, ExceptionEvent e) {
        logger.log(
                Level.WARNING,
                "Unexpected exception from downstream.",
                e.getCause());
        e.getChannel().close();
    }

    /**
     * @author The Netty Project (netty-dev@lists.jboss.org)
     * @author Trustin Lee (tlee@redhat.com)
     * @version $Rev: 1685 $, $Date: 2009-08-28 16:15:49 +0900 (금, 28 8 2009) $
     */
    private static final class Greeter implements ChannelFutureListener {

        private final SslHandler sslHandler;

        Greeter(SslHandler sslHandler) {
            this.sslHandler = sslHandler;
        }

        public void operationComplete(ChannelFuture future) throws Exception {
            if (future.isSuccess()) {
                // Once session is secured, send a greeting.
                future.getChannel().write(
                        "Welcome to " + InetAddress.getLocalHost().getHostName() +
                        " secure chat service!\n");
                future.getChannel().write(
                        "Your session is protected by " +
                        sslHandler.getEngine().getSession().getCipherSuite() +
                        " cipher suite.\n");

                // Register the channel to the global channel list
                // so the channel received the messages from others.
                channels.add(future.getChannel());
            } else {
                future.getChannel().close();
            }
        }
    }
}
