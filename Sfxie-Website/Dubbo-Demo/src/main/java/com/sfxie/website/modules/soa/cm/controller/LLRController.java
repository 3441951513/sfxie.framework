package com.sfxie.website.modules.soa.cm.controller;


import javax.annotation.Resource;







import javax.xml.bind.JAXBException;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sfxie.extension.spring4.mvc.controller.SpringMvcController;
import com.sfxie.extension.spring4.mvc.exception.AbstractExceptionWrapper;
import com.sfxie.extension.spring4.mvc.exception.ExceptionContainer;
import com.sfxie.extension.spring4.mvc.exception.MvcException;
import com.sfxie.soa.common.request.Request;
import com.sfxie.soa.modules.dubbo.service.cm.dubbo.LLRService;
import com.sfxie.soa.modules.dubbo.service.cm.pojo.UserEntity;
import com.sfxie.soa.modules.dubbo.service.cm.pojo.xml.LoginRequest;
import com.sfxie.utils.XmlUtils;

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
public class LLRController extends SpringMvcController{
	@Resource(name="LLRService")
	private LLRService llRService;
	
	/**
	 * 登录
	 * @TODO	
	 * @author 	xieshengfeng
	 * @email  	xsfcy@126.com
	 * @since 	上午09:48:57 2016年05月03日
	 * @example
	 * @return	
	 *
	 */
	@RequestMapping(value="/cm/login", method = RequestMethod.POST)
	public @ResponseBody Object login(@RequestBody final Request request ) {
		
		return (Object) ExceptionContainer.controller(new AbstractExceptionWrapper(){
			@Override
			public Object doMethod(Object... parameters) throws MvcException {
//				Request<UserEntity> request = new Request<UserEntity>();
				llRService.login((Request)parameters[0]);
				return "success";
			}
		},request);
	}
	/**
	 * 注销
	 * @TODO	
	 * @author 	xieshengfeng
	 * @email  	xsfcy@126.com
	 * @since 	上午09:48:57 2016年05月03日
	 * @example
	 * @return	
	 *
	 */
	@RequestMapping(value="/cm/logout", method = RequestMethod.POST)
	public @ResponseBody Object logout( ) {
		
		return (Object) ExceptionContainer.controller(new AbstractExceptionWrapper(){
			@Override
			public Object doMethod(Object... parameters) throws MvcException {
//				Request request = new Request();
//				llRService.logout(request);
				return "success";
			}
		});
	}
	/**
	 * 注册
	 * @TODO	
	 * @author 	xieshengfeng
	 * @email  	xsfcy@126.com
	 * @since 	上午09:48:57 2016年05月03日
	 * @example
	 * @return	
	 *
	 */
	@RequestMapping(value="/cm/register", method = RequestMethod.POST)
//	public @ResponseBody Object register(@RequestBody final Request<UserEntity> request ) {
	public @ResponseBody Object register( ) {	
		return (Object) ExceptionContainer.controller(new AbstractExceptionWrapper(){
			@Override
			public Object doMethod(Object... parameters) throws MvcException {
//				Request request = new Request();
//				llRService.register(request);
				return "success";
			}
		});
	}
	/*public static void main(String[] args) {
		String xml = "<?xml version=\"1.0\" encoding=\"utf-8\"?>"+
						"<request website=\"http://xxxx\" description=\"用户登录\">"+
						"	<parameter>"+
						"		<user_name>谢声锋</user_name>"+
						"	</parameter>"+
						"	<header><appId>1</appId></header>"+
						"</request>";
		try {
			LoginRequest d = XmlUtils.unserializer(LoginRequest.class, xml);
			Object dd = d.getParameter();
			System.out.println(1);;
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
}