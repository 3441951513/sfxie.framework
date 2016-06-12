package com.sfxie.website.modules.api3.common.jaxb;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import com.sfxie.utils.AmountUtils;


/**
 * 金额:分元转化
 * @TODO	
 * @author 	xieshengfeng
 * @email  	xsfcy@126.com
 * @since 	上午11:36:10 2015年9月22日
 * @example		
 *
 */
public class FenYuanMutualConvert extends XmlAdapter<String, Float> {

	@Override
	public Float unmarshal(String v) throws Exception {
		if(null!=v){
			return Float.parseFloat(AmountUtils.changeY2F(v));
		}
		return null;
	}

	@Override
	public String marshal(Float v) throws Exception {
		if(null==v)
			return "0.00";
		return AmountUtils.changeF2Y(String.valueOf(v.intValue()));
	}
	public static void main(String[] args) {
		System.out.println(Float.parseFloat(AmountUtils.changeY2F("0.01")));
	}

}
