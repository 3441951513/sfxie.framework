package com.sfxie.test;

import com.sfxie.test.controller.MultyThreadControllerTest;

public class NettyTest {
	/**		设置默认线程数量	*/
	public static int threadCount = 1;
	
	public static String rootUrl = "http://192.168.10.112:8050/";
	
	public static void main(String[] args) {
		testNettyMvc();
	}
	
	public static void testNettyMvc(){
		String xml = "<?xml version=\"1.0\" encoding=\"utf-8\"?><entity name=\"谢声锋\" add=\"xsf"+System.currentTimeMillis()+"\"></entity>";
		MultyThreadControllerTest threadControllerTest = new MultyThreadControllerTest();
		threadControllerTest.setRootUrl(rootUrl);
		threadControllerTest.setThreadCount(threadCount);
		threadControllerTest.setXmlParam(xml);
//		threadControllerTest.setXmlParamFilePath("C:\\Users\\xsf\\workspace\\java\\eclipse\\workspace\\GoLiveFramework\\WebRoot\\jsp\\api\\main\\params\\purchase\\getPurchaseType.json");
		threadControllerTest.setContollerName("foo3");
		threadControllerTest.setThreadRunCount(1);
		threadControllerTest.setThreadSleepSecond(0.1);
		threadControllerTest.multyThreadPostXML();
	}
}
