package com.sfxie.extension.spring4.mvc.controller;

import javax.servlet.http.HttpServletRequest;

import com.sfxie.extension.spring4.mvc.exception.MvcException;
import com.sfxie.extension.spring4.mvc.exception.info.ExceptionInfo;
//import com.sfxie.website.modules.api.model.common.response.Response;

public class DefaultExceptionResponseHandler implements ExceptionResponseHandler {

	@Override
	public Object mvcExceptionResponse(MvcException e,HttpServletRequest request) {
		/*String contentType = request.getContentType();
		Object exceptionInfo ;
		Response response ;
		if(contentType.contains("xml")){
			response = new Response();
//			exceptionInfo = ExceptionInfo.gainExceptionInfo("xml", e);
			com.sfxie.website.modules.api.model.common.response.Error error = new com.sfxie.website.modules.api.model.common.response.Error();
			error.setCode("1001");
			error.setNote(e.getExceptionEntity().getLocalMsg());
			error.setType("true");
			response.setWebsite(request.getRequestURL().toString());
			response.setError(error);
			exceptionInfo = response;
		}else{
			exceptionInfo = ExceptionInfo.gainExceptionInfo("json", e);
		}
		return exceptionInfo;*/
		
		return "服务器处理异常";
	}

	@Override
	public Object exceptionResponse(Exception e,HttpServletRequest request) {
		/*String contentType = request.getContentType();
		Object exceptionInfo ;
		Response response ;
		if(contentType.contains("xml")){
			response = new Response();
			exceptionInfo = ExceptionInfo.gainExceptionInfo("xml", e);
			com.sfxie.website.modules.api.model.common.response.Error error = new com.sfxie.website.modules.api.model.common.response.Error();
			error.setCode("1001");
			error.setNote(((ExceptionInfo)exceptionInfo).getErrorLocalMsg());
			error.setType("true");
			response.setWebsite(request.getRequestURL().toString());
			response.setError(error);
			exceptionInfo = response;
		}else{
			exceptionInfo = ExceptionInfo.gainExceptionInfo("json", e);
		}
		return exceptionInfo;*/
		return "服务器处理异常";
//		String errorClassName1 = e.getStackTrace()[0].getClassName();
//		String errorMethodName1 = e.getStackTrace()[0].getMethodName(); 
//		int errorLineNumber = e.getStackTrace()[0].getLineNumber();
//		exceptionEntity.setClassName(errorClassName1);
//		exceptionEntity.setMethodName(errorMethodName1);
//		exceptionEntity.setLineNumber(errorLineNumber);
	}

}
