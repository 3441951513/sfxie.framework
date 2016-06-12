package com.sfxie.website.modules.api3.mall.service;

import com.sfxie.website.modules.api3.mall.model.getgoodsdetail.request.GetGoodsDetailRequest;
import com.sfxie.website.modules.api3.mall.model.getgoodsdetail.response.GetGoodsDetailResponse;

public interface GetGoodsDetailService {

	public abstract GetGoodsDetailResponse getGoodsDetail(
			GetGoodsDetailRequest request);

}