package com.sfxie.extension.spring4.mvc.exception.event.dao;

import java.util.Date;

import com.sfxie.extension.logger.LoggerUtil;
import com.sfxie.extension.spring4.mvc.dispatcher.BatchNumberHolder;
import com.sfxie.extension.spring4.mvc.exception.MvcException;
import com.sfxie.extension.spring4.mvc.exception.event.logger.LoggerEvent;
import com.sfxie.extension.spring4.mvc.exception.event.logger.LoggerEventHandler;
import com.sfxie.extension.spring4.mvc.exception.info.ExceptionEntity;
import com.sfxie.extension.spring4.mvc.jacson.JSONUtil;
import com.sfxie.utils.DateHelper;
import com.sfxie.utils.XmlUtils;

/**
 * logger异常处理监听者实现类
 * @author xieshengfeng
 * @email  xsfcy@126.com
 * @since 2015年7月20日下午2:39:34
 */
public class DaoLoggerEventHandlerImpl extends LoggerEventHandler{

	
	public DaoLoggerEventHandlerImpl( MvcException exception) {
		super(exception);
	}


	@Override
	public void handleEvent(LoggerEvent event) {
		MvcException exception = this.getException();
		ExceptionEntity exceptionEntity = exception.getExceptionEntity();
		String dateString = DateHelper.formatLongDate(new Date(BatchNumberHolder.getBatchNumber()));
		StringBuffer sb = new StringBuffer();
		sb.append("\r\n###############################################################");
		sb.append(dateString);
		sb.append("###############################################################");
		sb.append("\r\n异常代码编号: ");
		sb.append(exceptionEntity.getCode());
		sb.append("\r\n异常代码层数: ");
		sb.append(exceptionEntity.getLayer());
		sb.append("\r\n异常发生时间: ");
		sb.append(dateString);
		sb.append("\r\n异常抛出位置: ").append(exceptionEntity.getClassName()).append(".").append(exceptionEntity.getMethodName()).append("()")
    	  .append("[行号: ").append(exceptionEntity.getLineNumber()).append("]");
		sb.append("\r\n业务方法参数: ");
    	if(null!=exception.getParameters() && exception.getParameters().length>0){
    		sb.append("\r\n    参数(json): \r\n\t");
    		sb.append(JSONUtil.toJSON(exception.getParameters()));
    	}
    	if(null!=exception.getXmlParameters() && exception.getXmlParameters().length>0){
    		for(int i=0;i<exception.getXmlParameters().length;i++){
    			Object obj = exception.getXmlParameters()[i];
    			try {
    				sb.append("\r\n    参数(xml) ");
					sb.append(i);
					sb.append(": \r\n\t");
					sb.append(XmlUtils.serializerXmlString(obj));
				} catch (Exception e) {
				} 
    		}
    	}
    	if(null!=exception.getOtherExceptionMsg() && exception.getOtherExceptionMsg().size()>0){
    		sb.append("\r\n附带信息: ");
    		for(int i=0;i<exception.getOtherExceptionMsg().size();i++){
    			String obj = exception.getOtherExceptionMsg().get(i);
    			try {
    				sb.append("\r\n    附带信息");
					sb.append(i);
					sb.append(": \r\n\t");
					sb.append(obj);
				} catch (Exception e) {
				} 
    		}
    	}
    	sb.append("\r\n异常完整信息: ");
    	sb.append("\t");
		sb.append(exceptionEntity.getFullMsg());
    	sb.append("\r\n###############################################################");
		sb.append(dateString);
		sb.append("###############################################################");
		LoggerUtil.dao(DaoLoggerEventHandlerImpl.class, sb.toString());
	}
}
