package com.sfxie.website.common.dispatcher;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.dubbo.remoting.http.servlet.DispatcherServlet;
import com.sfxie.extension.spring4.mvc.context.Context;
import com.sfxie.extension.spring4.mvc.dispatcher.BatchNumberHolder;

public class DubboDispatcherServlet extends DispatcherServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("UTF-8");
		Context.setRequest(request);
		Context.setResponse(response);
//		Context.retainPostParameter();
		super.service(request, response);
		BatchNumberHolder.clearBatchNumber();
	}
	
	
}
