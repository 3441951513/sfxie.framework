
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
 *         &lt;element name="sys" type="{http://oup.rockontrol.com}systemSyncManage" minOccurs="0"/>
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
    "sys"
})
@XmlRootElement(name = "createTheSystem")
public class CreateTheSystem {

    protected SystemSyncManage sys;

    /**
     * 获取sys属性的值。
     * 
     * @return
     *     possible object is
     *     {@link SystemSyncManage }
     *     
     */
    public SystemSyncManage getSys() {
        return sys;
    }

    /**
     * 设置sys属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link SystemSyncManage }
     *     
     */
    public void setSys(SystemSyncManage value) {
        this.sys = value;
    }

}
