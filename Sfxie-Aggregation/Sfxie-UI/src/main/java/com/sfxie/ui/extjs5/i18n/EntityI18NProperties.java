package com.sfxie.ui.extjs5.i18n;

import java.util.Map;

public class EntityI18NProperties {

	private String i18nEntityName;
	
	private Map<String,Map<String,String>> I18nEntity ;

	

	public String getI18nEntityName() {
		return i18nEntityName;
	}

	public void setI18nEntityName(String i18nEntityName) {
		this.i18nEntityName = i18nEntityName;
	}

	public Map<String, Map<String, String>> getI18nEntity() {
		return I18nEntity;
	}

	public void setI18nEntity(Map<String, Map<String, String>> i18nEntity) {
		I18nEntity = i18nEntity;
	}

	
}
