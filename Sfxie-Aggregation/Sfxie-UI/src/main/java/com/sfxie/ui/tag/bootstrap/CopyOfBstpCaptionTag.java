package com.sfxie.ui.tag.bootstrap;


import com.sfxie.ui.component.bootstrap.caption.CaptionMD;
import com.sfxie.ui.component.bootstrap.test.StatisDataModel;
import com.sfxie.ui.tag.base.SimpleTag;

public class CopyOfBstpCaptionTag  extends SimpleTag{
	/**
	 * 
	 */
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
		System.out.println(title);
		return generatedCaptionHtml(title);
	}
	
	
	private String generatedCaptionHtml(String title){
		CaptionMD model = StatisDataModel.getCaptionMD();
		return model.html();
	}
}
