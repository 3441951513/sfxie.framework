package com.sfxie.soa.modules.dubbo;


import com.sfxie.soa.dubbo.server.SoaServer;

public class SoaStartup {

	public static void main(String[] args) {
		SoaServer.getInstance().setCatalinaHome("D:\\workspace\\sfxie\\workspace");
		SoaServer.getInstance().setClassPath("config/extension/spring/xml/applicationContext-zk-provider.xml");
		SoaServer.getInstance().start();
	}
}
