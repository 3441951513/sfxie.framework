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
public class PriceFenConvertForNullXmlAdapter extends XmlAdapter<String, String> {

	@Override
	public String unmarshal(String v) throws Exception {
        if(null==v || v.equals("0"))
            return null;
        String r = "0.00";
        try {
            if(v.contains(".")){
                r = AmountUtils.changeF2Y(v.substring(0, v.indexOf(".")));
            }else{
                r = AmountUtils.changeF2Y(v);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return r;
	}

	@Override
	public String marshal(String v) throws Exception {
		 if(null==v || v.equals("0"))
			return null;
		String r = "0.00";
		try {
			if(v.contains(".")){
				r = AmountUtils.changeF2Y(v.substring(0, v.indexOf(".")));
			}else{
				r = AmountUtils.changeF2Y(v);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return r;
	}

}
