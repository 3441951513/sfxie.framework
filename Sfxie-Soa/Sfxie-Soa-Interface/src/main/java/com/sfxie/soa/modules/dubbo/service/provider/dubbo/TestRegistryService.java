package com.sfxie.soa.modules.dubbo.service.provider.dubbo;


import com.sfxie.extension.mybatis.service.IAutoUpdateService;
public interface TestRegistryService  extends IAutoUpdateService{

	public abstract String hello(String name);

}