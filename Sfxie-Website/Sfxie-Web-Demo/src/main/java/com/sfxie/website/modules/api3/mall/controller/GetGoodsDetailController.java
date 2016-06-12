package com.sfxie.website.modules.api3.mall.controller;


import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sfxie.extension.logger.LoggerUtil;
import com.sfxie.extension.spring4.mvc.controller.SpringMvcController;
import com.sfxie.extension.spring4.mvc.exception.AbstractExceptionWrapper;
import com.sfxie.extension.spring4.mvc.exception.ExceptionContainer;
import com.sfxie.extension.spring4.mvc.exception.MvcException;
import com.sfxie.soa.modules.dubbo.service.oa.dubbo.CompanyService;
import com.sfxie.soa.modules.dubbo.service.oa.pojo.SfxieSysCompany;
import com.sfxie.soa.modules.dubbo.service.provider.dubbo.TestRegistryService;
import com.sfxie.website.modules.api3.mall.model.getgoodsdetail.request.GetGoodsDetailRequest;
import com.sfxie.website.modules.api3.mall.model.getgoodsdetail.response.GetGoodsDetailResponse;
import com.sfxie.website.modules.api3.mall.service.GetGoodsDetailService;

/**
 * 获取购买商品详情
 * @TODO	
 * @author 	xieshengfeng
 * @email  	xsfcy@126.com
 * @since 	上午14:48:57 2016年03月1日
 * @example		
 *
 */
@RestController
public class GetGoodsDetailController extends SpringMvcController{
	@Resource
	private GetGoodsDetailService getGoodsDetailServiceImpl;
	@Resource
	private CompanyService companyService;
	@Resource
	private TestRegistryService testRegistryService;
	/**
	 * 获取购买商品详情
	 * @TODO	
	 * @author 	xieshengfeng
	 * @email  	xsfcy@126.com
	 * @since 	上午14:48:57 2016年03月1日
	 * @param GetGoodsDetailRequest request
	 * @return	
	 *
	 */
	@RequestMapping(value="/api3/mall/getGoodsDetail", method = RequestMethod.POST)
	public @ResponseBody GetGoodsDetailResponse getGoodsDetail(
			@RequestBody GetGoodsDetailRequest request) {
		
		return (GetGoodsDetailResponse) ExceptionContainer.controller(new AbstractExceptionWrapper(){
			@Override
			public Object doMethod(Object... parameters) throws MvcException {
				LoggerUtil.info("info");
				LoggerUtil.error("error");
				LoggerUtil.debug("debug");
				GetGoodsDetailRequest request = (GetGoodsDetailRequest) parameters[0];
//				System.out.println(testRegistryService.hello("sfxie"));
				SfxieSysCompany sfxieSysCompany = new SfxieSysCompany();
				sfxieSysCompany.setUserId("sfxie");
				sfxieSysCompany.setPassword("111111");
				sfxieSysCompany.setCompany_name_cn("谢声锋");
				Object obj = companyService.querySfxieCompanyList(sfxieSysCompany);
//				return getGoodsDetailServiceImpl.getGoodsDetail(request);
				return new GetGoodsDetailResponse();
			}
		},request);
	}
}