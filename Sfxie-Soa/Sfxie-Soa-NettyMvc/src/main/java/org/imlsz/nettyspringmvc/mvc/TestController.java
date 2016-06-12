package org.imlsz.nettyspringmvc.mvc;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sfxie.extension.spring4.mvc.exception.AbstractExceptionWrapper;
import com.sfxie.extension.spring4.mvc.exception.ExceptionContainer;
import com.sfxie.extension.spring4.mvc.exception.MvcException;
import com.sfxie.soa.modules.dubbo.service.oa.dubbo.CompanyService;
import com.sfxie.soa.modules.dubbo.service.oa.pojo.SfxieSysCompany;


@RestController
public class TestController {
	
	@Resource
	private CompanyService companyService;

	@RequestMapping(value="/foo3", method = {RequestMethod.POST,RequestMethod.GET})
    public @ResponseBody NettyMvcEntity handleFoo3( @RequestBody final NettyMvcEntity nettyMvcEntity) {
		
//		NettyMvcEntity nettyMvcEntity = new NettyMvcEntity();
//		nettyMvcEntity.setAdd("add");
//		nettyMvcEntity.setName("sfxie");
//		System.out.println(this);
//		System.out.println(SpringContextHolder.getBeanByName("companyMapper"));
//		System.out.println("TaskRunner thread: "+Thread.currentThread());
		ExceptionContainer.controller(new AbstractExceptionWrapper(){
			@Override
			public Object doMethod(Object... parameters) throws MvcException {
				List<SfxieSysCompany> cs = companyService.querySfxieCompanyList(null);
//				throw new BusinessException("dddd");
				return nettyMvcEntity;
			}
		} , nettyMvcEntity);
        return nettyMvcEntity;
    }
}
