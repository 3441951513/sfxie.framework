package com.sfxie.soa.modules.dubbo.service.oa.dubbo;

import java.util.List;

import com.sfxie.core.service.IBaseService;
import com.sfxie.soa.modules.dubbo.service.oa.exception.RegisterException;
import com.sfxie.soa.modules.dubbo.service.oa.pojo.SfxieSysUserinfo;


/**
 * 用户信息操作服务类
 * @author 	xieshengfeng
 * @email  	xsfcy@126.com
 * @since 	下午1:45:10 2016年4月19日
 *
 */
public interface UserService  extends IBaseService{

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
	public List<SfxieSysUserinfo> querySfxieSysUserinfoList(SfxieSysUserinfo entity);
	/**
	 * 用户注册
	 * @param sfxieSysUserinfo
	 * 			用户信息
	 * @return
	 */
	public Object register(SfxieSysUserinfo sfxieSysUserinfo ) throws RegisterException;

}