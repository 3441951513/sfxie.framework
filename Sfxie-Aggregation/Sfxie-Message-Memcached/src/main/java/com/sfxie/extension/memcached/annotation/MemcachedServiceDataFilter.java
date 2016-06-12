package com.sfxie.extension.memcached.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.sfxie.extension.memcached.service.ICacheResultFilter;

/**
 * MemcachedService数据处理注解<br>
 * 说明以注解方式设置过滤数据处理类
 * @TODO	
 * @author 	xieshengfeng
 * @email  	xsfcy@126.com
 * @since 	上午10:22:37 2015年9月8日
 * @example		
 *
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface MemcachedServiceDataFilter {

	/**
	 * MemcachedService数据处理类
	 * @return 
	 */
	Class<? extends ICacheResultFilter> filter();
	
}