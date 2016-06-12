package com.sfxie.website.common.exception;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.UnmarshalException;

import org.springframework.http.converter.HttpMessageNotWritableException;

import com.sfxie.extension.logger.LoggerUtil;
import com.sfxie.extension.spring4.mvc.context.Context;
import com.sfxie.extension.spring4.mvc.controller.ExceptionResponseHandler;
import com.sfxie.extension.spring4.mvc.dispatcher.BatchNumberHolder;
import com.sfxie.extension.spring4.mvc.exception.BusinessException;
import com.sfxie.extension.spring4.mvc.exception.ExceptionContainer;
import com.sfxie.extension.spring4.mvc.exception.MvcException;
import com.sfxie.extension.spring4.mvc.exception.info.ExceptionEntity;
import com.sfxie.extension.spring4.mvc.exception.info.ExceptionInfo;
import com.sfxie.utils.DateHelper;
import com.sfxie.utils.ExceptionUtil;
import com.sfxie.website.modules.api3.common.model.response.Response;
import com.sfxie.website.modules.api3.common.model.response.Error;

public class DefaultExceptionResponseHandler implements ExceptionResponseHandler {

	@Override
	public Object mvcExceptionResponse(MvcException e,HttpServletRequest request) {
		ExceptionEntity exceptionEntity = e.getExceptionEntity();
		String contentType = request.getContentType();
		Object exceptionInfo ;
		ApiExceptionResponse response ;
		if(contentType.contains("xml")){
			//非生产环境
			if(!Context.enviroment.equals("product")){
				response = new ApiExceptionResponse();
				Error error = new Error();
				if(null!=exceptionEntity.getLayer()){
					error.setNote(exceptionEntity.getFullMsg());
				}else{
					error.setNote("服务器处理出错!");
				}
				if(e.getCause() instanceof BusinessException){
					error.setNote(e.getCause().getLocalizedMessage());
					String errorCode = ((BusinessException)e.getCause()).getErrorCode();
					error.setCode(null==errorCode?"1001":errorCode);
				}else if(e instanceof BusinessException){
					error.setNote(e.getLocalizedMessage());
					error.setCode(null==e.getErrorCode()?"1001":e.getErrorCode());
				}
				error.setType("true");
				response.setWebsite(request.getRequestURL().toString());
				response.setError(error);
				List<Object> p = new ArrayList<Object>();
				Parameter parameter = new Parameter();
				if(null!=ExceptionContainer.getXmlParameters()){
					parameter.setType("xml");
					p.add(ExceptionContainer.getXmlParameters());
				}
				if(null!=ExceptionContainer.getPojoParameters()){
					parameter.setType("json");
					p.add(ExceptionContainer.getPojoParameters());
				}
				parameter.setData(p);
				response.setParameters(parameter );
				exceptionInfo = response;
			}else{
				response = new ApiExceptionResponse();
				Error error = new Error();
				if(null!=exceptionEntity.getLayer()){
					if(exceptionEntity.getLayer().equals("service")){
						error.setNote("业务层处理出错");
					}else if(exceptionEntity.getLayer().equals("controller")){
						error.setNote("控制层处理出错");
					}else{
						error.setNote("服务器处理出错!");
					}
				}else{
					error.setNote("服务器处理出错!");
				}
//				if(null!=exceptionEntity.getSelfErrorInfo()){
//					error.setNote(exceptionEntity.getSelfErrorInfo());
//				}
				if(e.getCause() instanceof BusinessException){
					error.setNote(e.getCause().getLocalizedMessage());
					String errorCode = ((BusinessException)e.getCause()).getErrorCode();
					error.setCode(null==errorCode?"1001":errorCode);
				}else if(e instanceof BusinessException){
					error.setNote(e.getLocalizedMessage());
					error.setCode(null==e.getErrorCode()?"1001":e.getErrorCode());
				}
				error.setType("true");
				response.setWebsite(request.getRequestURL().toString());
				response.setError(error);
				exceptionInfo = response;
			}
			
		}else{
			exceptionInfo = ExceptionInfo.gainExceptionInfo("json", e);
		}
		return exceptionInfo;
	}

	@Override
	public Object exceptionResponse(Exception e,HttpServletRequest request) {
		String contentType = request.getContentType();
		String url = request.getRequestURL().toString();
		Object exceptionInfo ;
		Response response ;
		if(null!=contentType && contentType.contains("xml")){
			response = new ApiExceptionResponse();
			Error error = new Error();
			error.setCode("1001");
			Throwable t = parseException(e);
			if (t instanceof UnmarshalException){ 										//service层执行异常
				error.setNote("xml参数格式有错!");
				logException("wrapXml",url,e);
			}else if(t instanceof HttpMessageNotWritableException){
				error.setNote("拼装返回xml结果出错!");
				logException("responseXml",url,e);
			}else{
				error.setNote("服务数据处理前出错!");
				logException("controllerPro",url,e);
			}
			error.setType("true");
			response.setWebsite(request.getRequestURL().toString());
			response.setError(error);
			exceptionInfo = response;
		}else{
			exceptionInfo = ExceptionInfo.gainExceptionInfo("json", e);
		}
		return exceptionInfo;
	}
	/**
	 * 从异常堆栈中找到MvcException异常<br>
	 * 如果找不到MvcException,则返回e
	 * @param e
	 * @return
	 */
    private Throwable parseException(Throwable e){
        Throwable tmp = e;
        int breakPoint = 0;
        while(tmp.getCause()!=null){
            if(tmp.equals(tmp.getCause())){
                break;
            }
            if (tmp instanceof UnmarshalException){
            	return tmp;
    		}
            tmp=tmp.getCause();
            breakPoint++;
            if(breakPoint>1000){
                break;
            }
        } 
        return e;
    }
    private void logException(String positionString,String url,Throwable e){
		String dateString = DateHelper.formatLongDate(new Date(BatchNumberHolder.getBatchNumber()));
		StringBuffer sb = new StringBuffer();
//		String queryString = request.getQueryString();
		sb.append("\r\n###############################################################");
		sb.append(dateString);
		sb.append("###############################################################");
		//执行controller层代码前报错
		sb.append("\r\n异常发生请求: ").append(url);
		if(positionString.equals("controllerPro")){
			sb.append("\r\n异常发生原因: controller层之前");
		}else if(positionString.equals("wrapXml")){
			sb.append("\r\n异常发生原因: 进入controller层之前封装xml参数时异常");
		}else if(positionString.equals("responseXml")){
			sb.append("\r\n异常发生原因: 执行业务代码后拼装返回xml结果时异常");
		}else{
			sb.append("\r\n异常发生原因: 未知");
		}
//		Context.retainPostParameter();
		sb.append("\r\n异常发生时间: ").append(dateString);
//		sb.append("\r\n请求参数：\r\n").append(Context.getPostParameter());
		sb.append("\r\n异常完整信息: ").append(ExceptionUtil.getExceptionMsg(e));
		sb.append("\r\n###############################################################");
		sb.append(dateString);
		sb.append("###############################################################");
		LoggerUtil.error(DefaultExceptionResponseHandler.class,sb.toString());
    }
}
