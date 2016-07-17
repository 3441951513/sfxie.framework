package com.sfxie.ui.extjs5.i18n;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.sfxie.ui.extjs5.annotation.I18nRefrenceEntities;
import com.cniemp.utils.LoggerUtil;
import com.cniemp.utils.jacson.JSONUtil;

public class Extjs5I18nHolder {
	
	public Extjs5I18nHolder(){
		instance = this;
	}
	
	public Extjs5I18nHolder getInstance(){
		if (null==instance){
			instance = this;
		}
		return instance;
	}
	
	private static Extjs5I18nHolder instance;
	@Resource
	private I18NOperator i18NOperator;
	@Resource
	private ModelContextScanExecutor modelContextScanExecutor;
	@Resource
	private ModelHelper  modelHelper ;
	
	private static ModelAnnotationDefinition modelAnnotationDefinition = new ModelAnnotationDefinition();
	
	/** 保存所有extjs4的i18n信息 */
	private static List<EntityI18NProperties> entityI18NProperties = new ArrayList<EntityI18NProperties>();
	
	/**
	 * 生成dto查询字段与数据库对应关系集合
	 */
	public void generateModelAnnotationDefinition(){
		modelHelper.generateModelAnnotationDefinition(modelHelper, modelContextScanExecutor, this.getModelAnnotationDefinition());
//		LoggerUtil.instance(Extjs5I18nHolder.class).info("finished creating ModelAnnotationDefinition["+this.getModelAnnotationDefinition().getClassFieldMap()+"]");
	}
	/**
	 * 获取dto对应的extjs4的i18n实体
	 * 主要是提供给前端用于获取dto字段的国际化值
	 * @param dtoClassName	dto全称
	 * @return
	 * @throws ClassNotFoundException 
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<EntityI18NProperties> getDtoI18NPropertiesByDtoClass(Class dtoCls  ) throws ClassNotFoundException{
		
		List<EntityI18NProperties> result = new ArrayList<EntityI18NProperties> ();
		I18nRefrenceEntities i18nRefrenceEntities = (I18nRefrenceEntities) dtoCls.getAnnotation(I18nRefrenceEntities.class);
		Class [] refrenceEntities = null;
		if(null != i18nRefrenceEntities){
			refrenceEntities = i18nRefrenceEntities.entityName();
		}
		for(EntityI18NProperties ei18n : entityI18NProperties){
			if(null != refrenceEntities)
				for(Class cls : refrenceEntities){
					if(ei18n.getI18nEntityName().equals(cls.getSimpleName()))
						result.add(ei18n);
				}
		}
		return result;
	}
	
	/**
	 * 获取extjs4的i18n实体
	 * @param entityName	实体名称
	 * @return
	 */
	public EntityI18NProperties getEntityI18NProperties(String entityName){
		for(EntityI18NProperties ei18n : entityI18NProperties){
			if(ei18n.getI18nEntityName().equals(entityName))
				return ei18n;
		}
		return null;
	}
	/**
	 * 获取extjs4的i18n实体中字段的国际化文本
	 * @param entityName	实体名称
	 * @param fieldName		字段名称
	 * @return
	 */
	public static Map<String,String> getEntityI18NProperties(String entityName,String fieldName){
		for(EntityI18NProperties ei18n : entityI18NProperties){
			if(ei18n.getI18nEntityName().equals(entityName))
				return ei18n.getI18nEntity().get(fieldName);
		}
		return null;
	}
	
	public I18NOperator getI18NOperator() {
		return i18NOperator;
	}
	public ModelAnnotationDefinition getModelAnnotationDefinition() {
		return modelAnnotationDefinition;
	}
	public void setModelAnnotationDefinition(
			ModelAnnotationDefinition modelAnnotationDefinition) {
		Extjs5I18nHolder.modelAnnotationDefinition = modelAnnotationDefinition;
	}
	public void init(){
		entityI18NProperties = this.i18NOperator.getAllI18NProperties();
		generateModelAnnotationDefinition();
		logInfo();
	}
	private void logInfo(){
		LoggerUtil.instance(Extjs5I18nHolder.class).info("finished creating entityI18NProperties["+JSONUtil.toJSON(entityI18NProperties)+"]");
		LoggerUtil.instance(Extjs5I18nHolder.class).info("finished creating modelAnnotationDefinition["+JSONUtil.toJSON(modelAnnotationDefinition)+"]");
//		LoggerUtil.instance(Extjs5I18nHolder.class).info("test i18n entity-Extjs5TestAnnotationEntity["+JSONUtil.toJSON(ContextHolder.getExtjs5I18nInfo(Extjs5TestAnnotationEntity.class))+"]");
	}
	/*public static Map<String,Object>  getExtjs5I18nInfo(Class<?> clazz){
		Map<String,Object> fieldsDtoMap = instance.getI18NOperator().createDtoFieldsModelWithFields(clazz);
		return fieldsDtoMap ;
	}*/
	public static Map<String,Object>  getExtjs5I18nInfo(Class<?> clazz){
		Map<String,Object> fieldsDtoMap = instance.getI18NOperator().createDtoFieldsModelWithFields(clazz);
		return fieldsDtoMap ;
	}
}
