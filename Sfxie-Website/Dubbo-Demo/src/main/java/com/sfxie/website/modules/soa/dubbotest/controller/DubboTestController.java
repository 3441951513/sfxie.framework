package com.sfxie.website.modules.soa.dubbotest.controller;


import javax.annotation.Resource;


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
import com.sfxie.soa.modules.dubbo.service.provider.rest.RestfulService;

import com.sfxie.soa.modules.dubbo.service.provider.pojo.Entity;

/**
 * 测试dubbo调用
 * @TODO	
 * @author 	xieshengfeng
 * @email  	xsfcy@126.com
 * @since 	上午14:48:57 2016年03月1日
 * @example		
 *
 */
@RestController
public class DubboTestController extends SpringMvcController{
	@Resource(name="companyServiceRef")
	private CompanyService companyService;
	@Resource(name="testRegistryServiceRef")
	private TestRegistryService testRegistryService;
	@Resource(name="restfulServiceRef")
	private RestfulService restfulService;
	
	/**
	 * 异常测试
	 * @TODO	
	 * @author 	xieshengfeng
	 * @email  	xsfcy@126.com
	 * @since 	下午3:19:57 2016年4月22日
	 * @example
	 * @return	
	 *
	 */
	@RequestMapping(value="/dubbo/test/exception", method = RequestMethod.POST)
	public @ResponseBody Object exception( ) {
		
		return (Object) ExceptionContainer.controller(new AbstractExceptionWrapper(){
			@Override
			public Object doMethod(Object... parameters) throws MvcException {
				SfxieSysCompany sfxieSysCompany = new SfxieSysCompany();
				sfxieSysCompany.setCompany_name_cn("谢声锋");
				Object obj = companyService.querySfxieCompanyList(sfxieSysCompany);
				return "success";
			}
		});
	}
	
	/**
	 * 异常测试
	 * @TODO	
	 * @author 	xieshengfeng
	 * @email  	xsfcy@126.com
	 * @since 	下午3:19:57 2016年4月22日
	 * @example
	 * @return	
	 *
	 */
	@RequestMapping(value="/dubbo/test/rest", method = RequestMethod.POST)
	public @ResponseBody Object rest( ) {
		
		return (Object) ExceptionContainer.controller(new AbstractExceptionWrapper(){
			@Override
			public Object doMethod(Object... parameters) throws MvcException {
				Entity o = restfulService.getUser(11l);
				return o;
			}
		});
	}
}