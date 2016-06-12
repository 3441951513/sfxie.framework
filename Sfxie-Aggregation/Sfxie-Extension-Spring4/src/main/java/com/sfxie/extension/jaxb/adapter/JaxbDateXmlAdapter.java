package com.sfxie.extension.jaxb.adapter;

import java.util.Date;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import com.sfxie.utils.DateHelper;

/**
 * 用于jaxb方式转化xml时的时间字符串互换适配
 * @TODO	
 * @author 	xieshengfeng
 * @email  	xsfcy@126.com
 * @since 	下午4:30:17 2015年9月10日
 * @example		
 *
 */
public class JaxbDateXmlAdapter extends XmlAdapter<String,Date> {

	@Override
	public Date unmarshal(String v) throws Exception {
		return DateHelper.parseDate(v);
	}

	@Override
	public String marshal(Date v) throws Exception {
		return DateHelper.formatLongDate(v);
	}

}