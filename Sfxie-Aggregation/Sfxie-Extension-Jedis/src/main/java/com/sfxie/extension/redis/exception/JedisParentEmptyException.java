package com.sfxie.extension.redis.exception;

import com.sfxie.extension.spring4.mvc.exception.RedisException;

/**
 * redis关联的父对象空异常
 * @author xieshengfeng
 * @email  xsfcy@126.com
 * @since 2015年7月22日上午10:27:04
 */
public class JedisParentEmptyException extends RedisException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JedisParentEmptyException(Exception t) {
		super("jedisParentEmptyException", t);
	}

	public JedisParentEmptyException(Throwable t) {
		super("jedisParentEmptyException", t);
	}

	
}
