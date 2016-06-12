package com.sfxie.test.business.api.test;


import org.junit.Test;

import com.sfxie.test.controller.BaseControllerTest;

public class PurchaseModuleControllerTest extends BaseControllerTest{

	/*	测试获取购买分类controller */
	@Test
	public void getPurchaseType(){
		String xmlParam = "<?xml version=\"1.0\" encoding=\"utf-8\"?>"+
							"<request website=\"http://xxxx\" pro_version=\"0.0.1\" app_version=\"0.0.1\" >"+
							"	<parameter iname=\"getPurchaseType\" apktype=\"1\" language=\"zh\" region=\"CN\" >"+
							"		<device dnum=\"120799599\" didtoken=\"a12eacf12213\" devmodel=\"rtd299x_tv030\" dver=\"x\" devtype=\"1\" clienttype=\"TCL-CN-RT95-E5700M-UDM\""+ 
							"		mac=\"408BF6F92D2E\" deviceid=\"\"/>"+
							"		<user userid=\"123\" token=\"\" />"+
							"	</parameter>"+
							"</request>";
		
		String response = "";
		setContollerName("PurchaseTypeController");
		setContollerMethod("getPurchaseType");
		setXmlParam(xmlParam);
		response = postXML();
		/*for(int i=0;i<10000;i++){
			setContollerName("PurchaseTypeController");
			setXmlParam(xmlParam);
			response = postXML();
			System.out.println(i);
		}*/
		System.out.println(response);
	}
	/*	测试获取推荐购买controller */
//	@Test
	public void getRecommendPurchase(){
//		deleteRecommendPurchaseList();
		/*String xmlParam = "<?xml version=\"1.0\" encoding=\"utf-8\"?>"+
							"<request website=\"http://xxxx\" pro_version=\"0.0.1\" app_version=\"0.0.1\" >"+
							"	<parameter iname=\"getRecommendPurchase\" apktype=\"1\" language=\"zh\" region=\"CN\">"+
							"	<device dnum=\"120799599\" didtoken=\"a12eacf12213\" devmodel=\"rtd299x_tv030\" dver=\"x\" devtype=\"1\" clienttype=\"TCL-CN-RT95-E5700M-UDM\""+ 
							"	mac=\"408BF6F92D2E\" deviceid=\"\"/>"+
							"	<user userid=\"123\" token=\"a213\" />"+
							"		<data startseq=\"1\"  limit=\"1\"/>"+
							"	</parameter>"+
							"</request>";*/
		String xmlParam = "<?xml version=\"1.0\" encoding=\"utf-8\"?>"+
							"<request"+
							"	website=\"http://183.60.142.159:8117/mallapi/springmvc/RecommendPurchaseController\""+
							"	pro_version=\"0.0.0.22\" app_version=\"2.2.3.9_advert_release\""+
							"	packagename=\"com.sfxie.advert\" versioncode=\"50\" apktype=\"4\">"+
							"	<parameter iname=\"getRecommendPurchase\" apktype=\"4\" language=\"zh\""+
							"		region=\"CN\">"+
							"		<device dnum=\"\" didtoken=\"\" devmodel=\"TianTian\" dver=\"x\""+
							"			devtype=\"1\" clienttype=\"OTHER\" mac=\"0800270D1988\" deviceid=\"\" />"+
							"		<user userid=\"10114\" token=\"dfb56d01f4e4fe5ea05f6a35599022a6\" />"+
							"		<data startseq=\"0\" limit=\"0\" />"+
							"	</parameter>"+
							"</request>";
		setContollerName("RecommendPurchaseController");
//		setContollerMethod("getPurchaseType");
		setXmlParam(xmlParam);
		String response = postXML();
		System.out.println(response);
	}
//	@Test
	/*	测试获取购买详情controller */
	public void getPurchaseDetail(){
		String xmlParam = "<?xml version=\"1.0\" encoding=\"utf-8\"?>"+
							"<request website=\"http://xxxx\" pro_version=\"0.0.1\" app_version=\"0.0.1\" >"+
							"	<parameter iname=\"getPurchaseDetail\" apktype=\"1\" language=\"zh\" region=\"CN\">"+
							"		<device dnum=\"120799599\" didtoken=\"a12eacf12213\" devmodel=\"rtd299x_tv030\" dver=\"x\" devtype=\"1\" clienttype=\"TCL-CN-RT95-E5700M-UDM\""+ 
							"		mac=\"408BF6F92D2E\" deviceid=\"\"/>"+
							"		<user userid=\"10114\" token=\"a213\" />"+
							"		<data goodsid=\"18\"/>"+
							"	</parameter>"+
							"</request>";
		
		setContollerName("PurchaseDetailController");
		setXmlParam(xmlParam);
		String response = postXML();
		System.out.println(response);
	}
//	@Test
	/*	测试获取商品列表controller */
	public void getPurchaseList(){
		String xmlParam = "<?xml version=\"1.0\" encoding=\"utf-8\"?>"+
							"<request website=\"http://xxxx\" pro_version=\"0.0.1\" app_version=\"0.0.1\" >"+
							"	<parameter iname=\"getPurchaseList\" apktype=\"1\" language=\"zh\" region=\"CN\">"+
							"		<device dnum=\"120799599\" didtoken=\"a12eacf12213\" devmodel=\"rtd299x_tv030\" dver=\"x\" devtype=\"1\" clienttype=\"TCL-CN-RT95-E5700M-UDM\""+ 
							"		mac=\"408BF6F92D2E\" deviceid=\"\"/>"+
							"		<user userid=\"10114\" token=\"a213\" />"+
							"		<data goodstype=\"12\"  startseq=\"0\"  limit=\"0\"/>"+
							"	</parameter>"+
							"</request>";
		
		setContollerName("PurchaseListController");
		setXmlParam(xmlParam);
		String response = postXML();
		System.out.println(response);
	}
//	@Test
	/*	测试查询支付状态controller */
	public void getPayState(){
		String xmlParam = "<?xml version=\"1.0\" encoding=\"utf-8\"?>"+
							"<request website=\"http://xxxx\" pro_version=\"0.0.1\" app_version=\"0.0.1\" >"+
							"	<parameter iname=\"getPayState\" apktype=\"1\" language=\"zh\" region=\"CN\">"+
							"		<device dnum=\"120799599\" didtoken=\"a12eacf12213\" devmodel=\"rtd299x_tv030\" dver=\"x\" devtype=\"1\" clienttype=\"TCL-CN-RT95-E5700M-UDM\""+ 
							"		mac=\"408BF6F92D2E\" deviceid=\"\"/>"+
							"		<user userid=\"10114\" token=\"a213\" />"+
							"		<data orderid=\"100\"/>"+
							"	</parameter>"+
							"</request>";
		
		setContollerName("QueryPayStateController");
		setXmlParam(xmlParam);
		String response = postXML();
		System.out.println(response);
	}
//	@Test
	/*	测试获取彩票入口信息controller */
	public void getLotteryEntranceInfo(){
		String xmlParam = "<?xml version=\"1.0\" encoding=\"utf-8\"?>"+
							"<request website=\"http://xxxx\" pro_version=\"0.0.1\" app_version=\"0.0.1\" >"+
							"	<parameter iname=\"getLotteryEntranceInfo\" apktype=\"1\" language=\"zh\" region=\"CN\">"+
							"		<device dnum=\"120799599\" didtoken=\"a12eacf12213\" devmodel=\"rtd299x_tv030\" dver=\"x\" devtype=\"1\" clienttype=\"TCL-CN-RT95-E5700M-UDM\""+ 
							"		mac=\"408BF6F92D2E\" deviceid=\"\"/>"+
							"		<user userid=\"10114\" token=\"a213\" />"+
							"	</parameter>"+
							"</request>";
		
		setContollerName("LotteryEntranceInfoController");
		setXmlParam(xmlParam);
		String response = postXML();
		System.out.println(response);
	}
//	@Test
	/*	测试查看彩种 */
	public void getLotteryStaticInfoType2(){
		String xmlParam = "<?xml version=\"1.0\" encoding=\"utf-8\"?>"+
				"<request website=\"http://xxxx\" pro_version=\"0.0.1\" app_version=\"0.0.1\" >"+
				"	<parameter iname=\"getLotteryEntranceInfo\" apktype=\"1\" language=\"zh\" region=\"CN\">"+
				"		<device dnum=\"120799599\" didtoken=\"a12eacf12213\" devmodel=\"rtd299x_tv030\" dver=\"x\" devtype=\"1\" clienttype=\"TCL-CN-RT95-E5700M-UDM\""+ 
				"		mac=\"408BF6F92D2E\" deviceid=\"\"/>"+
				"		<user userid=\"10114\" token=\"a213\" />"+
				"	</parameter>"+
				"</request>";
		setContollerName("ApiCommonController");
		setContollerMethod("findLotteryStaticInfoType2");
		setXmlParam(xmlParam);
		String response = postXML();
		System.out.println(response);
	}
//	@Test
	/*	测试创建购买订单 */
	public void createPurchaseOrder(){
		String xmlParam = "<?xml version=\"1.0\" encoding=\"utf-8\"?>"+
				"<request website=\"http://xxxx\" pro_version=\"0.0.1\" app_version=\"0.0.1\" >"+
				"	<parameter iname=\"createPurchaseOrder\" apktype=\"1\" language=\"zh\" region=\"CN\">"+
				"		<device dnum=\"120799599\" didtoken=\"a12eacf12213\" devmodel=\"rtd299x_tv030\" dver=\"x\" devtype=\"1\" clienttype=\"TCL-CN-RT95-E5700M-UDM\""+ 
				"		mac=\"408BF6F92D2E\" deviceid=\"\"/>"+
				"		<user userid=\"10001\" token=\"99e731ee05d9155b1947bedac74b4314\" />"+
				"		<data phone=\"100\" goodsid=\"19\" quantity=\"1\" />"+
				"		<client versioncode=\"50\" version=\"2.2.18.03_cinema_release\""+
				"			type=\"4\" mac=\"408BF6FA75D3\" deviceid=\"a18b3f1df718883d94a15a9eae1d4a428a496192\""+
				"			clienttype=\"NT667B\" />"+
				"	</parameter>"+
				"</request>";
//		<client clienttype="TCL-CN-RT95-E6700Q-UDM" mac="408BF6FABA86" deviceid="9cf96c59fe1125f785057baa6d736539d9a7be27" version="2.2.18.03_cinema_release" versioncode="50" type="2" />
		setContollerName("PurchaseOrderController");
		setXmlParam(xmlParam);
		String response = postXML();
		System.out.println(response);
	}
//	@Test
	/*	测试删除推荐购买缓存数据 */
	public void deleteRecommendPurchaseList(){
		String xmlParam = "";
		
		setContollerName("ApiMemcachedManagerController");
		setContollerMethod("deleteRecommendPurchaseList");
		setXmlParam(xmlParam);
		String response = postXML();
		System.out.println(response);
	}
//	@Test
	/*	测试刷新推荐购买商品列表数据缓存 */
	public void refleshRecommendPurchaseList(){
		String xmlParam = "";
		setContollerName("ApiMemcachedManagerController");
		setContollerMethod("refleshRecommendPurchaseList");
		setXmlParam(xmlParam);
		String response = postXML();
		System.out.println(response);
	}
//	@Test
	/*	测试刷新购买分类列表数据缓存 */
	public void refleshPurchaseTypeList(){
		String xmlParam = "";
		setContollerName("ApiMemcachedManagerController");
		setContollerMethod("refleshPurchaseTypeList");
		setXmlParam(xmlParam);
		String response = postXML();
		System.out.println(response);
	}
//	@Test
	/*	测试刷新商品列表数据缓存 */
	public void refleshPurchaseList(){
		String xmlParam = "";
		setContollerName("ApiMemcachedManagerController");
		setContollerMethod("refleshPurchaseList");
		setXmlParam(xmlParam);
		String response = postXML();
		System.out.println(response);
	}
//	@Test
	/*	测试刷新刷新彩种说明缓存*/
	public void refleshLotteryStaticInfoType2(){
		String xmlParam = "";
		setContollerName("ApiMemcachedManagerController");
		setContollerMethod("refleshLotteryStaticInfoType2");
		setXmlParam(xmlParam);
		String response = postXML();
		System.out.println(response);
	}
//	@Test
	public void testPurchaseOrder4ZFBController(){
		String stringParam = "orderSerial=207711433380772843";
		setContollerName("PurchaseOrder4ZFBController/changePurchaseOrderState");
		setStringParam(stringParam);
		String response = postString();
		System.out.println(response);
	}
}
