package com.sfxie.extension.jasperreport6.auto.visitor;

import com.sfxie.extension.jasperreport6.auto.detailfield.ColumnDetailFieldDefinition;
import com.sfxie.extension.jasperreport6.auto.detailfield.single.CDFDate;
import com.sfxie.extension.jasperreport6.auto.detailfield.single.CDFDouble;
import com.sfxie.extension.jasperreport6.auto.detailfield.single.CDFFloat;
import com.sfxie.extension.jasperreport6.auto.detailfield.single.CDFInteger;
import com.sfxie.extension.jasperreport6.auto.detailfield.single.CDFLong;
import com.sfxie.extension.jasperreport6.auto.detailfield.single.CDFString;
import com.sfxie.extension.jasperreport6.auto.reprot.ReportDefinition;
/**
 * 报表表头和数据区域定义的访问者
 * @TODO	
 * @author 	xieshengfeng
 * @email  	xsfcy@126.com
 * @since 	下午5:55:24 2015年7月27日	
 *
 */
public interface ReportElementVisitor {
	/**
	 * 
	 * @TODO	报表表头和数据区域为Date类型的访问方法
	 * @author 	xieshengfeng
	 * @email  	xsfcy@126.com
	 * @since 	下午5:55:52 2015年7月27日
	 * @param dateDetailField	
	 *
	 */
	public void visit(CDFDate dateDetailField,Integer xpotition);
	/**
	 * 
	 * @TODO	报表表头和数据区域为Float类型的访问方法
	 * @author 	xieshengfeng
	 * @email  	xsfcy@126.com
	 * @since 	下午5:55:52 2015年7月27日
	 * @param floatDetailField	
	 *
	 */
	public void visit(CDFFloat floatDetailField,Integer xpotition);
	/**
	 * 
	 * @TODO	报表表头和数据区域为Long类型的访问方法
	 * @author 	xieshengfeng
	 * @email  	xsfcy@126.com
	 * @since 	下午5:55:52 2015年7月27日
	 * @param longDetailField	
	 *
	 */
	public void visit(CDFLong longDetailField,Integer xpotition); 
	/**
	 * 
	 * @TODO	报表表头和数据区域为Integer类型的访问方法
	 * @author 	xieshengfeng
	 * @email  	xsfcy@126.com
	 * @since 	下午5:55:52 2015年7月27日
	 * @param integerDetailField	
	 *
	 */
	public void visit(CDFInteger integerDetailField,Integer xpotition); 
	/**
	 * 
	 * @TODO	报表表头和数据区域为String类型的访问方法
	 * @author 	xieshengfeng
	 * @email  	xsfcy@126.com
	 * @since 	下午5:55:52 2015年7月27日
	 * @param stringDetailField	
	 *
	 */
	public void visit(CDFString stringDetailField,Integer xpotition); 
	/**
	 * 
	 * @TODO	报表表头和数据区域为Double类型的访问方法
	 * @author 	xieshengfeng
	 * @email  	xsfcy@126.com
	 * @since 	下午5:55:52 2015年7月27日
	 * @param doubleDetailField	
	 *
	 */
	public void visit(CDFDouble doubleDetailField,Integer xpotition); 
	/**
	 * 
	 * @TODO	报表模板的访问方法
	 * @author 	xieshengfeng
	 * @email  	xsfcy@126.com
	 * @since 	下午5:55:52 2015年7月27日
	 * @param doubleDetailField	
	 *
	 */
	public void visit(ReportDefinition reportDefinition,Integer xpotition); 
	
	public void visit(ColumnDetailFieldDefinition detailField,Integer xpotition);
	
}
