package com.sfxie.soa.modules.dubbo.service.cm.exception;

import com.sfxie.extension.spring4.mvc.exception.BusinessException;

public class LogoutException extends BusinessException {

	public LogoutException(String message) {
		super(message);
	}
	public LogoutException() {
		super("注销错误");
	}
}
