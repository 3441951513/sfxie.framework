package com.sfxie.extension.mybatis.interceptor;

import java.util.List;
import java.util.Map;

import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.sfxie.data.security.DefaultSqlDecorator;
import com.sfxie.extension.mybatis.annotation.SqlDecorator;

/**
 * mybatis分页对象
 * @author xieshengfeng
 *
 */
@SqlDecorator(decorator = DefaultSqlDecorator.class)
public class Page {

	private static final Logger logger = LoggerFactory.getLogger(Page.class);
	private static ObjectMapper mapper = new ObjectMapper();

	public static String DEFAULT_PAGESIZE = "10";
	private int pageNo; // 当前页码
	private int pageSize; // 每页行数
	private int totalRecord; // 总记录数
	private int totalPage; // 总页数
	private Map<String, Object> params; // 查询条件
	private Map<String, List<Object>> paramLists; // 数组查询条件
	private String searchUrl; // Url地址
	private String pageNoDisp; // 可以显示的页号(分隔符"|"，总页数变更时更新)
	private List<?> results;

	public Page() {
		pageNo = 1;
		pageSize = Integer.valueOf(DEFAULT_PAGESIZE);
		totalRecord = 0;
		totalPage = 0;
		params = Maps.newHashMap();
		paramLists = Maps.newHashMap();
		searchUrl = "";
		pageNoDisp = "";
	}
	public Page(int pageNo, int pageSize) {
		this.pageNo = pageNo;
		this.pageSize = pageSize;
		totalRecord = 0;
		totalPage = 0;
		params = Maps.newHashMap();
		paramLists = Maps.newHashMap();
		searchUrl = "";
		pageNoDisp = "";
	}
	/**
	 * 构造分页对象
	 * @param pageNo
	 * 			当前页码
	 * @param pageSize
	 * 			页记录数
	 * @return
	 */
	public static Page newBuilder(int pageNo, int pageSize) {
		Page page = new Page();
		page.setPageNo(pageNo);
		page.setPageSize(pageSize);
		return page;
	}
	@Deprecated
	public static Page newBuilder(int pageNo, int pageSize, String url) {
		Page page = new Page();
		page.setPageNo(pageNo);
		page.setPageSize(pageSize);
		page.setSearchUrl(url);
		return page;
	}

	/**
	 * 查询条件转JSON
	 */
	public String getParaJson() {
		Map<String, Object> map = Maps.newHashMap();
		for (String key : params.keySet()) {
			if (params.get(key) != null) {
				map.put(key, params.get(key));
			}
		}
		String json = "";
		try {
			json = mapper.writeValueAsString(map);
		} catch (Exception e) {
			logger.error("转换JSON失败", params, e);
		}
		return json;
	}

	/**
	 * 数组查询条件转JSON
	 */
	public String getParaListJson() {
		Map<String, Object> map = Maps.newHashMap();
		for (String key : paramLists.keySet()) {
			List<Object> lists = paramLists.get(key);
			if (lists != null && lists.size() > 0) {
				map.put(key, lists);
			}
		}
		String json = "";
		try {
			json = mapper.writeValueAsString(map);
		} catch (Exception e) {
			logger.error("转换JSON失败", params, e);
		}
		return json;
	}

	/**
	 * 总件数变化时，更新总页数并计算显示样式
	 */
	private void refreshPage() {
		// 总页数计算
		totalPage = totalRecord % pageSize == 0 ? totalRecord / pageSize
				: (totalRecord / pageSize + 1);
		// 防止超出最末页（浏览途中数据被删除的情况）
		if (pageNo > totalPage && totalPage != 0) {
			pageNo = totalPage;
		}
		pageNoDisp = computeDisplayStyleAndPage();
	}

	/**
	 * 计算页号显示样式 这里实现以下的分页样式("[]"代表当前页号)，可根据项目需求调整 &nbsp;&nbsp; *&nbsp;&nbsp;
	 * [1],2,3,4,5,6,7,8..12,13 &nbsp;&nbsp; *&nbsp;&nbsp;
	 * 1,2..5,6,[7],8,9..12,13 &nbsp;&nbsp; *&nbsp;&nbsp;
	 * 1,2..6,7,8,9,10,11,12,[13]
	 */
	private String computeDisplayStyleAndPage() {
		List<Integer> pageDisplays = Lists.newArrayList();
		if (totalPage <= 11) {
			for (int i = 1; i <= totalPage; i++) {
				pageDisplays.add(i);
			}
		} else if (pageNo < 7) {
			for (int i = 1; i <= 8; i++) {
				pageDisplays.add(i);
			}
			pageDisplays.add(0);// 0 表示 省略部分(下同)
			pageDisplays.add(totalPage - 1);
			pageDisplays.add(totalPage);
		} else if (pageNo > totalPage - 6) {
			pageDisplays.add(1);
			pageDisplays.add(2);
			pageDisplays.add(0);
			for (int i = totalPage - 7; i <= totalPage; i++) {
				pageDisplays.add(i);
			}
		} else {
			pageDisplays.add(1);
			pageDisplays.add(2);
			pageDisplays.add(0);
			for (int i = pageNo - 2; i <= pageNo + 2; i++) {
				pageDisplays.add(i);
			}
			pageDisplays.add(0);
			pageDisplays.add(totalPage - 1);
			pageDisplays.add(totalPage);
		}
		return Joiner.on("|").join(pageDisplays.toArray());
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
		refreshPage();
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	/**
	 * 获取参数集合
	 * @return
	 */
	public Map<String, Object> getParams() {
		return params;
	}

	public void setParams(Map<String, Object> params) {
		this.params = params;
	}

	public Map<String, List<Object>> getParamLists() {
		return paramLists;
	}

	public void setParamLists(Map<String, List<Object>> paramLists) {
		this.paramLists = paramLists;
	}

	public String getSearchUrl() {
		return searchUrl;
	}

	public void setSearchUrl(String searchUrl) {
		this.searchUrl = searchUrl;
	}

	public String getPageNoDisp() {
		return pageNoDisp;
	}

	public void setPageNoDisp(String pageNoDisp) {
		this.pageNoDisp = pageNoDisp;
	}

	public List<?> getResults() {
		return results;
	}

	public void setResults(List<?> results) {
		this.results = results;
	}

}
