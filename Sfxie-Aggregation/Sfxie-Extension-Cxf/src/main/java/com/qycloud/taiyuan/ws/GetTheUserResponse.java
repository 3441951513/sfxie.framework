
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
 *         &lt;element name="用户对象" type="{http://oup.rockontrol.com}user" minOccurs="0"/>
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
    "\u7528\u6237\u5bf9\u8c61"
})
@XmlRootElement(name = "getTheUserResponse")
public class GetTheUserResponse {

    protected User 用户对象;

    /**
     * 获取用户对象属性的值。
     * 
     * @return
     *     possible object is
     *     {@link User }
     *     
     */
    public User get用户对象() {
        return 用户对象;
    }

    /**
     * 设置用户对象属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link User }
     *     
     */
    public void set用户对象(User value) {
        this.用户对象 = value;
    }

}
