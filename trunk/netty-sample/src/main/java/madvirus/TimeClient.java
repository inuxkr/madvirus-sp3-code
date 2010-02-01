package madvirus;

import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

import org.jboss.netty.bootstrap.ClientBootstrap;
import org.jboss.netty.channel.ChannelFactory;
import org.jboss.netty.channel.ChannelFuture;
import org.jboss.netty.channel.ChannelFutureListener;
import org.jboss.netty.channel.socket.nio.NioClientSocketChannelFactory;

public class TimeClient {

	public static void main(String[] args) {
		ChannelFactory factory = new NioClientSocketChannelFactory(Executors
				.newCachedThreadPool(), Executors.newCachedThreadPool());

		ClientBootstrap bootstrap = new ClientBootstrap(factory);

		TimeClientHandler handler = new TimeClientHandler();
		bootstrap.getPipeline().addLast("frameDecoder", new TimeDecoder());
		bootstrap.getPipeline().addLast("handler", handler);

		bootstrap.setOption("tcpNoDelay", true);
		bootstrap.setOption("keepAlive", true);

		ChannelFuture future = bootstrap.connect(new InetSocketAddress(
				"localhost", 8080));
		System.out.println("연결시도");
		future.awaitUninterruptibly();
		if (!future.isSuccess()) {
			System.out.println("연결실패");
			future.getCause().printStackTrace();
		}
		future.getChannel().getCloseFuture().awaitUninterruptibly();
		factory.releaseExternalResources();
		System.out.println("연결 종료함");
	}
}
