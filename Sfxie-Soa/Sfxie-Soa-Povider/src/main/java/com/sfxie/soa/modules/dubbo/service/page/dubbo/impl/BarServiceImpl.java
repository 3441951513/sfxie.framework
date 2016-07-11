package com.sfxie.soa.modules.dubbo.service.page.dubbo.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sfxie.soa.dubbo.service.BaseRestfulService;
import com.sfxie.soa.modules.dubbo.service.page.dubbo.BarService;
import com.sfxie.soa.modules.dubbo.service.page.pojo.SfxiePageBar;

/**
 * 栏位服务实现
 * @author xiesf
 *
 */
@Service("barService")
public class BarServiceImpl extends BaseRestfulService  implements BarService {

	@Override
	public List<SfxiePageBar> getBarList(String userId) {
		return barList(userId);
	}
	
	private List<SfxiePageBar> barList(String userId){
		List<SfxiePageBar> list = new ArrayList<SfxiePageBar>();
		
		SfxiePageBar bar1 = new SfxiePageBar();
		bar1.setName("testBar1");
		bar1.setText("测试栏目1");
		bar1.setUrl("/dd/ss/test1.html");
		list.add(bar1);
		
		SfxiePageBar bar2 = new SfxiePageBar();
		bar2.setName("testBar2");
		bar2.setText("测试栏目2");
		bar2.setUrl("/dd/ss/test2.html");
		list.add(bar2);
		
		SfxiePageBar bar3 = new SfxiePageBar();
		bar3.setName("testBar3");
		bar3.setText("测试栏目3");
		bar3.setUrl("/dd/ss/test3.html");
		list.add(bar3);
		
		return list;
	}

}
