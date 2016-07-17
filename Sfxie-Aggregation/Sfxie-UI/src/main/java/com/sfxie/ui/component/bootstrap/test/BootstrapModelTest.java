package com.sfxie.ui.component.bootstrap.test;

import org.junit.Test;

import com.sfxie.ui.component.bootstrap.BootstrapDefaultModelVisitor;
import com.sfxie.ui.component.bootstrap.a.ABstpMD;
import com.sfxie.ui.component.bootstrap.caption.CaptionMD;
import com.sfxie.ui.component.bootstrap.caption.CaptionPAMD;
import com.sfxie.ui.component.bootstrap.img.ImgBstpMD;
import com.sfxie.ui.component.bootstrap.thumbnail.ThumbnailMD;
import com.sfxie.ui.component.html.model.H3Model;
import com.sfxie.ui.component.html.model.PModel;


public class BootstrapModelTest {
	@Test
	public void testABstpMD(){
		ABstpMD model = StatisDataModel.getABstpMD();
		print(ABstpMD.class,model.html());
	}
	@Test
	public void testCaptionPAMD(){
		CaptionPAMD model = StatisDataModel.getCaptionPAMD();
		print(CaptionPAMD.class,model.html());
	}
	@Test
	public void testCaptionMD(){
		CaptionMD model = StatisDataModel.getCaptionMD();
		print(CaptionMD.class,model.html());
	}
	
	@Test
	public void testThumbnailMD(){
		ThumbnailMD model = StatisDataModel.getThumbnailMD();
		print(ThumbnailMD.class,model.html());
	}
	
	public  void print(Class<?> cls,String text){
		System.out.println("####################################"+cls.getSimpleName()+"####################################");
		System.out.println(text);
		System.out.println("####################################"+cls.getSimpleName()+"####################################");
		System.out.println();
	}
}
