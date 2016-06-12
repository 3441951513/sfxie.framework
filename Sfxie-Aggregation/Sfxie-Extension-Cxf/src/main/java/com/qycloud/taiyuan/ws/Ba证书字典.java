
package com.qycloud.taiyuan.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * Ba证书字典 entity. @author MyEclipse Persistence Tools
 * 
 * <p>ba证书字典 complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="ba证书字典">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="oid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="证书类别" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="证书代码" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="证书名称" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="发证机关" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="作业类别" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="准执项目" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="培训项目" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="到期是否可以下井" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="备注" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="录入人姓名" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="录入人id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="录入时间" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ba\u8bc1\u4e66\u5b57\u5178", propOrder = {
    "oid",
    "\u8bc1\u4e66\u7c7b\u522b",
    "\u8bc1\u4e66\u4ee3\u7801",
    "\u8bc1\u4e66\u540d\u79f0",
    "\u53d1\u8bc1\u673a\u5173",
    "\u4f5c\u4e1a\u7c7b\u522b",
    "\u51c6\u6267\u9879\u76ee",
    "\u57f9\u8bad\u9879\u76ee",
    "\u5230\u671f\u662f\u5426\u53ef\u4ee5\u4e0b\u4e95",
    "\u5907\u6ce8",
    "\u5f55\u5165\u4eba\u59d3\u540d",
    "\u5f55\u5165\u4ebaId"
})
public class Ba证书字典 {

    protected String oid;
    protected String 证书类别;
    protected String 证书代码;
    protected String 证书名称;
    protected String 发证机关;
    protected String 作业类别;
    protected String 准执项目;
    protected String 培训项目;
    protected String 到期是否可以下井;
    protected String 备注;
    protected String 录入人姓名;
    @XmlElement(name = "\u5f55\u5165\u4ebaid")
    protected String 录入人Id;
    @XmlAttribute
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar 录入时间;

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
     * 获取证书类别属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String get证书类别() {
        return 证书类别;
    }

    /**
     * 设置证书类别属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void set证书类别(String value) {
        this.证书类别 = value;
    }

    /**
     * 获取证书代码属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String get证书代码() {
        return 证书代码;
    }

    /**
     * 设置证书代码属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void set证书代码(String value) {
        this.证书代码 = value;
    }

    /**
     * 获取证书名称属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String get证书名称() {
        return 证书名称;
    }

    /**
     * 设置证书名称属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void set证书名称(String value) {
        this.证书名称 = value;
    }

    /**
     * 获取发证机关属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String get发证机关() {
        return 发证机关;
    }

    /**
     * 设置发证机关属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void set发证机关(String value) {
        this.发证机关 = value;
    }

    /**
     * 获取作业类别属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String get作业类别() {
        return 作业类别;
    }

    /**
     * 设置作业类别属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void set作业类别(String value) {
        this.作业类别 = value;
    }

    /**
     * 获取准执项目属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String get准执项目() {
        return 准执项目;
    }

    /**
     * 设置准执项目属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void set准执项目(String value) {
        this.准执项目 = value;
    }

    /**
     * 获取培训项目属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String get培训项目() {
        return 培训项目;
    }

    /**
     * 设置培训项目属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void set培训项目(String value) {
        this.培训项目 = value;
    }

    /**
     * 获取到期是否可以下井属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String get到期是否可以下井() {
        return 到期是否可以下井;
    }

    /**
     * 设置到期是否可以下井属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void set到期是否可以下井(String value) {
        this.到期是否可以下井 = value;
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
     * 获取录入人姓名属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String get录入人姓名() {
        return 录入人姓名;
    }

    /**
     * 设置录入人姓名属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void set录入人姓名(String value) {
        this.录入人姓名 = value;
    }

    /**
     * 获取录入人Id属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String get录入人Id() {
        return 录入人Id;
    }

    /**
     * 设置录入人Id属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void set录入人Id(String value) {
        this.录入人Id = value;
    }

    /**
     * 获取录入时间属性的值。
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar get录入时间() {
        return 录入时间;
    }

    /**
     * 设置录入时间属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void set录入时间(XMLGregorianCalendar value) {
        this.录入时间 = value;
    }

}
