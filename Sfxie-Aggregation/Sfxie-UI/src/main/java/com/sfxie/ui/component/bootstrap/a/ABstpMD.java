package com.sfxie.ui.component.bootstrap.a;


import com.sfxie.ui.component.base.annotation.HtmlAttribute;
import com.sfxie.ui.component.base.annotation.HtmlTag;
import com.sfxie.ui.component.html.model.AModel;

/**
 * 具体bootstrap样式的a标签实体模型
 * @TODO	
 * @author 	xieshengfeng
 * @email  	xsfcy@126.com
 * @since 	下午1:35:27 2015年9月17日
 * @example		
 *
 */
@HtmlTag(name="a")
public class ABstpMD extends AModel {

	private String role;
	
	@HtmlAttribute(value="button")
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String defaultClass() {
		return "btn";
	}
	@Override
	public String getAdditionCss() {
		return "btn-primary";
	}
}
