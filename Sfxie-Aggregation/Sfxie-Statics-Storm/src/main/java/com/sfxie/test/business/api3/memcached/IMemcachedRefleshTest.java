package com.sfxie.test.business.api3.memcached;

import java.util.List;

import org.junit.Test;

import com.sfxie.base.BaseTest;
import com.sfxie.extension.memcached.ApiMemcachedManager;
import com.sfxie.website.modules.api3.common.memcached.pojo.SysconfigPO;

public class IMemcachedRefleshTest  extends BaseTest{

	@Test
	public void testIMemcachedReflesh(){
		
		List<SysconfigPO> sysconfigPOs = ApiMemcachedManager.reflesh("sysConfigInit");
		System.out.println(sysconfigPOs.size());
	}
}
