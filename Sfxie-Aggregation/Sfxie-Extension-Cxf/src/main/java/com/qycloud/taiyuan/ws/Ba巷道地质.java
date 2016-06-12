
package com.qycloud.taiyuan.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * Ge巷道地质 entity. @author MyEclipse Persistence Tools
 * 
 * <p>ba巷道地质 complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="ba巷道地质">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="oid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="地点id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="地点名称" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="煤岩类别" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="巷道性质" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="支护形式" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="装载机械" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="耙斗机" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="溜子" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="风机" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="备注" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="断面周长" type="{http://www.w3.org/2001/XMLSchema}double" />
 *       &lt;attribute name="断面面积" type="{http://www.w3.org/2001/XMLSchema}double" />
 *       &lt;attribute name="巷高" type="{http://www.w3.org/2001/XMLSchema}double" />
 *       &lt;attribute name="巷宽" type="{http://www.w3.org/2001/XMLSchema}double" />
 *       &lt;attribute name="巷道长度" type="{http://www.w3.org/2001/XMLSchema}double" />
 *       &lt;attribute name="开采日期" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
 *       &lt;attribute name="阻力系数" type="{http://www.w3.org/2001/XMLSchema}double" />
 *       &lt;attribute name="风量" type="{http://www.w3.org/2001/XMLSchema}double" />
 *       &lt;attribute name="阻力" type="{http://www.w3.org/2001/XMLSchema}double" />
 *       &lt;attribute name="维护日期" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
 *       &lt;attribute name="结束日期" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
 *       &lt;attribute name="支护厚度" type="{http://www.w3.org/2001/XMLSchema}double" />
 *       &lt;attribute name="净断面面积" type="{http://www.w3.org/2001/XMLSchema}double" />
 *       &lt;attribute name="岩石厚度" type="{http://www.w3.org/2001/XMLSchema}double" />
 *       &lt;attribute name="巷道剩余长度" type="{http://www.w3.org/2001/XMLSchema}double" />
 *       &lt;attribute name="煤密度" type="{http://www.w3.org/2001/XMLSchema}double" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ba\u5df7\u9053\u5730\u8d28", propOrder = {
    "oid",
    "\u5730\u70b9Id",
    "\u5730\u70b9\u540d\u79f0",
    "\u7164\u5ca9\u7c7b\u522b",
    "\u5df7\u9053\u6027\u8d28",
    "\u652f\u62a4\u5f62\u5f0f",
    "\u88c5\u8f7d\u673a\u68b0",
    "\u8019\u6597\u673a",
    "\u6e9c\u5b50",
    "\u98ce\u673a",
    "\u5907\u6ce8"
})
public class Ba巷道地质 {

    protected String oid;
    @XmlElement(name = "\u5730\u70b9id")
    protected String 地点Id;
    protected String 地点名称;
    protected String 煤岩类别;
    protected String 巷道性质;
    protected String 支护形式;
    protected String 装载机械;
    protected String 耙斗机;
    protected String 溜子;
    protected String 风机;
    protected String 备注;
    @XmlAttribute
    protected Double 断面周长;
    @XmlAttribute
    protected Double 断面面积;
    @XmlAttribute
    protected Double 巷高;
    @XmlAttribute
    protected Double 巷宽;
    @XmlAttribute
    protected Double 巷道长度;
    @XmlAttribute
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar 开采日期;
    @XmlAttribute
    protected Double 阻力系数;
    @XmlAttribute
    protected Double 风量;
    @XmlAttribute
    protected Double 阻力;
    @XmlAttribute
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar 维护日期;
    @XmlAttribute
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar 结束日期;
    @XmlAttribute
    protected Double 支护厚度;
    @XmlAttribute
    protected Double 净断面面积;
    @XmlAttribute
    protected Double 岩石厚度;
    @XmlAttribute
    protected Double 巷道剩余长度;
    @XmlAttribute
    protected Double 煤密度;

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
     * 获取煤岩类别属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String get煤岩类别() {
        return 煤岩类别;
    }

