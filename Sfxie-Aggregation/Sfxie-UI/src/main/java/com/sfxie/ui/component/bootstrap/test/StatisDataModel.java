package com.sfxie.ui.component.bootstrap.test;

import com.sfxie.extension.spring4.mvc.context.Context;
import com.sfxie.ui.component.bootstrap.BootstrapDefaultModelVisitor;
import com.sfxie.ui.component.bootstrap.a.ABstpMD;
import com.sfxie.ui.component.bootstrap.button.BtnGroupJustifiedMD;
import com.sfxie.ui.component.bootstrap.button.BtnGroupMD;
import com.sfxie.ui.component.bootstrap.button.ButtonMD;
import com.sfxie.ui.component.bootstrap.caption.CaptionMD;
import com.sfxie.ui.component.bootstrap.caption.CaptionPAMD;
import com.sfxie.ui.component.bootstrap.container.ContainerMD;
import com.sfxie.ui.component.bootstrap.img.ImgBstpMD;
import com.sfxie.ui.component.bootstrap.thumbnail.ThumbnailMD;
import com.sfxie.ui.component.html.model.H3Model;
import com.sfxie.ui.component.html.model.PModel;

public class StatisDataModel {

	
	public static ImgBstpMD getImgBstpMD(){
		ImgBstpMD img = new ImgBstpMD();
		img.setSrc(Context.getContextUrl()+"/jsp/sfxie/images/nz/nz1.jpg");
		return img;
	}
	
	public static ABstpMD getABstpMD(){
		ABstpMD aBstpMD = new ABstpMD();
//		aBstpMD.setStyle("padding:0px;");
		aBstpMD.setAdditionCss("btn-default");
		aBstpMD.setHtmlModelVisitor(new BootstrapDefaultModelVisitor());
		aBstpMD.setHref("http://localhost:8080/ddd");
		aBstpMD.setContent("百度");
		return aBstpMD;
	}
	
	
	public static CaptionPAMD getCaptionPAMD(){
		ABstpMD aBstpMD =getABstpMD();
		
		ABstpMD aBstpMD2 = getABstpMD();
		
		CaptionPAMD captionPAMD = new CaptionPAMD();
		captionPAMD.getAList().add(aBstpMD);
		captionPAMD.getAList().add(aBstpMD2);
		return captionPAMD;
	}
	public static ContainerMD getContainerBstpMD(){
		ContainerMD model = new ContainerMD();
		return model;
	}
	public static CaptionMD getCaptionMD(){
		
		CaptionMD model = new CaptionMD();
		H3Model h3 = new H3Model();
		h3.setContent("七小格2015秋新款");
		PModel p = new PModel();
		p.setContent("纯棉针织面料 简洁舒适环保 ");
		CaptionPAMD pa = getCaptionPAMD();
		
		model.setP(p);
		model.setH3(h3);
		model.setPa(pa);
		model.setCss("caption");
		model.setAdditionCss("sfxie-mainpage-thumbnail-div");
		return model;
	}
	
	public static ThumbnailMD getThumbnailMD (){
		ThumbnailMD model = new ThumbnailMD ();
		model.setDiv(getCaptionMD());
		model.setImg(getImgBstpMD() );
		return model;
	}
	
	public static BtnGroupJustifiedMD getBtnGroupJustifiedMD(){
		BtnGroupJustifiedMD model = new BtnGroupJustifiedMD();
		
		BtnGroupMD btnGroupMD1 = new BtnGroupMD();
		ButtonMD buttonMD1 = new ButtonMD();
		buttonMD1.setContent("button1");
		btnGroupMD1.getChild().add(buttonMD1);
		model.getChild().add(btnGroupMD1);
		
		BtnGroupMD btnGroupMD2 = new BtnGroupMD();
		ButtonMD buttonMD2 = new ButtonMD();
		buttonMD2.setContent("button2");
		btnGroupMD2.getChild().add(buttonMD2);
		model.getChild().add(btnGroupMD2);
		
		BtnGroupMD btnGroupMD3 = new BtnGroupMD();
		ButtonMD buttonMD3 = new ButtonMD();
		buttonMD3.setContent("button3");
		btnGroupMD3.getChild().add(buttonMD3);
		model.getChild().add(btnGroupMD3);
		return model;
	}
}
