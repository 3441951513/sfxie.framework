package com.sfxie.ui.component.bootstrap.caption;


import com.sfxie.ui.component.base.annotation.HtmlTag;
import com.sfxie.ui.component.base.visitor.HtmlModelVisitor;
import com.sfxie.ui.component.bootstrap.BootstrapMD;
import com.sfxie.ui.component.html.model.H3Model;
import com.sfxie.ui.component.html.model.PModel;

/**
 * caption组件对应模型
 * @TODO	
 * @author 	xieshengfeng
 * @email  	xsfcy@126.com
 * @since 	上午11:20:42 2015年9月17日
 * @example		
 *
 */
@HtmlTag(name="div")
public class CaptionMD extends BootstrapMD{
	
	private H3Model h3;
	
	private PModel p;
	
	private CaptionPAMD pa;
	

	public H3Model getH3() {
		return h3;
	}

	public void setH3(H3Model h3) {
		this.h3 = h3;
	}

	public PModel getP() {
		return p;
	}

	public void setP(PModel p) {
		this.p = p;
	}

	public CaptionPAMD getPa() {
		return pa;
	}

	public void setPa(CaptionPAMD pa) {
		this.pa = pa;
	}

	@Override
	public String accept(HtmlModelVisitor visitor) {
		return visitor.visit(this);	
	}
	@Override
	public String defaultClass() {
		return "caption";
	}
}
