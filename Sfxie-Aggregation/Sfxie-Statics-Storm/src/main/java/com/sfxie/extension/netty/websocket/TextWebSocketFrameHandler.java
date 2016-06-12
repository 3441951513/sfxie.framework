package com.sfxie.extension.netty.websocket;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;

/**
 ** 文件名：TextWebSocketFrameHandler.java
 ** 主要作用：TODO
 *@author 囚徒困境
 *创建日期：2014年12月30日
 */
public class TextWebSocketFrameHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {
	
	private static int counter = 0;
	private final ChannelGroup group;
	
	public TextWebSocketFrameHandler(ChannelGroup group) {
		super();
		this.group = group;
	}
	@Override
	public void userEventTriggered(ChannelHandlerContext ctx, Object evt)
			throws Exception {
		
		if(evt == WebSocketServerProtocolHandler.ServerHandshakeStateEvent.HANDSHAKE_COMPLETE){
			ctx.pipeline().remove(HttpRequestHandler.class);
			counter ++ ;
			group.writeAndFlush(new TextWebSocketFrame("Client "+ctx.channel()+" joined! total counter:  "+counter));
			
			group.add(ctx.channel());
		}else{
			super.userEventTriggered(ctx, evt);
		}
		
	}

	@Override
	protected void channelRead0(ChannelHandlerContext ctx,
			TextWebSocketFrame msg) throws Exception {
		String text = msg.text();
		group.writeAndFlush(msg.retain());
	}
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
			throws Exception {
		ctx.close();
		cause.printStackTrace();
	}
}
