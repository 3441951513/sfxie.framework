package netty4.inaction.nine;


import java.net.InetSocketAddress;

import io.netty.bootstrap.Bootstrap;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * 	从Channel引导客户端
 * 	服务器端与客户端共享eventLoop
	共享EventLoop的好处:
	   	一个EventLoop由一个线程执行，共享EventLoop可以确定所有的Channel都分配给同一线程的EventLoop，
		这样就避免了不同线程之间切换上下文，从而减少资源开销。
 * 
 * @author c.k
 * 
 */
public class BootstrapingFromChannel {
	
	public static void main(String[] args) throws Exception {
		EventLoopGroup bossGroup = new NioEventLoopGroup(1);
		EventLoopGroup workerGroup = new NioEventLoopGroup();
		ServerBootstrap b = new ServerBootstrap();
		b.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class)
				.childHandler(new SimpleChannelInboundHandler<ByteBuf>() {
					ChannelFuture connectFuture;

					@Override
					public void channelActive(ChannelHandlerContext ctx) throws Exception {
						Bootstrap b = new Bootstrap();
						b.channel(NioSocketChannel.class).handler(
								new SimpleChannelInboundHandler<ByteBuf>() {
									@Override
									protected void channelRead0(ChannelHandlerContext ctx,
											ByteBuf msg) throws Exception {
										System.out.println("Received data");
										msg.clear();
									}
								});
						//在此处获取服务器的eventLoop并且共享
						b.group(ctx.channel().eventLoop());
						connectFuture = b.connect(new InetSocketAddress("127.0.0.1", 2048));
					}

					@Override
					protected void channelRead0(ChannelHandlerContext ctx, ByteBuf msg)
							throws Exception {
						if (connectFuture.isDone()) {
							// do something with the data
						}
					}
				});
		ChannelFuture f = b.bind(2048);
		f.addListener(new ChannelFutureListener() {
			@Override
			public void operationComplete(ChannelFuture future) throws Exception {
				if (future.isSuccess()) {
					System.out.println("Server bound");
				} else {
					System.err.println("bound fail");
					future.cause().printStackTrace();
				}
			}
		});
	}
}
