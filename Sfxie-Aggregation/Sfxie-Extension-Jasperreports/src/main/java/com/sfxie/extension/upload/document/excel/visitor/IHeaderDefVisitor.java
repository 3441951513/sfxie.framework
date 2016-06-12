package com.sfxie.extension.upload.document.excel.visitor;

import com.sfxie.extension.upload.document.excel.header.java.EHDDate;
import com.sfxie.extension.upload.document.excel.header.java.EHDDouble;
import com.sfxie.extension.upload.document.excel.header.java.EHDFloat;
import com.sfxie.extension.upload.document.excel.header.java.EHDInteger;
import com.sfxie.extension.upload.document.excel.header.java.EHDLong;
import com.sfxie.extension.upload.document.excel.header.java.EHDString;
/**
 * 上传处理excel文件访问者接口
 * @TODO	
 * @author 	xieshengfeng
 * @email  	xsfcy@126.com
 * @since 	下午3:36:38 2015年8月21日
 * @example		
 *
 */
public interface IHeaderDefVisitor {
	
	public String visit(EHDString headerDef);
	public String visit(EHDDouble headerDef);
	public String visit(EHDLong headerDef);
	public String visit(EHDFloat headerDef);
	public String visit(EHDDate headerDef);
	public String visit(EHDInteger headerDef);
	
	public boolean validateValue(EHDString headerDef);
	public boolean validateValue(EHDDouble headerDef);
	public boolean validateValue(EHDLong headerDef);
	public boolean validateValue(EHDFloat headerDef);
	public boolean validateValue(EHDInteger headerDef);
	
}
