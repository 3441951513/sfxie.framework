package com.sfxie.extension.upload.document.excel.header;

import com.sfxie.extension.upload.document.excel.CellValueEntity;
import com.sfxie.extension.upload.document.excel.visitor.IHeaderDefVisitable;
import com.sfxie.extension.upload.document.excel.visitor.IHeaderDefVisitor;

/**
 * 上传处理excel的excel表头列定义
 * @TODO	
 * @author 	xieshengfeng
 * @email  	xsfcy@126.com
 * @since 	下午3:44:00 2015年8月21日
 * @example		
 *
 */
public abstract class HeaderDefEntity implements IHeaderDefVisitable{
	/**	最终的值*/
	private Object value;
    /** 对应的代码	*/
    public String code;
    /** 对应的名称	*/
    public String name;
    /** 错误列的对应的名称	*/
    public String errorName;
    /** 所在行号	*/
    public int rowIndex;
    /** 所在列号 */
    public int cellIndex;
    /** 所在列对应的字母，如:AA,A,BA */
    private String excelColName;
    /** 所在列对应的错误提示信息 */
    private String exceptionText;
    /**	最初始的值*/
    private Object originalValue;
    
    public HeaderDefEntity(){}
    public HeaderDefEntity(String code, String name,String excelColName){
    	this.code = code;
    	this.name = name;
    	this.excelColName = excelColName;
    }
    @Override
    public String toString() {
        return code + "-" + name ;
    }
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRowIndex() {
		return rowIndex;
	}
	public void setRowIndex(int rowIndex) {
		this.rowIndex = rowIndex;
	}
	public int getCellIndex() {
		return getExcelCol(excelColName);
	}
	public void setCellIndex(int cellIndex) {
		this.cellIndex = cellIndex;
	}
	public String getExcelColName() {
		return excelColName;
	}
	public void setExcelColName(String excelColName) {
		this.excelColName = excelColName;
	}
	public String getExceptionText() {
		return exceptionText;
	}
	public void setExceptionText(String exceptionText) {
		this.exceptionText = exceptionText;
	}
	
	public String getErrorName() {
		return errorName;
	}
	public void setErrorName(String errorName) {
		this.errorName = errorName;
	}
	private static int getExcelCol(String col){
        col = col.toUpperCase();
        //从-1开始计算,字母重1开始运算。这种总数下来算数正好相同。

        int count = -1;
        char[] cs = col.toCharArray();
        for(int i=0;i<cs.length;i++)
        {
            count += (cs[i]-64 ) * Math.pow(26, cs.length-1-i);
        }
        return count;

     }
	public Object getValue() {
		return value;
	}
	public void setValue(Object value) {
		this.value = value;
	}
	
	@Override
	public boolean validateValue(IHeaderDefVisitor visitor,CellValueEntity cellValueEntity) {
		return true;
	}
	public Object getOriginalValue() {
		return originalValue;
	}
	public void setOriginalValue(Object originalValue) {
		this.originalValue = originalValue;
	}
	
	
}
