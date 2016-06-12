package org.imlsz.nettyspringmvc.netty;

import static io.netty.handler.codec.http.HttpHeaders.isKeepAlive;
import static io.netty.handler.codec.http.HttpHeaders.setContentLength;
import static io.netty.handler.codec.http.HttpHeaders.Names.CONNECTION;
import static io.netty.handler.codec.http.HttpHeaders.Names.CONTENT_LENGTH;
import static io.netty.handler.codec.http.HttpHeaders.Names.CONTENT_TYPE;
import static io.netty.handler.codec.http.HttpResponseStatus.BAD_REQUEST;
import static io.netty.handler.codec.http.HttpResponseStatus.INTERNAL_SERVER_ERROR;
import static io.netty.handler.codec.http.HttpResponseStatus.OK;
import static io.netty.handler.codec.http.HttpVersion.HTTP_1_1;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelProgressiveFuture;
import io.netty.channel.ChannelProgressiveFutureListener;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.DefaultHttpResponse;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.HttpContent;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.HttpResponse;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.codec.http.LastHttpContent;
import io.netty.handler.codec.http.HttpHeaders.Values;
import io.netty.handler.stream.ChunkedFile;
import io.netty.handler.stream.ChunkedStream;
import io.netty.util.CharsetUtil;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map.Entry;

import javax.activation.MimetypesFileTypeMap;
import javax.servlet.Servlet;
import javax.servlet.ServletContext;

import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.web.util.UriUtils;

public class CopyOfServletNettyHandler extends SimpleChannelInboundHandler<FullHttpRequest> {

	private final Servlet servlet;

	private final ServletContext servletContext;

	public CopyOfServletNettyHandler(Servlet servlet) {
		this.servlet = servlet;
		this.servletContext = servlet.getServletConfig().getServletContext();
	}
	/*@Override
	 public void channelRead(ChannelHandlerContext ctx, Object msg)throws Exception {
		HttpRequest request = null;
		HttpContent content = null;
		 if (msg instanceof HttpRequest) {
            request = (HttpRequest) msg;
        }
        if (msg instanceof HttpContent) {
            content = (HttpContent) msg;
        }

		MockHttpServletRequest servletRequest = createServletRequest(request,content);
        MockHttpServletResponse servletResponse = new MockHttpServletResponse();

		this.servlet.service(servletRequest, servletResponse);

        HttpResponseStatus status = HttpResponseStatus.valueOf(servletResponse.getStatus());
		HttpResponse response = new DefaultHttpResponse(HTTP_1_1, status);

		for (String name : servletResponse.getHeaderNames()) {
			for (Object value : servletResponse.getHeaderValues(name)) {
				response.headers().add(name, value);
			}
		}

        // Write the initial line and the header.
        ctx.write(response);
        ctx.flush();

        InputStream contentStream = new ByteArrayInputStream(servletResponse.getContentAsByteArray());

		// Write the content.
        ChannelFuture writeFuture = ctx.write(new ChunkedStream(contentStream));
        writeFuture.addListener(ChannelFutureListener.CLOSE);
    }*/

	private MockHttpServletRequest createServletRequest(FullHttpRequest httpRequest ) {
        UriComponents uriComponents = UriComponentsBuilder.fromUriString(httpRequest.getUri()).build();

		MockHttpServletRequest servletRequest = new MockHttpServletRequest(this.servletContext);
		servletRequest.setRequestURI(uriComponents.getPath());
		servletRequest.setPathInfo(uriComponents.getPath());
		servletRequest.setMethod(httpRequest.getMethod().name());

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

		servletRequest.setContent(httpRequest.content().array());

		try {
			if (uriComponents.getQuery() != null) {
				String query = UriUtils.decode(uriComponents.getQuery(), "UTF-8");
				servletRequest.setQueryString(query);
			}

			for (Entry<String, List<String>> entry : uriComponents.getQueryParams().entrySet()) {
				for (String value : entry.getValue()) {
					servletRequest.addParameter(
							UriUtils.decode(entry.getKey(), "UTF-8"),
							UriUtils.decode(value, "UTF-8"));
				}
			}
		}
		catch (UnsupportedEncodingException ex) {
			// shouldn't happen
		}

		return servletRequest;
	}

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        if (ctx.channel().isActive()) {
            sendError(ctx, INTERNAL_SERVER_ERROR);
        }
    }

    private static void sendError(ChannelHandlerContext ctx, HttpResponseStatus status) {
        HttpResponse response = new DefaultHttpResponse(HTTP_1_1, status);
        response.headers().add(CONTENT_TYPE, "text/plain; charset=UTF-8");
        // Close the connection as soon as the error message is sent.
        ctx.write(response).addListener(ChannelFutureListener.CLOSE);
    }
	@Override
	protected void channelRead0(ChannelHandlerContext ctx, FullHttpRequest request)
			throws Exception {
		/*HttpRequest request = null;
		HttpContent content = null;
		 if (msg instanceof HttpRequest) {
            request = (HttpRequest) msg;
        }
        if (msg instanceof HttpContent) {
            content = (HttpContent) msg;
        }*/
		MockHttpServletRequest servletRequest = createServletRequest(request);
        MockHttpServletResponse servletResponse = new MockHttpServletResponse();

		this.servlet.service(servletRequest, servletResponse);

       /* HttpResponseStatus status = HttpResponseStatus.valueOf(servletResponse.getStatus());
		HttpResponse response = new DefaultHttpResponse(HTTP_1_1, status);

		for (String name : servletResponse.getHeaderNames()) {
			for (Object value : servletResponse.getHeaderValues(name)) {
				response.headers().add(name, value);
			}
		}

        // Write the initial line and the header.
        ctx.write(response);
        ctx.flush();

        InputStream contentStream = new ByteArrayInputStream(servletResponse.getContentAsByteArray());

		// Write the content.
        ChannelFuture writeFuture = ctx.write(new ChunkedStream(contentStream));
        writeFuture.addListener(ChannelFutureListener.CLOSE);*/
		
		System.out.println(servletResponse.getContentAsString());
		HttpResponse response = new DefaultHttpResponse(HTTP_1_1, OK);
		setContentLength(response, servletResponse.getContentLength());
		setContentTypeHeader(response, servletResponse.getContentType());
		if (isKeepAlive(request)) {
			response.headers().set(CONNECTION, HttpHeaders.Values.KEEP_ALIVE);
		}
		System.out.println("TaskRunner thread: "+Thread.currentThread());
		ctx.write(response);
		ctx.flush();
		/*ChannelFuture sendFileFuture;
		sendFileFuture = ctx.write(servletResponse.getContentAsString());
		sendFileFuture.addListener(new ChannelProgressiveFutureListener() {
			@Override
			public void operationProgressed(ChannelProgressiveFuture future,
					long progress, long total) {
				if (total < 0) { // total unknown
					System.err.println("Transfer progress: " + progress);
				} else {
					System.err.println("Transfer progress: " + progress + " / "
							+ total);
				}
			}

			@Override
			public void operationComplete(ChannelProgressiveFuture future)
					throws Exception {
				System.out.println("Transfer complete.");
			}
		});
		ChannelFuture lastContentFuture = ctx
				.writeAndFlush(LastHttpContent.EMPTY_LAST_CONTENT);
		if (!isKeepAlive(request)) {
			lastContentFuture.addListener(ChannelFutureListener.CLOSE);
		}*/
	}
	
	private static void setContentTypeHeader(HttpResponse response,String contentType) {
//		MimetypesFileTypeMap mimeTypesMap = new MimetypesFileTypeMap();
		response.headers().set(CONTENT_TYPE,contentType);
	}

}
