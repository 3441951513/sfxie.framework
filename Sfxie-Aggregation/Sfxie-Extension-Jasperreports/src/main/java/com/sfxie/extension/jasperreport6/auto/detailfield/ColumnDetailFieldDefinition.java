package com.sfxie.extension.jasperreport6.auto.detailfield;

import java.util.Date;
import java.util.Map;

import net.sf.jasperreports.engine.design.JRDesignStaticText;
import net.sf.jasperreports.engine.design.JRDesignTextField;
import net.sf.jasperreports.engine.design.JasperDesign;

import com.sfxie.extension.jasperreport6.auto.detailfield.single.StateConvertor;
import com.sfxie.extension.jasperreport6.auto.reprot.ReportDefinition;
import com.sfxie.extension.jasperreport6.auto.visitor.ReportElementVisitable;
import com.sfxie.extension.jasperreport6.auto.visitor.ReportElementVisitor;
/**
 * 报表表头和数据区域定义
 * @TODO	
 * @author 	xieshengfeng
 * @email  	xsfcy@126.com
 * @since 	下午5:52:53 2015年7月27日	
 *
 */
public abstract class ColumnDetailFieldDefinition  implements ReportElementVisitable, StateConvertor{


	public void setValueDisplayMap (String stateKeyPrefix,Map<Object,String> map){}
	/**
	 * 
	 * @TODO	生成额外的key字符串,以防止全局{@link com.sfxie.extension.jasperreport6.auto.detailfield.single.StateStaticMap}有重复的key
	 * @author 	xieshengfeng
	 * @email  	xsfcy@126.com
	 * @since 	上午9:36:21 2015年7月28日
	 * @return	
	 *
	 */
	public String getStatePrefixKeyString(){
		String prefix = this.getClass().getSimpleName()+this.getColumnName();
		return prefix;
	}
	public abstract void accept(ReportElementVisitor visitor,Integer xpotition);
	/**	列名称,就是返回到文档中显示的列头	*/
	private String columnName;
	/**	数据对象的字段名,就是获取数据的字段*/
	private String fieldName;
	/**	列宽度(表头区域和数据区域)	*/
	private int columnWidth;
	/**	表头列高度,数据区域列高度由{@link com.sfxie.extension.jasperreport6.auto.reprot.ReportDefinition}的detailHeight成员变量决定	*/
	private int columnHeight;
	/**	java类型	*/
	private String javaType;
	/**	字段类型(定义数据区域的值类型)	*/
	private Class<?> clazz;
	/**	数据区域列TextField	*/
	private JRDesignTextField detailTextField;
	/**	表头区域列TextField	*/
	private JRDesignStaticText headerTextField;
	/**	报表对象	*/
	private JasperDesign jasperDesign;
	/**	报表定义对象	*/
	private ReportDefinition reportDefinition;
	
	public ColumnDetailFieldDefinition(){}
	
	public ColumnDetailFieldDefinition(String columnName, String fieldName ,
			Class<?> clazz) {
		super();
		this.columnName = columnName;
		this.fieldName = fieldName;
		this.clazz = clazz;
		
	}

	
	public ColumnDetailFieldDefinition(String columnName, String fieldName,int columnWidth,
			int columnHeight,Class<?> clazz) {
		super();
		this.columnName = columnName;
		this.fieldName = fieldName;
		this.columnWidth = columnWidth;
		this.columnHeight = columnHeight;
		this.clazz = clazz;
		
	}

	protected Class<?> generatedClass(){
		if(javaType.equals("string")){
			return String.class;
		}else if(javaType.equals("int") || javaType.equals("integer")){
			return Integer.class;
		}else if(javaType.equals("long")){
			return Long.class;
		}else if(javaType.equals("date")){
			return Date.class;
		}else if(javaType.equals("double")){
			return Double.class;
		}else if(javaType.equals("float")){
			return Float.class;
		}
		return String.class;
	}
	
	public Class<?> getClazz() {
		try {
			return null!=clazz?clazz:Class.forName(javaType);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return clazz;
	}

	public void setClazz(Class<?> clazz) {
		this.clazz = clazz;
	}

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public int getColumnWidth() {
		return columnWidth;
	}

	public void setColumnWidth(int columnWidth) {
		this.columnWidth = columnWidth;
	}


	public int getColumnHeight() {
		return columnHeight;
	}

	public void setColumnHeight(int columnHeight) {
		this.columnHeight = columnHeight;
	}

	public String getJavaType() {
		return javaType;
	}


	public void setJavaType(String javaType) {
		this.javaType = javaType;
	}

	public JRDesignTextField getDetailTextField() {
		return detailTextField;
	}

	public void setDetailTextField(JRDesignTextField detailTextField) {
		this.detailTextField = detailTextField;
	}

	public JRDesignStaticText getHeaderTextField() {
		return headerTextField;
	}

	public void setHeaderTextField(JRDesignStaticText headerTextField) {
		this.headerTextField = headerTextField;
	}
	public JasperDesign getJasperDesign() {
		return jasperDesign;
	}
	public void setJasperDesign(JasperDesign jasperDesign) {
		this.jasperDesign = jasperDesign;
	}
	public ReportDefinition getReportDefinition() {
		return reportDefinition;
	}
	public void setReportDefinition(ReportDefinition reportDefinition) {
		this.reportDefinition = reportDefinition;
	}
	
}
