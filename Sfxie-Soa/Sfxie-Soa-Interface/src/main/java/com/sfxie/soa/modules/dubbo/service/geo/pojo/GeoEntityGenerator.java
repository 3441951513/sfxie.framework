package com.sfxie.soa.modules.dubbo.service.geo.pojo;

import java.util.ArrayList;
import java.util.List;

import com.sfxie.utils.db.CobarSchema;
import com.sfxie.utils.db.DefaultSqlType2JavaType;
import com.sfxie.utils.db.GenEntity;
import com.sfxie.utils.db.Table;

public class GeoEntityGenerator {
	/**
	 * 出口 TODO
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		CobarSchema cs1 = new CobarSchema ();
		cs1.getDbMetaMap().put("sfxie_oa", "jdbc:mysql://xsfcjy.oicp.net:8607/sfxie_oa");
		cs1.setUserName("root");
		cs1.setUserPassword("root");
		List<Table> tableList = new ArrayList<Table>();
		addGeoTable(tableList);
		String packagePath = "com.sfxie.soa.modules.dubbo.service.geo.pojo";
		new GenEntity(packagePath,"\\main\\java",cs1,tableList,new DefaultSqlType2JavaType());
	}
	
	private static void addGeoTable(List<Table> tableList){

		Table table1 = new Table();
		table1.setDataNode("sfxie_oa");
		table1.setName("sfxie_geo_city");
		tableList.add(table1);
		
		Table table2 = new Table();
		table2.setDataNode("sfxie_oa");
		table2.setName("sfxie_geo_country");
		tableList.add(table2);
		
		Table table3 = new Table();
		table3.setDataNode("sfxie_oa");
		table3.setName("sfxie_geo_detail");
		tableList.add(table3);
		
		Table table4 = new Table();
		table4.setDataNode("sfxie_oa");
		table4.setName("sfxie_geo_district");
		tableList.add(table4);
		
		Table table5 = new Table();
		table5.setDataNode("sfxie_oa");
		table5.setName("sfxie_geo_province");
		tableList.add(table5);
		
		Table table6 = new Table();
		table6.setDataNode("sfxie_oa");
		table6.setName("sfxie_geo_street");
		tableList.add(table6);
	}
}
