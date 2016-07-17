package com.sfxie.ui.component.bootstrap.thumbnail;

import com.sfxie.ui.component.base.annotation.HtmlTag;
import com.sfxie.ui.component.base.visitor.HtmlModelVisitor;
import com.sfxie.ui.component.bootstrap.BootstrapMD;
import com.sfxie.ui.component.bootstrap.caption.CaptionMD;
import com.sfxie.ui.component.bootstrap.img.ImgBstpMD;

/**
 * 缩略图组件对应实体模型
 * @TODO	
 * @author 	xieshengfeng
 * @email  	xsfcy@126.com
 * @since 	上午8:59:46 2015年9月17日
 * @example		
 *
 */
@HtmlTag(name="div")
public class ThumbnailMD extends BootstrapMD{
	
	
	private CaptionMD div;
	
	private ImgBstpMD img;


	public CaptionMD getDiv() {
		return div;
	}
	public void setDiv(CaptionMD div) {
		this.div = div;
	}
	public ImgBstpMD getImg() {
		return img;
	}
	public void setImg(ImgBstpMD img) {
		this.img = img;
	}
	@Override
	public String getAdditionCss() {
		return "sfxie-mainpage-thumbnail";
	}
	@Override
	public String accept(HtmlModelVisitor visitor) {
		return visitor.visit(this);	
	}
	
	@Override
	public String defaultClass() {
		return "thumbnail";
	}
}
