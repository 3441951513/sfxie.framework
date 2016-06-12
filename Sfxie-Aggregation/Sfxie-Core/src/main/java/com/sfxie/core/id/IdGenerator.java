package com.sfxie.core.id;

import java.util.HashMap;
import java.util.Map;

import com.sfxie.utils.DateHelper;

public class IdGenerator {
	
	private static Map<String,String> dateMap = new HashMap<String,String>();
	private static int seq = 10000000;
	private static final int ROTATION = 99999999;

	public static synchronized long next() {
		String str = DateHelper.getNoBeepNow();
		if(!dateMap.containsKey(str)){
			dateMap.clear();
			seq = 10000;
			dateMap.put(str, null);
		}
		if (seq > ROTATION) seq = 10000;
		return Long.parseLong(str + (seq++));
	}
}
