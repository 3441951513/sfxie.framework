package com.sfxie.ui.tag.bootstrap;


import com.sfxie.ui.tag.base.SimpleTag;

public class BstpThumnailTag  extends SimpleTag{

	private static final long serialVersionUID = 1L;
	
	private String title;
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String html() throws Exception {
		return htmlModel.html();
	}
}
