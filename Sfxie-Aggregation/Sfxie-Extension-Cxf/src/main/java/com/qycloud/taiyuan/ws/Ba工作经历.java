
package com.qycloud.taiyuan.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * Ba工作经历 entity. @author MyEclipse Persistence Tools
 * 
 * <p>ba工作经历 complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="ba工作经历">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="oid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="员工id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="员工姓名" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="工作单位" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="职位" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="证明人" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="主要工作" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="工作成绩" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="备注" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="是否是本公司" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="工作开始日期" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
 *       &lt;attribute name="工作结束日期" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ba\u5de5\u4f5c\u7ecf\u5386", propOrder = {
    "oid",
    "\u5458\u5de5Id",
    "\u5458\u5de5\u59d3\u540d",
    "\u5de5\u4f5c\u5355\u4f4d",
    "\u804c\u4f4d",
    "\u8bc1\u660e\u4eba",
    "\u4e3b\u8981\u5de5\u4f5c",
    "\u5de5\u4f5c\u6210\u7ee9",
    "\u5907\u6ce8",
    "\u662f\u5426\u662f\u672c\u516c\u53f8"
})
public class Ba工作经历 {

    protected String oid;
    @XmlElement(name = "\u5458\u5de5id")
    protected String 员工Id;
    protected String 员工姓名;
    protected String 工作单位;
    protected String 职位;
    protected String 证明人;
    protected String 主要工作;
    protected String 工作成绩;
    protected String 备注;
    protected String 是否是本公司;
    @XmlAttribute
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar 工作开始日期;
    @XmlAttribute
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar 工作结束日期;

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
     * 获取工作单位属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String get工作单位() {
        return 工作单位;
    }

    /**
     * 设置工作单位属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void set工作单位(String value) {
        this.工作单位 = value;
    }

    /**
     * 获取职位属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String get职位() {
        return 职位;
    }

    /**
     * 设置职位属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void set职位(String value) {
        this.职位 = value;
    }

    /**
     * 获取证明人属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String get证明人() {
        return 证明人;
    }

    /**
     * 设置证明人属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void set证明人(String value) {
        this.证明人 = value;
    }

    /**
     * 获取主要工作属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String get主要工作() {
        return 主要工作;
    }

    /**
     * 设置主要工作属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void set主要工作(String value) {
        this.主要工作 = value;
    }

    /**
     * 获取工作成绩属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String get工作成绩() {
        return 工作成绩;
    }

    /**
     * 设置工作成绩属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void set工作成绩(String value) {
        this.工作成绩 = value;
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
     * 获取是否是本公司属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String get是否是本公司() {
        return 是否是本公司;
    }

    /**
     * 设置是否是本公司属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void set是否是本公司(String value) {
        this.是否是本公司 = value;
    }

    /**
     * 获取工作开始日期属性的值。
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar get工作开始日期() {
        return 工作开始日期;
    }

    /**
     * 设置工作开始日期属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void set工作开始日期(XMLGregorianCalendar value) {
        this.工作开始日期 = value;
    }

    /**
     * 获取工作结束日期属性的值。
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar get工作结束日期() {
        return 工作结束日期;
    }

    /**
     * 设置工作结束日期属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void set工作结束日期(XMLGregorianCalendar value) {
        this.工作结束日期 = value;
    }

}
