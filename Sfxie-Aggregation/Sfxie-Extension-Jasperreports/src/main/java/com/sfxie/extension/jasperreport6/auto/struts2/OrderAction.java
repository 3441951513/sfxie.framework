package com.sfxie.advert.modules.order.web;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import net.sf.json.JSONArray;

import org.apache.poi.ss.usermodel.Workbook;

import com.sfxie.advert.common.util.ConfigUtil;
import com.sfxie.advert.common.util.DateHelper;
import com.sfxie.advert.common.util.Tool;
import com.sfxie.advert.common.util.XmlUtils;
import com.sfxie.advert.modules.ad.persistence.pojo.AdGoods;
import com.sfxie.advert.modules.order.persistence.pojo.AdGoodsPosters;
import com.sfxie.advert.modules.order.persistence.pojo.AdGoodsType;
import com.sfxie.advert.modules.order.persistence.pojo.AdHotGoods;
import com.sfxie.advert.modules.order.persistence.pojo.AdOrder;
import com.sfxie.advert.modules.order.persistence.pojo.AdOrderAddress;
import com.sfxie.advert.modules.order.persistence.pojo.AdOrderGoods;
import com.sfxie.advert.modules.order.service.IGoodsPostersService;
import com.sfxie.advert.modules.order.service.IGoodsService;
import com.sfxie.advert.modules.order.service.IGoodsTypeService;
import com.sfxie.advert.modules.order.service.IHotGoodsService;
import com.sfxie.advert.modules.order.service.IOrderAddressService;
import com.sfxie.advert.modules.order.service.IOrderGoodsService;
import com.sfxie.advert.modules.order.service.IOrderService;
import com.sfxie.advert.modules.statistics.persistence.pojo.AdAnalysisExchange;
import com.sfxie.advert.modules.statistics.persistence.pojo.AdAnalysisExchangeDetail;
import com.sfxie.advert.modules.statistics.service.IStatisticsService;
import com.sfxie.advert.modules.userlog.persistence.pojo.CodePojo;
import com.sfxie.extension.jasperreport6.auto.detailfield.ColumnDetailFieldDefinition;
import com.sfxie.extension.jasperreport6.auto.detailfield.single.CDFDate;
import com.sfxie.extension.jasperreport6.auto.detailfield.single.CDFFloat;
import com.sfxie.extension.jasperreport6.auto.detailfield.single.CDFLong;
import com.sfxie.extension.jasperreport6.auto.detailfield.single.CDFRowIndex;
import com.sfxie.extension.jasperreport6.auto.detailfield.single.CDFString;
import com.sfxie.extension.jasperreport6.auto.detailfield.single.state.CDFIntegerState;
import com.sfxie.extension.jasperreport6.auto.reprot.ReportAutoGenerator;
import com.sfxie.extension.jasperreport6.auto.reprot.ReportDefinition;
import com.sfxie.extension.jasperreport6.auto.struts2.AutoJasperAction;
import com.mysql.jdbc.StringUtils;
import com.opensymphony.xwork2.ActionContext;

public class OrderAction extends AutoJasperAction {
	private static final long serialVersionUID = 5343174235682023681L;
	private IOrderAddressService orderAddressService;
	private IOrderGoodsService orderGoodsService;
	private IOrderService orderService;
	private List<AdOrderAddress> orders;
	private List<AdOrderGoods> goodsList;
//	private List<Map<String, Object>> statistics;
//	private List<Map<String, Object>> details;
	private List<AdAnalysisExchange> statistics;
	private List<AdAnalysisExchangeDetail> details;
	private AdAnalysisExchange exchange;
	private Long orderId;
	private AdOrderAddress order;
	private Date startDate;
	private Date endDate;
	private String uploadfileUrl;
	private InputStream excelStream;
	private String fileName;
	private Date nowDate;
	private String statisticsIds;
	private IGoodsService goodsService;
	private IHotGoodsService hotGoodsService;
	private IGoodsPostersService goodsPostersService;
	private List<AdGoods> goods;
	private AdGoods adGoods;
	private String ids;
	private String jsonResult;

