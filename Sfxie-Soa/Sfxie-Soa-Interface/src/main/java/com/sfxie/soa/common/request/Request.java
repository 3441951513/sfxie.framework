package com.sfxie.soa.common.request;

import javax.xml.bind.annotation.XmlRootElement;


/**
 * 全局参数请求对象
 * @TODO	
 * @author 	xieshengfeng
 * @email  	xsfcy@126.com
 * @since 	下午6:51:28 2016年5月3日
 * @example		
 *
 */
@XmlRootElement
public class Request  extends SecurityObject{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String test;

	public String getTest() {
		return test;
	}

	public void setTest(String test) {
		this.test = test;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
