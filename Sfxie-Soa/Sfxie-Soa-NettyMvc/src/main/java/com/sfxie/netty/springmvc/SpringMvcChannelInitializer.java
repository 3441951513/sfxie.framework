package com.sfxie.netty.springmvc;


import org.springframework.beans.factory.InitializingBean;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpRequestDecoder;
import io.netty.handler.codec.http.HttpResponseEncoder;
import io.netty.handler.stream.ChunkedWriteHandler;

/**
 * spring mvc与netty 4整合的channel初始化类<br>
 * 全局唯一
 * @TODO	
 * @author 	xieshengfeng
 * @email  	xsfcy@126.com
 * @since 	下午5:19:11 2016年5月24日
 * @example		
 *
 */

public class SpringMvcChannelInitializer extends ChannelInitializer<SocketChannel>  implements InitializingBean{

	/**
	 * 每次请求都会调用这个方法添加编码器,解码器和业务处理器
	 */
    @Override
    public void initChannel(SocketChannel channel) throws Exception {
        // Create a default pipeline implementation.
        ChannelPipeline pipeline = channel.pipeline();
        // Uncomment the following line if you want HTTPS
        //SSLEngine engine = SecureChatSslContextFactory.getServerContext().createSSLEngine();
        //engine.setUseClientMode(false);
        //pipeline.addLast("ssl", new SslHandler(engine));
        //添加http协议请求参数解码器
	    pipeline.addLast("http-decoder", new HttpRequestDecoder());
	    //添加http请求聚合器
	    pipeline.addLast("http-aggregator",new HttpObjectAggregator(65536));
	    //添加http协议返回值编码器
	    pipeline.addLast("http-encoder",new HttpResponseEncoder());
	    pipeline.addLast("http-chunked",new ChunkedWriteHandler());
	    //添加spring mvc业务处理器
        pipeline.addLast("springMvcHandler", new SpringMvcHandler(SpringNettyInitializer.getInstance().getDispatcherServlet()));
    }


	@Override
	public void afterPropertiesSet() throws Exception {
	}

}
