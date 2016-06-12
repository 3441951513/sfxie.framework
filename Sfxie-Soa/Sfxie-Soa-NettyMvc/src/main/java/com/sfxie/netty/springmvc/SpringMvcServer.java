package com.sfxie.netty.springmvc;



import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * spring mvc与netty4整合的服务器类
 * @TODO	
 * @author 	xieshengfeng
 * @email  	xsfcy@126.com
 * @since 	下午5:21:17 2016年5月24日
 * @example		
 *
 */
public class SpringMvcServer {
	
	private SpringMvcChannelInitializer springMvcChannelInitializer;
	
	private  String host; 

	private  int port;
	
	private SpringMvcServer(){}

	public void run() throws Exception {
		EventLoopGroup bossGroup = new NioEventLoopGroup(); 
		EventLoopGroup workerGroup = new NioEventLoopGroup();
		try {
			ServerBootstrap server = new ServerBootstrap();
			server.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class) 
					.childHandler(springMvcChannelInitializer).option(ChannelOption.SO_BACKLOG, 128) ; 
			ChannelFuture channelFuture = server.bind(host, port).sync();
			channelFuture.channel().closeFuture().sync();
		}finally {
			workerGroup.shutdownGracefully();
	        bossGroup.shutdownGracefully();
		}
	}

	public void setHost(String host) {
		this.host = host;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public void setSpringMvcChannelInitializer(
			SpringMvcChannelInitializer springMvcChannelInitializer) {
		this.springMvcChannelInitializer = springMvcChannelInitializer;
	}
	
	
}
