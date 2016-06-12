
package com.qycloud.taiyuan.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>addressOrg complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="addressOrg">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="oid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="地点编码" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="地点名称" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="地点位置id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="组织机构id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="组织机构" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="地点类型" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="地点全名" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="工程状态" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "addressOrg", propOrder = {
    "oid",
    "\u5730\u70b9\u7f16\u7801",
    "\u5730\u70b9\u540d\u79f0",
    "\u5730\u70b9\u4f4d\u7f6eId",
    "\u7ec4\u7ec7\u673a\u6784Id",
    "\u7ec4\u7ec7\u673a\u6784",
    "\u5730\u70b9\u7c7b\u578b",
    "\u5730\u70b9\u5168\u540d",
    "\u5de5\u7a0b\u72b6\u6001"
})
public class AddressOrg {

    protected String oid;
    protected String 地点编码;
    protected String 地点名称;
    @XmlElement(name = "\u5730\u70b9\u4f4d\u7f6eid")
    protected String 地点位置Id;
    @XmlElement(name = "\u7ec4\u7ec7\u673a\u6784id")
    protected String 组织机构Id;
    protected String 组织机构;
    protected String 地点类型;
    protected String 地点全名;
    protected String 工程状态;

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
     * 获取地点编码属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String get地点编码() {
        return 地点编码;
    }

    /**
     * 设置地点编码属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void set地点编码(String value) {
        this.地点编码 = value;
    }

    /**
     * 获取地点名称属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String get地点名称() {
        return 地点名称;
    }

    /**
     * 设置地点名称属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void set地点名称(String value) {
        this.地点名称 = value;
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
     * 获取组织机构属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String get组织机构() {
        return 组织机构;
    }

    /**
     * 设置组织机构属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void set组织机构(String value) {
        this.组织机构 = value;
    }

    /**
     * 获取地点类型属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String get地点类型() {
        return 地点类型;
    }

    /**
     * 设置地点类型属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void set地点类型(String value) {
        this.地点类型 = value;
    }

    /**
     * 获取地点全名属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String get地点全名() {
        return 地点全名;
    }

    /**
     * 设置地点全名属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void set地点全名(String value) {
        this.地点全名 = value;
    }

    /**
     * 获取工程状态属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String get工程状态() {
        return 工程状态;
    }

    /**
     * 设置工程状态属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void set工程状态(String value) {
        this.工程状态 = value;
    }

}
