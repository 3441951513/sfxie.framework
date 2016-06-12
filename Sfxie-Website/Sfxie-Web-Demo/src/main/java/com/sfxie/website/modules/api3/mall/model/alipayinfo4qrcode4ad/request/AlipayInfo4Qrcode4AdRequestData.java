package com.sfxie.website.modules.api3.mall.model.alipayinfo4qrcode4ad.request;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.sfxie.website.modules.api3.common.jaxb.PriceFenConvertXmlAdapter;


public class AlipayInfo4Qrcode4AdRequestData{

	private String subject;
	
	private String body;
	
	private String price;
	/**	订单编号	*/
	private String order;
	/**	通知地址：包含订单编号参数用于关联购买订单	*/
	private	String notifyUrl;
	/**	订单失效时间(单位分钟)	*/
	private String expire;

	@XmlAttribute
	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
	@XmlAttribute
	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}
	@XmlJavaTypeAdapter(PriceFenConvertXmlAdapter.class)
	@XmlAttribute
	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
	@XmlAttribute
	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}
	@XmlAttribute
	public String getNotifyUrl() {
		return notifyUrl;
	}

	public void setNotifyUrl(String notifyUrl) {
		this.notifyUrl = notifyUrl;
	}
	@XmlAttribute
	public String getExpire() {
		return expire;
	}

	public void setExpire(String expire) {
		this.expire = expire;
	}
	

}
