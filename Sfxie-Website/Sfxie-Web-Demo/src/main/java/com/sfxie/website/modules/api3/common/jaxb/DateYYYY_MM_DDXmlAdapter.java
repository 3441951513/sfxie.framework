package com.sfxie.website.modules.api3.common.jaxb;

import java.util.Date;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import com.sfxie.utils.DateHelper;

/** 
 * 2016-01-22类型的转换器
 * @author  huangxing 
 * @date 2016年2月26日 下午3:49:26 
 * @parameter  
 * @since  
 * @return 
 */

public class DateYYYY_MM_DDXmlAdapter extends XmlAdapter<String,Date> {

	@Override
	public Date unmarshal(String v) throws Exception {
		return DateHelper.parseDate(v);
	}

	@Override
	public String marshal(Date v) throws Exception {
		return DateHelper.formatDateType(v, DateHelper.format_no);
	}

}
