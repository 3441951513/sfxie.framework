package com.sfxie.soa.modules.dubbo.oa.service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.junit.Test;
import org.springframework.test.annotation.Rollback;

import com.sfxie.base.BaseTest;
import com.sfxie.soa.modules.dubbo.service.oa.dubbo.CompanyService;
import com.sfxie.soa.modules.dubbo.service.oa.pojo.SfxieSysCompany;


public class CompanyServiceTest extends BaseTest<CompanyService> {

	@Test
	public void queryCompanyList(){
		List<SfxieSysCompany> list =  getService().querySfxieCompanyList(new SfxieSysCompany());
		System.out.println(list);
	}
	
	@Rollback(true)
	@Test
	public void insertSfxieSysCompany(){
		String create_company_id = UUID.randomUUID().toString();
		SfxieSysCompany sfxieSysCompany = new SfxieSysCompany();
		sfxieSysCompany.setCompany_code("sfxie"+create_company_id);
		sfxieSysCompany.setCompany_name_cn("测试");
		sfxieSysCompany.setCompany_name_en("test");
		sfxieSysCompany.setCreate_company_id(create_company_id);
		sfxieSysCompany.setCreate_user("sfxie");
		sfxieSysCompany.setCreate_time(new Date());
		sfxieSysCompany.setId_(create_company_id);
		getService().insertEntity(sfxieSysCompany);
	}
}
