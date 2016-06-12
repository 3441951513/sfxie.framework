package com.sfxie.test.business.api3.makemoney.controller;


import org.junit.Test;

import com.sfxie.test.controller.BaseControllerTest;

public class MakeMoneyModuleControllerTest extends BaseControllerTest{

	/*	测试获取购买分类controller */
	@Test
	public void getPurchaseType(){
		String response = "";
		setContollerName("/api3/purchase/getAdMakeMoneyList");
		setXmlParamFilePath("C:\\Users\\xsf\\workspace\\java\\eclipse\\workspace\\GoLiveLhq3\\WebRoot\\jsp\\api\\main\\params\\common\\Request.json");
		response = postXML();
		System.out.println(response);
	}
}
