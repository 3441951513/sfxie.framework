package com.sfxie.extension.upload.document.excel.header.java;


/**
 * Double类型的百分比表头列定义
 * @TODO	
 * @author 	xieshengfeng
 * @email  	xsfcy@126.com
 * @since 	下午3:54:28 2015年8月21日
 * @example		
 *
 */
public class EHDDoublePersentage extends EHDDouble {
	/**	保留小数位	*/
	private int minimumFractionDigits;

	public EHDDoublePersentage(String string, String string2, String string3) {
		super(string, string2, string3);
	}
	public EHDDoublePersentage(String string, String string2, String string3,int minimumFractionDigits) {
		super(string, string2, string3);
		this.minimumFractionDigits = minimumFractionDigits;
	}
	public int getMinimumFractionDigits() {
		return minimumFractionDigits == 0?2:minimumFractionDigits;
	}
	/**
	 * 设置保留小数位
	 * @TODO	
	 * @author 	xieshengfeng
	 * @email  	xsfcy@126.com
	 * @since 	上午9:20:46 2015年8月18日
	 * @param minimumFractionDigits	
	 *
	 */
	public void setMinimumFractionDigits(int minimumFractionDigits) {
		this.minimumFractionDigits = minimumFractionDigits;
	}
	
	
}
