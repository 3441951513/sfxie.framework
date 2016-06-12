package com.sfxie.website.modules.api3.common.pojo;

import java.util.Date;

import com.sfxie.extension.mybatis.annotation.ColumnName;
import com.sfxie.extension.mybatis.annotation.TableName;

@TableName("g_ad_order_lock")
public class GAdOrderLock {
	
	@ColumnName(field="id")
	private Integer id;
	@ColumnName(field="goods_id")
	private Integer goodsId;
	@ColumnName(field="order_id")
	private Integer orderId;
	@ColumnName(field="lock_time")
	private Date lockTime;
	@ColumnName(field="quantity")
	private Integer quantity;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public Date getLockTime() {
		return lockTime;
	}
	public void setLockTime(Date lockTime) {
		this.lockTime = lockTime;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	
	
}
