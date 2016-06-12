package com.sfxie.soa.modules.dubbo.service.cm.pojo;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * 用户登录,注销,注册实体
 * @TODO	
 * @author 	xieshengfeng
 * @email  	xsfcy@126.com
 * @since 	下午8:12:35 2016年5月3日
 * @example		
 *
 */
@XmlRootElement(name="data")
public class UserEntity{

	private String user_name;
	
	private String user_password;

	private String user_type;
	
	private String user_mail;
	
	@XmlElement(name="user_name")
	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	@XmlElement(name="user_password")
	public String getUser_password() {
		return user_password;
	}

	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}

	@XmlElement(name="user_type")
	public String getUser_type() {
		return user_type;
	}

	public void setUser_type(String user_type) {
		this.user_type = user_type;
	}

	@XmlElement(name="user_mail")
	public String getUser_mail() {
		return user_mail;
	}

	public void setUser_mail(String user_mail) {
		this.user_mail = user_mail;
	}
	
	
}
