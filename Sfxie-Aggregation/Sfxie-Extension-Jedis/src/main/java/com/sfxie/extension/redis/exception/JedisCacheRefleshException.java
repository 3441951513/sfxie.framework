package com.sfxie.extension.redis.exception;

import com.sfxie.extension.spring4.mvc.exception.RedisException;

/**
 * 
 * @TODO	redis缓存刷新异常
 * @author 	xieshengfeng
 * @email  	xsfcy@126.com
 * @since 	下午1:36:27 2015-7-29
 * @example		
 *
 */
public class JedisCacheRefleshException extends RedisException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JedisCacheRefleshException(Exception t) {
		super("jedisCacheRefleshException", t);
	}

	public JedisCacheRefleshException(Throwable t) {
		super("jedisCacheRefleshException", t);
	}

	
}
