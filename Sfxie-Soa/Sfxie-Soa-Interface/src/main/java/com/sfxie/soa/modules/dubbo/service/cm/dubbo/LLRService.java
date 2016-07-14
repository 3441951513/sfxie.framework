package com.sfxie.soa.modules.dubbo.service.cm.dubbo;

import com.sfxie.core.service.IBaseService;
import com.sfxie.soa.modules.dubbo.service.cm.exception.LoginException;
import com.sfxie.soa.modules.dubbo.service.cm.exception.LogoutException;
import com.sfxie.soa.modules.dubbo.service.oa.pojo.SfxieSysUserinfo;

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
	public void login(SfxieSysUserinfo request) throws LoginException;
	/**	注销	*/
	public void logout(SfxieSysUserinfo request) throws LogoutException;
}
