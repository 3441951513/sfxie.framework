package com.sfxie.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPatch;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.CoreConnectionPNames;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HttpUtils {
	public static final Logger logger = LoggerFactory.getLogger(HttpUtils.class);

	/**
	 * @description 发送Http请求
	 * @param request
	 * @return
	 */
	private static String sendRequest(HttpUriRequest request) {
		HttpClient client = new DefaultHttpClient();
		client.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, 60000) ;
		String line = null;
		StringBuffer sb = new StringBuffer();
		try {
			HttpResponse res = client.execute(request);
			HttpEntity entity = res.getEntity();
			InputStreamReader isr = new InputStreamReader(entity.getContent(), "UTF-8");
			BufferedReader bufr = new BufferedReader(isr);// 缓冲
			while ((line = bufr.readLine()) != null) {
				sb.append(line);
			}
			isr.close();
			if (res.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
				throw new RuntimeException(sb.toString());
			}
		} catch (Exception e) {
			logger.error("HTTP服务存在异常，请检查http地址是否能访问！！", e);
			throw new RuntimeException(e);
		} finally {
			// 关闭连接 ,释放资源
			client.getConnectionManager().shutdown();
		}
		return sb.toString();
	}

	/**
	 * @description 向指定的URL发起一个put请求
	 * @param uri
	 * @param values
	 * @return
	 * @throws IOException
	 */
	public static String doPut(String url, List<NameValuePair> values) throws IOException {
		HttpPut request = new HttpPut(url);

		if (values != null) {
			request.setEntity(new UrlEncodedFormEntity(values));
		}
		return sendRequest(request);
	}

	/**
	 * @description 向指定的URL发起一个GET请求并以String类型返回数据，获取数据总线数据
	 * @param url
	 * @return
	 */
	public static String doGet(String url) {
		HttpGet request = new HttpGet(url);
		return sendRequest(request);
	}

	/**
	 * @description 向指定的URL发起一个post请求
	 * @param url
	 * @return
	 * @throws IOException
	 */
	public static String doPost(String url,String json) throws IOException {
		HttpPost request = new HttpPost(url);
		if (json != null) {
			StringEntity s = new StringEntity(json);
			s.setContentEncoding("UTF-8");    
			s.setContentType("application/json");  
			request.setEntity(s);
		}
		return sendRequest(request);
	}
	/**
	 * @description 向指定的URL发起一个post请求
	 * @param url
	 * @return
	 * @throws IOException
	 */
	public static String doPost(String url,List<NameValuePair> values) throws IOException {
		HttpPost request = new HttpPost(url);
		if (values != null) {
			request.setEntity(new UrlEncodedFormEntity(values,"UTF-8"));
		}
		return sendRequest(request);
	}
	/**
	 * @description 向指定的URL发起一个put请求
	 * @param uri
	 * @param values
	 * @return
	 * @throws IOException
	 */
	public static String doPath(String url, List<NameValuePair> values) throws IOException {
		HttpPatch request = new HttpPatch(url);
		request.setHeader("x-http-method-override", HttpPatch.METHOD_NAME);
		if (values != null) {
			request.setEntity(new UrlEncodedFormEntity(values));
		}
		return sendRequest(request);
	}
}