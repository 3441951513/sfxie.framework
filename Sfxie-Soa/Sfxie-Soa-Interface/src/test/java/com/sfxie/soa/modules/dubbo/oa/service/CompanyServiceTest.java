package com.sfxie.soa.modules.dubbo.oa.service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sfxie.base.BaseTest;
import com.sfxie.soa.modules.dubbo.service.oa.dubbo.CompanyService;
import com.sfxie.soa.modules.dubbo.service.oa.pojo.SfxieSysCompany;


public class CompanyServiceTest extends BaseTest {

	@Test
	public void queryCompanyList(){
		CompanyService companyService = this.getBeanByName("companyService");
		List<SfxieSysCompany> list =  companyService.querySfxieCompanyList(new SfxieSysCompany());
		System.out.println(list);
	}
	
	@Rollback(true)
	@Test
	public void insertSfxieSysCompany(){
		String create_company_id = UUID.randomUUID().toString();
		CompanyService companyService = this.getBeanByName("companyService");
		SfxieSysCompany sfxieSysCompany = new SfxieSysCompany();
		sfxieSysCompany.setCompany_code("sfxie"+create_company_id);
		sfxieSysCompany.setCompany_name_cn("测试");
		sfxieSysCompany.setCompany_name_en("test");
		sfxieSysCompany.setCreate_company_id(create_company_id);
		sfxieSysCompany.setCreate_user("sfxie");
		sfxieSysCompany.setCreate_time(new Date());
		sfxieSysCompany.setId_(create_company_id);
		companyService.insertEntity(sfxieSysCompany);
	}
}
