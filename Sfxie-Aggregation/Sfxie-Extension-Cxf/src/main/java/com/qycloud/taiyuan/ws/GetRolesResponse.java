
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
 *         &lt;element name="角色对象集合" type="{http://oup.rockontrol.com}roleList" minOccurs="0"/>
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
    "\u89d2\u8272\u5bf9\u8c61\u96c6\u5408"
})
@XmlRootElement(name = "getRolesResponse")
public class GetRolesResponse {

    protected RoleList 角色对象集合;

    /**
     * 获取角色对象集合属性的值。
     * 
     * @return
     *     possible object is
     *     {@link RoleList }
     *     
     */
    public RoleList get角色对象集合() {
        return 角色对象集合;
    }

    /**
     * 设置角色对象集合属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link RoleList }
     *     
     */
    public void set角色对象集合(RoleList value) {
        this.角色对象集合 = value;
    }

}
