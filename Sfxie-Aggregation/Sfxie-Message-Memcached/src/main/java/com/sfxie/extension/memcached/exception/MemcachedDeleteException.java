package com.sfxie.extension.memcached.exception;

import com.sfxie.extension.spring4.mvc.exception.MemcachedException;

/**
 * memcached缓存异常
 * @TODO	
 * @author 	xieshengfeng
 * @email  	xsfcy@126.com
 * @since 	下午5:54:12 2015年9月14日
 * @example		
 *
 */
public class MemcachedDeleteException extends MemcachedException {

	public MemcachedDeleteException(String t) {
		super(t);
	}
	public MemcachedDeleteException(Exception t) {
		super(t);
	}
}
