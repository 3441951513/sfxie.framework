
package com.qycloud.taiyuan.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Ba地点位置组织机构
 * 
 * <p>ba地点位置组织机构 complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="ba地点位置组织机构">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="oid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="地点位置id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="组织机构id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="address" type="{http://oup.rockontrol.com}ba地点位置" minOccurs="0"/>
 *         &lt;element name="org" type="{http://oup.rockontrol.com}baOrg" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ba\u5730\u70b9\u4f4d\u7f6e\u7ec4\u7ec7\u673a\u6784", propOrder = {
    "oid",
    "\u5730\u70b9\u4f4d\u7f6eId",
    "\u7ec4\u7ec7\u673a\u6784Id",
    "address",
    "org"
})
public class Ba地点位置组织机构 {

    protected String oid;
    @XmlElement(name = "\u5730\u70b9\u4f4d\u7f6eid")
    protected String 地点位置Id;
    @XmlElement(name = "\u7ec4\u7ec7\u673a\u6784id")
    protected String 组织机构Id;
    protected Ba地点位置 address;
    protected BaOrg org;

    /**
     * 获取oid属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOid() {
        return oid;
    }

    /**
     * 设置oid属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOid(String value) {
        this.oid = value;
    }

    /**
     * 获取地点位置Id属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String get地点位置Id() {
        return 地点位置Id;
    }

    /**
     * 设置地点位置Id属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void set地点位置Id(String value) {
        this.地点位置Id = value;
    }

    /**
     * 获取组织机构Id属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String get组织机构Id() {
        return 组织机构Id;
    }

    /**
     * 设置组织机构Id属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void set组织机构Id(String value) {
        this.组织机构Id = value;
    }

    /**
     * 获取address属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Ba地点位置 }
     *     
     */
    public Ba地点位置 getAddress() {
        return address;
    }

    /**
     * 设置address属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Ba地点位置 }
     *     
     */
    public void setAddress(Ba地点位置 value) {
        this.address = value;
    }

    /**
     * 获取org属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BaOrg }
     *     
     */
    public BaOrg getOrg() {
        return org;
    }

    /**
     * 设置org属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BaOrg }
     *     
     */
    public void setOrg(BaOrg value) {
        this.org = value;
    }

}
