
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
 *         &lt;element name="功能节点对象" type="{http://oup.rockontrol.com}func" minOccurs="0"/>
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
    "\u529f\u80fd\u8282\u70b9\u5bf9\u8c61"
})
@XmlRootElement(name = "getTheFuncResponse")
public class GetTheFuncResponse {

    protected Func 功能节点对象;

    /**
     * 获取功能节点对象属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Func }
     *     
     */
    public Func get功能节点对象() {
        return 功能节点对象;
    }

    /**
     * 设置功能节点对象属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Func }
     *     
     */
    public void set功能节点对象(Func value) {
        this.功能节点对象 = value;
    }

}
