package com.sfxie.statics.modules.storm.dao;


import com.sfxie.extension.mybatis.annotation.MyBatisRepository;
import com.sfxie.extension.mybatis.dao.AutoUpdateMapper;
import com.sfxie.statics.modules.storm.model.UserStatics;

@MyBatisRepository(Object.class)
public interface StaticsStormMapper extends AutoUpdateMapper{
	public UserStatics lockUserStatics();
}
