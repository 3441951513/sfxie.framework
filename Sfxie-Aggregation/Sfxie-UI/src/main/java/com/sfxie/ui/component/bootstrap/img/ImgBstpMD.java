package com.sfxie.ui.component.bootstrap.img;

import com.sfxie.ui.component.base.annotation.HtmlAttribute;
import com.sfxie.ui.component.base.annotation.HtmlTag;
import com.sfxie.ui.component.base.visitor.HtmlModelVisitor;
import com.sfxie.ui.component.bootstrap.BootstrapMD;

/**
 * bootstrap样式的img标签实体模型
 * @TODO	
 * @author 	xieshengfeng
 * @email  	xsfcy@126.com
 * @since 	下午2:15:57 2015年9月17日
 * @example		
 *
 */
@HtmlTag(name="img")
public class ImgBstpMD extends BootstrapMD {

	private String dataSrc;
	
	private String src;
	
	@HtmlAttribute
	public String getDataSrc() {
		return dataSrc;
	}

	public void setDataSrc(String dataSrc) {
		this.dataSrc = dataSrc;
	}
	
	@HtmlAttribute
	public String getSrc() {
		return src;
	}

	public void setSrc(String src) {
		this.src = src;
	}

	@Override
	public String accept(HtmlModelVisitor visitor) {
		return visitor.visit(this);	
	}
	
}
