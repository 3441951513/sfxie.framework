package com.sfxie.extension.spring4.mvc.jacson;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.ser.CustomSerializerFactory;
import org.codehaus.jackson.type.JavaType;
import org.codehaus.jackson.type.TypeReference;

import com.sfxie.extension.spring4.mvc.jacson.serializer.StringUnicodeSerializer;



public class JSONUtil {
	
	private static Logger logger= Logger.getLogger(JSONUtil.class);
	
	private static ObjectMapper objectMapper;
	
//	private static JsonBinder  binder = JsonBinder.buildNonDefaultBinder();  
	/**
	 * 懒惰单例模式得到ObjectMapper实例
	 * 此对象为Jackson的核心
	 */
	private static ObjectMapper getMapper(){
		if (objectMapper== null){
			objectMapper= new ObjectMapper();
			//当找不到对应的序列化器时 忽略此字段
			objectMapper.configure(SerializationConfig.Feature.FAIL_ON_EMPTY_BEANS, false);
			//设置当在被反系列化对象中找不到与反系列化字符串中的属性时忽略此属性
			objectMapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			//使Jackson JSON支持Unicode编码非ASCII字符
			CustomSerializerFactory serializerFactory= new CustomSerializerFactory();
			serializerFactory.addSpecificMapping(String.class, new StringUnicodeSerializer());
			objectMapper.setSerializerFactory(serializerFactory);
			// 允许单引号
			objectMapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
	        // 字段和值都加引号
			objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
	        // 数字也加引号
			objectMapper.configure(JsonGenerator.Feature.WRITE_NUMBERS_AS_STRINGS, true);
			objectMapper.configure(JsonGenerator.Feature.QUOTE_NON_NUMERIC_NUMBERS, true);
			//空值处理为空串
			/*objectMapper.getSerializerProvider().setNullValueSerializer(new JsonSerializer<Object>()
	        {
	            @Override
	            public void serialize(
	                    Object value,
	                    JsonGenerator jg,
	                    SerializerProvider sp) throws IOException, JsonProcessingException{
	                jg.writeString("");
	            }
	        });*/
		}
		return objectMapper;
	}
	
	public static ObjectMapper getObjectMapper(){
		return getMapper();
	}
	/**
	 * 用法如下：<br/>
 		List<UmSqlParameterDTO> umSqlParameterDTOList = new ArrayList<UmSqlParameterDTO>();<br/>
		umSqlParameterDTOList = JSONUtil.readValue(umSqlParameterDTOListString, umSqlParameterDTOList);<br/>
	 * @param valueString
	 * @param t
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public static <T, t> T readValue(String valueString,T t) throws JsonParseException, JsonMappingException, IOException{
		return JSONUtil.getObjectMapper().readValue(valueString, new TypeReference<t>() {});
	}
	/**
	 * 创建JSON处理器的静态方法
	 * @param content JSON字符串
	 * @return
	 */
	private static JsonParser getParser(String content){
		try{
			return getMapper().getJsonFactory().createJsonParser(content);
		}catch (IOException ioe){
			return null;
		}
	}
	
	/**
	 * 创建JSON生成器的静态方法, 使用标准输出
	 * @return
	 */
	private static JsonGenerator getGenerator(StringWriter sw){
		try{
			return getMapper().getJsonFactory().createJsonGenerator(sw);
		}catch (IOException e) {
			return null;
		}
	}
	
	/**
	 * JSON对象序列化
	 */
	public static String toJSON(Object obj){
		StringWriter sw= new StringWriter();
		JsonGenerator jsonGen= getGenerator(sw);
		if (jsonGen== null){
			try {
				sw.close();
			} catch (IOException e) {
			}
			return null;
		}		
		try {
			//由于在getGenerator方法中指定了OutputStream为sw
			//因此调用writeObject会将数据输出到sw
			jsonGen.writeObject(obj);
			//由于采用流式输出 在输出完毕后务必清空缓冲区并关闭输出流
			jsonGen.flush();
			jsonGen.close();
			return sw.toString();
		} catch (JsonGenerationException jge) {
			logger.error("JSON生成错误" + jge.getMessage());
		} catch (IOException ioe) {
			logger.error("JSON输入输出错误" + ioe.getMessage());
		}
		return null;		
	}
	
	/**
	 * JSON对象反序列化
	 */
	public static <T> T fromJSON(String json, Class<T> clazz) {
		try {
			JsonParser jp= getParser(json);
			return jp.readValueAs(clazz);
		} catch (JsonParseException jpe){
			logger.error(String.format("反序列化失败, 错误原因:%s", jpe.getMessage()));
		} catch (JsonMappingException jme){
			logger.error(String.format("反序列化失败, 错误原因:%s", jme.getMessage()));	
		} catch (IOException ioe){
			logger.error(String.format("反序列化失败, 错误原因:%s", ioe.getMessage()));
		}
		return null;
	}
	
	public static <T> List<T> listFromJSON(String listString,Class<?> clazz){
//		如果是ArrayList<YourBean>那么使用ObjectMapper 的getTypeFactory().constructParametricType(collectionClass, elementClasses);
//		如果是HashMap<String,YourBean>那么 ObjectMapper 的getTypeFactory().constructParametricType(HashMap.class,String.class, YourBean.class);
		try {
			List<T> beanList = getMapper().readValue(listString, getCollectionType(ArrayList.class,clazz));
			return beanList;
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null; 

	}
	public static JavaType getCollectionType(Class<?> collectionClass, Class<?>... elementClasses) {   
		return getMapper().getTypeFactory().constructParametricType(collectionClass, elementClasses);   
	}   
}
