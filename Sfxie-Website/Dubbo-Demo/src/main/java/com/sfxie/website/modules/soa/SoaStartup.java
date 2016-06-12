package com.sfxie.website.modules.soa;


import com.sfxie.soa.dubbo.server.SoaServer;

public class SoaStartup {

	public static void main(String[] args) {
		SoaServer.getInstance().setCatalinaHome("D:\\workspace\\sfxie\\workspace");
		SoaServer.getInstance().setClassPath("config/extension/spring/xml/applicationContext-zk-customer.xml");
		SoaServer.getInstance().start();
	}
}
