package com.sfxie.ui.component.bootstrap.button;

import com.sfxie.ui.component.base.annotation.HtmlTag;
import com.sfxie.ui.component.bootstrap.BootstrapMD;

@HtmlTag(name="div")
public class BtnGroupMD  extends BootstrapMD{

	private ButtonMD button;

	public ButtonMD getButton() {
		return button;
	}

	public void setButton(ButtonMD button) {
		this.button = button;
	}

	@Override
	public String defaultClass() {
		// TODO Auto-generated method stub
		return "btn-group";
	}
	
	
}
