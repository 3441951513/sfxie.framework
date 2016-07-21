package com.sfxie.extension.aliyun.oss.filter;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.Filter;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.GetObjectRequest;
import com.aliyun.oss.model.OSSObject;

public class OssImgFilter implements Filter {

	private String endpoint;
	private String accessKeyId;
	private String accessKeySecret;
	private String bucketName;

	private void donwloadFile(String path, HttpServletResponse response) {
//		String path = "decoratioin/object-get-progress-sample.jpg";

		OSSClient client = new OSSClient(endpoint, accessKeyId, accessKeySecret);

		try {
			// 带进度条的下载
			if(path.startsWith("/")){
				path = path.replaceFirst("/", "");
			}
			OSSObject obj = client.getObject(new GetObjectRequest(bucketName,path));
			response.getOutputStream().write(
					toByteArray(obj.getObjectContent()));
			response.flushBuffer();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static byte[] toByteArray(InputStream input) throws IOException {
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		copy(input, output);
		return output.toByteArray();
	}

	public static int copy(InputStream input, OutputStream output)
			throws IOException {
		long count = copyLarge(input, output);
		if (count > 2147483647L) {
			return -1;
		}
		return (int) count;
	}

	public static long copyLarge(InputStream input, OutputStream output)
			throws IOException {
		byte[] buffer = new byte[4096];
		long count = 0L;
		int n = 0;
		while (-1 != (n = input.read(buffer))) {
			output.write(buffer, 0, n);
			count += n;
		}
		return count;
	}

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filterChain) throws IOException, ServletException {
//		((HttpServletResponse) response).setHeader("Cache-Control", "no-cache");
//		((HttpServletResponse) response).setHeader("Pragma", "no-cache");
//		((HttpServletResponse) response).setDateHeader("Expires", -1);
		
		HttpServletRequest request1 = (HttpServletRequest)request;
        String context = request1.getContextPath();
        String url = request1.getRequestURI().replace(context, "");
        
		if(filterImg(url)){
			donwloadFile(url,(HttpServletResponse) response);
		}else{
			filterChain.doFilter(request, response);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		endpoint = arg0.getInitParameter("endpoint");
		accessKeyId = arg0.getInitParameter("accessKeyId");
		accessKeySecret = arg0.getInitParameter("accessKeySecret");
		bucketName = arg0.getInitParameter("bucketName");
		
	}

	public boolean filterImg(String url) {
		if (url.startsWith("/uploadfile") && (url.endsWith(".gif") || url.endsWith(".jpg")
				|| url.endsWith(".png") || url.endsWith(".bmp"))) {
			return true;
		} else {
			return false;
		}
	}
}
