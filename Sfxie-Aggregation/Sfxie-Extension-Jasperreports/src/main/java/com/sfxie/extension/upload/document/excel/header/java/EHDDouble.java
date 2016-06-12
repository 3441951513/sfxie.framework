package com.sfxie.extension.upload.document.excel.header.java;

import com.sfxie.extension.upload.document.excel.CellValueEntity;
import com.sfxie.extension.upload.document.excel.header.HeaderDefEntity;
import com.sfxie.extension.upload.document.excel.visitor.IHeaderDefVisitor;

/**
 * double类型表头列定义
 * @TODO	
 * @author 	xieshengfeng
 * @email  	xsfcy@126.com
 * @since 	下午3:53:34 2015年8月21日
 * @example		
 *
 */
public class EHDDouble extends HeaderDefEntity{
	
	public EHDDouble(String string, String string2, String string3) {
		super(string,string2,string3);
	}

	@Override
	public String accept(IHeaderDefVisitor visitor) {
		return visitor.visit(this);
	}

	@Override
	public boolean validateValue(IHeaderDefVisitor visitor,
			CellValueEntity cellValueEntity) {
		try{
			Double.parseDouble(this.getValue().toString());
		}catch(Exception e){
			//如果是非数字,则设置值为0
			this.setValue(0D);
		}
		return true;
	}
	
	
}
