package com.sfxie.ui.component.base.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * html标签的属性声明注解
 * @author xieshengfeng
 *
 */
@Target({ElementType.FIELD,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface HtmlAttribute {
	/**  属性名称	 */
	String name() default "";
	/**	其它需要追加的内容对应的方法名	*/
	String[] additionalMethod() default {};
	/**	默认值	*/
	String value() default "";
}
