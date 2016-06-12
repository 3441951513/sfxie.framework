package com.sfxie.website.modules.api3.common.model.response;

import java.util.Date;

import javax.xml.bind.annotation.XmlAttribute;

import com.sfxie.extension.spring4.mvc.dispatcher.BatchNumberHolder;
import com.sfxie.utils.DateHelper;

public class Error {

	private String type;
	private String code;
	private String note;
	private String serverTime;
	
	@XmlAttribute(name = "type")
	public String getType() {
		return null==type?"false":type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	@XmlAttribute(name = "code")
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	@XmlAttribute(name = "note")
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	
	@XmlAttribute(name = "servertime")
	public String getServerTime() {
		return DateHelper.formatLongDate(new Date(BatchNumberHolder.getBatchNumber()));
	}
	public void setServerTime(String serverTime) {
		this.serverTime = serverTime;
	}
	
	
}
