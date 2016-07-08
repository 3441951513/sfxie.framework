package com.sfxie.soa.modules.dubbo.service.oa.exception;

import com.sfxie.extension.spring4.mvc.exception.BusinessException;

/**
 * 密码为空异常
 * @author xiesf
 *
 */
public class RegisterException extends BusinessException {

	public RegisterException(String msg ) {
		super(msg);
	}
	public RegisterException(String message,String code) {
		super(message,code);
	}
	
}
