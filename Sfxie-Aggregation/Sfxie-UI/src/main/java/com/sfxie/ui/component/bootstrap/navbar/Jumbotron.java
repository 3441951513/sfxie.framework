package com.sfxie.ui.component.bootstrap.navbar;

import com.sfxie.ui.component.base.annotation.HtmlTag;
import com.sfxie.ui.component.bootstrap.BootstrapMD;
/**
 * bootstrap的巨幕组件实体模型
 * @TODO	
 * @author 	xieshengfeng
 * @email  	xsfcy@126.com
 * @since 	下午2:15:57 2015年9月28日
 * @example		
 *
 */
@HtmlTag(name="div")
public class Jumbotron  extends BootstrapMD {

	@Override
	public String defaultClass() {
		return "jumbotron";
	}

	@Override
	public String getAdditionCss() {
		return "masthead";
	}

	
	
}
