
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
 *         &lt;element name="role角色对象" type="{http://oup.rockontrol.com}role" minOccurs="0"/>
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
    "role\u89d2\u8272\u5bf9\u8c61"
})
@XmlRootElement(name = "getTheRoleResponse")
public class GetTheRoleResponse {

    protected Role role角色对象;

    /**
     * 获取role角色对象属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Role }
     *     
     */
    public Role getRole角色对象() {
        return role角色对象;
    }

    /**
     * 设置role角色对象属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Role }
     *     
     */
    public void setRole角色对象(Role value) {
        this.role角色对象 = value;
    }

}
