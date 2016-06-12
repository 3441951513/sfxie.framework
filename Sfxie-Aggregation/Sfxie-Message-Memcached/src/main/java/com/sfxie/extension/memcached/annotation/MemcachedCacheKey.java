package com.sfxie.extension.memcached.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * MemcachedService数据不进行cache处理注解
 * @TODO	
 * @author 	xieshengfeng
 * @email  	xsfcy@126.com
 * @since 	上午10:22:37 2015年9月8日
 * @example		
 *
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface MemcachedCacheKey {
	/**
	 * 缓存主键
	 * @return 
	 */
	String cacheKey();
}