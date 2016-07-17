package com.sfxie.ui.tag.bootstrap;


import com.sfxie.ui.component.base.model.AbstractModelDataProvider;
import com.sfxie.ui.component.bootstrap.button.BtnGroupJustifiedMD;
import com.sfxie.ui.component.bootstrap.test.StatisDataModel;
import com.sfxie.ui.component.html.model.HtmlModel;

public class BtnGroupJustifiedTagDP  extends AbstractModelDataProvider {

	@Override
	public HtmlModel getModel() {
		System.out.println(getAttribute("title"));
		return generatedModel();
	}
	
	private BtnGroupJustifiedMD generatedModel(){
		BtnGroupJustifiedMD model =StatisDataModel.getBtnGroupJustifiedMD();
		return model;
	}

}
