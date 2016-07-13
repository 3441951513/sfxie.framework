package com.sfxie.soa.modules.dubbo.service.cm.pojo;

import com.sfxie.extension.mybatis.annotation.ColumnName;
import com.sfxie.soa.common.request.Request;
import com.sfxie.soa.common.request.SecurityContext;
import com.sfxie.soa.common.request.SecurityUser;

public class LoginRequest extends Request implements SecurityUser{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**	用户名(前端传递过来)	*/
	@ColumnName(field="user_id",isId=true)
	private String user_id;

	/**	用户密码(前端传递过来)	*/
	@ColumnName(field="user_password")
	private String user_password;
	
	/**	用户名(前端传递过来) */
	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	/**	用户密码(前端传递过来) */
	public String getUser_password() {
		return user_password;
	}

	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String getUserId() {
		return SecurityContext.getSecurityUser().getUserId();
	}

	@Override
	public String getUserPassword() {
		return SecurityContext.getSecurityUser().getUserPassword();
	}

	@Override
	public String getOrgId() {
		return SecurityContext.getSecurityUser().getOrgId();
	}

}
