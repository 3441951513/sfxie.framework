package com.sfxie.soa.modules.dubbo.service.cm.dubbo;

import com.sfxie.core.service.IBaseService;
import com.sfxie.soa.common.request.SecurityUser;
import com.sfxie.soa.modules.dubbo.service.cm.exception.LoginException;
import com.sfxie.soa.modules.dubbo.service.cm.exception.LogoutException;

/**
 * 登录,注销,注册接口服务
 * @TODO	
 * @author 	xieshengfeng
 * @email  	xsfcy@126.com
 * @since 	下午1:10:14 2016年5月3日
 * @example		
 *
 */
public interface LLRService extends IBaseService{

	/**	登录	*/
	public void login(SecurityUser scurityObject) throws LoginException;
	/**	注销	*/
	public void logout(SecurityUser scurityObject) throws LogoutException;
}
