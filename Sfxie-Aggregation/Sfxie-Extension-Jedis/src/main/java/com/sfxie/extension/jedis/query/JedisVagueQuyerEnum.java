package com.sfxie.extension.jedis.query;
/**
 * 模糊查询参数
 * @author xieshengfeng
 * @email  xsfcy@126.com
 * @since 2015年7月21日上午10:56:39
 */
public enum JedisVagueQuyerEnum { 
	/**
	 * 左模糊查询
	 */
	LEFT(0),
	/**
	 * 右模糊查询
	 */
	RIGHT(1),
	/**
	 * 两边模糊查询
	 */
	BOTH(2);
	
	private int value;
	
	public int getValue() {
        return value;
    }
    //构造器默认也只能是private, 从而保证构造函数只能在内部使用
	JedisVagueQuyerEnum(int value) {
		this.value = value;
    }
};
