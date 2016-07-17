package com.sfxie.ui.extjs5.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 用于定义表格生成表单的更新操作的提交地址
 * @author XIESHENGFENG
 * @since 2015-05-29
 */
@Retention (RetentionPolicy.RUNTIME)    
@Target (ElementType.TYPE)    
public @interface ExtjsGridFormSubmitUrl {
	/** 提交地址*/
	String submitUrl();
}
