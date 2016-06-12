package com.sfxie.website.modules.api3.common.pojo;

import java.util.Date;


//@TableName(value="g_ad_electronic_voucher")
public class GAdElectronicVoucher {

//	@ColumnName(field="ID")
	private Long id;
//	@ColumnName(field="GoodsID")
	private String goodsId;
//	@ColumnName(field="OrderID")
	private String orderId;
//	@ColumnName(field="UpdateTime")
	private Date updateTime;
//	@ColumnName(field="State")
	private Short state;
	
	private String evCode;
	
	private Date lockTimes;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public Short getState() {
		return state;
	}
	public void setState(Short state) {
		this.state = state;
	}
	public String getEvCode() {
		return evCode;
	}
	public void setEvCode(String evCode) {
		this.evCode = evCode;
	}
	public Date getLockTimes() {
		return lockTimes;
	}
	public void setLockTimes(Date lockTimes) {
		this.lockTimes = lockTimes;
	}
	
	
}
