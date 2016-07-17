package com.sfxie.ui.tag.bootstrap;


import com.sfxie.ui.component.base.model.AbstractModelDataProvider;
import com.sfxie.ui.component.bootstrap.test.StatisDataModel;
import com.sfxie.ui.component.bootstrap.thumbnail.ThumbnailMD;
import com.sfxie.ui.component.html.model.HtmlModel;

public class BstpThumnailTagDP  extends AbstractModelDataProvider {

	@Override
	public HtmlModel getModel() {
		System.out.println(getAttribute("title"));
		return generatedThumbnailMD("生成model示例");
	}
	
	private ThumbnailMD generatedThumbnailMD(String title){
		ThumbnailMD model =StatisDataModel.getThumbnailMD();
		return model;
	}

}
