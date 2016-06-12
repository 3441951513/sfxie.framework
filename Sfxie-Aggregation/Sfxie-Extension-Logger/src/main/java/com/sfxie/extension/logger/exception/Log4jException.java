package com.sfxie.extension.logger.exception;

import com.sfxie.core.exception.ExceptionEvent;
import com.sfxie.core.exception.ExceptionEventListener;
import com.sfxie.core.exception.FrameworkException;

public class Log4jException extends FrameworkException {

	public Log4jException(String errorMsg) {
		super(errorMsg);
	}
	@Override
	public void addEventListener(
			ExceptionEventListener<? extends ExceptionEvent> listener) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void removeEventListener(
			ExceptionEventListener<? extends ExceptionEvent> listener) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void notifyListeners(ExceptionEvent event) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void notifyAllListeners() {
		// TODO Auto-generated method stub
		
	}

}
