package com.sfxie.soa.dubbo.pojo;

import java.util.ArrayList;
import java.util.List;

import com.sfxie.utils.db.CobarSchema;
import com.sfxie.utils.db.DefaultSqlType2JavaType;
import com.sfxie.utils.db.GenEntity;
import com.sfxie.utils.db.Table;

/**
 * 实体类生成器
 * @TODO	
 * @author 	xieshengfeng
 * @email  	xsfcy@126.com
 * @since 	下午1:36:24 2016年4月22日
 * @example		
 *
 */
public class PojoGenerater {

	public static void main(String[] args) {
		CobarSchema cs1 = new CobarSchema ();
		cs1.getDbMetaMap().put("sfxie_oa", "jdbc:mysql://192.168.10.112:3306/sfxie_oa");
		cs1.setUserName("root");
		cs1.setUserPassword("root");
		List<Table> tableList = new ArrayList<Table>();
		
		Table table3 = new Table();
		table3.setDataNode("sfxie_oa");
		table3.setName("sfxie_sys_company");
		tableList.add(table3);
		
		table3 = new Table();
		table3.setDataNode("sfxie_oa");
		table3.setName("sfxie_sys_role_action");
		tableList.add(table3);
		
		table3 = new Table();
		table3.setDataNode("sfxie_oa");
		table3.setName("sfxie_sys_action");
		tableList.add(table3);
		
		table3 = new Table();
		table3.setDataNode("sfxie_oa");
		table3.setName("sfxie_sys_authorization");
		tableList.add(table3);
		
		table3 = new Table();
		table3.setDataNode("sfxie_oa");
		table3.setName("sfxie_sys_auth_role_menu");
		tableList.add(table3);
		
		table3 = new Table();
		table3.setDataNode("sfxie_oa");
		table3.setName("sfxie_sys_auth_data");
		tableList.add(table3);
		
		table3 = new Table();
		table3.setDataNode("sfxie_oa");
		table3.setName("sfxie_sys_post_role");
		tableList.add(table3);
		
		table3 = new Table();
		table3.setDataNode("sfxie_oa");
		table3.setName("sfxie_sys_user_relation");
		tableList.add(table3);
		
		table3 = new Table();
		table3.setDataNode("sfxie_oa");
		table3.setName("sfxie_sys_post");
		tableList.add(table3);
		
		table3 = new Table();
		table3.setDataNode("sfxie_oa");
		table3.setName("sfxie_sys_department");
		tableList.add(table3);
		
		table3 = new Table();
		table3.setDataNode("sfxie_oa");
		table3.setName("sfxie_sys_organizition");
		tableList.add(table3);
		
		table3 = new Table();
		table3.setDataNode("sfxie_oa");
		table3.setName("sfxie_sys_userinfo");
		tableList.add(table3);
		
		table3 = new Table();
		table3.setDataNode("sfxie_oa");
		table3.setName("sfxie_sys_role_menu");
		tableList.add(table3);
		
		table3 = new Table();
		table3.setDataNode("sfxie_oa");
		table3.setName("sfxie_sys_menu");
		tableList.add(table3);
		
		table3 = new Table();
		table3.setDataNode("sfxie_oa");
		table3.setName("sfxie_sys_user_role");
		tableList.add(table3);
		
		table3 = new Table();
		table3.setDataNode("sfxie_oa");
		table3.setName("sfxie_sys_role");
		tableList.add(table3);
		
		table3 = new Table();
		table3.setDataNode("sfxie_oa");
		table3.setName("sfxie_sys_system");
		tableList.add(table3);
		
		/*cs1.getDbMetaMap().put("sfxie_oa", "jdbc:mysql://183.60.142.159:3306/golivetest?Unicode=true&characterEncoding=utf-8&autoReconnect=true&zeroDateTimeBehavior=convertToNull");
		cs1.setUserName("cmstest");
		cs1.setUserPassword("!mI65DU9B5");
		List<Table> tableList = new ArrayList<Table>();
		
		Table table3 = new Table();
		table3.setDataNode("sfxie_oa");
		table3.setName("g_ad3_log_access_goods");
		tableList.add(table3);*/
		
		
		
		String packagePath = "com.sfxie.soa.modules.dubbo.service.oa.impl.pojo";
		new GenEntity(packagePath,"\\main\\java",cs1,tableList,new DefaultSqlType2JavaType());
		
		/*try {
			GenEntity.printAllTableName();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}
}
