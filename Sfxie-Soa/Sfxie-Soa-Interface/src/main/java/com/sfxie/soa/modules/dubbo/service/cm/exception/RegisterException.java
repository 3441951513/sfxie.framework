package com.sfxie.soa.modules.dubbo.service.cm.exception;

import com.sfxie.extension.spring4.mvc.exception.BusinessException;

public class RegisterException extends BusinessException {

	public RegisterException(String message) {
		super(message);
	}
	public RegisterException() {
		super("注册错误");
	}
}
