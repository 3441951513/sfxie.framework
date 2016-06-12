package com.sfxie.extension.upload.document.excel;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.sfxie.extension.upload.document.excel.header.HeaderDefEntity;
import com.sfxie.extension.upload.document.excel.header.HeaderDefLinkedList;
import com.sfxie.extension.upload.document.excel.visitor.IHeaderDefVisitor;


/**
 * 上传excel处理模块的操作Excel表格的功能类
 * @TODO	
 * @author 	xieshengfeng
 * @email  	xsfcy@126.com
 * @since 	下午3:45:08 2015年8月21日
 * @example	
 * <code>
 * 		
  		String fileName = "用户充值.xls";//用户充值.xlsx
  		InputStream in = new FileInputStream(file);<br>
		// excel的第四行数据列定义<br>
		HeaderDefLinkedList headerCellLinkeList2 = new HeaderDefLinkedList();<br>
       	headerCellLinkeList2.setValidatedRowIndex(1);<br>
       	headerCellLinkeList2.setDataType("list");<br>
       	HeaderDefEntity headerCellEntity21 = new UserIdEHDInteger("member","用户ID","A");<br>
       	HeaderDefEntity headerCellEntity22 = new EHDDouble("value","充值金额(单位：分)","B");<br>
       	HeaderDefEntity headerCellEntity23 = new EHDString("reason","操作原因","C");<br>
       	headerCellLinkeList2.addHeaderDefEntity(headerCellEntity21);<br>
       	headerCellLinkeList2.addHeaderDefEntity(headerCellEntity22);<br>
       	headerCellLinkeList2.addHeaderDefEntity(headerCellEntity23);<br>
    	ExcelReader excelReader = new ExcelReader();<br>
    	excelReader.getHeaderDefinitionList().add(headerCellLinkeList2);<br>
    	String fileName = action.getUploadFileName();<br>
		String fileType = fileName.split("\\.")[fileName.split("\\.").length - 1];<br>
		excelReader.setFileType(fileType);<br>
     	excelReader.validateDocumentDefinition(in) ;<br>
     	excelReader.setHeaderDefVisitor(new RechargeHeaderDefVisitor());<br>
     	Map<String,Object> result = new HashMap<String,Object>();<br>
		if (excelReader.getErrorHeaderDefinitionList().size() > 0) {<br>
			result.put("success", false);<br>
			result.put("errorHeaderDefinitionList",excelReader.getErrorHeaderDefinitionList());<br>
		} else {<br>
			excelReader.getData();<br>
			result.put("success", true);<br>
			result.put("cellValueSubList",excelReader.getCellValueSubList());<br>
		}<br>
		action.setResult(result);<br>
 * </code>
 * 	
 *
 */
public class ExcelReader {
	/**	文件类型:xls或xlsx*/
	private String fileType;
	/**	表头定义访问者	*/
	private IHeaderDefVisitor headerDefVisitor;
	/**	excel文档	*/
    private Workbook wb;
    /**	excel文档sheet	*/
    private Sheet sheet;
    /**	表头定义列表	*/
    private List<HeaderDefLinkedList> headerDefinitionList;
    /**	错误表头列表	*/
    private List<HeaderDefLinkedList> errorHeaderDefinitionList;
    /**	single类型的值列表	*/
    private List<CellValueEntity> cellValueList;
    /**	list类型的值列表	*/
    private List<List<CellValueEntity>> cellValueSubList;


