
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
 *         &lt;element name="fid" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="og" type="{http://oup.rockontrol.com}org" minOccurs="0"/>
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
    "fid",
    "og"
})
@XmlRootElement(name = "createTheOrg")
public class CreateTheOrg {

    protected Integer fid;
    protected Org og;

    /**
     * 获取fid属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getFid() {
        return fid;
    }

    /**
     * 设置fid属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setFid(Integer value) {
        this.fid = value;
    }

    /**
     * 获取og属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Org }
     *     
     */
    public Org getOg() {
        return og;
    }

    /**
     * 设置og属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Org }
     *     
     */
    public void setOg(Org value) {
        this.og = value;
    }

}
