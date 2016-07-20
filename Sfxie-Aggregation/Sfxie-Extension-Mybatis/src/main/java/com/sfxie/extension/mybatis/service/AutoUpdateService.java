package com.sfxie.extension.mybatis.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.sfxie.exception.framework.FrameworkException;
import com.sfxie.extension.mybatis.dao.AutoUpdateMapper;
import com.sfxie.core.service.TransactionService;
import com.sfxie.core.service.IBaseService;
import com.sfxie.extension.spring4.mvc.exception.MvcException;
import com.sfxie.utils.CollectionUtil;
import com.sfxie.utils.MapUtil;

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
	/**
	 * 根据主键获取实体
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public <T> T findByKey(T entity) throws FrameworkException {
		// TODO Auto-generated method stub
		List<Map> list = autoUpdateMapper.findByKey(entity);
		if(CollectionUtil.isNotEmpty(list)){
			try {
				return (T) MapUtil.mapToObject(list.get(0), entity.getClass());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public <T> List<T> findList(T entity) throws FrameworkException {
		List<Map> list = autoUpdateMapper.findList(entity);
		List<T> result = new ArrayList<T>();
		if(CollectionUtil.isNotEmpty(list)){
			try {
				result.add( (T) MapUtil.mapToObject(list.get(0), entity.getClass()));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}

}
