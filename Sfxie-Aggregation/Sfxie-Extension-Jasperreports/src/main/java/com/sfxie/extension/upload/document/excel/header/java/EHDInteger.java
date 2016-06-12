package com.sfxie.extension.upload.document.excel.header.java;

import com.sfxie.extension.upload.document.excel.header.HeaderDefEntity;
import com.sfxie.extension.upload.document.excel.visitor.IHeaderDefVisitor;

/**
 * Integer类型表头列定义
 * @TODO	
 * @author 	xieshengfeng
 * @email  	xsfcy@126.com
 * @since 	下午3:55:58 2015年8月21日
 * @example		
 *
 */
public class EHDInteger extends HeaderDefEntity{
	public EHDInteger(String string, String string2, String string3) {
		super(string,string2,string3);
	}
	@Override
	public String accept(IHeaderDefVisitor visitor) {
		return visitor.visit(this);
	}

}
