package com.sfxie.extension.jasperreport6.auto.detailfield.single;

import com.sfxie.extension.jasperreport6.auto.detailfield.ColumnDetailFieldDefinition;
import com.sfxie.extension.jasperreport6.auto.visitor.ReportElementVisitor;
/**
 * String类型的报表表头和数据区域定义
 * @TODO	
 * @author 	xieshengfeng
 * @email  	xsfcy@126.com
 * @since 	下午6:02:42 2015年7月27日	
 *
 */
public class CDFString extends ColumnDetailFieldDefinition {

	public CDFString(String columnName, String fieldName,
			int columnWidth, int columnHeight) {
		super(columnName, fieldName, columnWidth, columnHeight, String.class);
	}
	
	@Override
	public void accept(ReportElementVisitor visitor,Integer xpotition) {
		visitor.visit(this,xpotition);
	}
}
