
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
 *         &lt;element name="op" type="{http://oup.rockontrol.com}厂商Cdt" minOccurs="0"/>
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
    "op"
})
@XmlRootElement(name = "getManufacturers")
public class GetManufacturers {

    protected 厂商Cdt op;

    /**
     * 获取op属性的值。
     * 
     * @return
     *     possible object is
     *     {@link 厂商Cdt }
     *     
     */
    public 厂商Cdt getOp() {
        return op;
    }

    /**
     * 设置op属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link 厂商Cdt }
     *     
     */
    public void setOp(厂商Cdt value) {
        this.op = value;
    }

}
