
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
 *         &lt;element name="组织机构对象" type="{http://oup.rockontrol.com}org" minOccurs="0"/>
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
    "\u7ec4\u7ec7\u673a\u6784\u5bf9\u8c61"
})
@XmlRootElement(name = "getTheOrgByCodeResponse")
public class GetTheOrgByCodeResponse {

    protected Org 组织机构对象;

    /**
     * 获取组织机构对象属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Org }
     *     
     */
    public Org get组织机构对象() {
        return 组织机构对象;
    }

    /**
     * 设置组织机构对象属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Org }
     *     
     */
    public void set组织机构对象(Org value) {
        this.组织机构对象 = value;
    }

}
