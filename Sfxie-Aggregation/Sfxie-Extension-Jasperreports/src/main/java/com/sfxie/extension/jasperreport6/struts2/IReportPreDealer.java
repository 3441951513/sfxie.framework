package com.sfxie.report;

/**
 * 报表模块的处理前的处理接口
 */
public interface IReportPreDealer {

	/**
	 * 处理前的处理方法，用于设置一些ireport需要的参数
	 */
	void preDeal(ReportAction reportAction);
}
