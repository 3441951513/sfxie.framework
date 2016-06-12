package com.sfxie.core.exception;

import org.springframework.dao.DataAccessException;


public abstract class FrameworkException extends DataAccessException  implements ExceptionEventSource{

	public FrameworkException(String msg) {
		super(msg);
	}

	public FrameworkException(String msg, Throwable cause) {
		super(msg, cause);
	}
	
}
