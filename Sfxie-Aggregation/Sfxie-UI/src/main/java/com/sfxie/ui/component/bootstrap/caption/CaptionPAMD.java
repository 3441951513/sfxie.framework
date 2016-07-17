package com.sfxie.ui.component.bootstrap.caption;

import java.util.List;

import com.sfxie.ui.component.base.annotation.HtmlTag;
import com.sfxie.ui.component.base.visitor.HtmlModelVisitor;
import com.sfxie.ui.component.bootstrap.BootstrapMD;
import com.sfxie.ui.component.bootstrap.a.ABstpMD;
import com.sfxie.utils.CollectionUtil;

/**
 * bootstrap的caption组件下的p标签内的a标签
 * @TODO	
 * @author 	xieshengfeng
 * @email  	xsfcy@126.com
 * @since 	下午1:21:32 2015年9月17日
 * @example		
 *
 */
@HtmlTag(name="p")
public class CaptionPAMD extends BootstrapMD{

	private List<ABstpMD> aList;

	public List<ABstpMD> getAList() {
		return aList = CollectionUtil.nullRetureNewList(aList);
	}

	public void setAList(List<ABstpMD> aList) {
		this.aList = aList;
	}
	
	@Override
	public String accept(HtmlModelVisitor visitor) {
		return visitor.visit(this);	
	}
}
