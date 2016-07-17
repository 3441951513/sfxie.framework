package com.sfxie.ui.component.bootstrap.button;

import com.sfxie.ui.component.base.annotation.HtmlAttribute;
import com.sfxie.ui.component.base.annotation.HtmlTag;
import com.sfxie.ui.component.bootstrap.BootstrapMD;

@HtmlTag(name="div")
public class BtnGroupJustifiedMD   extends BootstrapMD{

	private String role;
	
	@Override
	public String getAdditionCss() {
		return "btn-group-justified";
	}

	@Override
	public String defaultClass() {
		return "btn-group";
	}
	
	@HtmlAttribute
	public String getRole() {
		return null==role?"":"group";
	}

	public void setRole(String role) {
		this.role = role;
	}
	
}
