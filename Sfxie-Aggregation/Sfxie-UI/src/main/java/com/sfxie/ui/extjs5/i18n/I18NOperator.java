package com.sfxie.ui.extjs5.i18n;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

import org.springframework.beans.factory.InitializingBean;

import com.cniemp.extension.mybatis.annotation.ColumnName;
import com.cniemp.extension.mybatis.annotation.NotDBField;
import com.sfxie.ui.extjs5.annotation.ExtjsCombo;
import com.sfxie.ui.extjs5.annotation.ExtjsComboDefinition;
import com.sfxie.ui.extjs5.annotation.ExtjsGridColumn;
import com.sfxie.ui.extjs5.annotation.I18nRefrenceEntities;
import com.sfxie.ui.extjs5.annotation.I18nRefrencePropertity;
import com.cniemp.utils.StringUtils;

public class I18NOperator implements InitializingBean{
	
	//单例
	public static I18NOperator instance = null;
	
	public String split;
	
	private List<Map<String,String>> currentEntityLocaleListMap = null;
	
	private List<Map<String,String>> currentPageLocaleListMap = null;
	
	private ResourceBundle entityBundle ;
	
	private ResourceBundle pageBundle ;
	
	public I18NOperator(){
		instance = this;
	}
	
	/**
	 * 初始化资源文件
	 */
	public void init(){
		//获得系统默认的国家/语言环境
//		Locale.setDefault(Locale.ENGLISH);
		//获得系统默认的国家/语言环境
		/*for(Map<String,String> map : this.getCurrentEntityLocaleListMap()){
			Locale  currentPageLocale = new Locale(map.get("language"),map.get("country")); 
			ResourceBundle pageBundle = ResourceBundle.getBundle(this.getCurrentPageLocaleMap().get("fileName"),currentPageLocale);
			result.put(map.get("language").toUpperCase()+this.getSplit()+map.get("country").toUpperCase(), pageBundle.getString(propertyName));
		}*/
		Locale  currentEntityLocale = new Locale(this.getCurrentEntityLocaleListMap().get(0).get("language"),this.getCurrentEntityLocaleListMap().get(0).get("country")); 
//		Locale myLocale = Locale.getDefault();
//		System.out.println(Locale.ENGLISH);
		//获得系统默认的国家/语言环境
		instance.entityBundle = ResourceBundle.getBundle(this.getCurrentEntityLocaleListMap().get(0).get("fileName"),currentEntityLocale);
		
		Locale  currentPageLocale = new Locale(this.getCurrentPageLocaleListMap().get(0).get("language"),this.getCurrentPageLocaleListMap().get(0).get("country")); 
		instance.pageBundle = ResourceBundle.getBundle(this.getCurrentPageLocaleListMap().get(0).get("fileName"),currentPageLocale);
	}