    /**
     * 设置煤岩类别属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void set煤岩类别(String value) {
        this.煤岩类别 = value;
    }

    /**
     * 获取巷道性质属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String get巷道性质() {
        return 巷道性质;
    }

    /**
     * 设置巷道性质属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void set巷道性质(String value) {
        this.巷道性质 = value;
    }

    /**
     * 获取支护形式属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String get支护形式() {
        return 支护形式;
    }

    /**
     * 设置支护形式属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void set支护形式(String value) {
        this.支护形式 = value;
    }

    /**
     * 获取装载机械属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String get装载机械() {
        return 装载机械;
    }

    /**
     * 设置装载机械属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void set装载机械(String value) {
        this.装载机械 = value;
    }

    /**
     * 获取耙斗机属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String get耙斗机() {
        return 耙斗机;
    }

    /**
     * 设置耙斗机属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void set耙斗机(String value) {
        this.耙斗机 = value;
    }

    /**
     * 获取溜子属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String get溜子() {
        return 溜子;
    }

    /**
     * 设置溜子属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void set溜子(String value) {
        this.溜子 = value;
    }

    /**
     * 获取风机属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String get风机() {
        return 风机;
    }

    /**
     * 设置风机属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void set风机(String value) {
        this.风机 = value;
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
     * 获取断面周长属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double get断面周长() {
        return 断面周长;
    }

    /**
     * 设置断面周长属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void set断面周长(Double value) {
        this.断面周长 = value;
    }

    /**
     * 获取断面面积属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double get断面面积() {
        return 断面面积;
    }

    /**
     * 设置断面面积属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void set断面面积(Double value) {
        this.断面面积 = value;
    }

    /**
     * 获取巷高属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double get巷高() {
        return 巷高;
    }

    /**
     * 设置巷高属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void set巷高(Double value) {
        this.巷高 = value;
    }

    /**
     * 获取巷宽属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double get巷宽() {
        return 巷宽;
    }

    /**
     * 设置巷宽属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void set巷宽(Double value) {
        this.巷宽 = value;
    }

    /**
     * 获取巷道长度属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double get巷道长度() {
        return 巷道长度;
    }

    /**
     * 设置巷道长度属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void set巷道长度(Double value) {
        this.巷道长度 = value;
    }

    /**
     * 获取开采日期属性的值。
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar get开采日期() {
        return 开采日期;
    }

    /**
     * 设置开采日期属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void set开采日期(XMLGregorianCalendar value) {
        this.开采日期 = value;
    }

    /**
     * 获取阻力系数属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double get阻力系数() {
        return 阻力系数;
    }

    /**
     * 设置阻力系数属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void set阻力系数(Double value) {
        this.阻力系数 = value;
    }

    /**
     * 获取风量属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double get风量() {
        return 风量;
    }

    /**
     * 设置风量属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void set风量(Double value) {
        this.风量 = value;
    }

    /**
     * 获取阻力属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double get阻力() {
        return 阻力;
    }

    /**
     * 设置阻力属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void set阻力(Double value) {
        this.阻力 = value;
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

    /**
     * 获取结束日期属性的值。
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar get结束日期() {
        return 结束日期;
    }

    /**
     * 设置结束日期属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void set结束日期(XMLGregorianCalendar value) {
        this.结束日期 = value;
    }

    /**
     * 获取支护厚度属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double get支护厚度() {
        return 支护厚度;
    }

    /**
     * 设置支护厚度属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void set支护厚度(Double value) {
        this.支护厚度 = value;
    }

    /**
     * 获取净断面面积属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double get净断面面积() {
        return 净断面面积;
    }

    /**
     * 设置净断面面积属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void set净断面面积(Double value) {
        this.净断面面积 = value;
    }

    /**
     * 获取岩石厚度属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double get岩石厚度() {
        return 岩石厚度;
    }

    /**
     * 设置岩石厚度属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void set岩石厚度(Double value) {
        this.岩石厚度 = value;
    }

    /**
     * 获取巷道剩余长度属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double get巷道剩余长度() {
        return 巷道剩余长度;
    }

    /**
     * 设置巷道剩余长度属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void set巷道剩余长度(Double value) {
        this.巷道剩余长度 = value;
    }

    /**
     * 获取煤密度属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double get煤密度() {
        return 煤密度;
    }

    /**
     * 设置煤密度属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void set煤密度(Double value) {
        this.煤密度 = value;
    }

}
