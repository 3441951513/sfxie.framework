package com.sfxie.data.security;

import com.sfxie.exception.framework.FrameworkException;

/**
 * sql装潢接口
 * @author xiesf
 *
 */
public interface ISqlDecorator {

	/**
	 * 装潢sql
	 * @param originalSql
	 * 			原sql
	 * @param parameter
	 * 			参数
	 * @return
	 * 			装潢后的sql
	 */
	public String decoratedSql(String originalSql,Object parameter) throws FrameworkException;
}
