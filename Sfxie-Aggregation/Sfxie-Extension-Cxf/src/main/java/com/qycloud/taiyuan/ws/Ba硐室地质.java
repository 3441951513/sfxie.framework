
package com.qycloud.taiyuan.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * Ge硐室地质 entity. @author MyEclipse Persistence Tools
 * 
 * <p>ba硐室地质 complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="ba硐室地质">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="oid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="地点id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="地点名称" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="用途" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="断面形式" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="高度" type="{http://www.w3.org/2001/XMLSchema}double" />
 *       &lt;attribute name="长度" type="{http://www.w3.org/2001/XMLSchema}double" />
 *       &lt;attribute name="宽度" type="{http://www.w3.org/2001/XMLSchema}double" />
 *       &lt;attribute name="面积" type="{http://www.w3.org/2001/XMLSchema}double" />
 *       &lt;attribute name="建设日期" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
 *       &lt;attribute name="维护日期" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ba\u7850\u5ba4\u5730\u8d28", propOrder = {
    "oid",
    "\u5730\u70b9Id",
    "\u5730\u70b9\u540d\u79f0",
    "\u7528\u9014",
    "\u65ad\u9762\u5f62\u5f0f"
})
public class Ba硐室地质 {

    protected String oid;
    @XmlElement(name = "\u5730\u70b9id")
    protected String 地点Id;
    protected String 地点名称;
    protected String 用途;
    protected String 断面形式;
    @XmlAttribute
    protected Double 高度;
    @XmlAttribute
    protected Double 长度;
    @XmlAttribute
    protected Double 宽度;
    @XmlAttribute
    protected Double 面积;
    @XmlAttribute
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar 建设日期;
    @XmlAttribute
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar 维护日期;

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
     * 获取地点Id属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String get地点Id() {
        return 地点Id;
    }

    /**
     * 设置地点Id属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void set地点Id(String value) {
        this.地点Id = value;
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
     * 获取用途属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String get用途() {
        return 用途;
    }

    /**
     * 设置用途属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void set用途(String value) {
        this.用途 = value;
    }

    /**
     * 获取断面形式属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String get断面形式() {
        return 断面形式;
    }

    /**
     * 设置断面形式属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void set断面形式(String value) {
        this.断面形式 = value;
    }

    /**
     * 获取高度属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double get高度() {
        return 高度;
    }

    /**
     * 设置高度属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void set高度(Double value) {
        this.高度 = value;
    }

    /**
     * 获取长度属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double get长度() {
        return 长度;
    }

    /**
     * 设置长度属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void set长度(Double value) {
        this.长度 = value;
    }

    /**
     * 获取宽度属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double get宽度() {
        return 宽度;
    }

    /**
     * 设置宽度属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void set宽度(Double value) {
        this.宽度 = value;
    }

    /**
     * 获取面积属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double get面积() {
        return 面积;
    }

    /**
     * 设置面积属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void set面积(Double value) {
        this.面积 = value;
    }

    /**
     * 获取建设日期属性的值。
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar get建设日期() {
        return 建设日期;
    }

    /**
     * 设置建设日期属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void set建设日期(XMLGregorianCalendar value) {
        this.建设日期 = value;
    }

    /**
     * 获取维护日期属性的值。
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar get维护日期() {
        return 维护日期;
    }

    /**
     * 设置维护日期属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void set维护日期(XMLGregorianCalendar value) {
        this.维护日期 = value;
    }

}
