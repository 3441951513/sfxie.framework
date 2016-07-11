package com.sfxie.soa.modules.dubbo.service.cm.exception;

import com.sfxie.extension.spring4.mvc.exception.BusinessException;

/**
 * 登录异常
 * @author xiesf
 *
 */
public class LoginException extends BusinessException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public LoginException(String message) {
		super(message);
	}
	public LoginException() {
		super("登录错误");
	}
	public LoginException(String message,String code) {
		super(message,code);
	}
}
