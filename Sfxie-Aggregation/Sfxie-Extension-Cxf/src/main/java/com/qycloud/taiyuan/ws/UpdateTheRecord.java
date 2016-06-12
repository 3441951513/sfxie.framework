
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
 *         &lt;element name="baRecord" type="{http://oup.rockontrol.com}baRecord" minOccurs="0"/>
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
    "baRecord"
})
@XmlRootElement(name = "updateTheRecord")
public class UpdateTheRecord {

    protected BaRecord baRecord;

    /**
     * 获取baRecord属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BaRecord }
     *     
     */
    public BaRecord getBaRecord() {
        return baRecord;
    }

    /**
     * 设置baRecord属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BaRecord }
     *     
     */
    public void setBaRecord(BaRecord value) {
        this.baRecord = value;
    }

}
