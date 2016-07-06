package com.sfxie.soa.modules.dubbo.service.oa.dubbo.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sfxie.soa.dubbo.service.BaseRestfulService;
import com.sfxie.soa.modules.dubbo.dao.oa.mapper.UserMapper;
import com.sfxie.soa.modules.dubbo.service.oa.dubbo.UserService;
import com.sfxie.soa.modules.dubbo.service.oa.pojo.SfxieSysUserinfo;

@Service("userService")
public class UserServiceImpl  extends BaseRestfulService implements UserService {
	@Resource
	private UserMapper mapper;

	@Override
	public List<SfxieSysUserinfo> querySfxieSysUserinfoList(SfxieSysUserinfo entity) {
		return mapper.getSfxieSysUserinfoList(entity);
	}
	
}
