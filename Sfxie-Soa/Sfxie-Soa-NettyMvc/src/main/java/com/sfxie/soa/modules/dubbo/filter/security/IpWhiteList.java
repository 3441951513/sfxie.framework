package com.sfxie.soa.modules.dubbo.filter.security;

import java.util.List;

public class IpWhiteList {

	private boolean isEnabled;
	
	private List<String> ipList;

	
	public boolean isEnabled() {
		return isEnabled;
	}

	public void setIsEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	public List<String> getIpList() {
		return ipList;
	}

	public void setIpList(List<String> ipList) {
		this.ipList = ipList;
	}
}
