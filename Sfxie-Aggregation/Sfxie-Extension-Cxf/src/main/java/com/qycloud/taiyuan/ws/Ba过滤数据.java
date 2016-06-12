
package com.qycloud.taiyuan.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Ba过滤数据 entity. @author MyEclipse Persistence Tools
 * 
 * <p>ba过滤数据 complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="ba过滤数据">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="sysId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="oid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="类型" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="业务id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="业务名称" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="业务编码" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="过滤子节点" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="备注" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="是否过滤" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ba\u8fc7\u6ee4\u6570\u636e", propOrder = {
    "sysId",
    "oid",
    "\u7c7b\u578b",
    "\u4e1a\u52a1Id",
    "\u4e1a\u52a1\u540d\u79f0",
    "\u4e1a\u52a1\u7f16\u7801",
    "\u8fc7\u6ee4\u5b50\u8282\u70b9",
    "\u5907\u6ce8",
    "\u662f\u5426\u8fc7\u6ee4"
})
public class Ba过滤数据 {

    protected String sysId;
    protected String oid;
    protected String 类型;
    @XmlElement(name = "\u4e1a\u52a1id")
    protected String 业务Id;
    protected String 业务名称;
    protected String 业务编码;
    protected String 过滤子节点;
    protected String 备注;
    protected String 是否过滤;

    /**
     * 获取sysId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSysId() {
        return sysId;
    }

    /**
     * 设置sysId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSysId(String value) {
        this.sysId = value;
    }

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
     * 获取类型属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String get类型() {
        return 类型;
    }

    /**
     * 设置类型属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void set类型(String value) {
        this.类型 = value;
    }

    /**
     * 获取业务Id属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String get业务Id() {
        return 业务Id;
    }

    /**
     * 设置业务Id属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void set业务Id(String value) {
        this.业务Id = value;
    }

    /**
     * 获取业务名称属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String get业务名称() {
        return 业务名称;
    }

    /**
     * 设置业务名称属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void set业务名称(String value) {
        this.业务名称 = value;
    }

    /**
     * 获取业务编码属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String get业务编码() {
        return 业务编码;
    }

    /**
     * 设置业务编码属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void set业务编码(String value) {
        this.业务编码 = value;
    }

    /**
     * 获取过滤子节点属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String get过滤子节点() {
        return 过滤子节点;
    }

    /**
     * 设置过滤子节点属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void set过滤子节点(String value) {
        this.过滤子节点 = value;
    }

    /**
     * 获取备注属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String get备注() {
        return 备注;
    }

    /**
     * 设置备注属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void set备注(String value) {
        this.备注 = value;
    }

    /**
     * 获取是否过滤属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String get是否过滤() {
        return 是否过滤;
    }

    /**
     * 设置是否过滤属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void set是否过滤(String value) {
        this.是否过滤 = value;
    }

}
