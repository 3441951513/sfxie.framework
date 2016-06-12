
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
 *         &lt;element name="角色权限数组" type="{http://oup.rockontrol.com}roleAuthList" minOccurs="0"/>
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
    "\u89d2\u8272\u6743\u9650\u6570\u7ec4"
})
@XmlRootElement(name = "getAuthsResponse")
public class GetAuthsResponse {

    protected RoleAuthList 角色权限数组;

    /**
     * 获取角色权限数组属性的值。
     * 
     * @return
     *     possible object is
     *     {@link RoleAuthList }
     *     
     */
    public RoleAuthList get角色权限数组() {
        return 角色权限数组;
    }

    /**
     * 设置角色权限数组属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link RoleAuthList }
     *     
     */
    public void set角色权限数组(RoleAuthList value) {
        this.角色权限数组 = value;
    }

}
