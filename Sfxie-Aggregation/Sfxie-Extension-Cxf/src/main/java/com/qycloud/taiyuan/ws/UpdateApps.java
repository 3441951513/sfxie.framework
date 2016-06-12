
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
 *         &lt;element name="aps" type="{http://oup.rockontrol.com}appList" minOccurs="0"/>
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
    "aps"
})
@XmlRootElement(name = "updateApps")
public class UpdateApps {

    protected AppList aps;

    /**
     * 获取aps属性的值。
     * 
     * @return
     *     possible object is
     *     {@link AppList }
     *     
     */
    public AppList getAps() {
        return aps;
    }

    /**
     * 设置aps属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link AppList }
     *     
     */
    public void setAps(AppList value) {
        this.aps = value;
    }

}
