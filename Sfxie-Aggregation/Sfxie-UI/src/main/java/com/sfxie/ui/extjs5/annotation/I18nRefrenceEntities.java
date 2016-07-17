package com.sfxie.ui.extjs5.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 用于dto关联i18n实体的注解
 * @author XIESHENGFENG
 *
 */
@Retention (RetentionPolicy.RUNTIME)    
@Target({ ElementType.TYPE })  
@SuppressWarnings("rawtypes")
public @interface I18nRefrenceEntities {
	Class[] entityName();
}
