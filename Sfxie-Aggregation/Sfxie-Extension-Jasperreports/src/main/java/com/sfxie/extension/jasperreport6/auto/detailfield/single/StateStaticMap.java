package com.sfxie.extension.jasperreport6.auto.detailfield.single;

import java.util.HashMap;
/**
 * 全局状态转化value/display映射Map
 * @TODO	
 * @author 	xieshengfeng
 * @email  	xsfcy@126.com
 * @since 	下午6:02:09 2015年7月27日	
 *
 */
public class StateStaticMap extends HashMap<Object,String>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static StateStaticMap instance;
	
	private StateStaticMap(){
		
	}
	
	public static StateStaticMap getStateStaticMap(){
		if(null==instance)
			instance = new StateStaticMap();
		return instance;
	}
}