	/**
	 * 获取字段的默认的国际化的资源(单个)
	 * @param name
	 * @return
	 */
	public String getSinglePropertyMapping(String name){
		try {
			return getString(instance.entityBundle,name);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 获取所有字段的所有国际化资源
	 * @param propertyName	字段名
	 * @return
	 */
	public Map<String,String> getAllPropertyMapping(String propertyName){
		Map<String,String> result = new HashMap<String,String>();
//		List<HashMap<String,String>> result = new ArrayList<HashMap<String,String>>();
		/** 循环在spring配置文件中配置的properties文件，获取所有与该propertyName所配置的所有国际化字段名称*/
		for(Map<String,String> map : this.getCurrentEntityLocaleListMap()){
			Locale  currentPageLocale = new Locale(map.get("language"),map.get("country")); 
			ResourceBundle pageBundle = ResourceBundle.getBundle(map.get("fileName"),currentPageLocale);
			try {
				result.put(map.get("language").toUpperCase()+this.getSplit()+map.get("country").toUpperCase(), getString(pageBundle,propertyName));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		/** result最终的存放的格式为:{"ZH_CN":"用户名称","EN_CA":"userName"}*/
		return result;
	}
	/**
	 * 获取所有国际化的资源
	 * @param name
	 * @return
	 */
	public Map<String,Map<String,String>> getPageElementAllProperties(){
		Map<String,Map<String,String>> result = new HashMap<String,Map<String,String>>();
		/** 循环在spring配置文件中配置的properties文件，获取所有与该propertyName所配置的所有国际化字段名称*/
		for(Map<String,String> map : this.getCurrentPageLocaleListMap()){
			Locale  currentPageLocale = new Locale(map.get("language"),map.get("country")); 
			ResourceBundle pageBundle = ResourceBundle.getBundle(map.get("fileName"),currentPageLocale);
			Enumeration<String> keys = instance.pageBundle.getKeys();
			while(keys.hasMoreElements()){
				String key = keys.nextElement();
				if(null==result.get(key)){
					Map<String,String> tempMap = new HashMap<String,String>();
					result.put(key, tempMap);
				}
				if(null!=pageBundle.getString(key)){
					try {
						result.get(key).put(map.get("language").toUpperCase()+this.getSplit()+map.get("country").toUpperCase(),
								getString(pageBundle,key));
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
		
		
		
		/** 最终返回格式如下：
		 * {
		 *   "deleteRole" : {
		 *	 	'zh_CN' : '修改角色',
		 *	 	'en' : 'modifyRole',
		 *	 	'en_ca' : 'modifyRole'
		 *   }
		 * }
		 */
		return result;
	}
	/**
	 * 获取所有国际化的资源键值对
	 * @return
	 */
	public List<EntityI18NProperties> getAllI18NProperties(){
		List<EntityI18NProperties> result = new ArrayList<EntityI18NProperties>();
		/**
		 * entity格式如下:
		 * 
		 {
		 	EntityName1:{
		 				fieldName1:{
		 						'zh_CN' : '修改角色',
		 						'en_ca' : 'modifyRole'
		 				},
		 				fieldName12:{
		 						'zh_CN' : '删除角色',
		 						'en_ca' : 'modifyRole'
		 				}
		 	},
		 	EntityName2:{
		 				fieldName1:{
		 						'zh_CN' : '修改角色',
		 						'en_ca' : 'modifyRole'
		 				}
		 	}
		 }
		 */
		Map<String,Map<String,Map<String,String>>> entity =  new HashMap<String,Map<String,Map<String,String>>>();
		String spliter = "\\.";
		
		/** 循环在spring配置文件中配置的properties文件，获取所有与该propertyName所配置的所有国际化字段名称*/
		for(Map<String,String> map : this.getCurrentEntityLocaleListMap()){
			Locale  currentPageLocale = new Locale(map.get("language"),map.get("country")); 
			ResourceBundle bundle = ResourceBundle.getBundle(map.get("fileName"),currentPageLocale);
			Enumeration<String> keys = instance.entityBundle.getKeys();
			while(keys.hasMoreElements()){
				String key = keys.nextElement();
				Map<String,String> i18nValue =  new HashMap<String,String>();
				if(null==entity.get(key.split(spliter)[0])){
					Map<String,Map<String,String>> tempMap = new HashMap<String,Map<String,String>>();
					entity.put(key.split(spliter)[0], tempMap);
				}
				try {
					if(null!=bundle.getString(key)){
						/*"deleteRole" :{
					 		*	 	'zh_CN' : '修改角色',
		 					*	 	'en_ca' : 'modifyRole'
		 					*   }
		 					*/
						if(null == entity.get(key.split(spliter)[0]).get(key.split(spliter)[1])){
							entity.get(key.split(spliter)[0]).put(key.split(spliter)[1], i18nValue);
						}
						entity.get(key.split(spliter)[0]).get(key.split(spliter)[1]).put(map.get("language").toUpperCase()+this.getSplit()+map.get("country").toUpperCase(),
								getString(bundle,key));
//						entity.get(key.split(".")[0]).get(key.split(".")[1]).put(key, value);
					
					}
				} catch (Exception e) {
					//e.printStackTrace();
				}
			}
			
		}
		for(String key : entity.keySet()){
			EntityI18NProperties entityI18NProperties = new EntityI18NProperties();
			entityI18NProperties.setI18nEntityName(key);
			entityI18NProperties.setI18nEntity(entity.get(key));
			result.add(entityI18NProperties);
		}
		
		/** 最终返回格式如下：
		 * {
		 *   "deleteRole" : {
		 *	 	'zh_CN' : '修改角色',
		 *	 	'en_ca' : 'modifyRole'
		 *   }
		 * }
		 */
		return result;
	}
	/**
	 * 获取国际化的资源属性
	 * @param name
	 * @return
	 */
	public Map<String,String> getPageElementAllProperty(){
		Enumeration<String> keys = instance.pageBundle.getKeys();
		Map<String,String> map = new HashMap<String,String>();
		while(keys.hasMoreElements()){
			String key = keys.nextElement();
			try {
				String value = getString(instance.pageBundle,key);
				if(null!=value){
					map.put(key, value);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return map;
	}
	/**
	 * 在bean初始化时执行
	 */
	@Override
	public void afterPropertiesSet() throws Exception {
		init();
	}

	public List<Map<String, String>> getCurrentEntityLocaleListMap() {
		return currentEntityLocaleListMap;
	}

	public void setCurrentEntityLocaleListMap(
			List<Map<String, String>> currentEntityLocaleListMap) {
		this.currentEntityLocaleListMap = currentEntityLocaleListMap;
	}

	public List<Map<String, String>> getCurrentPageLocaleListMap() {
		return currentPageLocaleListMap;
	}

	public void setCurrentPageLocaleListMap(
			List<Map<String, String>> currentPageLocaleListMap) {
		this.currentPageLocaleListMap = currentPageLocaleListMap;
	}

	public String getSplit() {
		return split;
	}

	public void setSplit(String split) {
		this.split = split;
	}

	@SuppressWarnings("finally")
	public String  getString(ResourceBundle pageBundle,String key) throws Exception{
		String value = null;
		try {
			value = pageBundle.getString(key);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}finally{
			if(null != value)
				return value;
			else if(key.contains("."))
				return key.substring(key.lastIndexOf(".")+1,key.length());
			else
				return key;
		}
	}
	/**
	 * 生成dto方法对应字段的map模型
	 * @param dtoClass
	 * @return
	 */
	public Map<String,Object> createDtoFieldsModelWithMethods(Class<?> dtoClass){
		
		List<Method> dtoMethods = getDtoGetMethods(dtoClass);
		List<Method> dtoRefrenceMethods = getDtoRefrenceGetMethods(dtoClass);
		Map<String,Object> result = new HashMap<String,Object>();
		List<HashMap<String,Object>> models = new ArrayList<HashMap<String,Object>>();
		List<String> columns = new ArrayList<String>();
		for(Method method : dtoMethods){
			HashMap<String,Object> model = new HashMap<String,Object>();
			String fieldName = getFieldNameByMethod(method);
			model.put("type",method.getReturnType().getSimpleName().toLowerCase());
			model.put("title","");   
			model.put("name",fieldName);
			model.put("order","-1");
			
			parseExtjsGridColumn(model,method);
			parseExtjsCombo(model,method);
			
			
	        I18nRefrencePropertity entityInternational = method  
	        		.getAnnotation(I18nRefrencePropertity.class ); 
	        //如果dto的某一方法自身已经注解了I18nRefrencePropertity，执行以下if语句，如果没有执行else语句
	        if(null != entityInternational){
	        	String property = entityInternational.property();
	        	String entityName = property.substring(0, property.lastIndexOf("."));
	        	String lastName = property.substring(property.lastIndexOf(".")+1);
	        	Object text = Extjs5I18nHolder.getEntityI18NProperties(entityName, lastName);
	        	if(null!=property)
	        		model.put("title",text);
	        }else{
	        	for(Method refrenceMethod : dtoRefrenceMethods){
	        		if(method.getName().equals(refrenceMethod.getName())){
	        			
	        			parseExtjsGridColumn(model,refrenceMethod);
	        			parseExtjsCombo(model,refrenceMethod);
	        			
	        			I18nRefrencePropertity entityInternational1 = refrenceMethod  
		                .getAnnotation(I18nRefrencePropertity.class ); 
	        			if(null != entityInternational1){
	        				String property = entityInternational1.property();
	        				String entityName = property.substring(0, property.lastIndexOf("."));
	        	        	String lastName = property.substring(property.lastIndexOf(".")+1);
	        	        	Object text = Extjs5I18nHolder.getEntityI18NProperties(entityName, lastName);
	        	        	if(null!=property)
	        	        		model.put("title",text);
		    	        	break;
	        			}
	        		}
	        	}
	        }
	        columns.add(fieldName);
	        models.add(model);
		}
		result.put("fields", models);
		result.put("columns", columns);
		return result;
		
	}
	/**
	 * 生成dto方法对应字段的map模型
	 * @param dtoClass
	 * @return
	 */
	public Map<String,Object> createDtoFieldsModelWithFields(Class<?> dtoClass){
		
		List<Field> dtoFields = getDtoGetFields(dtoClass);
		List<Field> dtoRefrenceFields = getDtoRefrenceFields(dtoClass);
		Map<String,Object> result = new HashMap<String,Object>();
		List<HashMap<String,Object>> models = new ArrayList<HashMap<String,Object>>();
		List<String> columns = new ArrayList<String>();
		for(Field field : dtoFields){
			HashMap<String,Object> model = new HashMap<String,Object>();
			String fieldName = field.getName();
			model.put("type",field.getType().getSimpleName().toLowerCase());
			model.put("title","");   
			model.put("name",fieldName);
			model.put("order","-1");
			
			parseExtjsGridColumn(model,field);
			parseExtjsCombo(model,field);
			parseColumnName(model,field);
			
			
	        I18nRefrencePropertity entityInternational = field  
	        		.getAnnotation(I18nRefrencePropertity.class ); 
	        //如果dto的某一方法自身已经注解了I18nRefrencePropertity，执行以下if语句，如果没有执行else语句
	        if(null != entityInternational){
	        	String property = entityInternational.property();
	        	String entityName = property.substring(0, property.lastIndexOf("."));
	        	String lastName = property.substring(property.lastIndexOf(".")+1);
	        	Object text = Extjs5I18nHolder.getEntityI18NProperties(entityName, lastName);
	        	if(null!=property)
	        		model.put("title",text);
	        }else{
	        	for(Field refrenceField : dtoRefrenceFields){
	        		if(field.getName().equals(refrenceField.getName())){
	        			
	        			parseExtjsGridColumn(model,refrenceField);
	        			parseExtjsCombo(model,refrenceField);
	        			parseColumnName(model,field);
	        			
	        			I18nRefrencePropertity entityInternational1 = refrenceField  
		                .getAnnotation(I18nRefrencePropertity.class ); 
	        			if(null != entityInternational1){
	        				String property = entityInternational1.property();
	        				String entityName = property.substring(0, property.lastIndexOf("."));
	        	        	String lastName = property.substring(property.lastIndexOf(".")+1);
	        	        	Object text = Extjs5I18nHolder.getEntityI18NProperties(entityName, lastName);
	        	        	if(null!=property)
	        	        		model.put("title",text);
		    	        	break;
	        			}
	        		}
	        	}
	        }
	        columns.add(fieldName);
	        models.add(model);
		}
		result.put("fields", models);
		result.put("columns", columns);
		return result;
		
	}
	/**
	 * 解析ExtjsGridColumn注解
	 * @param model
	 * @param method
	 */
	private void parseExtjsGridColumn(HashMap<String,Object> model,Method method){
		ExtjsGridColumn extjsGridColumn = method   
                .getAnnotation(ExtjsGridColumn.class ); 
		if(null!=extjsGridColumn){
			Boolean tip = extjsGridColumn.tip().getValue();
        	int flex = extjsGridColumn.flex().getValue();
        	int order = extjsGridColumn.order();
        	model.put("flex",flex);
        	model.put("tip",tip);
        	if(-1!=order)
        		model.put("order",order);
        	else
        		model.put("order","-1");
		}
	}
	private void parseExtjsGridColumn(HashMap<String,Object> model,Field field){
		ExtjsGridColumn extjsGridColumn = field   
                .getAnnotation(ExtjsGridColumn.class ); 
		if(null!=extjsGridColumn){
			Boolean tip = extjsGridColumn.tip().getValue();
        	int flex = extjsGridColumn.flex().getValue();
        	int order = extjsGridColumn.order();
        	model.put("flex",flex);
        	model.put("tip",tip);
        	if(-1!=order)
        		model.put("order",order);
        	else
        		model.put("order","-1");
		}
	}
	/**
	 * 解析ExtjsCombo注解
	 * @param model
	 * @param method
	 */
	private void parseExtjsCombo(HashMap<String,Object> model,Method method){
		ExtjsCombo extjsCombo = method   
                .getAnnotation(ExtjsCombo.class ); 
		if(null!=extjsCombo){
			Class extjsComboCls = extjsCombo.comboName();
			ExtjsComboDefinition extjsComboDefinition = (ExtjsComboDefinition) extjsComboCls.getAnnotation(ExtjsComboDefinition.class);
			String comboName = StringUtils.lowerFirstChar(extjsComboDefinition.comboName().getSimpleName());
			model.put("comboName",comboName);
			model.put("comboType",extjsComboDefinition.comboType());
		}
	}
	private void parseExtjsCombo(HashMap<String,Object> model,Field field){
		ExtjsCombo extjsCombo = field   
                .getAnnotation(ExtjsCombo.class ); 
		if(null!=extjsCombo){
			Class extjsComboCls = extjsCombo.comboName();
			ExtjsComboDefinition extjsComboDefinition = (ExtjsComboDefinition) extjsComboCls.getAnnotation(ExtjsComboDefinition.class);
			String comboName = StringUtils.lowerFirstChar(extjsComboDefinition.comboName().getSimpleName());
			model.put("comboName",comboName);
			model.put("comboType",extjsComboDefinition.comboType());
		}
	}
	/**
	 * 解析ColumnName注解
	 * @param model
	 * @param method
	 */
	private void parseColumnName(HashMap<String,Object> model,Field field){
		if(null != field.getAnnotation(NotDBField.class))
			return;
		ColumnName columnName = field.getAnnotation(ColumnName.class ); 
		if(null!=columnName){
			String dbFieldName = columnName.field();
			if(dbFieldName.equals("")){
				model.put("dbName",field.getName());
			}else{
				model.put("dbName",dbFieldName);
			}
		}else{
			model.put("dbName",field.getName());
		}
	}
	/**
	 * 获取dto自身的方法集合
	 * @param dtoClass
	 * @return
	 */
	private List<Method> getDtoGetMethods(Class<?> dtoClass){
		
		Method[] methods = dtoClass.getDeclaredMethods(); 
		List<Method> dtoAllFields = new ArrayList<Method>();
		if(methods.length>0)
			for(Method method : methods){
				if(method.getName().contains("get"))
					dtoAllFields.add(method);
			}
		return dtoAllFields;
		
	}
	/**
	 * 获取dto自身的方法集合
	 * @param dtoClass
	 * @return
	 */
	private List<Field> getDtoGetFields(Class<?> dtoClass){
		Field[] fields = dtoClass.getDeclaredFields(); 
		List<Field> dtoAllFields = new ArrayList<Field>();
		if(fields.length>0)
			for(Field field : fields){
					dtoAllFields.add(field);
			}
		return dtoAllFields;
		
	}
	/**
	 * 获取dto注解的关联实体的方法集合
	 * @param dtoClass
	 * @return
	 */
	private List<Method> getDtoRefrenceGetMethods(Class<?> dtoClass){
		
		List<Method> dtoAllFields = new ArrayList<Method>();
		I18nRefrenceEntities i18nRefrenceEntities = (I18nRefrenceEntities) dtoClass.getAnnotation(I18nRefrenceEntities.class);
		Class [] refrenceEntities = null;
		if(null != i18nRefrenceEntities){
			refrenceEntities = i18nRefrenceEntities.entityName();
		}
		if(null!=refrenceEntities){
			for(Class refrenceEntity : refrenceEntities){
				try {
					Method [] methods = refrenceEntity.getDeclaredMethods();
					if(methods.length>0)
						for(Method method : methods){
							if(method.getName().contains("get"))
								dtoAllFields.add(method);
						}
				} catch (SecurityException e) {
					e.printStackTrace();
				}
			}
		}
		return dtoAllFields;
	}
	/**
	 * 获取dto注解的关联实体的方法集合
	 * @param dtoClass
	 * @return
	 */
	private List<Field> getDtoRefrenceFields(Class<?> dtoClass){
		
		List<Field> dtoAllFields = new ArrayList<Field>();
		I18nRefrenceEntities i18nRefrenceEntities = (I18nRefrenceEntities) dtoClass.getAnnotation(I18nRefrenceEntities.class);
		Class [] refrenceEntities = null;
		if(null != i18nRefrenceEntities){
			refrenceEntities = i18nRefrenceEntities.entityName();
		}
		if(null!=refrenceEntities){
			for(Class refrenceEntity : refrenceEntities){
				try {
					Field [] fields = refrenceEntity.getDeclaredFields();
					if(fields.length>0)
						for(Field field : fields){
							dtoAllFields.add(field);
						}
				} catch (SecurityException e) {
					e.printStackTrace();
				}
			}
		}
		return dtoAllFields;
	}
	/**
	 * 通过方法获取对应的字段名
	 * @param method
	 * @return
	 */
	private String getFieldNameByMethod(Method method){
		
		String methodName = method.getName();
    	String fieldOldName = methodName.replace("get", "");
    	String ch = fieldOldName.substring(0, 1);
    	String fieldName = fieldOldName.replaceFirst(ch, ch.toLowerCase());
    	return fieldName;
    	
	}
	
}
