package com.sfxie.extension.jasperreport6.auto.detailfield.single;

import java.util.Map;
/**
 * 状态转化器
 * @TODO 
 * @author xieshengfeng
 * @since 2015年7月27日下午4:15:40
 * {@link com.sfxie.extension.jasperreport6.auto.detailfield.single.StateConvertor}
 *
 */
public interface StateConvertor {
	/**
	 * 设置状态值与显示映射Map
	 * @TODO	
	 * @author 	xieshengfeng
	 * @email  	xsfcy@126.com
	 * @since 	上午9:33:34 2015年7月28日
	 * @param stateKeyPrefix
	 * 			额外添加的key字符串,以防止全局{@link com.sfxie.extension.jasperreport6.auto.detailfield.single.StateStaticMap}有重复的key
	 * @param map	
	 * 			全局{@link com.sfxie.extension.jasperreport6.auto.detailfield.single.StateStaticMap}对象
	 *
	 */
	public void setValueDisplayMap (String stateKeyPrefix,Map<Object,String> map);
}
