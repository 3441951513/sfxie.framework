package com.sfxie.extension.spring4.mvc.controller;

import javax.servlet.http.HttpServletRequest;

import com.sfxie.extension.spring4.mvc.exception.MvcException;

/**
 * 异常返回对象处理接口
 * @TODO	
 * @author 	xieshengfeng
 * @email  	xsfcy@126.com
 * @since 	上午9:56:23 2015年9月7日
 * @example		
 *
 */
public interface ExceptionResponseHandler {
	/**	MvcException异常返回对象	*/
	public Object mvcExceptionResponse(MvcException e,HttpServletRequest request);
	/**	Exception异常返回对象	*/
	public Object exceptionResponse(Exception e,HttpServletRequest request);
	
}
