package com.sfxie.ui.tag.bootstrap;

import com.sfxie.ui.component.base.model.AbstractModelDataProvider;
import com.sfxie.ui.component.bootstrap.test.StatisDataModel;
import com.sfxie.ui.component.html.model.HtmlModel;

public class BstpCaptionTagDP extends AbstractModelDataProvider {

	@Override
	public HtmlModel getModel() {
		System.out.println(getAttribute("title"));
		return StatisDataModel.getCaptionMD();
	}
		
}
