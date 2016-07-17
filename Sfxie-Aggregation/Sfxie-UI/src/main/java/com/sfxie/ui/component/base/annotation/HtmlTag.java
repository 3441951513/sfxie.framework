package com.sfxie.ui.component.base.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * html标签的标签名称声明注解
 * @author xieshengfeng
 *
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface HtmlTag {
	/**
	 * tag名称
	 * @return 
	 */
	String name() ;
}
