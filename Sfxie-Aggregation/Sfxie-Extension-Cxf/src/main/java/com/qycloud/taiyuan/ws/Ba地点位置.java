
package com.qycloud.taiyuan.ws;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * Ba地点位置 entity. @author MyEclipse Persistence Tools
 * 
 * <p>ba地点位置 complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="ba地点位置">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="addrOrg" type="{http://oup.rockontrol.com}ba地点位置组织机构" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="oid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="地点类型" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="地点编码" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="地点名称" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="工程状态" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="备注" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="org" type="{http://oup.rockontrol.com}org" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="地点全名" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fatherId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="hasChild" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ge巷道地质" type="{http://oup.rockontrol.com}ba巷道地质" minOccurs="0"/>
 *         &lt;element name="ge掘进通风" type="{http://oup.rockontrol.com}ba掘进通风" minOccurs="0"/>
 *         &lt;element name="ge煤层地质" type="{http://oup.rockontrol.com}ba煤层地质" minOccurs="0"/>
 *         &lt;element name="ge硐室地质" type="{http://oup.rockontrol.com}ba硐室地质" minOccurs="0"/>
 *         &lt;element name="密闭说明" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="地点类型编码" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="通风系统" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="坐标x" type="{http://www.w3.org/2001/XMLSchema}long" />
 *       &lt;attribute name="坐标y" type="{http://www.w3.org/2001/XMLSchema}long" />
 *       &lt;attribute name="坐标z" type="{http://www.w3.org/2001/XMLSchema}long" />
 *       &lt;attribute name="坐标x1" type="{http://www.w3.org/2001/XMLSchema}long" />
 *       &lt;attribute name="坐标y1" type="{http://www.w3.org/2001/XMLSchema}long" />
 *       &lt;attribute name="坐标z1" type="{http://www.w3.org/2001/XMLSchema}long" />
 *       &lt;attribute name="封闭时间" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ba\u5730\u70b9\u4f4d\u7f6e", propOrder = {
    "addrOrg",
    "oid",
    "\u5730\u70b9\u7c7b\u578b",
    "\u5730\u70b9\u7f16\u7801",
    "\u5730\u70b9\u540d\u79f0",
    "\u5de5\u7a0b\u72b6\u6001",
    "\u5907\u6ce8",
    "org",
    "\u5730\u70b9\u5168\u540d",
    "fatherId",
    "hasChild",
    "ge\u5df7\u9053\u5730\u8d28",
    "ge\u6398\u8fdb\u901a\u98ce",
    "ge\u7164\u5c42\u5730\u8d28",
    "ge\u7850\u5ba4\u5730\u8d28",
    "\u5bc6\u95ed\u8bf4\u660e",
    "\u5730\u70b9\u7c7b\u578b\u7f16\u7801",
    "\u901a\u98ce\u7cfb\u7edf"
})
public class Ba地点位置 {

    protected List<Ba地点位置组织机构> addrOrg;
    protected String oid;
    protected String 地点类型;
    protected String 地点编码;
    protected String 地点名称;
    protected String 工程状态;
    protected String 备注;
    protected List<Org> org;
    protected String 地点全名;
    protected String fatherId;
    protected String hasChild;
    protected Ba巷道地质 ge巷道地质;
    protected Ba掘进通风 ge掘进通风;
    protected Ba煤层地质 ge煤层地质;
    protected Ba硐室地质 ge硐室地质;
    protected String 密闭说明;
    protected String 地点类型编码;
    protected String 通风系统;
    @XmlAttribute(name = "\u5750\u6807x")
    protected Long 坐标X;
    @XmlAttribute(name = "\u5750\u6807y")
    protected Long 坐标Y;
    @XmlAttribute(name = "\u5750\u6807z")
    protected Long 坐标Z;
    @XmlAttribute(name = "\u5750\u6807x1")
    protected Long 坐标X1;
    @XmlAttribute(name = "\u5750\u6807y1")
    protected Long 坐标Y1;
    @XmlAttribute(name = "\u5750\u6807z1")
    protected Long 坐标Z1;
    @XmlAttribute
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar 封闭时间;

