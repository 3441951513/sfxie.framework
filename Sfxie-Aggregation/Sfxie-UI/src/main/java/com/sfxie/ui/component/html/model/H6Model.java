package com.sfxie.ui.component.html.model;

import com.sfxie.ui.component.base.visitor.HtmlModelVisitor;

public class H6Model extends HtmlModel {

	
	@Override
	public String defaultClass() {
		return null;
	}
	
	@Override
	public String accept(HtmlModelVisitor visitor) {
		return visitor.visit(this);	
	}
}
