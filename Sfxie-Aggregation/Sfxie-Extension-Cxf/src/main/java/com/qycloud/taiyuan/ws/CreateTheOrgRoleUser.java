
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
 *         &lt;element name="orgRoleId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="list" type="{http://oup.rockontrol.com}userList" minOccurs="0"/>
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
    "orgRoleId",
    "list"
})
@XmlRootElement(name = "createTheOrgRoleUser")
public class CreateTheOrgRoleUser {

    protected String orgRoleId;
    protected UserList list;

    /**
     * 获取orgRoleId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrgRoleId() {
        return orgRoleId;
    }

    /**
     * 设置orgRoleId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrgRoleId(String value) {
        this.orgRoleId = value;
    }

    /**
     * 获取list属性的值。
     * 
     * @return
     *     possible object is
     *     {@link UserList }
     *     
     */
    public UserList getList() {
        return list;
    }

    /**
     * 设置list属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link UserList }
     *     
     */
    public void setList(UserList value) {
        this.list = value;
    }

}
