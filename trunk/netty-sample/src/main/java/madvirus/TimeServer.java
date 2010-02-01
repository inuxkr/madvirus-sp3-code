package madvirus;

import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

import org.jboss.netty.bootstrap.ServerBootstrap;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelFactory;
import org.jboss.netty.channel.group.ChannelGroup;
import org.jboss.netty.channel.group.ChannelGroupFuture;
import org.jboss.netty.channel.group.DefaultChannelGroup;
import org.jboss.netty.channel.socket.nio.NioServerSocketChannelFactory;

public class TimeServer {

	static final ChannelGroup allChannels = new DefaultChannelGroup(
			"time.server");

	public static void main(String[] args) {
		ChannelFactory factory = new NioServerSocketChannelFactory(Executors
				.newCachedThreadPool(), Executors.newCachedThreadPool());

		ServerBootstrap bootstrap = new ServerBootstrap(factory);

		TimeServerHandler handler = new TimeServerHandler();
		bootstrap.getPipeline().addLast("frameEncoder", new TimeEncoder());
		bootstrap.getPipeline().addLast("handler", handler);

		bootstrap.setOption("child.tcpNoDelay", true);
		bootstrap.setOption("child.keepAlive", true);

		Channel channel = bootstrap.bind(new InetSocketAddress(8080));
		System.out.println("8080 포트에 바인딩 됨");

		allChannels.add(channel);

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		ChannelGroupFuture future = allChannels.close();
		future.awaitUninterruptibly();
		factory.releaseExternalResources();
		System.out.println("서버 종료됨");
	}
}
