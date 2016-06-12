
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
 *         &lt;element name="rls" type="{http://oup.rockontrol.com}roleList" minOccurs="0"/>
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
    "rls"
})
@XmlRootElement(name = "updateRoles")
public class UpdateRoles {

    protected RoleList rls;

    /**
     * 获取rls属性的值。
     * 
     * @return
     *     possible object is
     *     {@link RoleList }
     *     
     */
    public RoleList getRls() {
        return rls;
    }

    /**
     * 设置rls属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link RoleList }
     *     
     */
    public void setRls(RoleList value) {
        this.rls = value;
    }

}
