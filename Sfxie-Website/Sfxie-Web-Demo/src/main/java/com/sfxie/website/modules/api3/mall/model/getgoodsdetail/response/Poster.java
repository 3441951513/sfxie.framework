package com.sfxie.website.modules.api3.mall.model.getgoodsdetail.response;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.sfxie.website.modules.api3.common.jaxb.ImageRootPathConvertXmlAdapter;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement
public class Poster {

	private String url;

	@XmlAttribute
	@XmlJavaTypeAdapter(ImageRootPathConvertXmlAdapter.class)
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	
}
