package com.sfxie.netty.springmvc;

import static io.netty.handler.codec.http.HttpHeaders.Names.CONNECTION;
import static io.netty.handler.codec.http.HttpHeaders.Names.CONTENT_LENGTH;
import static io.netty.handler.codec.http.HttpHeaders.Names.CONTENT_TYPE;
import static io.netty.handler.codec.http.HttpResponseStatus.CONTINUE;
import static io.netty.handler.codec.http.HttpResponseStatus.OK;
import static io.netty.handler.codec.http.HttpVersion.HTTP_1_1;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.HttpResponse;
import io.netty.handler.codec.http.HttpHeaders.Values;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map.Entry;

import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import netty4.sfxie.TaskRunner;

import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.web.util.UriUtils;

public class SpringMvcHandler extends
		SimpleChannelInboundHandler<FullHttpRequest> {

	private final Servlet servlet;

	private final ServletContext servletContext;

	public SpringMvcHandler(Servlet servlet) {
		this.servlet = servlet;
		this.servletContext = servlet.getServletConfig().getServletContext();
	}
	
	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) {
		ctx.flush();
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
		// cause.printStackTrace();
		ctx.close();
	}

	/**
	 * 将netty的request转化成spring mvc的request
	 * @TODO	
	 * @author 	xieshengfeng
	 * @email  	xsfcy@126.com
	 * @since 	上午8:09:47 2016年5月24日
	 * @example
	 * @param httpRequest
	 * @return	
	 *
	 */
	private MockHttpServletRequest createServletRequest(
			FullHttpRequest httpRequest) {
		UriComponents uriComponents = UriComponentsBuilder.fromUriString(
				httpRequest.getUri()).build();

		MockHttpServletRequest servletRequest = new MockHttpServletRequest(this.servletContext);
		servletRequest.setRequestURI(uriComponents.getPath());
		servletRequest.setPathInfo(uriComponents.getPath());
		servletRequest.setMethod(httpRequest.getMethod().name());

		if (httpRequest.content().hasArray()) {
			// 直接获取数组字节
			servletRequest.setContent(httpRequest.content().array());
		} else {
			// 间接获取数组字节
			ByteBuf byteBuf = httpRequest.content();
			byte[] bs = new byte[byteBuf.readableBytes()];
			byteBuf.readBytes(bs);
			servletRequest.setContent(bs);
			
		}
		
		if (uriComponents.getScheme() != null) {
			servletRequest.setScheme(uriComponents.getScheme());
		}
		if (uriComponents.getHost() != null) {
			servletRequest.setServerName(uriComponents.getHost());
		}
		if (uriComponents.getPort() != -1) {
			servletRequest.setServerPort(uriComponents.getPort());
		}

		for (String name : httpRequest.headers().names()) {
			servletRequest.addHeader(name, httpRequest.headers().get(name));
		}
		

		try {
			if (uriComponents.getQuery() != null) {
				String query = UriUtils.decode(uriComponents.getQuery(),
						"UTF-8");
				servletRequest.setQueryString(query);
			}

			for (Entry<String, List<String>> entry : uriComponents
					.getQueryParams().entrySet()) {
				for (String value : entry.getValue()) {
					servletRequest.addParameter(
							UriUtils.decode(entry.getKey(), "UTF-8"),
							UriUtils.decode(value, "UTF-8"));
				}
			}
		} catch (UnsupportedEncodingException ex) {
			// shouldn't happen
		}

		return servletRequest;
	}

	/**
	 * ctx和req是每次请求都生成一个新的对象
	 */
	@Override
	protected void channelRead0(final ChannelHandlerContext ctx,
			final FullHttpRequest req) throws Exception {
		System.out.println(this);
		//只能在前面构造spring mvc的request,因为在非i/o线程外构造会造成线程无限等待
		final MockHttpServletRequest servletRequest = createServletRequest(req);
//		System.out.println(ctx);
		// 开启业务处理线程处理业务逻辑,防止i/o线程阻塞
		TaskRunner.getInstance().submitTask(new Runnable() {
			@Override
			public void run() {
				MockHttpServletResponse servletResponse = new MockHttpServletResponse();
				try {
					servlet.service(servletRequest, servletResponse);
				} catch (ServletException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				if (HttpHeaders.is100ContinueExpected(req)) {
					ctx.write(new DefaultFullHttpResponse(HTTP_1_1, CONTINUE));
				}
				boolean keepAlive = HttpHeaders.isKeepAlive(req);
				FullHttpResponse response = new DefaultFullHttpResponse(
						HTTP_1_1, OK, Unpooled.wrappedBuffer(servletResponse
								.getContentAsByteArray()));
				setContentTypeHeader(response, "text/plain");
				response.headers().set(CONTENT_LENGTH,response.content().readableBytes());
//				System.out.println(ctx);
				if (!keepAlive) {
					ctx.write(response).addListener(ChannelFutureListener.CLOSE);
					//将结果返回
					ctx.flush();
				} else {
					response.headers().set(CONNECTION, Values.KEEP_ALIVE);
					ctx.write(response);
					//将结果返回
					ctx.flush();
				}
			}
		});
	}

	private static void setContentTypeHeader(HttpResponse response,
			String contentType) {
		response.headers().set(CONTENT_TYPE, contentType);
	}
}
