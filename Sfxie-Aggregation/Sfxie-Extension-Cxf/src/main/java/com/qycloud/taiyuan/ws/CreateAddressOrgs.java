
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
 *         &lt;element name="addressOrg" type="{http://oup.rockontrol.com}ba地点位置组织机构List" minOccurs="0"/>
 *         &lt;element name="orgIds" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "addressOrg",
    "orgIds"
})
@XmlRootElement(name = "createAddressOrgs")
public class CreateAddressOrgs {

    protected Ba地点位置组织机构List addressOrg;
    protected String orgIds;

    /**
     * 获取addressOrg属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Ba地点位置组织机构List }
     *     
     */
    public Ba地点位置组织机构List getAddressOrg() {
        return addressOrg;
    }

    /**
     * 设置addressOrg属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Ba地点位置组织机构List }
     *     
     */
    public void setAddressOrg(Ba地点位置组织机构List value) {
        this.addressOrg = value;
    }

    /**
     * 获取orgIds属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrgIds() {
        return orgIds;
    }

    /**
     * 设置orgIds属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrgIds(String value) {
        this.orgIds = value;
    }

}
