package com.sfxie.soa.modules.dubbo.service.cm.dubbo.impl;

import org.springframework.stereotype.Service;

import com.sfxie.extension.spring4.properties.SwitchPropertyPlaceholderConfigurer;
import com.sfxie.soa.common.request.SecurityUser;
import com.sfxie.soa.dubbo.service.BaseRestfulService;
import com.sfxie.soa.modules.common.context.Properties;
import com.sfxie.soa.modules.dubbo.service.cm.dubbo.LLRService;
import com.sfxie.soa.modules.dubbo.service.cm.exception.LoginException;
import com.sfxie.soa.modules.dubbo.service.cm.exception.LogoutException;
import com.sfxie.soa.modules.dubbo.service.cm.pojo.LoginRequest;
import com.sfxie.utils.MD5Util;

/**
 * 登录,注销,注册服务实现类
 * @TODO	
 * @author 	xieshengfeng
 * @email  	xsfcy@126.com
 * @since 	下午7:49:22 2016年5月3日
 * @example		
 *
 */
@Service("LLRService")
public class LLRServiceImpl extends BaseRestfulService implements LLRService {

	public void login(SecurityUser request) throws LoginException {
		judgeUserInfo(request);
		if(!request.getUserPassword().equals(MD5Util.string2MD5(((LoginRequest)request).getUser_password()))){
			throw new LoginException(Properties.getProperty("login.error.password"),"login.error.password");
		}
	}

	public void logout(SecurityUser request) throws LogoutException {
		judgeUserInfo(request);
	}

	/**	判断用户信息	*/
	private void judgeUserInfo(SecurityUser request) throws LoginException,LogoutException{
		if(null==((LoginRequest)request).getUser_password()){
			throw new LoginException(Properties.getProperty("login.empty.password"),"login.empty.password");
		}
		if(null==((LoginRequest)request).getUser_id()){
			throw new LoginException(Properties.getProperty("login.empty.username"),"login.empty.username");
		}
	}

}
