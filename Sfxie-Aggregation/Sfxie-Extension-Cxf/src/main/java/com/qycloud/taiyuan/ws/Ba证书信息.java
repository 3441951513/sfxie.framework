
package com.qycloud.taiyuan.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * Ba证书信息 entity. @author MyEclipse Persistence Tools
 * 
 * <p>ba证书信息 complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="ba证书信息">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="oid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="员工id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="员工姓名" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="证书id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="证书编号" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="取得资格途径" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="备注" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="证书名称" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="证书类型" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="发证单位" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="初审时间" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
 *       &lt;attribute name="发证时间" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
 *       &lt;attribute name="下次复审时间" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
 *       &lt;attribute name="有效期" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ba\u8bc1\u4e66\u4fe1\u606f", propOrder = {
    "oid",
    "\u5458\u5de5Id",
    "\u5458\u5de5\u59d3\u540d",
    "\u8bc1\u4e66Id",
    "\u8bc1\u4e66\u7f16\u53f7",
    "\u53d6\u5f97\u8d44\u683c\u9014\u5f84",
    "\u5907\u6ce8",
    "\u8bc1\u4e66\u540d\u79f0",
    "\u8bc1\u4e66\u7c7b\u578b",
    "\u53d1\u8bc1\u5355\u4f4d"
})
public class Ba证书信息 {

    protected String oid;
    @XmlElement(name = "\u5458\u5de5id")
    protected String 员工Id;
    protected String 员工姓名;
    @XmlElement(name = "\u8bc1\u4e66id")
    protected String 证书Id;
    protected String 证书编号;
    protected String 取得资格途径;
    protected String 备注;
    protected String 证书名称;
    protected String 证书类型;
    protected String 发证单位;
    @XmlAttribute
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar 初审时间;
    @XmlAttribute
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar 发证时间;
    @XmlAttribute
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar 下次复审时间;
    @XmlAttribute
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar 有效期;

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
     * 获取员工Id属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String get员工Id() {
        return 员工Id;
    }

    /**
     * 设置员工Id属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void set员工Id(String value) {
        this.员工Id = value;
    }

    /**
     * 获取员工姓名属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String get员工姓名() {
        return 员工姓名;
    }

    /**
     * 设置员工姓名属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void set员工姓名(String value) {
        this.员工姓名 = value;
    }

    /**
     * 获取证书Id属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String get证书Id() {
        return 证书Id;
    }

    /**
     * 设置证书Id属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void set证书Id(String value) {
        this.证书Id = value;
    }

    /**
     * 获取证书编号属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String get证书编号() {
        return 证书编号;
    }

    /**
     * 设置证书编号属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void set证书编号(String value) {
        this.证书编号 = value;
    }

    /**
     * 获取取得资格途径属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String get取得资格途径() {
        return 取得资格途径;
    }

    /**
     * 设置取得资格途径属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void set取得资格途径(String value) {
        this.取得资格途径 = value;
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
     * 获取证书类型属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String get证书类型() {
        return 证书类型;
    }

    /**
     * 设置证书类型属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void set证书类型(String value) {
        this.证书类型 = value;
    }

    /**
     * 获取发证单位属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String get发证单位() {
        return 发证单位;
    }

    /**
     * 设置发证单位属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void set发证单位(String value) {
        this.发证单位 = value;
    }

    /**
     * 获取初审时间属性的值。
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar get初审时间() {
        return 初审时间;
    }

    /**
     * 设置初审时间属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void set初审时间(XMLGregorianCalendar value) {
        this.初审时间 = value;
    }

    /**
     * 获取发证时间属性的值。
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar get发证时间() {
        return 发证时间;
    }

    /**
     * 设置发证时间属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void set发证时间(XMLGregorianCalendar value) {
        this.发证时间 = value;
    }

    /**
     * 获取下次复审时间属性的值。
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar get下次复审时间() {
        return 下次复审时间;
    }

    /**
     * 设置下次复审时间属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void set下次复审时间(XMLGregorianCalendar value) {
        this.下次复审时间 = value;
    }

    /**
     * 获取有效期属性的值。
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar get有效期() {
        return 有效期;
    }

    /**
     * 设置有效期属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void set有效期(XMLGregorianCalendar value) {
        this.有效期 = value;
    }

}
