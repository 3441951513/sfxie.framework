package com.sfxie.test.business.api3.makemoney.controller;


import org.junit.Test;

import com.sfxie.test.controller.BaseControllerTest;
import com.sfxie.test.controller.MultyThreadControllerTest;

public class MakeMoneyModuleControllerTest extends BaseControllerTest{

	@Test
	public void getAdMakeMoneyList(){
		/*String response = "";
		setContollerName("/api3/purchase/getAdMakeMoneyList");
		setXmlParamFilePath("C:\\Users\\xsf\\workspace\\java\\eclipse\\workspace\\GoLiveLhq3\\WebRoot\\jsp\\api\\main\\params\\common\\Request.json");
		response = postXML();
		System.out.println(response);*/
		
	}
	public static void main(String[] args) {
		/**	测试获取购买分类controller */
		for(int i=0;i<1000;i++){
			new Thread(new Runnable() {
				@Override
				public void run() {
					MultyThreadControllerTest threadControllerTest = new MultyThreadControllerTest();
					threadControllerTest.setThreadCount(1);
					threadControllerTest.setXmlParamFilePath("C:\\Users\\xsf\\workspace\\java\\eclipse\\workspace\\GoLiveLhq3\\WebRoot\\jsp\\api\\main\\params\\mall\\getGoodsDetail.xml");
					threadControllerTest.setContollerName("/api3/mall/getGoodsDetail");
					threadControllerTest.setThreadRunCount(1);
					threadControllerTest.setThreadSleepSecond(1);
					threadControllerTest.multyThreadPostXML();
				}
			}).start();;
		}
		try {
			Thread.currentThread().sleep(1000000000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
