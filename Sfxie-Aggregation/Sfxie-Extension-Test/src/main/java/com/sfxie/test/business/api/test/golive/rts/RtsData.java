package com.sfxie.test.business.api.test.golive.rts;

import javax.xml.bind.annotation.XmlAttribute;

public class RtsData{

	private String pvLogId;

	@XmlAttribute(name="pv_log_id")
	public String getPvLogId() {
		return pvLogId;
	}

	public void setPvLogId(String pvLogId) {
		this.pvLogId = pvLogId;
	}
	
}
