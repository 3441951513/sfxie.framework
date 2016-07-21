package com.sfxie.data.security;

import com.sfxie.exception.framework.FrameworkException;

public class SqlSecurityException extends FrameworkException {

	public SqlSecurityException() {
		super("您没有权限执行sql");
	}
	public SqlSecurityException(String message) {
		super(message);
	}

}
