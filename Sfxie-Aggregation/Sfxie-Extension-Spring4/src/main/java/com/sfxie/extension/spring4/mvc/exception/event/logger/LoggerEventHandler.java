package com.sfxie.extension.spring4.mvc.exception.event.logger;

import java.io.Serializable;

import com.sfxie.exception.framework.ExceptionEventListener;
import com.sfxie.extension.spring4.mvc.exception.MvcException;
/**
 * 异常事件监听器-日记
 * @TODO	
 * @author 	xieshengfeng
 * @email  	xsfcy@126.com
 * @since 	下午7:09:33 2015年10月22日
 * @example		
 *
 */
public abstract class LoggerEventHandler  implements ExceptionEventListener<LoggerEvent> ,Serializable{  
	
	private static final long serialVersionUID = 1L;
	
	private MvcException exception;
	
	public LoggerEventHandler( MvcException exception) {
		this.exception = exception;
	}

	public MvcException getException() {
		return exception;
	}
	
	
}
