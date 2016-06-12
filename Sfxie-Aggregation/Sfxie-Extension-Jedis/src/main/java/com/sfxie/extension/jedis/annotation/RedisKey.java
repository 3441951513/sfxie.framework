package com.sfxie.extension.jedis.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 保存到redis时的关键字定义
 * @author xieshengfeng
 * @email  xsfcy@126.com
 * @since 2015年7月22日上午9:36:22
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface RedisKey {

	/**
	 * 关键字名称
	 * @return 
	 */
	String name() default "";
	
}