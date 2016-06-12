package com.sfxie.soa.common.request;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;

/**
 * 安全控制传输实体
 * @TODO	
 * @author 	xieshengfeng
 * @email  	xsfcy@126.com
 * @since 	下午1:58:06 2016年4月20日
 * @example		
 *
 */
public class SecurityObject implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	protected Header header;
	
	@XmlElement(name="header")
	public Header getHeader() {
		return header;
	}

	public void setHeader(Header header) {
		this.header = header;
	}
	
	
	/*private String userId;
	
	private String userName;
	
	private String password;


	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	*/
	
}
