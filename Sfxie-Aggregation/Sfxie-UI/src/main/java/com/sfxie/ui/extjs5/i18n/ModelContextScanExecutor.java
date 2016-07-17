package com.sfxie.ui.extjs5.i18n;

import java.util.List;

/**
 * 系统加载时用于获取配置的路径下所有的dto类
 * @author Administrator
 *
 */
//@Component("modelContextScanExecutor")
public class ModelContextScanExecutor {
   
//	@Resource
	private DtoClassScanPathCollection dtoClassScanPathCollection;
	
	private GetAllClassName getAllClassName;
//	@Resource
	
	
	private ModelContextScanExecutor(){}
	public List<String> getAllDtoI18NClassName() {
		String[] paths = new String[this.dtoClassScanPathCollection.getDtoPaths().size()];
		this.dtoClassScanPathCollection.getDtoPaths().toArray(paths);
		return getAllClassName.getAllClassName(paths);
	}
	
	public DtoClassScanPathCollection getDtoClassScanPathCollection() {
		return dtoClassScanPathCollection;
	}
	public void setDtoClassScanPathCollection(
			DtoClassScanPathCollection dtoClassScanPathCollection) {
		this.dtoClassScanPathCollection = dtoClassScanPathCollection;
	}
	public GetAllClassName getGetAllClassName() {
		return getAllClassName;
	}
	public void setGetAllClassName(GetAllClassName getAllClassName) {
		this.getAllClassName = getAllClassName;
	}
	
	
}
