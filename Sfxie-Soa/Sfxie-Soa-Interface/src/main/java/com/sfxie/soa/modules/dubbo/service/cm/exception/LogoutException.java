package com.sfxie.soa.modules.dubbo.service.cm.exception;

import com.sfxie.extension.spring4.mvc.exception.BusinessException;
/**
 * 登出异常
 * @author xiesf
 *
 */
public class LogoutException extends BusinessException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public LogoutException(String message) {
		super(message);
	}
	public LogoutException() {
		super("注销错误");
	}
	public LogoutException(String message,String code) {
		super(message,code);
	}
}
