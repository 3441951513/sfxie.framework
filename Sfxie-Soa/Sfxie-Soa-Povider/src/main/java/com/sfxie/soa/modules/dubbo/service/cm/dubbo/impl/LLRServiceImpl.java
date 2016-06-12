package com.sfxie.soa.modules.dubbo.service.cm.dubbo.impl;

import org.springframework.stereotype.Service;

import com.sfxie.soa.common.request.Request;
import com.sfxie.soa.common.request.SecurityObject;
import com.sfxie.soa.dubbo.service.BaseRestfulService;
import com.sfxie.soa.modules.dubbo.service.cm.dubbo.LLRService;
import com.sfxie.soa.modules.dubbo.service.cm.exception.LoginException;
import com.sfxie.soa.modules.dubbo.service.cm.exception.LogoutException;
import com.sfxie.soa.modules.dubbo.service.cm.exception.RegisterException;

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

	@Override
	public void login(SecurityObject scurityObject) throws LoginException {
		Request request =   (Request) scurityObject;
		judgeUserInfo(request);
	}

	@Override
	public void logout(SecurityObject scurityObject) throws LogoutException {
		Request request =   (Request) scurityObject;
		judgeUserInfo(request);
	}

	@Override
	public void register(SecurityObject scurityObject) throws RegisterException {
		Request request =   (Request) scurityObject;
		judgeUserInfo(request);
	}

	/**	判断用户信息	*/
	private void judgeUserInfo(Request request){
		if(null==request.getHeader()){
			throw new LoginException("用户信息参数不能为空!");
		}
	}
}
