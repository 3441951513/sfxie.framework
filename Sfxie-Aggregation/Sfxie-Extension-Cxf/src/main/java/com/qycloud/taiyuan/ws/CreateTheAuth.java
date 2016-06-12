
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
 *         &lt;element name="rlId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ra" type="{http://oup.rockontrol.com}baRoleAuthorityList" minOccurs="0"/>
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
    "rlId",
    "ra"
})
@XmlRootElement(name = "createTheAuth")
public class CreateTheAuth {

    protected String rlId;
    protected BaRoleAuthorityList ra;

    /**
     * 获取rlId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRlId() {
        return rlId;
    }

    /**
     * 设置rlId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRlId(String value) {
        this.rlId = value;
    }

    /**
     * 获取ra属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BaRoleAuthorityList }
     *     
     */
    public BaRoleAuthorityList getRa() {
        return ra;
    }

    /**
     * 设置ra属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BaRoleAuthorityList }
     *     
     */
    public void setRa(BaRoleAuthorityList value) {
        this.ra = value;
    }

}
