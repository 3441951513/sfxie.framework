package com.sfxie.extension.mybatis.dao;

import java.util.Date;

import com.sfxie.core.condition.Condition;
import com.sfxie.extension.mybatis.annotation.ColumnName;
import com.sfxie.extension.mybatis.annotation.ConditionColumn;
import com.sfxie.extension.mybatis.annotation.NotDBField;
import com.sfxie.extension.mybatis.annotation.PartitionField;
import com.sfxie.extension.mybatis.annotation.TableName;
@TableName(value="MASTER")
public class Master implements Condition{
	
	@ColumnName(field="NAME_")
	private String name; 
	
	@ColumnName(field="PARTITION_STRING1")
//	@PartitionField
	private String partitionString1;
	
	private String PARTITION_STRING2;
	
	@ColumnName(field="ID_")
	@PartitionField
	@ConditionColumn
	private Long id;
	
	@NotDBField
	private Date createTime;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPartitionString1() {
		return partitionString1;
	}
	public void setPartitionString1(String partitionString1) {
		this.partitionString1 = partitionString1;
	}
	
	public String getPARTITION_STRING2() {
		return PARTITION_STRING2;
	}
	public void setPARTITION_STRING2(String pARTITION_STRING2) {
		PARTITION_STRING2 = pARTITION_STRING2;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
}
