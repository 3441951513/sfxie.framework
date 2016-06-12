package com.sfxie.soa.modules.dubbo.service.cm.exception;

import com.sfxie.extension.spring4.mvc.exception.BusinessException;

public class LoginException extends BusinessException {

	public LoginException(String message) {
		super(message);
	}
	public LoginException() {
		super("登录错误");
	}
}
