
package com.qycloud.taiyuan.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * Ba通知 entity. @author MyEclipse Persistence Tools
 * 
 * <p>ba通知 complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="ba通知">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="oid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="队组" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="队组id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="人员" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="人员id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="信息内容" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="是否提示" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="提示时间" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
 *       &lt;attribute name="录入时间" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ba\u901a\u77e5", propOrder = {
    "oid",
    "\u961f\u7ec4",
    "\u961f\u7ec4Id",
    "\u4eba\u5458",
    "\u4eba\u5458Id",
    "\u4fe1\u606f\u5185\u5bb9",
    "\u662f\u5426\u63d0\u793a"
})
public class Ba通知 {

    protected String oid;
    protected String 队组;
    @XmlElement(name = "\u961f\u7ec4id")
    protected String 队组Id;
    protected String 人员;
    @XmlElement(name = "\u4eba\u5458id")
    protected String 人员Id;
    protected String 信息内容;
    protected String 是否提示;
    @XmlAttribute
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar 提示时间;
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
     * 获取队组属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String get队组() {
        return 队组;
    }

    /**
     * 设置队组属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void set队组(String value) {
        this.队组 = value;
    }

    /**
     * 获取队组Id属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String get队组Id() {
        return 队组Id;
    }

    /**
     * 设置队组Id属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void set队组Id(String value) {
        this.队组Id = value;
    }

    /**
     * 获取人员属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String get人员() {
        return 人员;
    }

    /**
     * 设置人员属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void set人员(String value) {
        this.人员 = value;
    }

    /**
     * 获取人员Id属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String get人员Id() {
        return 人员Id;
    }

    /**
     * 设置人员Id属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void set人员Id(String value) {
        this.人员Id = value;
    }

    /**
     * 获取信息内容属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String get信息内容() {
        return 信息内容;
    }

    /**
     * 设置信息内容属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void set信息内容(String value) {
        this.信息内容 = value;
    }

    /**
     * 获取是否提示属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String get是否提示() {
        return 是否提示;
    }

    /**
     * 设置是否提示属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void set是否提示(String value) {
        this.是否提示 = value;
    }

    /**
     * 获取提示时间属性的值。
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar get提示时间() {
        return 提示时间;
    }

    /**
     * 设置提示时间属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void set提示时间(XMLGregorianCalendar value) {
        this.提示时间 = value;
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
