package com.sfxie.extension.spring4.mvc.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.sfxie.extension.spring4.mvc.exception.info.ExceptionInfo;
import com.sfxie.extension.spring4.mvc.jacson.JSONUtil;
/**
 * 异常拦截器类,拦截全局异常
 * 如果没有引入{@link com.sfxie.extension.spring4.mvc.controller.ExceptionController}<br>
 * 则由此类来控制全局异常信息
 * @author xieshengfeng
 * @email  xsfcy@126.com
 * @since 2015年7月20日下午2:03:10
 */
public class MvcHandlerExceptionResolver implements HandlerExceptionResolver {

	@Override
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception e) {
		ExceptionInfo exceptionInfo = ExceptionInfo.gainExceptionInfo("json", e);
		response.setCharacterEncoding("UTF-8");  
		response.setContentType("text/json; charset=UTF-8");
	    try {  
	        PrintWriter writer = response.getWriter();  
	        writer.write(JSONUtil.toJSON(exceptionInfo));  
	        writer.flush();  
	    } catch (IOException ex) {  
	          
	    }  
		return null;
	}
}
