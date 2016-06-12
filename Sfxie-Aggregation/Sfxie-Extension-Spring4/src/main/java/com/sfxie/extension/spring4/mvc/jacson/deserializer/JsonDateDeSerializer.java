package com.sfxie.extension.spring4.mvc.jacson.deserializer;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;
import org.springframework.stereotype.Component;

/**
 * 反系列化时根据时间字符串生成时间对象
 */
@Component
public class JsonDateDeSerializer extends JsonDeserializer<Date>{

    private static final String dateFormat = "yyyy-MM-dd";

	@Override
	public Date deserialize(JsonParser jsonParser, DeserializationContext context)
			throws IOException, JsonProcessingException {
		// TODO Auto-generated method stub
		String text = jsonParser.getText();
		Date date = null;
		SimpleDateFormat sdf =   new SimpleDateFormat(dateFormat);
		try {
			date = sdf.parse(text);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

}

