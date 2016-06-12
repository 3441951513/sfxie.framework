package com.sfxie.website.modules.api3.common.jaxb;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import org.apache.commons.lang3.StringUtils;

import com.sfxie.extension.spring4.mvc.context.Context;
import com.sfxie.extension.spring4.properties.SpringPropertyPlaceholderConfigurer;
import com.sfxie.utils.Tool;

/**
 * 图片路径加前缀
 *
 * @author xieshengfeng
 * @TODO
 * @email xsfcy@126.com
 * @example
 * @since 上午11:36:10 2015年9月22日
 */
public class ImageRootPathConvertXmlAdapter extends XmlAdapter<String, String> {

    @Override
    public String unmarshal(String v) throws Exception {
        return v;
    }

    @Override
    public String marshal(String v) throws Exception {
        //如果为空,返回v
        if (StringUtils.isEmpty(v))
            return v;
        else {
            if (null != Context.getRequest()) {
                String img_path = (String) SpringPropertyPlaceholderConfigurer.getContextProperty("img.path");
                if (null != v && v.indexOf("http://") == -1 && v.indexOf("https://") == -1) {
                    v = img_path + v;
                }
                //国管替换
                String tag = (String) Context.getRequest().getAttribute("GOLIVE_LHQ_CIBNTV");
                String img_cibn_path = (String) SpringPropertyPlaceholderConfigurer.getContextProperty("img_cibn_dm");
                if (null != tag) {
                    v = Tool.replaceUrl(v, img_cibn_path);
                }
            }
            return v;
        }
    }
}
