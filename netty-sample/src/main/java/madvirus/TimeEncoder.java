package madvirus;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ChannelPipelineCoverage;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.channel.SimpleChannelHandler;

@ChannelPipelineCoverage("all")
public class TimeEncoder extends SimpleChannelHandler {

	@Override
	public void writeRequested(ChannelHandlerContext ctx, MessageEvent e)
			throws Exception {
		System.out.println("메시지를 인코딩 함");
		UnixTime time = (UnixTime) e.getMessage();

		ChannelBuffer buf = ChannelBuffers.buffer(4);
		buf.writeInt(time.getValue());

		Channels.write(ctx, e.getFuture(), buf);
	}
}
