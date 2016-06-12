package com.sfxie.extension.mybatis.dao;

import java.util.List;
import java.util.Map;

import com.sfxie.extension.mybatis.annotation.MyBatisRepository;
import com.sfxie.extension.mybatis.interceptor.PageMybatis;


@MyBatisRepository(Master.class)
public interface MasterMapper extends IMybatisDao<Object, Long> {

	public List<Master> findJoinList(Map<String,Object> map);
	
	public List<Master> findAllList(Map<String,Object> map);
	
	public void insertMaster(Master master);
	
	public List<Master> findPage(PageMybatis<Master> page);
	
	public List<Master> findPage2(PageMybatis<Master> page);
}
