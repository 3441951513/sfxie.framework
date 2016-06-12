package com.sfxie.extension.spring4.datasource.multy;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 动态数据源
 * @TODO 
 * @author xsf
 * 2015年7月22日下午3:00:38
 * {@link com.sfxie.advert.common.spring.datasource.multy.DynamicDataSource}
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

	@Override
    protected Object determineCurrentLookupKey() {
		return DBContextHolder.getDbType();//获得当前数据源标识符
    }

}
