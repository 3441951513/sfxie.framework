package com.sfxie.ui.extjs5.grid;

import java.util.List;
/**
 * 分页结果对象
 * @author XIESHENGFENG
 */

public class QueryPager {
	/**
	 * 查询记录总数
	 */
	private int totalCount;
	/**
	 * 查询记录结果
	 */
	private List<?> result;
	/**
	 * 获取查询记录总数
	 * @return
	 */
	public int getTotalCount() {
		return totalCount;
	}
	
	/**
	 * 获取查询记录结果
	 * @return
	 */
	public List<?> getResult() {
		return result;
	}
	
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	
	public void setResult(List<?> result) {
		this.result = result;
	}
	
	
}
