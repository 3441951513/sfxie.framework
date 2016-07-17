package com.sfxie.ui.component.bootstrap.button;

import com.sfxie.ui.component.base.annotation.HtmlAttribute;
import com.sfxie.ui.component.base.annotation.HtmlTag;
import com.sfxie.ui.component.base.visitor.HtmlModelVisitor;
import com.sfxie.ui.component.bootstrap.BootstrapMD;

/**
 * 按钮组件实体模型 
 * @TODO	
 * @author 	xieshengfeng
 * @email  	xsfcy@126.com
 * @since 	上午9:04:39 2015年9月17日
 * @example		
 *
 */
@HtmlTag(name="button")
public class ButtonMD  extends BootstrapMD{
	
	private String type ;
	
	@Override
	public String getAdditionCss() {
		return null!=super.getAdditionCss()?super.getAdditionCss():"btn-default";
	}

	@Override
	public String accept(HtmlModelVisitor visitor) {
		return visitor.visit(this);
	}

	@Override
	public String defaultClass() {
		return "btn";
	}

	@HtmlAttribute
	public String getType() {
		return null==type?"":"button";
	}

	public void setType(String type) {
		this.type = type;
	}
	
}
