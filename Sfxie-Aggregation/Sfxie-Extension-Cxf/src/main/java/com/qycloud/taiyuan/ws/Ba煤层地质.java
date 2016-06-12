
package com.qycloud.taiyuan.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * Ge煤层地质 entity. @author MyEclipse Persistence Tools
 * 
 * <p>ba煤层地质 complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="ba煤层地质">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="oid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="地点id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="地点名称" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="采煤机械" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="类型" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="煤层构" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="构造" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="回采工艺" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="备注" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="煤层地质" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="工作面长度" type="{http://www.w3.org/2001/XMLSchema}double" />
 *       &lt;attribute name="倾向长度" type="{http://www.w3.org/2001/XMLSchema}double" />
 *       &lt;attribute name="预计储量" type="{http://www.w3.org/2001/XMLSchema}double" />
 *       &lt;attribute name="可开采储量" type="{http://www.w3.org/2001/XMLSchema}double" />
 *       &lt;attribute name="采高" type="{http://www.w3.org/2001/XMLSchema}double" />
 *       &lt;attribute name="顺槽剩余长度" type="{http://www.w3.org/2001/XMLSchema}double" />
 *       &lt;attribute name="探测平均煤厚" type="{http://www.w3.org/2001/XMLSchema}double" />
 *       &lt;attribute name="循环进度" type="{http://www.w3.org/2001/XMLSchema}double" />
 *       &lt;attribute name="底板高程" type="{http://www.w3.org/2001/XMLSchema}double" />
 *       &lt;attribute name="煤层厚度" type="{http://www.w3.org/2001/XMLSchema}double" />
 *       &lt;attribute name="密度" type="{http://www.w3.org/2001/XMLSchema}double" />
 *       &lt;attribute name="架数" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="最大控顶距" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="最小顶距" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="co2量" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="ch4量" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="温度" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="炸药最大量" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="风速" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="风量" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="人数" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="开采日期" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
 *       &lt;attribute name="维护日期" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
 *       &lt;attribute name="累计开采量" type="{http://www.w3.org/2001/XMLSchema}double" />
 *       &lt;attribute name="结束日期" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
 *       &lt;attribute name="工作面走向长度" type="{http://www.w3.org/2001/XMLSchema}double" />
 *       &lt;attribute name="倾角" type="{http://www.w3.org/2001/XMLSchema}double" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ba\u7164\u5c42\u5730\u8d28", propOrder = {
    "oid",
    "\u5730\u70b9Id",
    "\u5730\u70b9\u540d\u79f0",
    "\u91c7\u7164\u673a\u68b0",
    "\u7c7b\u578b",
    "\u7164\u5c42\u6784",
    "\u6784\u9020",
    "\u56de\u91c7\u5de5\u827a",
    "\u5907\u6ce8",
    "\u7164\u5c42\u5730\u8d28"
})
public class Ba煤层地质 {

    protected String oid;
    @XmlElement(name = "\u5730\u70b9id")
    protected String 地点Id;
    protected String 地点名称;
    protected String 采煤机械;
    protected String 类型;
    protected String 煤层构;
    protected String 构造;
    protected String 回采工艺;
    protected String 备注;
    protected String 煤层地质;
    @XmlAttribute
    protected Double 工作面长度;
    @XmlAttribute
    protected Double 倾向长度;
    @XmlAttribute
    protected Double 预计储量;
    @XmlAttribute
    protected Double 可开采储量;
    @XmlAttribute
    protected Double 采高;
    @XmlAttribute
    protected Double 顺槽剩余长度;
    @XmlAttribute
    protected Double 探测平均煤厚;
    @XmlAttribute
    protected Double 循环进度;
    @XmlAttribute
    protected Double 底板高程;
    @XmlAttribute
    protected Double 煤层厚度;
    @XmlAttribute
    protected Double 密度;
    @XmlAttribute
    protected Integer 架数;
    @XmlAttribute
    protected Integer 最大控顶距;
    @XmlAttribute
    protected Integer 最小顶距;
    @XmlAttribute(name = "co2\u91cf")
    protected Integer co2量;
    @XmlAttribute(name = "ch4\u91cf")
    protected Integer ch4量;
    @XmlAttribute
    protected Integer 温度;
    @XmlAttribute
    protected Integer 炸药最大量;
    @XmlAttribute
    protected Integer 风速;
    @XmlAttribute
    protected Integer 风量;
    @XmlAttribute
    protected Integer 人数;
    @XmlAttribute
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar 开采日期;
    @XmlAttribute
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar 维护日期;
    @XmlAttribute
    protected Double 累计开采量;
    @XmlAttribute
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar 结束日期;
    @XmlAttribute
    protected Double 工作面走向长度;
    @XmlAttribute
    protected Double 倾角;

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
     * 获取采煤机械属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String get采煤机械() {
        return 采煤机械;
    }

