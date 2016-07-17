package com.sfxie.ui.extjs5.i18n;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * 自定义实体注解类，用于为dto查询数据时匹配查询语句中的字段名.
 *
 * @author XIESHENGFENG <br>
 * |------------------------------------|<br>
 * |email:xieshengfeng@eastcompeace.com |<br>
 * |------------------------------------|<br>
 * @since 2012-09-1    <br>
 *
 */
@Documented
@Retention (RetentionPolicy.RUNTIME)    
@Target ({ElementType.TYPE,ElementType.METHOD,ElementType.FIELD})    
public @interface DtoField2QueryField {
	/**
	 * 设置dto字段与查询字段的匹配关系
	 * @return
	 */
	String field() default "";
	
}