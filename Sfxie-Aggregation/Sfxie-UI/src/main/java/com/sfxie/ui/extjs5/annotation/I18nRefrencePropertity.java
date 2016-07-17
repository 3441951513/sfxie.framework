package com.sfxie.ui.extjs5.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * 
 * @author XIESHENGFENG
 * 用于实体类国际化属性字段的注解
 *
 */
@Retention (RetentionPolicy.RUNTIME)    
@Target (ElementType.FIELD)    
public   @interface  I18nRefrencePropertity    
{   
	/**
	 * 关联的实体属性字段名
	 * @return
	 */
	String property();
	//String order();
	/**
	 * 用于extjs4 grid 的列宽度设置
	 * @return
	 */
}   

