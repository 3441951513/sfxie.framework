
package com.qycloud.taiyuan.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * Ba社会关系 entity. @author MyEclipse Persistence Tools
 * 
 * <p>ba社会关系 complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="ba社会关系">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="oid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="员工id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="员工姓名" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="关系人姓名" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="与本人关系" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="工作单位" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="职务" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="政治面貌" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="备注" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="出生日期" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ba\u793e\u4f1a\u5173\u7cfb", propOrder = {
    "oid",
    "\u5458\u5de5Id",
    "\u5458\u5de5\u59d3\u540d",
    "\u5173\u7cfb\u4eba\u59d3\u540d",
    "\u4e0e\u672c\u4eba\u5173\u7cfb",
    "\u5de5\u4f5c\u5355\u4f4d",
    "\u804c\u52a1",
    "\u653f\u6cbb\u9762\u8c8c",
    "\u5907\u6ce8"
})
public class Ba社会关系 {

    protected String oid;
    @XmlElement(name = "\u5458\u5de5id")
    protected String 员工Id;
    protected String 员工姓名;
    protected String 关系人姓名;
    protected String 与本人关系;
    protected String 工作单位;
    protected String 职务;
    protected String 政治面貌;
    protected String 备注;
    @XmlAttribute
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar 出生日期;

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
     * 获取关系人姓名属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String get关系人姓名() {
        return 关系人姓名;
    }

    /**
     * 设置关系人姓名属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void set关系人姓名(String value) {
        this.关系人姓名 = value;
    }

    /**
     * 获取与本人关系属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String get与本人关系() {
        return 与本人关系;
    }

    /**
     * 设置与本人关系属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void set与本人关系(String value) {
        this.与本人关系 = value;
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
     * 获取职务属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String get职务() {
        return 职务;
    }

    /**
     * 设置职务属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void set职务(String value) {
        this.职务 = value;
    }

    /**
     * 获取政治面貌属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String get政治面貌() {
        return 政治面貌;
    }

    /**
     * 设置政治面貌属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void set政治面貌(String value) {
        this.政治面貌 = value;
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
     * 获取出生日期属性的值。
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar get出生日期() {
        return 出生日期;
    }

    /**
     * 设置出生日期属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void set出生日期(XMLGregorianCalendar value) {
        this.出生日期 = value;
    }

}
