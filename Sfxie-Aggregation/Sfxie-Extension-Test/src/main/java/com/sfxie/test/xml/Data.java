package com.sfxie.test.xml;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

@XmlRootElement
@XmlSeeAlso({
SfxieData.class})
@XmlAccessorType(XmlAccessType.NONE)
public abstract class Data<T> {
	
	protected List<T> list;
	
	private Integer total;

	@XmlAttribute
	public Integer getTotal() {
		return list.size();
	}

	public void setTotal(Integer total) {
		this.total = total;
	}


	public abstract List<T> getList() ;

	public abstract void setList(List<T> list);
}

