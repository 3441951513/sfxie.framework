package com.sfxie.soa.modules.security.data;

import com.sfxie.data.security.ISqlDecorator;
import com.sfxie.extension.spring4.mvc.exception.BusinessException;

public class DataFilter implements ISqlDecorator {

	@Override
	public String decoratedSql(String originalSql,Object parameter) throws BusinessException{
//		if(null!=originalSql){  //测试与异常模块的结合
//			throw new BusinessException("没有权限执行此查询sql");
//		}
		return originalSql;
	}

}
