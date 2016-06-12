package com.sfxie.website.modules.api3.mall.model.alipayinfo4qrcode4ad.response;


import java.util.Date;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.sfxie.extension.jaxb.adapter.JaxbDateXmlAdapter;


public class AlipayInfo4Qrcode4AdError {
	
	private String type;
	private String note;
	private Date time;
	
	@XmlAttribute
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@XmlAttribute
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	@XmlJavaTypeAdapter(JaxbDateXmlAdapter.class)
	@XmlAttribute
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	
}
