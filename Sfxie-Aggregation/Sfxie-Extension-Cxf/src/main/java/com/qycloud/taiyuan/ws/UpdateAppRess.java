
package com.qycloud.taiyuan.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>anonymous complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="rss" type="{http://oup.rockontrol.com}appResList" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "rss"
})
@XmlRootElement(name = "updateAppRess")
public class UpdateAppRess {

    protected AppResList rss;

    /**
     * 获取rss属性的值。
     * 
     * @return
     *     possible object is
     *     {@link AppResList }
     *     
     */
    public AppResList getRss() {
        return rss;
    }

    /**
     * 设置rss属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link AppResList }
     *     
     */
    public void setRss(AppResList value) {
        this.rss = value;
    }

}
