package com.sfxie.ui.extjs5.i18n;

import java.util.HashMap;
import java.util.Map;
/**
 * 存放DTO对象字段与数据库相对应的字段名
 * @author Administrator
 *
 */
public class ModelAnnotationDefinition {

	/**
	 * 可以根据类名和属性名获取与数据库相对应的字段名
	 * 存放实体所有注解字段信息,有fields和hibernate的column、table字段。
	 * key为类名全称,value的key为own(它的value的key是fields(它的value是一個list<Map>))、refrences(它的value是一個list<map>,這個map是一個)其它以後再設置
	 */
	private Map<String,Map<String,Object>> classFieldMap = new HashMap<String,Map<String,Object>>();

	public Map<String, Map<String, Object>> getClassFieldMap() {
		return classFieldMap;
	}

	public void setClassFieldMap(Map<String, Map<String, Object>> classFieldMap) {
		this.classFieldMap = classFieldMap;
	}
}
