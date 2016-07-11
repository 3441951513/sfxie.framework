package com.sfxie.soa.modules.dubbo.service.page.dubbo;

import java.util.List;

import com.sfxie.core.service.IBaseService;
import com.sfxie.soa.modules.dubbo.service.page.pojo.SfxiePageBar;

/**
 * 栏位服务接口
 * @author xiesf
 *
 */
public interface BarService extends IBaseService {

	/**
	 * 根据用户获取用户可见的栏位
	 * @param userId
	 * 			用户名
	 * @return
	 */
	public List<SfxiePageBar> getBarList(String userId);
}
