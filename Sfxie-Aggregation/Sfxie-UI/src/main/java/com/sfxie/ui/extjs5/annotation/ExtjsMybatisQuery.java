package com.sfxie.ui.extjs5.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 标注方法执行是否是进行extjs的grid控件数据的查询
 * @author xieshengfeng
 * @since 2015-06-01
 *
 */
@Retention (RetentionPolicy.RUNTIME)    
@Target (ElementType.METHOD)    
public @interface ExtjsMybatisQuery {

}
