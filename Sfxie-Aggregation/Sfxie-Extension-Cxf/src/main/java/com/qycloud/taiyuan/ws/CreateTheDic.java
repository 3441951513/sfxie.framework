
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
 *         &lt;element name="dc" type="{http://oup.rockontrol.com}dic" minOccurs="0"/>
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
    "dc"
})
@XmlRootElement(name = "createTheDic")
public class CreateTheDic {

    protected Dic dc;

    /**
     * 获取dc属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Dic }
     *     
     */
    public Dic getDc() {
        return dc;
    }

    /**
     * 设置dc属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Dic }
     *     
     */
    public void setDc(Dic value) {
        this.dc = value;
    }

}
