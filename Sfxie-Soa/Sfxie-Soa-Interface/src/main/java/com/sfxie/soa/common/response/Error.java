package com.sfxie.soa.common.response;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlElement;

import com.sfxie.extension.spring4.mvc.dispatcher.BatchNumberHolder;
import com.sfxie.utils.DateHelper;

public class Error  implements Serializable{

	private String type;
	private String code;
	private String note;
	private String serverTime;
	
	@XmlElement(name = "type")
	public String getType() {
		return null==type?"false":type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	@XmlElement(name = "code")
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	@XmlElement(name = "note")
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	
	@XmlElement(name = "servertime")
	public String getServerTime() {
		return DateHelper.formatLongDate(new Date(BatchNumberHolder.getBatchNumber()));
	}
	public void setServerTime(String serverTime) {
		this.serverTime = serverTime;
	}
	
	
}
