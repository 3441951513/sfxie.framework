package com.sfxie.website.modules.soa.app.controller;


import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sfxie.extension.spring4.mvc.controller.SpringMvcController;
import com.sfxie.extension.spring4.mvc.exception.AbstractExceptionWrapper;
import com.sfxie.extension.spring4.mvc.exception.ExceptionContainer;
import com.sfxie.extension.spring4.mvc.exception.MvcException;
import com.sfxie.soa.modules.dubbo.service.app.dubbo.BarService;
import com.sfxie.soa.modules.dubbo.service.cm.pojo.LoginRequest;

/**
 * 登录,注销,注册控制器
 * @TODO	
 * @author 	xieshengfeng
 * @email  	xsfcy@126.com
 * @since 	上午09:45:57 2016年05月03日
 * @example		
 *
 */
@RestController
public class PageController extends SpringMvcController{
	
	private BarService barService;
	
	/**
	 * 获取当前用户可见的栏位
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/page/user/bars", method = RequestMethod.POST)
	public @ResponseBody Object login(@RequestBody final LoginRequest request ) {
		
		return (Object) ExceptionContainer.controller(new AbstractExceptionWrapper(request){
			@Override
			public Object doMethod(Object... obj) throws MvcException {
				return barService.getBarList(request.getUser_id());
			}
		});
	}
}