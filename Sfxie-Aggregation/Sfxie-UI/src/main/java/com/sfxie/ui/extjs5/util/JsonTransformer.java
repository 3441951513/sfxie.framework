package com.sfxie.ui.extjs5.util;

import java.util.List;


import com.cniemp.utils.StringUtils;
import com.cniemp.utils.jacson.JSONUtil;

/**
 * 用于java对象和json对象的相互转换
 * @author xieshengfeng
 * @since 2013-06-21
 *
 */
public class JsonTransformer {
	/**
	 * 把java对象转化成JSONObject对象  <br>
	 * @param target  	java对象<br>
	 * @return	                      返回JSONObject对象<br>		
	 */
	public static Object transformObjectToJSONObject(Object target){
		/*JsonConfig jf = new JsonConfig(); 
		Map<String, Object> abstractedJsonValueProcessor = ContextHolder.getBeansOfType(AbstractedJsonValueProcessor.class);
		for(String key : abstractedJsonValueProcessor.keySet()){
			Class<?> cls = ((DateJsonValueProcessor)abstractedJsonValueProcessor.get(key)).getClazz();
			jf.registerJsonValueProcessor(cls,(DateJsonValueProcessor)abstractedJsonValueProcessor.get(key));
		}
		return JSONObject.fromObject(target,jf);*/
		return JSONUtil.toJSON(target);
	}
	/**
	 * 把java List对象转化成JSONArray对象<br>
	 * @param target	java List对象<br>
	 * @return			返回JSONArray对象<br>
	 */
	public static Object transformListToJSONArray(List<?> target){
		/*JsonConfig jf = new JsonConfig(); 
		Map<String, Object> abstractedJsonValueProcessor = ContextHolder.getBeansOfType(AbstractedJsonValueProcessor.class);
		for(String key : abstractedJsonValueProcessor.keySet()){
			Class<?> cls = ((DateJsonValueProcessor)abstractedJsonValueProcessor.get(key)).getClazz();
			jf.registerJsonValueProcessor(cls,(DateJsonValueProcessor)abstractedJsonValueProcessor.get(key));
		}
		//System.out.println(JSONArray.fromObject(target,jf).toString()); 
		return JSONArray.fromObject(target,jf);*/
		return JSONUtil.toJSON(target);
	}
	/**
	 * 把Json数组字符串转化成java List<?>对象<br>
	 * @param json			Json数组字符串<br>
	 * @param objectClass	java List<?>对象中的?部分<br>
	 * @return				返回java List<?>对象<br>
	 */
	public static List<?> transformArrayStringToListObject(String json,Class<?> objectClass){
		if (!StringUtils.isValidateString(json)) {
			return java.util.Collections.EMPTY_LIST;
		}
		
		/*DateFormatDecorator dateFormatDecorator = (DateFormatDecorator) ContextHolder.getBeanByClass(DateFormatDecorator.class);
		if(dateFormatDecorator.getDateFormat().size()>0){
			String [] formatString = new String [dateFormatDecorator.getDateFormat().size()];
			dateFormatDecorator.getDateFormat().toArray(formatString);
			JSONUtils.getMorpherRegistry().registerMorpher(new DateMorpher(formatString) );  
		}
		return (List<?>)JSONArray.toCollection(JSONArray.fromObject(json),objectClass);*/
		return JSONUtil.listFromJSON(json);
	}
	/**
	 * 把json对象的字符串形式转化成java对象
	 * @param entity
	 * @return 
	 * @return 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> T toBeanFromJSONString(String entity,Class<? extends Object> clazz){
		/*DateFormatDecorator dateFormatDecorator = (DateFormatDecorator) ContextHolder.getBeanByClass(DateFormatDecorator.class);
		if(dateFormatDecorator.getDateFormat().size()>0){
			String [] formatString = new String [dateFormatDecorator.getDateFormat().size()];
			dateFormatDecorator.getDateFormat().toArray(formatString);
			JSONUtils.getMorpherRegistry().registerMorpher(new DateMorpher(formatString) );  
		}
		T t = (T) JSONObject.toBean(JSONObject.fromObject(entity), clazz);
		return t;*/
		return (T) JSONUtil.fromJSON(entity, clazz);
	}
}
