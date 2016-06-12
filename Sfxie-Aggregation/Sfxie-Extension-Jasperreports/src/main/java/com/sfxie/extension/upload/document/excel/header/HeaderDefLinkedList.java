package com.sfxie.extension.upload.document.excel.header;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

/**
 * 表头定义列表,有两种类型,分别是single和list
 * @TODO	
 * @author 	xieshengfeng
 * @email  	xsfcy@126.com
 * @since 	下午3:48:52 2015年8月21日
 * @example		
 *
 */
public class HeaderDefLinkedList {

	/** 数据的类型(单行[single]或者列表[list] ) */
	public String dataType;
	/** 是否验证通过   */
	private boolean validate;
	 /** 所在验证行号	*/
    public int validatedRowIndex;
    /** 所在验证列号 */
    public int validatedCellIndex;
    /** 是否已经验证过   */
	private boolean hasValidate;
    
    
    
	private HeaderDefEntity header = null;
	
	private List<HeaderDefEntity> headerList;

	public void addHeaderDefEntity(HeaderDefEntity node) {
		if (headerList == null) {
			headerList = new ArrayList<HeaderDefEntity>();
		}
		headerList.add(node);
	}
	
	public void clear() {
		header = null;
	}

	public boolean isEmpty() {
		if (header == null)
			return true;
		else
			return false;
	}

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public boolean isValidate() {
		return validate;
	}

	public void setValidate(boolean validate) {
		this.validate = validate;
	}

	public int getValidatedRowIndex() {
		return validatedRowIndex;
	}

	public void setValidatedRowIndex(int validatedRowIndex) {
		this.validatedRowIndex = validatedRowIndex;
	}

	public int getValidatedCellIndex() {
		return validatedCellIndex;
	}

	public void setValidatedCellIndex(int validatedCellIndex) {
		this.validatedCellIndex = validatedCellIndex;
	}

	/*public HeaderDefEntity getHeader() {
		return (HeaderDefEntity) get(0);
	}
*/
	/**
	 * 验证行
	 * @TODO	
	 * @author 	xieshengfeng
	 * @email  	xsfcy@126.com
	 * @since 	下午4:14:04 2015年8月17日
	 * @param sheet	
	 *
	 */
	public void validateRow(Sheet sheet){
		boolean flag = true;
		Row row = sheet.getRow((short)this.validatedRowIndex-1);
		for(HeaderDefEntity eqEl : headerList){
			
	        if(eqEl!=null && null!=row){
	        	String str = getCellFormatValue(row.getCell((short) getExcelCol(eqEl.getExcelColName()))).trim();
	            if(StringUtils.isNotEmpty(str)){
	            	if(str.equals(eqEl.getName())){
	            		;
	            	}else{
	            		eqEl.setErrorName(str);
	            		eqEl.setExceptionText("列不存在或者列名与模板的名称不对应！");
	            		flag = false ;
	            	}
	            }else{
	            	eqEl.setExceptionText("列名不存在！");
	            	eqEl.setErrorName(str);
            		flag = false ;
	            }
	        }else{
	        	eqEl.setExceptionText("列名不存在！");
            	eqEl.setErrorName("空列名");
        		flag = false ;
	        }
		}
		if(flag)
			this.setValidate(true);
	}   
	
	/**
     * 根据HSSFCell类型设置数据
     * @param cell
     * @return
     */
    private String getCellFormatValue(Cell cell) {
        String cellvalue = "";
        if (cell != null) {
            // 判断当前Cell的Type
            switch (cell.getCellType()) {
            // 如果当前Cell的Type为NUMERIC
            case HSSFCell.CELL_TYPE_NUMERIC:
            case HSSFCell.CELL_TYPE_FORMULA: {
                // 判断当前的cell是否为Date
                if (HSSFDateUtil.isCellDateFormatted(cell)) {
                    // 如果是Date类型则，转化为Data格式
                    
                    //方法1：这样子的data格式是带时分秒的：2011-10-12 0:00:00
                    //cellvalue = cell.getDateCellValue().toLocaleString();
                    
                    //方法2：这样子的data格式是不带带时分秒的：2011-10-12
                    Date date = cell.getDateCellValue();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    cellvalue = sdf.format(date);
                    
                }
                // 如果是纯数字
                else {
                    // 取得当前Cell的数值
                    cellvalue = String.valueOf(cell.getNumericCellValue());
                }
                break;
            }
            // 如果当前Cell的Type为STRIN
            case HSSFCell.CELL_TYPE_STRING:
                // 取得当前的Cell字符串
                cellvalue = cell.getRichStringCellValue().getString();
                break;
            // 默认的Cell值
            default:
                cellvalue = " ";
            }
        } else {
            cellvalue = "";
        }
        return cellvalue;

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

	public boolean isHasValidate() {
		return hasValidate;
	}

	public void setHasValidate(boolean hasValidate) {
		this.hasValidate = hasValidate;
	}

	public List<HeaderDefEntity> getHeaderList() {
		return headerList;
	}

	public void setHeaderList(List<HeaderDefEntity> headerList) {
		this.headerList = headerList;
	}
    
    
}
