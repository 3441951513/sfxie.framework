package com.sfxie.website.modules.api3.mall.model.createpurchaseorder.response;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlTransient;

public class Pay {

	/**	必填	支付参数信息串	*/
	private String param_string ;
	/**	必填	支付url	*/
	private String url ;
	/**	可空	提示信息	*/
	private String info;
	/**	支付类型(1-支付宝,2-微信)	*/
	private String type;
	
	private Integer quantity;
	@XmlAttribute
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	@XmlAttribute(name="param_string")
	public String getParam_string() {
		return param_string;
	}
	public void setParam_string(String param_string) {
		this.param_string = param_string;
	}
	@XmlAttribute
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	@XmlTransient
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	@XmlAttribute
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
}
