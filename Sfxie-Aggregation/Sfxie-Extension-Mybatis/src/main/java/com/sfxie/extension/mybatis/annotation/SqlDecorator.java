package com.sfxie.extension.mybatis.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.sfxie.data.security.ISqlDecorator;

/**
 * 用于mybatis框架执行查询时的拦截注解，可用于数据权限控制模块或者其他sql拦截处理
 * @example 
 	<code>	
 		@SqlDecorator(decorator = DefaultSqlDecorator.class) 
			public class Page {<br>
		}
	</code>
	<code>	
 		@SqlDecorator(decorator = DefaultSqlDecorator.class) 
			public class SfxieSysUserinfo {<br>
		}
	</code>
 * @author xieshengfeng
 * @since 2015-05-15
 *
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface SqlDecorator {

	/**
	 * sql装潢类
	 * @return 
	 */
	Class<? extends ISqlDecorator> decorator() ;
}