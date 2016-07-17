package com.sfxie.ui.extjs5.grid.entity;

public class ColumnEntity {

	private String dataIndex;
	private String type;
	private String xtype;
	private String editor;
//	private Boolean editable;
	private Boolean tip;
	private Boolean date;
	private String header;
	private String comboName;
	private String comboType;
	private Integer flex;
	private String titleAlign;
	private String sortType;
	
	
	public String getEditor() {
		return editor;
	}
	public void setEditor(String editor) {
		this.editor = editor;
	}
	public String getDataIndex() {
		return dataIndex;
	}
	public void setDataIndex(String dataIndex) {
		this.dataIndex = dataIndex;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getXtype() {
		return xtype;
	}
	public void setXtype(String xtype) {
		this.xtype = xtype;
	}
	/*public Boolean getEditable() {
		return editable;
	}
	public void setEditable(Boolean editable) {
		this.editable = editable;
	}*/
	
	public Boolean getTip() {
		return tip;
	}
	public void setTip(Boolean tip) {
		this.tip = tip;
	}
	public Boolean getDate() {
		return date;
	}
	public void setDate(Boolean date) {
		this.date = date;
	}
	public String getHeader() {
		return header;
	}
	public void setHeader(String header) {
		this.header = header;
	}
	public String getComboName() {
		return comboName;
	}
	public void setComboName(String comboName) {
		this.comboName = comboName;
	}
	public String getComboType() {
		return comboType;
	}
	public void setComboType(String comboType) {
		this.comboType = comboType;
	}
	public Integer getFlex() {
		return flex;
	}
	public void setFlex(Integer flex) {
		this.flex = flex;
	}
	public String getTitleAlign() {
		return titleAlign;
	}
	public void setTitleAlign(String titleAlign) {
		this.titleAlign = titleAlign;
	}
	public String getSortType() {
		return sortType;
	}
	public void setSortType(String sortType) {
		this.sortType = sortType;
	}
	
	
	
	
}
