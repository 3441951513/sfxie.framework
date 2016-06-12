
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
 *         &lt;element name="addrCon" type="{http://oup.rockontrol.com}addressCdt" minOccurs="0"/>
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
    "addrCon"
})
@XmlRootElement(name = "getTheSingleAddress")
public class GetTheSingleAddress {

    protected AddressCdt addrCon;

    /**
     * 获取addrCon属性的值。
     * 
     * @return
     *     possible object is
     *     {@link AddressCdt }
     *     
     */
    public AddressCdt getAddrCon() {
        return addrCon;
    }

    /**
     * 设置addrCon属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link AddressCdt }
     *     
     */
    public void setAddrCon(AddressCdt value) {
        this.addrCon = value;
    }

}