	public Date getNowDate() {
		return this.nowDate;
	}

	public void setNowDate(Date nowDate) {
		this.nowDate = nowDate;
	}

	public String getFileName() {
		try {
			if (this.fileName != null) {
				return new String(this.fileName.getBytes("gb2312"), "iso8859-1");
			}

			return "report.xlsx";
		} catch (UnsupportedEncodingException e) {
		}
		return "report.xlsx";
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public InputStream getExcelStream() {
		return this.excelStream;
	}

	public void setExcelStream(InputStream excelStream) {
		this.excelStream = excelStream;
	}


	public String getStatisticsIds() {
		return this.statisticsIds;
	}

	public void setStatisticsIds(String statisticsIds) {
		this.statisticsIds = statisticsIds;
	}

	public AdAnalysisExchange getExchange() {
		return this.exchange;
	}

	public void setExchange(AdAnalysisExchange exchange) {
		this.exchange = exchange;
	}

	public void setOrderService(IOrderService orderService) {
		this.orderService = orderService;
	}

	public List<AdAnalysisExchange> getStatistics() {
		return statistics;
	}

	public void setStatistics(List<AdAnalysisExchange> statistics) {
		this.statistics = statistics;
	}

	public List<AdAnalysisExchangeDetail> getDetails() {
		return details;
	}

	public void setDetails(List<AdAnalysisExchangeDetail> details) {
		this.details = details;
	}

	public String getUploadfileUrl() {
		return this.uploadfileUrl;
	}

	public void setUploadfileUrl(String uploadfileUrl) {
		this.uploadfileUrl = uploadfileUrl;
	}

	public List<AdOrderGoods> getGoodsList() {
		return this.goodsList;
	}

	public void setGoodsList(List<AdOrderGoods> goodsList) {
		this.goodsList = goodsList;
	}

	public Long getOrderId() {
		return this.orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public void setOrderGoodsService(IOrderGoodsService orderGoodsService) {
		this.orderGoodsService = orderGoodsService;
	}

	public List<AdOrderAddress> getOrders() {
		return this.orders;
	}

	public void setOrders(List<AdOrderAddress> orders) {
		this.orders = orders;
	}

	public AdOrderAddress getOrder() {
		return this.order;
	}

	public void setOrder(AdOrderAddress order) {
		this.order = order;
	}

	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public void setOrderAddressService(IOrderAddressService orderAddressService) {
		this.orderAddressService = orderAddressService;
	}

	public String index() throws Exception {
		setToPage("/cms/jsp/order/management/index.jsp");
		return "success";
	}

	public String list() throws Exception {
		this.nowDate = DateHelper.getStartDate(new Date());

		this.orders = this.orderAddressService.findOrders(this.pager,
				this.order, this.startDate, this.endDate).getData();
		setToPage("/cms/jsp/order/management/list.jsp");
		return "success";
	}

	public String goodsIndex() throws Exception {
		this.order = ((AdOrderAddress) this.orderAddressService
				.getByKey(this.order.getId()));
		setToPage("/cms/jsp/order/management/goodsIndex.jsp");
		return "success";
	}

	public String goodsList() throws Exception {
		if (this.orderId != null) {
			AdOrderGoods goods = new AdOrderGoods();
			AdOrder od = new AdOrder();
			od.setId(this.orderId);
			goods.setOrder(od);
			this.uploadfileUrl = ConfigUtil.getProperty("uploadfile.url");
			this.goodsList = this.orderGoodsService.findOrderGoods(this.pager,
					goods).getData();
		}
		setToPage("/cms/jsp/order/management/goodsList.jsp");
		return "success";
	}
	
	IStatisticsService statisticsService;
	
	public void setStatisticsService(IStatisticsService statisticsService) {
		this.statisticsService = statisticsService;
	}


	public String statisticsIndex() throws Exception {
		setToPage("/cms/jsp/order/statistics/index.jsp");
		return "success";
	}

	public String statisticsList() throws Exception {
//		statistics = orderService.findOrderStatistics(pager,exchange, startDate, endDate).getData();
		statistics = statisticsService.findOrderStatistics(pager,exchange, startDate, endDate).getData();
		setToPage("/cms/jsp/order/statistics/list.jsp");
		return "success";
	}

	public String statisticsDetailIndex() throws Exception {
		setToPage("/cms/jsp/order/statistics/detailIndex.jsp");
		return "success";
	}

	public String statisticsDetailList() throws Exception {
//		details = orderService.findStatisticsDetail(pager,statisticsIds).getData();
		details = statisticsService.findStatisticsOderDetail(pager,statisticsIds).getData();
		setToPage("/cms/jsp/order/statistics/detailList.jsp");
		return "success";
	}

	public String exportExcelStatistics() throws Exception {
		setFileName("兑换量统计.xlsx");
		ActionContext ac = ActionContext.getContext();
		ServletContext sc = (ServletContext) ac.get("com.opensymphony.xwork2.dispatcher.ServletContext");
		String templateDir = sc.getRealPath("/")+ "static/templates/orderExchange.xlsx";

		Map map = new HashMap();
		if ((exchange != null) && (exchange.getGoodsName() != null)&& (!"".equals(exchange.getGoodsName()))) {
			exchange.setGoodsName(URLDecoder.decode(exchange.getGoodsName(), "UTF-8"));
		}

//		statistics = orderService.findOrderStatistics(exchange,startDate, endDate);
		statistics = statisticsService.findOrderStatistics(null,exchange, startDate, endDate).getData();
		String reportDate = null;
		if ((statistics == null) || (statistics.size() == 0)) {
			statistics = new ArrayList();
			reportDate = "";
		} else {
//			reportDate = DateHelper.formatDateType(startDate,"yyyy-MM-dd")+ " 至 "+ DateHelper.formatDateType(endDate,"yyyy-MM-dd");
			reportDate = statisticsService.getOrderReportDate(exchange, startDate, endDate);
		}
		
		map.put("list", this.statistics);
		map.put("reportDate", reportDate);
		map.put("nowDate",
				DateHelper.formatDateType(new Date(), "yyyy-MM-dd HH:mm:ss"));

		Workbook workbook = Tool.getWorkBook(templateDir, map);
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		workbook.write(output);
		byte[] ba = output.toByteArray();
		this.excelStream = new ByteArrayInputStream(ba);
		output.flush();
		output.close();
		return "excel";
	}

	public String exportExcelDetail() throws Exception {
		ActionContext ac = ActionContext.getContext();
		ServletContext sc = (ServletContext) ac.get("com.opensymphony.xwork2.dispatcher.ServletContext");
		String templateDir = sc.getRealPath("/")+ "static/templates/exchangeDetail.xlsx";

		Map map = new HashMap();
//		this.details = orderService.findStatisticsDetail(statisticsIds);
		details = statisticsService.findStatisticsOderDetail(null,statisticsIds).getData();
		String reportDate = null;
		if ((details == null) || (details.size() == 0)) {
			details = new ArrayList();
			reportDate = "";
		} else {
//			reportDate = DateHelper.formatDateType(startDate,"yyyy-MM-dd")+ " 至 "+ DateHelper.formatDateType(endDate,"yyyy-MM-dd");
			reportDate = statisticsService.getOrderDetailReportDate(statisticsIds);
		}
		map.put("list", this.details);
		map.put("reportDate", reportDate);
		map.put("nowDate",
				DateHelper.formatDateType(new Date(), "yyyy-MM-dd HH:mm:ss"));

		Workbook workbook = Tool.getWorkBook(templateDir, map);
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		workbook.write(output);
		byte[] ba = output.toByteArray();
		this.excelStream = new ByteArrayInputStream(ba);
		output.flush();
		output.close();
		return "excel";
	}

	public String saveState() throws Exception {
		this.orderAddressService.updateOrderAddress(this.order);
		return "success";
	}

	public String goodIndex() throws Exception {
		setToPage("/cms/jsp/order/goods/index.jsp");
		return "success";
	}

	public String goodList() throws Exception {
		this.pager.setEsc(Boolean.valueOf(false));
		this.goods = this.goodsService.fingListGoods(this.pager, this.adGoods)
				.getData();
		setToPage("/cms/jsp/order/goods/list.jsp");
		return "success";
	}

	public String goodAdd() throws Exception {
		adGoods = new AdGoods();
		adGoods.setTypeparList(goodsService.getSelect("id","name","g_ad_goods_type"," where `Level` = 1 and state = 1 "));
		setToPage("/cms/jsp/order/goods/add.jsp");
		return "success";
	}

	public String goodEdit() throws Exception {
		if (this.adGoods != null){
			adGoods = goodsService.getGoodsByKey(adGoods.getId());
		}
		
		adGoods.setTypeparList(goodsService.getSelect("id","name","g_ad_goods_type"," where `Level` = 1 and state = 1 "));
		if (!StringUtils.isEmptyOrWhitespaceOnly(adGoods.getType()+"")) {
			CodePojo cp = new CodePojo();
			cp.setCodevalue(adGoods.getType()+"");
			adGoods.setTypeList(goodsService.ajaxGetSelect(cp,1));
		}
		setToPage("/cms/jsp/order/goods/edit.jsp");
		return "success";
	}
	
	//获取下拉选项列表
	private List<CodePojo> codePojos;

	private CodePojo codePojo;
	
	public String ajaxGetSelect () throws Exception {
		if (codePojo != null) {
			codePojos = goodsService.ajaxGetSelect(codePojo,2);
			JSONArray jsonArray = JSONArray.fromObject(codePojos);
			jsonResult = jsonArray.toString();
		}else {
			jsonResult = "error";
		}
		return SUCCESS;
	}

	public String goodSave() throws Exception {
		if (this.adGoods != null) {
			Date now = new Date();
			List<AdGoods> upLst = new ArrayList<AdGoods>();
			if (this.adGoods.getId() == null) {//新增
				//获取主键
				Long goodsId = this.goodsService.getGoodsId();
				this.adGoods.setId(goodsId);
				this.adGoods.setCreateTime(now);
			}else { //修改
				//先删除热门商品和商品图片
				hotGoodsService.deleteByGoodsIds(adGoods.getId()+"");
				goodsPostersService.deleteByGoodsIds(adGoods.getId()+"");
			}
			upLst.add(adGoods);
			goodsService.saveOrUpdateAll(upLst);
			//保存热门商品类型
			String[] levs = this.adGoods.getLev().split(",");
			for (int i = 0; i < levs.length; i++) {
				AdHotGoods adHotGoods = new AdHotGoods();
				adHotGoods.setGoodsId(this.adGoods.getId());
				Long level = Long.valueOf(Long.parseLong(levs[i]));
				adHotGoods.setLevel(level);
				adHotGoods.setCreateTime(now);
				this.hotGoodsService.add(adHotGoods);
			}
			//保存商品图片
			String[] posters = this.adGoods.getPosterUrl().split(",");
			for (int i = 0; i < posters.length; i++) {
				AdGoodsPosters adGoodsPosters = new AdGoodsPosters();
				adGoodsPosters.setGoodsId(this.adGoods.getId());
				adGoodsPosters.setCreateTime(now);
				adGoodsPosters.setSeq(Long.valueOf(Long.parseLong(i + "")));
				adGoodsPosters.setPath1(posters[i]);
				adGoodsPosters.setPath2(posters[i]);
				this.goodsPostersService.add(adGoodsPosters);
			}
			
			this.jsonResult = "保存成功！";
		}
		return "success";
	}

	public String checkIsExsits() throws Exception {
		if (this.adGoods != null) {
			if (this.goodsService.checkOnly(this.adGoods))
				this.jsonResult = "ok";
			else
				this.jsonResult = "error";
		} else {
			this.jsonResult = "error";
		}
		return "success";
	}

	public String goodDelete() throws Exception {
		if (this.ids != null) {
			goodsService.deleteByIds(ids);
			hotGoodsService.deleteByGoodsIds(ids);
			goodsPostersService.deleteByGoodsIds(ids);
			msg = "删除成功！";
		}
		return goodList();
	}

	private List<AdGoodsType> goodsTypes;
	private AdGoodsType goodsType;
	private IGoodsTypeService goodsTypeService;

    private Long parentID; 
    private Integer level;

	private String fileUrl;
	
	
	public void setGoodsTypeService(IGoodsTypeService goodsTypeService) {
		this.goodsTypeService = goodsTypeService;
	}
	

	public List<CodePojo> getCodePojos() {
		return codePojos;
	}

	public void setCodePojos(List<CodePojo> codePojos) {
		this.codePojos = codePojos;
	}

	public CodePojo getCodePojo() {
		return codePojo;
	}

	public void setCodePojo(CodePojo codePojo) {
		this.codePojo = codePojo;
	}

	public String getFileUrl() {
		return fileUrl;
	}

	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}

	public Long getParentID() {
		return parentID;
	}

	public void setParentID(Long parentID) {
		this.parentID = parentID;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public List<AdGoodsType> getGoodsTypes() {
		return goodsTypes;
	}

	public void setGoodsTypes(List<AdGoodsType> goodsTypes) {
		this.goodsTypes = goodsTypes;
	}

	public AdGoodsType getGoodsType() {
		return goodsType;
	}

	public void setGoodsType(AdGoodsType goodsType) {
		this.goodsType = goodsType;
	}

	/****************商品类型管理**************************/
	public String goodsTypeIndex() throws Exception {
		pager.setEsc(Boolean.valueOf(false));
		fileUrl = ConfigUtil.getProperty("uploadfile.url"); 
		goodsTypes = goodsTypeService.findListGoodsType(pager, goodsType,parentID,level)
				.getData();
		setToPage("/cms/jsp/order/goodstype/list.jsp");
		return "success";
	}

	public String goodsTypeAdd() throws Exception {
		setToPage("/cms/jsp/order/goodstype/add.jsp");
		return "success";
	}

	public String goodsTypeEdit() throws Exception {
		if (goodsType != null){
			goodsType = goodsTypeService.getGoodsTypeByKey(goodsType.getId());
		}
		setToPage("/cms/jsp/order/goodstype/edit.jsp");
		return "success";
	}

	public String goodsTypeSave() throws Exception {
		if (goodsType != null){
			Date now = new Date();
			goodsType.setCreateDate(now);
			goodsType.setState(new Long("1"));
			goodsTypes = new ArrayList<AdGoodsType>();
			goodsTypes.add(goodsType);
			goodsTypeService.saveOrUpdateAll(goodsTypes);
			jsonResult = "保存成功！";
			msg = "保存成功！";
		}
		return goodsTypeIndex();
	}
	
	public String goodsTypeDelete() throws Exception {
		if (this.ids != null) {
			goodsTypeService.deleteByIds(ids);
			msg = "删除成功！";
		}
		return goodsTypeIndex();
	}
	
	public String goodsTypeChekOnly () throws Exception {
		if (goodsType != null) {
				jsonResult = goodsTypeService.checkOnly(goodsType);
		}else {
			jsonResult = "error：获取参数出错！";
		}
		return SUCCESS;
	}
	
	//刷新
	public String refresh() throws Exception {
		boolean isSuc = true;
		try {
			String resurl = ConfigUtil.getProperty("goodstype.url");
			String[] resurls = resurl.split(",");
			for (int i = 0; i < resurls.length; i++) {
				XmlUtils.postHttpData(resurls[i]);
			}
		} catch (Exception e) {
			isSuc = false;
		}
		if (!isSuc) {
			msg = "数据刷新失败";
		} else {
			msg = "数据刷新成功";
		}
		return goodsTypeIndex();
	}

	
	/****************商品类型管理end**************************/
	
	/**
	 * 导出报表数据
	 * @TODO	
	 * @author 	xieshengfeng
	 * @email  	xsfcy@126.com
	 * @since 	下午5:32:45 2015年7月28日
	 * @return
	 * @throws Exception	
	 *
	 */
	public String listForReport() throws Exception {
		this.nowDate = DateHelper.getStartDate(new Date());
		List<?> dataList;
		if(this.getExportAll()){
			dataList = this.orderAddressService.findOrdersForReport(this.pager,
					this.order, this.startDate, this.endDate).getData();
		}else{
			dataList = this.orderAddressService.findOrders(this.pager, order, startDate, endDate).getData();
		}
		
		ReportDefinition reportDefinition = new ReportDefinition("订单管理",ReportAutoGenerator.FORMAT_XLSX);
//		序号 	订单编号 	订单金额(元) 	用户账号 	支付状态 	手机号码 	支付备注 	时间 	配送状态 	是否有电子券密码 
		List<ColumnDetailFieldDefinition> DetailFieldList = new ArrayList<ColumnDetailFieldDefinition>();
//		String columnName, String fieldName,int columnWidth,int columnHeight,Class<?> clazz
		DetailFieldList.add(new CDFRowIndex("序号 ","",60,40));
//		DetailFieldList.add(new TowRowCDF("合并单元格",250,40,
//				new CDFString("订单编号 ","order.orderCode",150,20),
//				new CDFFloat("订单金额(元) ","order.price",100,20)));
		DetailFieldList.add(new CDFString("订单编号 ","order.orderCode",150,40));
		DetailFieldList.add(new CDFFloat("订单金额(元) ","order.price",100,40));
		DetailFieldList.add(new CDFLong("用户账号 ","order.userID",100,40));
		DetailFieldList.add(new CDFIntegerState("支付状态 ","order.payState",100,40){
			@Override
			public void setValueDisplayMap(String stateKeyPrefix,Map<Object, String> map) {
				map.put(stateKeyPrefix+0, "等待支付");
				map.put(stateKeyPrefix+1, "支付成功");
				map.put(stateKeyPrefix+2, "库存不足");
				map.put(stateKeyPrefix+3, "余额不足");
				map.put(stateKeyPrefix+4, "支付失败");
			}
		});
		DetailFieldList.add(new CDFString("手机号码  ","phone",100,40));
		DetailFieldList.add(new CDFString("支付备注 ","order.payNote",100,40));
		DetailFieldList.add(new CDFDate("时间 ","order.createTime",100,40));
		DetailFieldList.add(new CDFIntegerState("配送状态 ","state",100,40){
			@Override
			public void setValueDisplayMap(String stateKeyPrefix,Map<Object, String> map) {
				map.put(stateKeyPrefix+0, "未发货");
				map.put(stateKeyPrefix+1, "已发货");
				map.put(stateKeyPrefix+2, "已送达");
			}
		});
		DetailFieldList.add(new CDFString("是否有电子券密码 ","evCodeFlag",100,40));
		this.setAutoJasperDetailFieldList(DetailFieldList);
		this.setAutoJasperReportDefinition(reportDefinition);
		this.setAutoJasperDataList(dataList);
		return "autoJasper";
	}
	public List<AdGoods> getGoods() {
		return this.goods;
	}

	public void setGoods(List<AdGoods> goods) {
		this.goods = goods;
	}

	public AdGoods getAdGoods() {
		return this.adGoods;
	}

	public void setAdGoods(AdGoods adGoods) {
		this.adGoods = adGoods;
	}

	public String getIds() {
		return this.ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	public String getJsonResult() {
		return this.jsonResult;
	}

	public void setJsonResult(String jsonResult) {
		this.jsonResult = jsonResult;
	}

	public void setGoodsService(IGoodsService goodsService) {
		this.goodsService = goodsService;
	}

	public void setHotGoodsService(IHotGoodsService hotGoodsService) {
		this.hotGoodsService = hotGoodsService;
	}

	public void setGoodsPostersService(IGoodsPostersService goodsPostersService) {
		this.goodsPostersService = goodsPostersService;
	}
}