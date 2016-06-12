package com.sfxie.extension.jasperreport6.auto.detailfield.single.state;

import java.util.Map;

import com.sfxie.extension.jasperreport6.auto.detailfield.single.CDFString;
import com.sfxie.extension.jasperreport6.auto.visitor.ReportElementVisitor;
/**
 * 拥有String类型状态转化报表表头和数据区域定义
 * @TODO	
 * @author 	xieshengfeng
 * @email  	xsfcy@126.com
 * @since 	下午6:02:55 2015年7月27日	
 *
 */
public abstract class CDFStringState extends CDFString{

	public CDFStringState(String columnName, String fieldName,
			int columnWidth, int columnHeight) {
		super(columnName, fieldName, columnWidth, columnHeight);
	}
	
	@Override
	public void accept(ReportElementVisitor visitor,Integer xpotition) {
		visitor.visit(this,xpotition);
	}

	@Override
	public abstract void setValueDisplayMap(String stateKeyPrefix,Map<Object ,String> map);
}