    /**
     * 根据HSSFCell类型设置数据
     * @param cell
     * @param cellValueEntity 
     * @return
     */
    private void getCellFormatValue(Cell cell,HeaderDefEntity headerDefEntity, CellValueEntity cellValueEntity) {
        Object cellvalue = null;
        if (cell != null) {
            // 判断当前Cell的Type
            switch (cell.getCellType()) {
            // 如果当前Cell的Type为NUMERIC
            case HSSFCell.CELL_TYPE_NUMERIC:
            	cellvalue = cell.getNumericCellValue();
            case HSSFCell.CELL_TYPE_FORMULA: {
                // 判断当前的cell是否为Date
                if (HSSFDateUtil.isCellDateFormatted(cell)) {
                	cellvalue = cell.getDateCellValue();
                }
                break;
            }
            // 如果当前Cell的Type为STRIN
            case HSSFCell.CELL_TYPE_STRING:
                // 取得当前的Cell字符串
                cellvalue = StringUtils.trim(cell.getRichStringCellValue().getString());
                break;
            // 默认的Cell值
            default:
                cellvalue = " ";
            }
        } 
        headerDefEntity.setValue(cellvalue);
//        if(headerDefEntity.validateValue(headerDefVisitor,cellValueEntity)){
//        	cellValueEntity.setValue(headerDefEntity.accept(headerDefVisitor));
//        }
    }
    /**
     * 验证表头
     * @TODO	
     * @author 	xieshengfeng
     * @email  	xsfcy@126.com
     * @since 	下午4:11:07 2015年8月17日
     * @param is	
     *
     */
    public void validateDocumentDefinition(InputStream is){
    	if ("xls".equals(fileType)) {
    		try {
    			wb = new HSSFWorkbook(is);
    		} catch (Exception e1) {
    			e1.printStackTrace();
    		}
		}else if ("xlsx".equals(fileType)) {
			try {
				wb = new XSSFWorkbook(is);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		sheet = wb.getSheetAt(0);
        // 得到总行数
        // 正文内容应该从第二行开始,第一行为表头的标题
		while(null!=getHeaderDefLinkedList()){
			HeaderDefLinkedList headerDefLinkedList = getHeaderDefLinkedList();
	        if(null!=headerDefLinkedList){
	    		//如果str和定义的名称一致
	    		headerDefLinkedList.validateRow(sheet);
	    		headerDefLinkedList.setHasValidate(true);
	    	}else{
	    		return ;
	    	}
    	}
		if(null!=this.headerDefinitionList)
			for(HeaderDefLinkedList headerDefLinkedList :this.headerDefinitionList){
				if(!headerDefLinkedList.isValidate()){
					this.getErrorHeaderDefinitionList().add(headerDefLinkedList);
				}
			}
		
    }
    public void getData(){
    	if(null!=this.headerDefinitionList){
    		for(HeaderDefLinkedList headerDefLinkedList :this.headerDefinitionList){
    			//处理single类型
    			if("single".equals(headerDefLinkedList.getDataType())){
    				Row row = sheet.getRow(headerDefLinkedList.getValidatedRowIndex()-1);
    				for(HeaderDefEntity headerDefEntity : headerDefLinkedList.getHeaderList()){
    					headerDefEntity.setOriginalValue(null);
    					Cell cell = row.getCell(headerDefEntity.getCellIndex());
    					CellValueEntity cellValueEntity = new CellValueEntity();
    					getCellFormatValue(cell,headerDefEntity,cellValueEntity);
    					//验证单元格内容
    					if(!headerDefEntity.validateValue(headerDefVisitor,cellValueEntity)){
    						if(null!=headerDefEntity.getOriginalValue()){
    							cellValueEntity.setOriginalValue(headerDefEntity.getOriginalValue());
    						}
//    						continue;
    			        }
    					cellValueEntity.setValue(headerDefEntity.accept(headerDefVisitor));
    					cellValueEntity.setName(headerDefEntity.getName());
    					cellValueEntity.setCode(headerDefEntity.getCode());
    					this.getCellValueList().add(cellValueEntity);
    				}
    			}
    			//处理list类型
    			else if("list".equals(headerDefLinkedList.getDataType())){
    				int rowNum = sheet.getLastRowNum();
    				int startRow = headerDefLinkedList.getValidatedRowIndex();
    				for(;startRow<=rowNum;startRow++){
    					Row row = sheet.getRow(startRow); 
    					List<CellValueEntity> cellList = new ArrayList<CellValueEntity>();
    					for(HeaderDefEntity headerDefEntity : headerDefLinkedList.getHeaderList()){
    						headerDefEntity.setOriginalValue(null);
    						Cell cell = row.getCell(headerDefEntity.getCellIndex());
    						CellValueEntity cellValueEntity = new CellValueEntity();
    						getCellFormatValue(cell,headerDefEntity,cellValueEntity);
    						//验证单元格内容
        					if(!headerDefEntity.validateValue(headerDefVisitor,cellValueEntity)){
        						if(null!=headerDefEntity.getOriginalValue()){
        							cellValueEntity.setOriginalValue(headerDefEntity.getOriginalValue());
        						}
//        						continue;
        			        }
        					cellValueEntity.setValue(headerDefEntity.accept(headerDefVisitor));
        					cellValueEntity.setName(headerDefEntity.getName());
    						cellValueEntity.setCode(headerDefEntity.getCode());
    						cellList.add(cellValueEntity);
    					}
    					if(!judgeCellValueEntityIsAllNull(cellList))
    						this.getCellValueSubList().add(cellList);
    				}
    			}
    		}
    	}
	}
    private boolean judgeCellValueEntityIsAllNull(List<CellValueEntity> cellList ){
    	int listSize = 0;
    	for(CellValueEntity cellValueEntity : cellList){
    		if(StringUtils.isEmpty(cellValueEntity.getValue())){
    			listSize++;
    		}
    	}
    	if(listSize == cellList.size())
    		return true;
    	return false;
    }
	public List<HeaderDefLinkedList> getHeaderDefinitionList() {
		if(null==headerDefinitionList)
			headerDefinitionList = new ArrayList<HeaderDefLinkedList>();
		return headerDefinitionList;
	}

	public void setHeaderDefinitionList(
			List<HeaderDefLinkedList> headerDefinitionList) {
		this.headerDefinitionList = headerDefinitionList;
	}
    
	private HeaderDefLinkedList getHeaderDefLinkedList(){
		if(null!=this.headerDefinitionList)
			for(HeaderDefLinkedList headerDefLinkedList : this.headerDefinitionList){
				if(!headerDefLinkedList.isValidate() && !headerDefLinkedList.isHasValidate()){
					return headerDefLinkedList;
				}
			}
		return null;
	}
	
	public List<CellValueEntity> getCellValueList() {
		if(null == cellValueList)
			cellValueList = new ArrayList<CellValueEntity>();
		return cellValueList;
	}

	public void setCellValueList(List<CellValueEntity> cellValueList) {
		this.cellValueList = cellValueList;
	}

	public List<List<CellValueEntity>> getCellValueSubList() {
		if(null == cellValueSubList)
			cellValueSubList = new ArrayList<List<CellValueEntity>> ();
		return cellValueSubList;
	}

	public void setCellValueSubList(List<List<CellValueEntity>> cellValueSubList) {
		this.cellValueSubList = cellValueSubList;
	}

	public List<HeaderDefLinkedList> getErrorHeaderDefinitionList() {
		if(null==errorHeaderDefinitionList)
			errorHeaderDefinitionList = new ArrayList<HeaderDefLinkedList>();
		return errorHeaderDefinitionList;
	}

	public void setErrorHeaderDefinitionList(
			List<HeaderDefLinkedList> errorHeaderDefinitionList) {
		this.errorHeaderDefinitionList = errorHeaderDefinitionList;
	}

	public void setHeaderDefVisitor(
			IHeaderDefVisitor headerDefVisitor) {
		this.headerDefVisitor = headerDefVisitor;
	}
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	
	
}