package com.sfxie.ui.component.html.model;

import com.sfxie.ui.component.base.annotation.HtmlTag;
import com.sfxie.ui.component.base.visitor.HtmlModelVisitor;
@HtmlTag(name="h3")
public class H3Model extends HtmlModel {

	@Override
	public String accept(HtmlModelVisitor visitor) {
		return visitor.visit(this);	
	}
	
	@Override
	public String defaultClass() {
		return null;
	}
}
