package com.sfxie.website.common.context;

import com.sfxie.extension.spring4.mvc.context.Context;
import com.sfxie.soa.modules.dubbo.service.oa.pojo.SfxieSysUserinfo;

public class SystemContext extends Context {

	public SystemContext(){
		super();
	}
	
	public static SfxieSysUserinfo getCurrentSfxieSysUserinfo (){
		SfxieSysUserinfo user = new SfxieSysUserinfo();
		user.setCreate_company_id("00000000");
		user.setUser_id("13246779797");
		return user;
	}
}
