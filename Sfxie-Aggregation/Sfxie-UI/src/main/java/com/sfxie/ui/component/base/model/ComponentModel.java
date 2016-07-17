package com.sfxie.ui.component.base.model;

import com.sfxie.ui.component.base.visitor.HtmlModelVisitable;
/**
 * 组件实体模型基类
 * @TODO	
 * @author 	xieshengfeng
 * @email  	xsfcy@126.com
 * @since 	上午9:06:14 2015年9月17日
 * @example		
 *
 */
public abstract class ComponentModel implements HtmlModelVisitable  {
	/** 设置class属性默认值*/
	public abstract String defaultClass();
}
