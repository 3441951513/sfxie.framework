package com.sfxie.soa.common.response;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public abstract class Data<T>  implements Serializable{
	
	protected List<T> list;
	
	private Integer total;

	@XmlAttribute
	public Integer getTotal() {
		return null==total?(null!=list?list.size():null):total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public abstract List<T> getList() ;

	public void setList(List<T> list){
		this.list = list;
	}
	
	public List<T> createList(){
		if(null==this.list)
			this.list =  new ArrayList<T>();
		return this.list ;
	}
}

