package com.sfxie.website.modules.api3.mall.model.wxinfo4qrcode4ad.confirm;

import java.util.Date;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.sfxie.website.modules.api3.common.jaxb.DateYYYYMMDDHHMMSSXmlAdapter;
import com.sfxie.website.modules.api3.common.jaxb.PriceFenConvertXmlAdapter;

public class WxConfirmOrder {

	private String serial;
	
	private String productName;
	
	private String price;
	
	private String valid;
	
	private Date createTime;
	
	private Date expireTime;

	@XmlAttribute
	public String getSerial() {
		return serial;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}
	@XmlAttribute
	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}
	@XmlAttribute
	@XmlJavaTypeAdapter(PriceFenConvertXmlAdapter.class)
	public String getPrice() {
		return price;
	}
 
	public void setPrice(String price) {
		this.price = price;
	}
	@XmlAttribute
	public String getValid() {
		return valid;
	}

	public void setValid(String valid) {
		this.valid = valid;
	}
	@XmlAttribute
	@XmlJavaTypeAdapter(DateYYYYMMDDHHMMSSXmlAdapter.class)
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	@XmlAttribute
	@XmlJavaTypeAdapter(DateYYYYMMDDHHMMSSXmlAdapter.class)
	public Date getExpireTime() {
		return expireTime;
	}

	public void setExpireTime(Date expireTime) {
		this.expireTime = expireTime;
	}
	
	
//	serial="13508" productName="" price="" valid="true" creat
//			eTime="" expireTime=""
}
