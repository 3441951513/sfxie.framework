package com.sfxie.ui.extjs5.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 用于字段上指定要哪个组合框注解
 * @author XIESHENGFENG
 *
 */
@Retention (RetentionPolicy.RUNTIME)    
@Target (ElementType.METHOD)    
public @interface ExtjsCombo {
	Class<?> comboName();
}
