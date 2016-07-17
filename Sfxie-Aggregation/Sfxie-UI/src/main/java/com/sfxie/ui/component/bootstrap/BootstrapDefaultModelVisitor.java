package com.sfxie.ui.component.bootstrap;

import java.util.List;

import com.sfxie.ui.component.bootstrap.a.ABstpMD;
import com.sfxie.ui.component.bootstrap.caption.CaptionMD;
import com.sfxie.ui.component.bootstrap.caption.CaptionPAMD;
import com.sfxie.ui.component.bootstrap.container.ContainerMD;
import com.sfxie.ui.component.bootstrap.img.ImgBstpMD;
import com.sfxie.ui.component.bootstrap.thumbnail.ThumbnailMD;
import com.sfxie.utils.CollectionUtil;

public class BootstrapDefaultModelVisitor extends BootstrapAbstractModelVisitor{

	@Override
	public String visitThumbnailMD(ThumbnailMD model) {
		model.getChild().add(model.getImg());
		model.getChild().add(model.getDiv());
		return visitMode(model);
	}


	@Override
	public String visitImgBstpMD(ImgBstpMD model) {
		return visitMode(model);
	}

	@Override
	public String visitCaptionMD(CaptionMD model) {
		
		model.getChild().add(model.getH3());
		model.getChild().add(model.getP());
		model.getChild().add(model.getPa());
		
		return visitMode(model);
	}
	
	@Override
	public String visitCaptionPAMD(CaptionPAMD model) {
		List<ABstpMD> aList = model.getAList();
		if(CollectionUtil.isNotEmpty(aList)){
			for(ABstpMD aBstpMD : aList){
				model.getChild().add(aBstpMD);
			}
		}
		return visitMode(model);
	}

	@Override
	public String visitABstpMD(ABstpMD model) {
		return visitMode(model);
	}


	@Override
	public String visitContainerMD(ContainerMD model) {
		return visitMode(model);
	}
}
