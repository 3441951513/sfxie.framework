package com.sfxie.statics.modules.storm.service.impl;

import org.springframework.stereotype.Service;

import com.sfxie.extension.mybatis.service.AutoUpdateService;
import com.sfxie.statics.modules.storm.model.UserStatics;


@Service(value="staticsStormServiceImpl")
public class StaticsStormServiceImpl extends AutoUpdateService   {
	
	public void saveOrUpdateToMysql(UserStatics userStatics){
		
		insertEntity(userStatics);
	}
}
