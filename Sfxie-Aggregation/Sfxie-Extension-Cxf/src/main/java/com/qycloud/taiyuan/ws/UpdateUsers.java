
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
 *         &lt;element name="us" type="{http://oup.rockontrol.com}userList" minOccurs="0"/>
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
    "us"
})
@XmlRootElement(name = "updateUsers")
public class UpdateUsers {

    protected UserList us;

    /**
     * 获取us属性的值。
     * 
     * @return
     *     possible object is
     *     {@link UserList }
     *     
     */
    public UserList getUs() {
        return us;
    }

    /**
     * 设置us属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link UserList }
     *     
     */
    public void setUs(UserList value) {
        this.us = value;
    }

}
