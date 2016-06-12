
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
 *         &lt;element name="sysMap" type="{http://oup.rockontrol.com}syncManageMapping" minOccurs="0"/>
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
    "sysMap"
})
@XmlRootElement(name = "getSyncManageMappingList")
public class GetSyncManageMappingList {

    protected SyncManageMapping sysMap;

    /**
     * 获取sysMap属性的值。
     * 
     * @return
     *     possible object is
     *     {@link SyncManageMapping }
     *     
     */
    public SyncManageMapping getSysMap() {
        return sysMap;
    }

    /**
     * 设置sysMap属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link SyncManageMapping }
     *     
     */
    public void setSysMap(SyncManageMapping value) {
        this.sysMap = value;
    }

}
