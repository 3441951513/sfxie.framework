package com.sfxie.extension.mongodb.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * mongodb分类文档名注解
 * @TODO	
 * @author 	xieshengfeng
 * @email  	xsfcy@126.com
 * @since 	上午11:06:24 2016年2月29日
 * @example		
 *
 */
@Document
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE })
public @interface PartitionDocument {

	/**
	 * 分类文档名称
	 * @TODO	
	 * @return	
	 *
	 */
	Class<?> partitionName();
}
