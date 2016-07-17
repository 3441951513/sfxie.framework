package com.sfxie.ui.extjs5.mybatis;

import java.util.ArrayList;
import java.util.List;

import com.cniemp.extension.mybatis.interceptor.QueryConditionEntity;
import com.cniemp.extension.mybatis.interceptor.QueryGroupConditionEntity;

/**
 * 用于设置外带查询参数列表,主要用于统一的查询功能
 * @author xsf
 *
 */
public class MybatisQueryConditionThreadLocal {

	private static ThreadLocal<ExtjsMybatisQueryCondition> extjsMybatisQueryCondition = new ThreadLocal<ExtjsMybatisQueryCondition>();
	
	
	private MybatisQueryConditionThreadLocal(){};
	
	private static MybatisQueryConditionThreadLocal instance = new MybatisQueryConditionThreadLocal();
	
	/*public static MybatisQueryConditionThreadLocal getInstance(){
		if(null==instance)
			instance = new MybatisQueryConditionThreadLocal();
		return instance;
	}*/
	
	public static MybatisQueryConditionThreadLocal addQueryConditionEntity(QueryConditionEntity queryConditionEntity){
		ExtjsMybatisQueryCondition condition = extjsMybatisQueryCondition.get();
		if(null==condition){
			condition = new ExtjsMybatisQueryCondition();
			extjsMybatisQueryCondition.set(condition);
		}
		List<QueryConditionEntity> queryConditionEntityList = extjsMybatisQueryCondition.get().queryConditionEntityList;
		if(null==queryConditionEntityList){
			queryConditionEntityList = new ArrayList<QueryConditionEntity>();
			extjsMybatisQueryCondition.get().setQueryConditionEntityList(queryConditionEntityList);
		}
		queryConditionEntityList.add(queryConditionEntity);
		return instance;
		/*List<QueryConditionEntity> list = queryConditionEntityList.get();
		if(null==list){
			list = new ArrayList<QueryConditionEntity>();
			queryConditionEntityList.set(list);
		}
		list.add(queryConditionEntity);
		return instance;*/
	}
	public static MybatisQueryConditionThreadLocal addQueryGroupConditionEntity(QueryGroupConditionEntity queryGroupConditionEntity){
		ExtjsMybatisQueryCondition condition = extjsMybatisQueryCondition.get();
		if(null==condition){
			condition = new ExtjsMybatisQueryCondition();
			extjsMybatisQueryCondition.set(condition);
		}
		List<QueryGroupConditionEntity> queryGroupConditionEntityList = extjsMybatisQueryCondition.get().getQueryGroupConditionEntityList();
		if(null==queryGroupConditionEntityList){
			queryGroupConditionEntityList = new ArrayList<QueryGroupConditionEntity>();
			extjsMybatisQueryCondition.get().setQueryGroupConditionEntityList(queryGroupConditionEntityList);
		}
		queryGroupConditionEntityList.add(queryGroupConditionEntity);
		return instance;
		/*List<QueryConditionEntity> list = queryConditionEntityList.get();
		if(null==list){
			list = new ArrayList<QueryConditionEntity>();
			queryConditionEntityList.set(list);
		}
		list.add(queryConditionEntity);
		return instance;*/
	}
	/*public static List<QueryConditionEntity> get(){
		return queryConditionEntityList.get();
	}*/
	public static ExtjsMybatisQueryCondition get(){
		ExtjsMybatisQueryCondition condition = extjsMybatisQueryCondition.get();
		if(null==condition){
			condition = new ExtjsMybatisQueryCondition();
			extjsMybatisQueryCondition.set(condition);
		}
		return extjsMybatisQueryCondition.get();
	}
	public static void remove(){
		extjsMybatisQueryCondition.remove();
	}
}
