package com.sfxie.ui.component.bootstrap.container;

import com.sfxie.ui.component.base.annotation.HtmlTag;
import com.sfxie.ui.component.bootstrap.BootstrapMD;
@HtmlTag(name="div")
public class ContainerMD extends BootstrapMD {

	
	@Override
	public String defaultClass() {
		return "container";
	}

	@Override
	public String getAdditionCss() {
		return null!=this.additionCss?"":"sfxie-demo-container";
	}
}
