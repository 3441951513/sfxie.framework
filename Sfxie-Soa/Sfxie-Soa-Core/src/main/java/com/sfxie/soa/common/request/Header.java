package com.sfxie.soa.common.request;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 接口请求头,用于接口安全控制
 * @TODO	
 * @author 	xieshengfeng
 * @email  	xsfcy@126.com
 * @since 	下午2:51:18 2016年5月3日
 * @example		
 *
 */
@XmlRootElement(name="header")
public class Header implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	/**	合作者ID(唯一)	*/
	private String appId;
	/**	合作者Key	*/
	private String appKey;
	/**	访问控制令牌	*/
	private String token;
	/**	访问控制令牌过期时间	*/
	private int tokenExpireTime;
	/**	签名md5(token+tokenExpireTime+appId+appKey)-唯一	*/
	private String signature;;
	
	
	
	@XmlElement(name="appId")
	public String getAppId() {
		return appId;
	}
	public void setAppId(String appId) {
		this.appId = appId;
	}
	public String getAppKey() {
		return appKey;
	}
	public void setAppKey(String appKey) {
		this.appKey = appKey;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public int getTokenExpireTime() {
		return tokenExpireTime;
	}
	public void setTokenExpireTime(int tokenExpireTime) {
		this.tokenExpireTime = tokenExpireTime;
	}
	public String getSignature() {
		return signature;
	}
	public void setSignature(String signature) {
		this.signature = signature;
	}
	
}
