package com.sfxie.ui.extjs5.mybatis;

import java.util.List;

import com.cniemp.extension.mybatis.interceptor.QueryConditionEntity;
import com.cniemp.extension.mybatis.interceptor.QueryGroupConditionEntity;

public class ExtjsMybatisQueryCondition {
	
	public ExtjsMybatisQueryCondition(){}

	private Integer limit;
	
	private Integer start;
	
	private String i18nLanguage;
	
	private List<String> usingFields;
	
	private Boolean forceFit;
	
	List<QueryGroupConditionEntity> QueryGroupConditionEntityList;
	
	List<QueryConditionEntity> queryConditionEntityList ;
	
	private Integer total;
	
	private Class<?> entityClass;
	

	public Integer getLimit() {
		return limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	public Integer getStart() {
		return start;
	}

	public void setStart(Integer start) {
		this.start = start;
	}

	public String getI18nLanguage() {
		return i18nLanguage;
	}

	public void setI18nLanguage(String i18nLanguage) {
		this.i18nLanguage = i18nLanguage;
	}

	public List<QueryConditionEntity> getQueryConditionEntityList() {
		return queryConditionEntityList;
	}

	public void setQueryConditionEntityList(
			List<QueryConditionEntity> queryConditionEntityList) {
		this.queryConditionEntityList = queryConditionEntityList;
	}
	
	

	public List<QueryGroupConditionEntity> getQueryGroupConditionEntityList() {
		return QueryGroupConditionEntityList;
	}

	public void setQueryGroupConditionEntityList(
			List<QueryGroupConditionEntity> queryGroupConditionEntityList) {
		QueryGroupConditionEntityList = queryGroupConditionEntityList;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public List<String> getUsingFields() {
		return usingFields;
	}

	public void setUsingFields(List<String> usingFields) {
		this.usingFields = usingFields;
	}

	public Boolean getForceFit() {
		return forceFit;
	}

	public void setForceFit(Boolean forceFit) {
		this.forceFit = forceFit;
	}

	public Class<?> getEntityClass() {
		return entityClass;
	}

	public void setEntityClass(Class<?> entityClass) {
		this.entityClass = entityClass;
	}
	
	
}
