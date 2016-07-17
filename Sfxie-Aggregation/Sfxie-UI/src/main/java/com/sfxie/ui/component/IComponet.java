package com.sfxie.ui.component;
/**
 * 组件接口
 * @TODO	
 * @author 	xieshengfeng
 * @email  	xsfcy@126.com
 * @since 	上午8:42:50 2015年9月17日
 * @example	
 * @param <Model>	
 *
 */
public interface IComponet<Model>{

	/**
	 * 获取生成的组件字符串
	 * @TODO	
	 * @author 	xieshengfeng
	 * @email  	xsfcy@126.com
	 * @since 	上午8:43:06 2015年9月17日
	 * @param model
	 * 		拼装组件所需的实体参数
	 * @return	
	 *
	 */
	public String html(Model model);
}
