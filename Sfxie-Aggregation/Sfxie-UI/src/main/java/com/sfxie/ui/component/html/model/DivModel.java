package com.sfxie.ui.component.html.model;

import com.sfxie.ui.component.base.annotation.HtmlTag;
import com.sfxie.ui.component.base.visitor.HtmlModelVisitor;


@HtmlTag(name="div")
public class DivModel extends HtmlModel {

	
	@Override
	public String defaultClass() {
		return null;
	}
	
	@Override
	public String accept(HtmlModelVisitor visitor) {
		return visitor.visit(this);	
	}
}
