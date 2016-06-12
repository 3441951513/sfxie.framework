package com.sfxie.extension.redis.exception;

import com.sfxie.extension.spring4.mvc.exception.RedisException;

/**
 * redis主键未定义异常
 * @author xieshengfeng
 * @email  xsfcy@126.com
 * @since 2015年7月22日上午10:27:04
 */
public class JedisKeyUndifinedException extends RedisException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JedisKeyUndifinedException(Exception t) {
		super("jedisKeyException", t);
	}

	public JedisKeyUndifinedException(Throwable t) {
		super("jedisKeyException", t);
	}

	
}
