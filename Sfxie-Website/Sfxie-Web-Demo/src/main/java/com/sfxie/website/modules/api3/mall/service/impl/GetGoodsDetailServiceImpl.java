package com.sfxie.website.modules.api3.mall.service.impl;



import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sfxie.extension.mybatis.service.AutoUpdateService;
import com.sfxie.extension.spring4.mvc.exception.AbstractExceptionWrapper;
import com.sfxie.extension.spring4.mvc.exception.ExceptionContainer;
import com.sfxie.extension.spring4.mvc.exception.MvcException;
import com.sfxie.website.modules.api3.mall.dao.GAd3Goods;
import com.sfxie.website.modules.api3.mall.dao.GetGoodsDetailMapper;
import com.sfxie.website.modules.api3.mall.model.getgoodsdetail.request.GetGoodsDetailRequest;
import com.sfxie.website.modules.api3.mall.model.getgoodsdetail.response.GetGoodsDetailResponse;
import com.sfxie.website.modules.api3.mall.model.getgoodsdetail.response.Goods;
import com.sfxie.website.modules.api3.mall.service.GetGoodsDetailService;

@Service 
public class GetGoodsDetailServiceImpl  extends AutoUpdateService implements GetGoodsDetailService {
	

	@Resource
	private GetGoodsDetailMapper getGoodsDetailMapper;
	/* (non-Javadoc)
	 * @see com.sfxie.website.modules.api3.mall.service.impl.GetGoodsDetailService#getAdQuestionList(com.sfxie.website.modules.api3.mall.model.getgoodsdetail.request.GetGoodsDetailRequest)
	 */
	@Override
	public GetGoodsDetailResponse getGoodsDetail(GetGoodsDetailRequest request) {
//		throws MvcException
		return (GetGoodsDetailResponse) ExceptionContainer.service(new AbstractExceptionWrapper(){
			@Override
			public Object doMethod(Object... parameters) throws MvcException {
				GetGoodsDetailRequest request = (GetGoodsDetailRequest) parameters[0];
				GetGoodsDetailResponse response = new GetGoodsDetailResponse();
				GAd3Goods gAd3GoodsTemp  = getGoodsDetailMapper.getGAd3GoodsById(request.getParameter().getData().getGoodsid());
//				System.out.println(gAd3GoodsTemp.getId());
				return response;
			}
		},request);
	} 
}
