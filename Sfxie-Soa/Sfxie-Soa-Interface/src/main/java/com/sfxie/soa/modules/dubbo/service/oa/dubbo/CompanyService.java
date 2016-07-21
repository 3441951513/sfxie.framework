package com.sfxie.soa.modules.dubbo.service.oa.dubbo;

import java.util.List;

import com.sfxie.core.service.IBaseService;
import com.sfxie.extension.mybatis.interceptor.Page;
import com.sfxie.soa.modules.dubbo.service.oa.pojo.SfxieSysCompany;


/**
 * 公司操作服务类
 * @author 	xieshengfeng
 * @email  	xsfcy@126.com
 * @since 	下午1:45:10 2016年4月19日
 *
 */
public interface CompanyService  extends IBaseService{

	/**
	 * 查询公司列表 
	 * @TODO	
	 * @author 	xieshengfeng
	 * @email  	xsfcy@126.com
	 * @since 	下午1:45:10 2016年4月19日
	 * @example
	 * @return	
	 *
	 */
	public List<SfxieSysCompany> querySfxieCompanyList(SfxieSysCompany sfxieSysCompany);
	
	/**
	 * 查询公司列表 
	 * @TODO	
	 * @author 	xieshengfeng
	 * @email  	xsfcy@126.com
	 * @since 	下午1:45:10 2016年4月19日
	 * @example
	 * @return	
	 *
	 */
	public List<SfxieSysCompany> querySfxieCompanyPage(Page page);

}