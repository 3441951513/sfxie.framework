package com.sfxie.extension.spring4.mvc;


import java.io.IOException;


//import org.codehaus.jackson.map.DeserializationConfig;
//import org.codehaus.jackson.map.JsonSerializer;
//import org.codehaus.jackson.map.SerializationConfig;
//import org.codehaus.jackson.map.SerializerProvider;
//import org.codehaus.jackson.map.ser.CustomSerializerFactory;

import com.fasterxml.jackson.core.JsonParser.Feature;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.SerializerProvider;


public class ObjectMappingCustomer extends ObjectMapper
{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ObjectMappingCustomer()
    {
        super();
        
        // 允许单引号
        this.configure(Feature.ALLOW_SINGLE_QUOTES, true);
        // 允许字段和值都加引号
        this.configure(Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
        
        this.configure(Feature.ALLOW_NON_NUMERIC_NUMBERS, true);
        //设置当在被反系列化对象中找不到与反系列化字符串中的属性时忽略此属性
        this.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
//        this.configure(MapperFeature ., arg1)
        // 数字也加引号
//        this.configure(JsonGenerator.Feature.WRITE_NUMBERS_AS_STRINGS, true);
//        this.configure(JsonGenerator.Feature.QUOTE_NON_NUMERIC_NUMBERS, true);

      //当找不到对应的序列化器时 忽略此字段
        this.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		//使Jackson JSON支持Unicode编码非ASCII字符
//		SerializerFactory serializerFactory= new SerializerFactory();
//		serializerFactory.addSpecificMapping(String.class, new StringUnicodeSerializer());
//		this.setSerializerFactory(serializerFactory);
        // 空值处理为空串
        this.getSerializerProvider().setNullValueSerializer(new JsonSerializer<Object>()
        {

			@Override
			public void serialize(Object arg0,
					com.fasterxml.jackson.core.JsonGenerator arg1,
					SerializerProvider arg2) throws IOException,
					JsonProcessingException {
				arg1.writeString("");
			}
        });

    }
}



/*package com.sfxie.extension.spring4.mvc;


import java.io.IOException;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.SerializerProvider;
import org.codehaus.jackson.map.ser.CustomSerializerFactory;


public class ObjectMappingCustomer extends ObjectMapper
{

    public ObjectMappingCustomer()
    {
        super();
        // 允许单引号
        this.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
        // 字段和值都加引号
        this.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
        // 数字也加引号
        this.configure(JsonGenerator.Feature.WRITE_NUMBERS_AS_STRINGS, true);
        this.configure(JsonGenerator.Feature.QUOTE_NON_NUMERIC_NUMBERS, true);

      //当找不到对应的序列化器时 忽略此字段
        this.configure(SerializationConfig.Feature.FAIL_ON_EMPTY_BEANS, false);
		//设置当在被反系列化对象中找不到与反系列化字符串中的属性时忽略此属性
        this.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		//使Jackson JSON支持Unicode编码非ASCII字符
		CustomSerializerFactory serializerFactory= new CustomSerializerFactory();
		serializerFactory.addSpecificMapping(String.class, new StringUnicodeSerializer());
		this.setSerializerFactory(serializerFactory);
        
        // 空值处理为空串
        this.getSerializerProvider().setNullValueSerializer(new JsonSerializer<Object>()
        {

            @Override
            public void serialize(
                    Object value,
                    JsonGenerator jg,
                    SerializerProvider sp) throws IOException, JsonProcessingException
            {
                jg.writeString("");
            }
        });

    }
}
*/