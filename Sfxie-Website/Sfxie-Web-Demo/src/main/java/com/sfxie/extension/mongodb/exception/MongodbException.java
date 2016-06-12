package com.sfxie.extension.mongodb.exception;

import com.sfxie.extension.spring4.mvc.exception.DaoException;

public class MongodbException extends DaoException {

	public MongodbException(String msg, Exception t) {
		super(msg, t);
	}

	public MongodbException(String msg){
		super(msg,new Exception ());
	}
}
