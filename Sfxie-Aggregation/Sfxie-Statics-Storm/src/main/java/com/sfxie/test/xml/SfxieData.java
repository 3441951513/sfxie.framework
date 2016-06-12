package com.sfxie.test.xml;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.sfxie.test.xml.SfieEntity.SfxieEntity;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement
public class SfxieData extends Data<SfxieEntity> {

	private String age;
	
	@XmlElement(name="entity")
	@Override
	public List<SfxieEntity> getList() {
		if(null==list){
			list = new ArrayList<SfxieEntity>();
		}
		return list;
	}

	@Override
	public void setList(List<SfxieEntity> list) {
		this.list = list;
	}

	@XmlAttribute
	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}
	
	

}
