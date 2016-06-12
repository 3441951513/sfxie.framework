package com.sfxie.website.modules.api3.mall.model.getmallclassifyproductlist.response;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;


public class Covers {
	
	private List<Cover> cover;

	@XmlElement
	public List<Cover> getCover() {
		if(null==cover)
			cover = new ArrayList<Cover>();
		return cover;
	}

	public void setCover(List<Cover> cover) {
		this.cover = cover;
	}
}
