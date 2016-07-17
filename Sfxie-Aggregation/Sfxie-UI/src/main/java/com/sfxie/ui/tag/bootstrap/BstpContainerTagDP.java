package com.sfxie.ui.tag.bootstrap;


import com.sfxie.ui.component.base.model.AbstractModelDataProvider;
import com.sfxie.ui.component.bootstrap.container.ContainerMD;
import com.sfxie.ui.component.bootstrap.test.StatisDataModel;
import com.sfxie.ui.component.html.model.HtmlModel;

public class BstpContainerTagDP  extends AbstractModelDataProvider {

	@Override
	public HtmlModel getModel() {
		return generatedModel();
	}
	
	private ContainerMD generatedModel(){
		ContainerMD model =StatisDataModel.getContainerBstpMD();
		return model;
	}

}
