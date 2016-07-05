package com.sfxie.soa.modules.dubbo.oa.service;

import java.util.List;

import org.junit.Test;

import com.sfxie.base.BaseTest;
import com.sfxie.soa.modules.dubbo.service.oa.dubbo.UserService;
import com.sfxie.soa.modules.dubbo.service.oa.pojo.SfxieSysUserinfo;


public class UserServiceTest extends BaseTest<UserService,SfxieSysUserinfo> {

	@Test
	public void queryCompanyList(){
		List<SfxieSysUserinfo> list =  getService().querySfxieSysUserinfoList(new SfxieSysUserinfo());
		System.out.println(list);
	}
	

	@Override
	protected SfxieSysUserinfo getInsertEntity() {
		
		SfxieSysUserinfo entity = new SfxieSysUserinfo();
		entity.setUser_id("User"+getUUID());
		entity.setUser_password("dddd");
		entity.setCreate_company_id(getUUID());
		return entity;
	}
	@Override
	protected SfxieSysUserinfo getUpdateEntity() {
		return null;
	}
}
