package com.sfxie.extension.jedis.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 序列化对象时忽略被序列化注解(要和java关键字transient一起使用)
 * @author xieshengfeng
 * @email  xsfcy@126.com
 * @since 2015年7月22日上午9:36:22
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface RedisTransient {
}