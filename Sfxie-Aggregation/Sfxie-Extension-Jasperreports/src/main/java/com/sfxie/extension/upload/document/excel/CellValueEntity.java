package com.sfxie.extension.upload.document.excel;

/**
 * 返回的单元格值对象
 * @TODO	
 * @author 	xieshengfeng
 * @email  	xsfcy@126.com
 * @since 	下午3:57:20 2015年8月21日
 * @example		
 *
 */
public class CellValueEntity {
	
    
    /** 对应的代码   */
    public String code;
    /** 对应的名称   */
    public String name;
    /** 所在列号  */
    /** 所在行列对应值  */
    public String value;
    /**	最初始的值*/
    private Object originalValue;
    
    /** 所在行列对应值的错误提示信息   */
    public String exceptionText;
    
    public CellValueEntity(){}
    
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
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getExceptionText() {
		return exceptionText;
	}

	public void setExceptionText(String exceptionText) {
		this.exceptionText = exceptionText;
	}

	public Object getOriginalValue() {
		return originalValue;
	}

	public void setOriginalValue(Object originalValue) {
		this.originalValue = originalValue;
	}
	
	 
}
