
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
 *         &lt;element name="sysCdt" type="{http://oup.rockontrol.com}systemSyncManageCdt" minOccurs="0"/>
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
    "sysCdt"
})
@XmlRootElement(name = "getSystemSyncInfo")
public class GetSystemSyncInfo {

    protected SystemSyncManageCdt sysCdt;

    /**
     * 获取sysCdt属性的值。
     * 
     * @return
     *     possible object is
     *     {@link SystemSyncManageCdt }
     *     
     */
    public SystemSyncManageCdt getSysCdt() {
        return sysCdt;
    }

    /**
     * 设置sysCdt属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link SystemSyncManageCdt }
     *     
     */
    public void setSysCdt(SystemSyncManageCdt value) {
        this.sysCdt = value;
    }

}
