package com.sfxie.test.business.api.test.golive.rts;





import javax.xml.bind.JAXBException;

import com.sfxie.test.controller.MultyThreadCallback;
import com.sfxie.test.controller.MultyThreadControllerTest;
import com.sfxie.utils.XmlUtils;

public class GoLiveLhqRtsControllerThreadTest{

	/**		设置默认线程数量	*/
	public static int threadCount = 1;
	
	public static String rootUrl = "http://sfxie112:8080/GoLiveAdvertAPI/";
	
	public static void main(String[] args) {
		/////////////////////////////////////////////////
		testPurchaseTypeController();
		//////////////////////////////////////////////////
		
		/*String response = "<?xml version=\"1.0\" encoding=\"utf-8\" ?>"+
				"<response website=\"http://sfxie112:8080/GoLiveAdvertAPI/dynamicData-reportPVLog.action\">"+
				    "<error type=\"false\" note=\"\" servertime=\"2016-01-16 15:37:18\"/>"+
						"<data pv_log_id=\"10353198\" get_golds=\"\" is_max=\"0\" total_golds=\"\"/>"+
				"</response>";
		try {
			RtsResponse rtsResponse  = XmlUtils.unserializer(RtsResponse.class, response);
		} catch (JAXBException e) {
			e.printStackTrace();
		}*/

	}
	/**	测试获取购买分类controller */
	public static void testPurchaseTypeController(){
		MultyThreadControllerTest threadControllerTest = new MultyThreadControllerTest();
		threadControllerTest.getParameterMap().put("parameter","");
		threadControllerTest.setRootUrl(rootUrl);
		threadControllerTest.setThreadCount(threadCount);
		final String parameterPath = "C:\\Users\\xsf\\workspace\\java\\eclipse\\workspace\\GoLiveFramework\\test\\com\\golive\\test\\business\\api\\test\\golive\\rts\\ReportPVLog.json";
		threadControllerTest.setXmlParamFilePath(parameterPath);
		threadControllerTest.setContollerName("/dynamicData-reportPVLog.action");
		threadControllerTest.setThreadRunCount(500);
		threadControllerTest.setThreadSleepSecond(0);
		threadControllerTest.setCallback(new MultyThreadCallback(){
			@Override
			public void callback(String response) {
				RtsResponse rtsResponse;
				try {
					rtsResponse = XmlUtils.unserializer(RtsResponse.class, response);
					MultyThreadControllerTest threadControllerTest = new MultyThreadControllerTest();
					threadControllerTest.getParameterMap().put("parameter",rtsResponse.getData().getPvLogId());
					threadControllerTest.setRootUrl(rootUrl);
					threadControllerTest.setThreadCount(threadCount);
					threadControllerTest.setXmlParamFilePath(parameterPath);
					threadControllerTest.setContollerName("/dynamicData-reportPVLog.action");
					threadControllerTest.setThreadRunCount(1);
					threadControllerTest.setThreadSleepSecond(0);
					threadControllerTest.multyThreadPostXML();
				} catch (JAXBException e) {
					e.printStackTrace();
				}
			}
		});
		threadControllerTest.multyThreadPostXML();
		
	}
	
}
