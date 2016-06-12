package com.sfxie.website.modules.api3.mall.model.getmallclassifyproductlist.response;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.sfxie.website.modules.api3.common.jaxb.ImageRootPathConvertXmlAdapter;

public class Cover {
	
	/**	海报类型（1首页横条2首页竖条3首页方块4详情海报 ） */
	private Short shape;
	/**	封面	*/
	private String cover;
	
	@XmlAttribute
	public Short getShape() {
		return shape;
	}

	public void setShape(Short shape) {
		this.shape = shape;
	}
	@XmlAttribute
	@XmlJavaTypeAdapter(ImageRootPathConvertXmlAdapter.class)
	public String getCover() {
		return cover;
	}

	public void setCover(String cover) {
		this.cover = cover;
	}
}
