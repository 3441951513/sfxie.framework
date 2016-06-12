package com.sfxie.extension.spring4.mvc.jacson;

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

import com.sfxie.extension.spring4.mvc.jacson.serializer.StringUnicodeSerializer;


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
