package com.sfxie.soa.common.request;

import java.io.Serializable;


public interface SecurityUser  extends Serializable{

	/**
	 * 获取登录用户id
	 * @param user_password
	 */
	public String getUserId();

	/**	获取登录用户密码	*/
	public String getUserPassword();
	/**	获取登录用户所在组织	*/
	public String getOrgId();
}
