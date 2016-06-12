package com.sfxie.test.business.api.test;




import org.apache.log4j.Logger;

import com.sfxie.test.controller.MultyThreadControllerTest;
import com.sfxie.utils.DateHelper;
import com.sfxie.utils.LoggerUtil;

public class PurchaseModuleControllerThreadTest{

	/**		设置默认线程数量	*/
	public static int threadCount = 1;
	
	public static String rootUrl = "http://192.168.10.112:8080/GoLiveFramework/springmvc/";
	
	public static void main(String[] args) {
//		Logger logger = LoggerUtil.instance(PurchaseModuleControllerThreadTest.class);
//		logger.info(DateHelper.getChineseNow()+"开始测试");
//		logger.info(DateHelper.getChineseNow()+"结束测试"+"\r\n\r\n");
		/////////////////////////////////////////////////
		testPurchaseTypeController();
		testRecommendPurchaseController();
		testPurchaseDetailController();
		testPurchaseListController();
		testQueryPayStateController();
		testLotteryEntranceInfoController();
		testFindLotteryStaticInfoType2();
		//////////////////////////////////////////////////
		System.out.println();

	}
	/**	测试获取购买分类controller */
	public static void testPurchaseTypeController(){
		MultyThreadControllerTest threadControllerTest = new MultyThreadControllerTest();
		threadControllerTest.setRootUrl(rootUrl);
		threadControllerTest.setThreadCount(threadCount);
		threadControllerTest.setXmlParamFilePath("C:\\Users\\xsf\\workspace\\java\\eclipse\\workspace\\GoLiveFramework\\WebRoot\\jsp\\api\\main\\params\\purchase\\getPurchaseType.json");
		threadControllerTest.setContollerName("PurchaseTypeController");
		threadControllerTest.setThreadRunCount(10);
		threadControllerTest.setThreadSleepSecond(0.01);
		threadControllerTest.multyThreadPostXML();
	}
	/**	测试获取推荐购买controller */
	public static void testRecommendPurchaseController(){
		MultyThreadControllerTest threadControllerTest = new MultyThreadControllerTest();
		threadControllerTest.setRootUrl(rootUrl);
		threadControllerTest.setThreadCount(threadCount);
		threadControllerTest.setXmlParamFilePath("C:\\Users\\xsf\\workspace\\java\\eclipse\\workspace\\GoLiveFramework\\WebRoot\\jsp\\api\\main\\params\\purchase\\getRecommendPurchase.json");
		threadControllerTest.setContollerName("RecommendPurchaseController");
		threadControllerTest.setThreadRunCount(10);
		threadControllerTest.setThreadSleepSecond(0.01);
		threadControllerTest.multyThreadPostXML();
	}
	/**	测试获取购买详情controller */
	public static void testPurchaseDetailController(){
		MultyThreadControllerTest threadControllerTest = new MultyThreadControllerTest();
		threadControllerTest.setRootUrl(rootUrl);
		threadControllerTest.setThreadCount(threadCount);
		threadControllerTest.setXmlParamFilePath("C:\\Users\\xsf\\workspace\\java\\eclipse\\workspace\\GoLiveFramework\\WebRoot\\jsp\\api\\main\\params\\purchase\\getPurchaseDetail.json");
		threadControllerTest.setContollerName("PurchaseDetailController");
		threadControllerTest.setThreadRunCount(10);
		threadControllerTest.setThreadSleepSecond(0.01);
		threadControllerTest.multyThreadPostXML();
	}
	/**	测试获取商品列表controller */
	public static void testPurchaseListController(){
		MultyThreadControllerTest threadControllerTest = new MultyThreadControllerTest();
		threadControllerTest.setRootUrl(rootUrl);
		threadControllerTest.setThreadCount(threadCount);
		threadControllerTest.setXmlParamFilePath("C:\\Users\\xsf\\workspace\\java\\eclipse\\workspace\\GoLiveFramework\\WebRoot\\jsp\\api\\main\\params\\purchase\\getPurcaseList.json");
		threadControllerTest.setContollerName("PurchaseListController");
		threadControllerTest.setThreadRunCount(10);
		threadControllerTest.setThreadSleepSecond(0.01);
		threadControllerTest.multyThreadPostXML();
	}
	/**	测试查询支付状态controller */
	public static void testQueryPayStateController(){
		MultyThreadControllerTest threadControllerTest = new MultyThreadControllerTest();
		threadControllerTest.setRootUrl(rootUrl);
		threadControllerTest.setThreadCount(threadCount);
		threadControllerTest.setXmlParamFilePath("C:\\Users\\xsf\\workspace\\java\\eclipse\\workspace\\GoLiveFramework\\WebRoot\\jsp\\api\\main\\params\\purchase\\queryPayState.json");
		threadControllerTest.setContollerName("QueryPayStateController");
		threadControllerTest.setThreadRunCount(10);
		threadControllerTest.setThreadSleepSecond(0.01);
		threadControllerTest.multyThreadPostXML();
	}
	/**	测试获取彩票入口信息controller */
	public static void testLotteryEntranceInfoController(){
		MultyThreadControllerTest threadControllerTest = new MultyThreadControllerTest();
		threadControllerTest.setRootUrl(rootUrl);
		threadControllerTest.setThreadCount(threadCount);
		threadControllerTest.setXmlParamFilePath("C:\\Users\\xsf\\workspace\\java\\eclipse\\workspace\\GoLiveFramework\\WebRoot\\jsp\\api\\main\\params\\purchase\\getLotteryEntranceInfo.json");
		threadControllerTest.setContollerName("LotteryEntranceInfoController");
		threadControllerTest.setThreadRunCount(10);
		threadControllerTest.setThreadSleepSecond(0.01);
		threadControllerTest.multyThreadPostXML();
	}
	/**	测试查看彩种 */
	public static void testFindLotteryStaticInfoType2(){
		MultyThreadControllerTest threadControllerTest = new MultyThreadControllerTest();
		threadControllerTest.setRootUrl(rootUrl);
		threadControllerTest.setThreadCount(threadCount);
		threadControllerTest.setXmlParamFilePath("C:\\Users\\xsf\\workspace\\java\\eclipse\\workspace\\GoLiveFramework\\WebRoot\\jsp\\api\\main\\params\\purchase\\queryLotteryType.json");
		threadControllerTest.setContollerName("ApiCommonController");
		threadControllerTest.setContollerMethod("findLotteryStaticInfoType2");
		threadControllerTest.setThreadRunCount(10);
		threadControllerTest.setThreadSleepSecond(0.01);
		threadControllerTest.multyThreadPostXML();
	}
}
