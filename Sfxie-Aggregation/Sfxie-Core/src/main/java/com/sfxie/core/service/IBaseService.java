package com.sfxie.core.service;

import com.sfxie.exception.framework.FrameworkException;

/**
 * 服务基接口,实现类{@link com.sfxie.core.service.TransactionService}
 * 
 * @author XIESHENGFENG
 * @since 2013-06-23
 *
 */
public interface IBaseService {

	public void insertEntity(Object entity) throws FrameworkException;
	
	public void insertEntity(Object entity1,Object entity2) throws FrameworkException;
	
	public void updateEntity(Object entity) throws FrameworkException;
	
	public void deleteEntity(Object entity) throws FrameworkException;
}
