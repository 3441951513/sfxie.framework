package com.sfxie.ui.component.bootstrap;

import com.sfxie.ui.component.base.visitor.HtmlModelVisitor;
import com.sfxie.ui.component.html.model.HtmlModel;

public abstract class BootstrapMD extends HtmlModel {

	protected String htmlFile;
	
	protected String jsFile;
	
	
	@Override
	public String accept(HtmlModelVisitor visitor) {
		return visitor.visit(this);
	}

	public String getHtmlFile() {
		return htmlFile;
	}

	public void setHtmlFile(String htmlFile) {
		this.htmlFile = htmlFile;
	}

	public String getJsFile() {
		return jsFile;
	}

	public void setJsFile(String jsFile) {
		this.jsFile = jsFile;
	}

	
	
}
