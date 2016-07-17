package com.sfxie.ui.component.base.visitor;

import com.sfxie.ui.component.html.model.HtmlModel;


public interface HtmlModelVisitor {
	
	public String visit(HtmlModel model);
	
}
