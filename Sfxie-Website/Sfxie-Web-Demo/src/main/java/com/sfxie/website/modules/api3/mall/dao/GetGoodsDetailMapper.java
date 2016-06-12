package com.sfxie.website.modules.api3.mall.dao;

import com.sfxie.extension.mybatis.annotation.MyBatisRepository;
import com.sfxie.extension.mybatis.dao.AutoUpdateMapper;


@MyBatisRepository(Object.class)
public interface GetGoodsDetailMapper extends AutoUpdateMapper{
	public GAd3Goods getGAd3GoodsById(Integer goodsid);
}
