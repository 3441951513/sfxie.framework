package com.sfxie.extension.redis.exception;

import com.sfxie.extension.spring4.mvc.exception.RedisException;

/**
 * 
 * @TODO	redis缓存初始化异常
 * @author 	xieshengfeng
 * @email  	xsfcy@126.com
 * @since 	下午1:36:27 2015-7-29
 * @example		
 *
 */
public class JedisCacheInitException extends RedisException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JedisCacheInitException(Exception t) {
		super("jedisCacheInitException", t);
	}

	public JedisCacheInitException(Throwable t) {
		super("jedisCacheInitException", t);
	}

	
}
