
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
 *         &lt;element name="ma" type="{http://oup.rockontrol.com}ba厂商" minOccurs="0"/>
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
    "ma"
})
@XmlRootElement(name = "updateManufacturer")
public class UpdateManufacturer {

    protected Ba厂商 ma;

    /**
     * 获取ma属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Ba厂商 }
     *     
     */
    public Ba厂商 getMa() {
        return ma;
    }

    /**
     * 设置ma属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Ba厂商 }
     *     
     */
    public void setMa(Ba厂商 value) {
        this.ma = value;
    }

}
