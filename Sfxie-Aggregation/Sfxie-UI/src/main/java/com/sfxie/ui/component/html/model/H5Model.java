package com.sfxie.ui.component.html.model;

import com.sfxie.ui.component.base.annotation.HtmlTag;
import com.sfxie.ui.component.base.visitor.HtmlModelVisitor;

@HtmlTag(name="h5")
public class H5Model extends HtmlModel {

	@Override
	public String defaultClass() {
		return null;
	}
	
	@Override
	public String accept(HtmlModelVisitor visitor) {
		return visitor.visit(this);	
	}
}
