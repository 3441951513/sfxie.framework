package com.sfxie.ui.extjs5.i18n;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sfxie.ui.extjs5.annotation.I18nRefrenceEntities;

//import javax.persistence.Column;



/**
 * 创建用于前台获取extjs4的已经国际化的columns和fields包装类
 *
 * @author XIESHENGFENG <br>
 * |------------------------------------|<br>
 * |email:xieshengfeng@eastcompeace.com |<br>
 * |------------------------------------|<br>
 * @since 2012-09-1    <br>
 *
 */
public class ModelHelper{

	/**
	 * 生成dto查询字段与数据库对应关系集合
	 */
	public void generateModelAnnotationDefinition(ModelHelper  modelHelper,ModelContextScanExecutor modelContextScanExecutor,ModelAnnotationDefinition modelAnnotationDefinition){
		List<String> allDtoI18NResourceClassName = modelContextScanExecutor.getAllDtoI18NClassName();
//		Map model = instance.getWebApplicationContext().getBeansWithAnnotation(ModelEntityAnnotation.class);
		try {
			for(String key : allDtoI18NResourceClassName){
				Class<?> cls = Class.forName(key.replace(".class", ""));
				modelHelper.createModelAnnotationDefinition(cls,modelAnnotationDefinition);
			}
		} catch (SecurityException e1) {
			e1.printStackTrace();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
	}
	@SuppressWarnings("rawtypes")
	public void createModelAnnotationDefinition(Class<?> clazz,ModelAnnotationDefinition  modelAnnotationDefinition) {
		
		I18nRefrenceEntities modelEntityAnnotation = (I18nRefrenceEntities) clazz.getAnnotation(I18nRefrenceEntities.class);
		List<String> refrenceEntityList = new ArrayList<String>();
		Map<String,Object> definition = new HashMap<String,Object>();
		if(null != modelEntityAnnotation){
			Class [] refrenceEntities = modelEntityAnnotation.entityName();
			for(Class cls : refrenceEntities){
				refrenceEntityList.add(cls.getCanonicalName());
			}
//			refrenceEntities = refrenceEntitieString.split(InternationalEntityRegister.split);
		}
		/*if(refrenceEntityList.size()>0){
			for(String entity : refrenceEntityList){
				try {
					createMethodModel(entity,definition);
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
			}
		}*/
		//处理dto里的@DtoField2QueryField注解
		DtoField2QueryField  dtoField2QueryField = clazz.getAnnotation(DtoField2QueryField.class);
		if(null!=dtoField2QueryField){
			try {
				createDtoField2DatabaseFieldMethodModel(clazz.getName(),definition);
			} catch (SecurityException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		if(definition.size()>0)
			modelAnnotationDefinition.getClassFieldMap().put(clazz.getName(), definition);
		
	}
	/**
	 * 
	 * @param entityName
	 * @param definition
	 * @throws SecurityException
	 * @throws ClassNotFoundException
	 */
	/*private void createMethodModel(String entityName,Map<String,Object> definition) throws SecurityException, ClassNotFoundException{
		//获取所有的关联方法
		Method[] methods = Class.forName(entityName).getDeclaredMethods(); 
        for (Method method : methods) {  
        	Column column = method.getAnnotation(Column.class);
        	String fieldName = getFieldNameByMethod(method);
        	if(null!=column){
        		definition.put(fieldName, column.name());
	        }
        }  
	}*/ 
	/**
	 * 
	 * @param entityName
	 * @param definition
	 * @throws SecurityException
	 * @throws ClassNotFoundException
	 */
	private void createDtoField2DatabaseFieldMethodModel(String entityName,Map<String,Object> definition) throws SecurityException, ClassNotFoundException{
		//获取所有的关联方法
		Method[] methods = Class.forName(entityName).getDeclaredMethods(); 
        for (Method method : methods) {  
        	DtoField2QueryField column = method.getAnnotation(DtoField2QueryField.class);
        	String fieldName = getFieldNameByMethod(method);
        	if(null!=column){
        		definition.put(fieldName, column.field());
	        }
        }  
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