    /**
     * Gets the value of the addrOrg property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the addrOrg property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAddrOrg().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Ba地点位置组织机构 }
     * 
     * 
     */
    public List<Ba地点位置组织机构> getAddrOrg() {
        if (addrOrg == null) {
            addrOrg = new ArrayList<Ba地点位置组织机构>();
        }
        return this.addrOrg;
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
     * Gets the value of the org property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the org property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOrg().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Org }
     * 
     * 
     */
    public List<Org> getOrg() {
        if (org == null) {
            org = new ArrayList<Org>();
        }
        return this.org;
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
     * 获取fatherId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFatherId() {
        return fatherId;
    }

    /**
     * 设置fatherId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFatherId(String value) {
        this.fatherId = value;
    }

    /**
     * 获取hasChild属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHasChild() {
        return hasChild;
    }

    /**
     * 设置hasChild属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHasChild(String value) {
        this.hasChild = value;
    }

    /**
     * 获取ge巷道地质属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Ba巷道地质 }
     *     
     */
    public Ba巷道地质 getGe巷道地质() {
        return ge巷道地质;
    }

    /**
     * 设置ge巷道地质属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Ba巷道地质 }
     *     
     */
    public void setGe巷道地质(Ba巷道地质 value) {
        this.ge巷道地质 = value;
    }

    /**
     * 获取ge掘进通风属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Ba掘进通风 }
     *     
     */
    public Ba掘进通风 getGe掘进通风() {
        return ge掘进通风;
    }

    /**
     * 设置ge掘进通风属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Ba掘进通风 }
     *     
     */
    public void setGe掘进通风(Ba掘进通风 value) {
        this.ge掘进通风 = value;
    }

    /**
     * 获取ge煤层地质属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Ba煤层地质 }
     *     
     */
    public Ba煤层地质 getGe煤层地质() {
        return ge煤层地质;
    }

    /**
     * 设置ge煤层地质属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Ba煤层地质 }
     *     
     */
    public void setGe煤层地质(Ba煤层地质 value) {
        this.ge煤层地质 = value;
    }

    /**
     * 获取ge硐室地质属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Ba硐室地质 }
     *     
     */
    public Ba硐室地质 getGe硐室地质() {
        return ge硐室地质;
    }

    /**
     * 设置ge硐室地质属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Ba硐室地质 }
     *     
     */
    public void setGe硐室地质(Ba硐室地质 value) {
        this.ge硐室地质 = value;
    }

    /**
     * 获取密闭说明属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String get密闭说明() {
        return 密闭说明;
    }

    /**
     * 设置密闭说明属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void set密闭说明(String value) {
        this.密闭说明 = value;
    }

    /**
     * 获取地点类型编码属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String get地点类型编码() {
        return 地点类型编码;
    }

    /**
     * 设置地点类型编码属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void set地点类型编码(String value) {
        this.地点类型编码 = value;
    }

    /**
     * 获取通风系统属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String get通风系统() {
        return 通风系统;
    }

    /**
     * 设置通风系统属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void set通风系统(String value) {
        this.通风系统 = value;
    }

    /**
     * 获取坐标X属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long get坐标X() {
        return 坐标X;
    }

    /**
     * 设置坐标X属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void set坐标X(Long value) {
        this.坐标X = value;
    }

    /**
     * 获取坐标Y属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long get坐标Y() {
        return 坐标Y;
    }

    /**
     * 设置坐标Y属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void set坐标Y(Long value) {
        this.坐标Y = value;
    }

    /**
     * 获取坐标Z属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long get坐标Z() {
        return 坐标Z;
    }

    /**
     * 设置坐标Z属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void set坐标Z(Long value) {
        this.坐标Z = value;
    }

    /**
     * 获取坐标X1属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long get坐标X1() {
        return 坐标X1;
    }

    /**
     * 设置坐标X1属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void set坐标X1(Long value) {
        this.坐标X1 = value;
    }

    /**
     * 获取坐标Y1属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long get坐标Y1() {
        return 坐标Y1;
    }

    /**
     * 设置坐标Y1属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void set坐标Y1(Long value) {
        this.坐标Y1 = value;
    }

    /**
     * 获取坐标Z1属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long get坐标Z1() {
        return 坐标Z1;
    }

    /**
     * 设置坐标Z1属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void set坐标Z1(Long value) {
        this.坐标Z1 = value;
    }

    /**
     * 获取封闭时间属性的值。
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar get封闭时间() {
        return 封闭时间;
    }

    /**
     * 设置封闭时间属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void set封闭时间(XMLGregorianCalendar value) {
        this.封闭时间 = value;
    }

}
