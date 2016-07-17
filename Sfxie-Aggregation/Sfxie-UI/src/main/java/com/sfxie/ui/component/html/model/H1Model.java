package com.sfxie.ui.component.html.model;

import com.sfxie.ui.component.base.visitor.HtmlModelVisitor;

public class H1Model extends HtmlModel {

	@Override
	public String accept(HtmlModelVisitor visitor) {
		return visitor.visit(this);	
	}
	
	@Override
	public String defaultClass() {
		return null;
	}
}
