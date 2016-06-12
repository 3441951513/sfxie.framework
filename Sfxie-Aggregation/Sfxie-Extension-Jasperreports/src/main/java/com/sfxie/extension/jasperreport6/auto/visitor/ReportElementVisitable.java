package com.sfxie.extension.jasperreport6.auto.visitor;
/**
 * 报表表头和数据列表区域定义设置接口<br>	
 * 访问者模式应用
 * @TODO	
 * @author 	xieshengfeng
 * @email  	xsfcy@126.com
 * @since 	下午5:53:42 2015年7月27日	
 *
 */
public interface ReportElementVisitable {
	/**
	 * 接受访问者的访问
	 * @TODO	
	 * @author 	xieshengfeng
	 * @email  	xsfcy@126.com
	 * @since 	下午5:55:15 2015年7月27日
	 * @param visitor	
	 *
	 */
	public void accept(ReportElementVisitor visitor,Integer xpotition);
}
