package com.sfxie.extension.upload.document.excel.visitor;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Date;

import com.sfxie.extension.upload.document.excel.header.HeaderDefEntity;
import com.sfxie.extension.upload.document.excel.header.java.EHDDate;
import com.sfxie.extension.upload.document.excel.header.java.EHDDouble;
import com.sfxie.extension.upload.document.excel.header.java.EHDFloat;
import com.sfxie.extension.upload.document.excel.header.java.EHDInteger;
import com.sfxie.extension.upload.document.excel.header.java.EHDLong;
import com.sfxie.extension.upload.document.excel.header.java.EHDDoublePersentage;
import com.sfxie.extension.upload.document.excel.header.java.EHDString;
import com.sfxie.utils.DateHelper;

/**
 * 默认的上传处理excel文件访问者接口
 * @TODO	
 * @author 	xieshengfeng
 * @email  	xsfcy@126.com
 * @since 	下午3:56:41 2015年8月21日
 * @example		
 *
 */
public class DefaultHeaderDefVisitor implements IHeaderDefVisitor {

	@Override
	public String visit(EHDString headerDef) {
		if(null==headerDef.getValue()){
			return "";
		}
		return headerDef.getValue().toString();
	}

	@Override
	public String visit(EHDDouble headerDef) {
		//对百分比进行处理
		if(EHDDoublePersentage.class.isAssignableFrom(headerDef.getClass())){
			if(null!=headerDef.getValue()){
				NumberFormat nf = NumberFormat.getPercentInstance();
				nf.setMinimumFractionDigits(((EHDDoublePersentage)headerDef).getMinimumFractionDigits());//设置保留小数位
				nf.setRoundingMode(RoundingMode.HALF_UP); //设置舍入模式
				String percent = nf.format(headerDef.getValue());
				return percent;
			}else{
				return "0";
			}
		}else{
			if(null!=headerDef.getValue()){
				String returnText = String.valueOf(headerDef.getValue());
				BigDecimal bd = new BigDecimal(returnText);  
				returnText = bd.toPlainString();
				return returnText;
			}
		}
		return "";
	}

	@Override
	public String visit(EHDLong headerDef) {
		if(null!=headerDef.getValue()){
			return headerDef.getValue().toString();
		}
		return "";
	}

	@Override
	public String visit(EHDFloat headerDef) {
		if(null!=headerDef.getValue()){
			return headerDef.getValue().toString();
		}
		return "";
	}

	@Override
	public String visit(EHDDate headerDef) {
		return DateHelper.formatLongDate((Date)headerDef.getValue());
	}

	@Override
	public String visit(EHDInteger headerDef) {
		if(null!=headerDef.getValue()){
			return String.valueOf(((Double)headerDef.getValue()).intValue());
		}
		return "";
	}

	@Override
	public boolean validateValue(EHDString headerDef) {
		return isNullOrEmpty(headerDef);
	}

	@Override
	public boolean validateValue(EHDDouble headerDef) {
		return isNullOrEmpty(headerDef);
	}

	@Override
	public boolean validateValue(EHDLong headerDef) {
		return isNullOrEmpty(headerDef);
	}

	@Override
	public boolean validateValue(EHDFloat headerDef) {
		return isNullOrEmpty(headerDef);
	}

	@Override
	public boolean validateValue(EHDInteger headerDef) {
		return isNullOrEmpty(headerDef);
	}

	private boolean isNullOrEmpty(HeaderDefEntity headerDef){
		if(null==headerDef.getValue() || headerDef.getValue().equals("")){
			return false;
		}
		return true;
	}
}
