package com.sfxie.ui.extjs5.i18n;

import java.util.ArrayList;
import java.util.List;

public class DtoClassScanPathCollection {

	
	/**
	 * 用于保存系统加载时获取要用所有的dto字段与数据库字段对应关系的类的扫描包(package)名
	 */
	private List<String> dtoPaths = new ArrayList<String>();

	public List<String> getDtoPaths() {
		return dtoPaths;
	}

	public void setDtoPaths(List<String> dtoPaths) {
		this.dtoPaths = dtoPaths;
	}
}
