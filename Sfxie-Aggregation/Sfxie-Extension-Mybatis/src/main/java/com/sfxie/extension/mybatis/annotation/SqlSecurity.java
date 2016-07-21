package com.sfxie.extension.mybatis.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.sfxie.data.security.ISqlSecurity;

/**
 * 用于mybatis框架执行查询时的拦截注解，可用于数据安全控制拦截处理
 * @example 
 	<code>	
 		@SqlSecurity(decorator = DefaultSqlDecorator.class) 
			public class Page {<br>
		}
	</code>
	<code>	
 		@SqlSecurity(decorator = DefaultSqlDecorator.class) 
			public class SfxieSysUserinfo {<br>
		}
	</code>
 * @author xieshengfeng
 * @since 2015-05-15
 *
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface SqlSecurity {

	/**
	 * sql安全处理类
	 * @return 
	 */
	Class<? extends ISqlSecurity> securitor() ;
}