    /**
     * 设置采煤机械属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void set采煤机械(String value) {
        this.采煤机械 = value;
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
     * 获取煤层构属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String get煤层构() {
        return 煤层构;
    }

    /**
     * 设置煤层构属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void set煤层构(String value) {
        this.煤层构 = value;
    }

    /**
     * 获取构造属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String get构造() {
        return 构造;
    }

    /**
     * 设置构造属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void set构造(String value) {
        this.构造 = value;
    }

    /**
     * 获取回采工艺属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String get回采工艺() {
        return 回采工艺;
    }

    /**
     * 设置回采工艺属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void set回采工艺(String value) {
        this.回采工艺 = value;
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
     * 获取煤层地质属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String get煤层地质() {
        return 煤层地质;
    }

    /**
     * 设置煤层地质属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void set煤层地质(String value) {
        this.煤层地质 = value;
    }

    /**
     * 获取工作面长度属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double get工作面长度() {
        return 工作面长度;
    }

    /**
     * 设置工作面长度属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void set工作面长度(Double value) {
        this.工作面长度 = value;
    }

    /**
     * 获取倾向长度属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double get倾向长度() {
        return 倾向长度;
    }

    /**
     * 设置倾向长度属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void set倾向长度(Double value) {
        this.倾向长度 = value;
    }

    /**
     * 获取预计储量属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double get预计储量() {
        return 预计储量;
    }

    /**
     * 设置预计储量属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void set预计储量(Double value) {
        this.预计储量 = value;
    }

    /**
     * 获取可开采储量属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double get可开采储量() {
        return 可开采储量;
    }

    /**
     * 设置可开采储量属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void set可开采储量(Double value) {
        this.可开采储量 = value;
    }

    /**
     * 获取采高属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double get采高() {
        return 采高;
    }

    /**
     * 设置采高属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void set采高(Double value) {
        this.采高 = value;
    }

    /**
     * 获取顺槽剩余长度属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double get顺槽剩余长度() {
        return 顺槽剩余长度;
    }

    /**
     * 设置顺槽剩余长度属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void set顺槽剩余长度(Double value) {
        this.顺槽剩余长度 = value;
    }

    /**
     * 获取探测平均煤厚属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double get探测平均煤厚() {
        return 探测平均煤厚;
    }

    /**
     * 设置探测平均煤厚属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void set探测平均煤厚(Double value) {
        this.探测平均煤厚 = value;
    }

    /**
     * 获取循环进度属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double get循环进度() {
        return 循环进度;
    }

    /**
     * 设置循环进度属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void set循环进度(Double value) {
        this.循环进度 = value;
    }

    /**
     * 获取底板高程属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double get底板高程() {
        return 底板高程;
    }

    /**
     * 设置底板高程属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void set底板高程(Double value) {
        this.底板高程 = value;
    }

    /**
     * 获取煤层厚度属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double get煤层厚度() {
        return 煤层厚度;
    }

    /**
     * 设置煤层厚度属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void set煤层厚度(Double value) {
        this.煤层厚度 = value;
    }

    /**
     * 获取密度属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double get密度() {
        return 密度;
    }

    /**
     * 设置密度属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void set密度(Double value) {
        this.密度 = value;
    }

    /**
     * 获取架数属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer get架数() {
        return 架数;
    }

    /**
     * 设置架数属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void set架数(Integer value) {
        this.架数 = value;
    }

    /**
     * 获取最大控顶距属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer get最大控顶距() {
        return 最大控顶距;
    }

    /**
     * 设置最大控顶距属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void set最大控顶距(Integer value) {
        this.最大控顶距 = value;
    }

    /**
     * 获取最小顶距属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer get最小顶距() {
        return 最小顶距;
    }

    /**
     * 设置最小顶距属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void set最小顶距(Integer value) {
        this.最小顶距 = value;
    }

    /**
     * 获取co2量属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCo2量() {
        return co2量;
    }

    /**
     * 设置co2量属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCo2量(Integer value) {
        this.co2量 = value;
    }

    /**
     * 获取ch4量属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCh4量() {
        return ch4量;
    }

    /**
     * 设置ch4量属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCh4量(Integer value) {
        this.ch4量 = value;
    }

    /**
     * 获取温度属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer get温度() {
        return 温度;
    }

    /**
     * 设置温度属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void set温度(Integer value) {
        this.温度 = value;
    }

    /**
     * 获取炸药最大量属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer get炸药最大量() {
        return 炸药最大量;
    }

    /**
     * 设置炸药最大量属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void set炸药最大量(Integer value) {
        this.炸药最大量 = value;
    }

    /**
     * 获取风速属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer get风速() {
        return 风速;
    }

    /**
     * 设置风速属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void set风速(Integer value) {
        this.风速 = value;
    }

    /**
     * 获取风量属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer get风量() {
        return 风量;
    }

    /**
     * 设置风量属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void set风量(Integer value) {
        this.风量 = value;
    }

    /**
     * 获取人数属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer get人数() {
        return 人数;
    }

    /**
     * 设置人数属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void set人数(Integer value) {
        this.人数 = value;
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
     * 获取累计开采量属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double get累计开采量() {
        return 累计开采量;
    }

    /**
     * 设置累计开采量属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void set累计开采量(Double value) {
        this.累计开采量 = value;
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
     * 获取工作面走向长度属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double get工作面走向长度() {
        return 工作面走向长度;
    }

    /**
     * 设置工作面走向长度属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void set工作面走向长度(Double value) {
        this.工作面走向长度 = value;
    }

    /**
     * 获取倾角属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double get倾角() {
        return 倾角;
    }

    /**
     * 设置倾角属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void set倾角(Double value) {
        this.倾角 = value;
    }

}
