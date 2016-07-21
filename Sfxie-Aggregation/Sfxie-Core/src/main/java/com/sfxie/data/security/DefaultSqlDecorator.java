package com.sfxie.data.security;

public class DefaultSqlDecorator implements ISqlDecorator{

	@Override
	public String decoratedSql(String originalSql,Object parameter) {
		return originalSql;
	}

}
