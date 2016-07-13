package com.sfxie.extension.mybatis.service;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.sfxie.exception.framework.FrameworkException;
import com.sfxie.extension.mybatis.dao.AutoUpdateMapper;
import com.sfxie.core.service.TransactionService;
import com.sfxie.core.service.IBaseService;
import com.sfxie.extension.spring4.mvc.exception.MvcException;

/**
 * 封装的有根据实体自动生成增、删、改功能sql的service
 * @TODO	
 * @author 	xieshengfeng
 * @email  	xsfcy@126.com
 * @since 	下午4:25:15 2015年8月31日
 * @example		
 *
 */
@Service
public class AutoUpdateService extends TransactionService implements IBaseService{

	@Resource
	private AutoUpdateMapper autoUpdateMapper;
	
	protected static final Log logger = LogFactory.getLog(AutoUpdateService.class);

	/**
	 * 根据实体类利用mybatis自动添加记录操作
	 * 
	 * @param entities
	 * @throws MvcException 
	 */
	public void insertEntity(Object... entities) throws MvcException {
		if(entities.length>0){
			for(Object entity : entities){
				autoUpdateMapper.insertEntity(entity);
			}
		}
	}
	/**
	 * 根据实体类利用mybatis自动修改记录操作
	 * 
	 * @param entities
	 */
	public void updateEntity(Object... entities) throws MvcException {
		if(entities.length>0){
			for(Object entity : entities){
				autoUpdateMapper.updateEntity(entity);
			}
		}
	}

	/**
	 * 根据实体类利用mybatis自动删除记录操作
	 * 
	 * @param entities
	 */
	public void deleteEntity(Object... entities) throws MvcException {
		if(entities.length>0){
			for(Object entity : entities){
				autoUpdateMapper.deleteEntity(entity);
			}
		}
	}
	@Override
	public Object findEntity(Object entity) throws FrameworkException {
		// TODO Auto-generated method stub
		return autoUpdateMapper.find(entity);
	}

}
