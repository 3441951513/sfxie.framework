
package com.qycloud.taiyuan.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * Ba教育经历 entity. @author MyEclipse Persistence Tools
 * 
 * <p>ba教育经历 complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="ba教育经历">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="oid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="员工id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="员工姓名" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="就读院校" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="最高学历" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="所学专业" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="类型" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="主要课程" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="获得奖励" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="备注" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="最高学位" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="就读开始日期" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
 *       &lt;attribute name="就读结束日期" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ba\u6559\u80b2\u7ecf\u5386", propOrder = {
    "oid",
    "\u5458\u5de5Id",
    "\u5458\u5de5\u59d3\u540d",
    "\u5c31\u8bfb\u9662\u6821",
    "\u6700\u9ad8\u5b66\u5386",
    "\u6240\u5b66\u4e13\u4e1a",
    "\u7c7b\u578b",
    "\u4e3b\u8981\u8bfe\u7a0b",
    "\u83b7\u5f97\u5956\u52b1",
    "\u5907\u6ce8",
    "\u6700\u9ad8\u5b66\u4f4d"
})
public class Ba教育经历 {

    protected String oid;
    @XmlElement(name = "\u5458\u5de5id")
    protected String 员工Id;
    protected String 员工姓名;
    protected String 就读院校;
    protected String 最高学历;
    protected String 所学专业;
    protected String 类型;
    protected String 主要课程;
    protected String 获得奖励;
    protected String 备注;
    protected String 最高学位;
    @XmlAttribute
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar 就读开始日期;
    @XmlAttribute
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar 就读结束日期;

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
     * 获取就读院校属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String get就读院校() {
        return 就读院校;
    }

    /**
     * 设置就读院校属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void set就读院校(String value) {
        this.就读院校 = value;
    }

    /**
     * 获取最高学历属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String get最高学历() {
        return 最高学历;
    }

    /**
     * 设置最高学历属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void set最高学历(String value) {
        this.最高学历 = value;
    }

    /**
     * 获取所学专业属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String get所学专业() {
        return 所学专业;
    }

    /**
     * 设置所学专业属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void set所学专业(String value) {
        this.所学专业 = value;
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
     * 获取主要课程属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String get主要课程() {
        return 主要课程;
    }

    /**
     * 设置主要课程属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void set主要课程(String value) {
        this.主要课程 = value;
    }

    /**
     * 获取获得奖励属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String get获得奖励() {
        return 获得奖励;
    }

    /**
     * 设置获得奖励属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void set获得奖励(String value) {
        this.获得奖励 = value;
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
     * 获取最高学位属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String get最高学位() {
        return 最高学位;
    }

    /**
     * 设置最高学位属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void set最高学位(String value) {
        this.最高学位 = value;
    }

    /**
     * 获取就读开始日期属性的值。
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar get就读开始日期() {
        return 就读开始日期;
    }

    /**
     * 设置就读开始日期属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void set就读开始日期(XMLGregorianCalendar value) {
        this.就读开始日期 = value;
    }

    /**
     * 获取就读结束日期属性的值。
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar get就读结束日期() {
        return 就读结束日期;
    }

    /**
     * 设置就读结束日期属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void set就读结束日期(XMLGregorianCalendar value) {
        this.就读结束日期 = value;
    }

}
