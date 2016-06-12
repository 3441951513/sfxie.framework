package com.sfxie.website.modules.api3.common.model.request;

import javax.xml.bind.annotation.XmlAttribute;


public class Data {

	/**	当前页码，0表示不分页	*/
	private Integer startseq;
	/**	每页显示记录数，0表示不分页	*/
	private Integer limit;
	
	@XmlAttribute
	public Integer getStartseq() {
		return startseq;
	}
	public void setStartseq(Integer startseq) {
		this.startseq = startseq;
	}
	@XmlAttribute
	public Integer getLimit() {
		return limit;
	}
	public void setLimit(Integer limit) {
		this.limit = limit;
	}
	
	
}
