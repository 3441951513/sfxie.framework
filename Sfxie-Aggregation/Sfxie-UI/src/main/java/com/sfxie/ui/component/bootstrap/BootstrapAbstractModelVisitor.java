package com.sfxie.ui.component.bootstrap;

import com.sfxie.ui.component.bootstrap.a.ABstpMD;
import com.sfxie.ui.component.bootstrap.caption.CaptionMD;
import com.sfxie.ui.component.bootstrap.caption.CaptionPAMD;
import com.sfxie.ui.component.bootstrap.container.ContainerMD;
import com.sfxie.ui.component.bootstrap.img.ImgBstpMD;
import com.sfxie.ui.component.bootstrap.thumbnail.ThumbnailMD;
import com.sfxie.ui.component.html.model.HtmlModel;
import com.sfxie.ui.component.html.visitor.HtmlDefaultModelVisitor;

/**
 * bootstrap组件实体模型抽象访问者
 * @TODO	
 * @author 	xieshengfeng
 * @email  	xsfcy@126.com
 * @since 	下午2:14:26 2015年9月17日
 * @example		
 *
 */
public abstract class BootstrapAbstractModelVisitor extends HtmlDefaultModelVisitor {

	@Override
	public String visit(HtmlModel model) {
		String result = null;
		if(model.getClass().isAssignableFrom(ThumbnailMD.class)){
			result = visitThumbnailMD((ThumbnailMD) model);
		}else if(model.getClass().isAssignableFrom(CaptionMD.class)){
			result = visitCaptionMD((CaptionMD) model);
		}else if(model.getClass().isAssignableFrom(ImgBstpMD.class)){
			result = visitImgBstpMD((ImgBstpMD) model);
		}else if(model.getClass().isAssignableFrom(CaptionPAMD.class)){
			result = visitCaptionPAMD((CaptionPAMD) model);
		}else if(model.getClass().isAssignableFrom(ThumbnailMD.class)){
			result = visitThumbnailMD((ThumbnailMD) model);
		}else if(model.getClass().isAssignableFrom(ABstpMD.class)){
			result = visitABstpMD((ABstpMD) model);
		}else if(model.getClass().isAssignableFrom(ContainerMD.class)){
			result = visitContainerMD((ContainerMD) model);
		}else{
			result = super.visit(model);
		}
		return result;
	}
	public abstract String visitContainerMD(ContainerMD model);
	public abstract String visitThumbnailMD(ThumbnailMD model);
	public abstract String visitCaptionMD(CaptionMD model);
	public abstract String visitImgBstpMD(ImgBstpMD model);
	/**	生成bootstrap的caption组件下的具有a标签的p标签	*/
	public abstract String visitCaptionPAMD(CaptionPAMD model);
	/**	生成bootstrap的caption组件下的a标签	*/
	public abstract String visitABstpMD(ABstpMD model);
	
}
