package com.sfxie.website.modules.api3.common.pojo;

import com.sfxie.extension.mybatis.annotation.ColumnName;
import com.sfxie.extension.mybatis.annotation.TableName;

/**
 * 订单支付表(用于对账)
 * @TODO	
 * @author 	xieshengfeng
 * @email  	xsfcy@126.com
 * @since 	下午4:30:27 2016年3月20日
 * @example		
 *
 */
@TableName(value="g_ad3_order_pay")
public class GAd3OrderPay {
	  /**
     * 主键ID
     *
     *
     */
	@ColumnName(field="id")
    private Integer id;
    /**
     * 订单编号
     *
     *
     */
    @ColumnName(field="order_code")
    private String orderCode;
    /**
     * 支付类型(1-支付宝,2-微信)
     *
     *
     */
    @ColumnName(field="pay_type")
    private String payType;
    /**
     * 支付状态,1-已支付,0-未支付
     *
     *
     */
    @ColumnName(field="pay_state")
    private String payState;
    
    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPayType() {
		return payType;
	}
	public void setPayType(String payType) {
		this.payType = payType;
	}
	public String getPayState() {
		return payState;
	}
	public void setPayState(String payState) {
		this.payState = payState;
	}
	public String getOrderCode() {
		return orderCode;
	}
	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}
    
    
    
}
