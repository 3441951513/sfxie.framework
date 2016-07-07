package com.sfxie.data.security;


/**
 * sql安全控制接口
 * @author xiesf
 *
 */
public interface ISqlSecurity {

	/**
	 * 装潢sql
	 * @param originalSql
	 * 			原sql
	 * @param parameter
	 * 			参数
	 */
	public void securitySql(String originalSql,Object parameter) throws SqlSecurityException;
}
