
package com.qycloud.taiyuan.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>ba文档 complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="ba文档">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="oid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="系统id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="表名" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="业务id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="上传人id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="上传人" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="上传文件名" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="文件大小" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="文件路径" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="pdf路径" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="swf路径" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="备注" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="上传时间" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ba\u6587\u6863", propOrder = {
    "oid",
    "\u7cfb\u7edfId",
    "\u8868\u540d",
    "\u4e1a\u52a1Id",
    "\u4e0a\u4f20\u4ebaId",
    "\u4e0a\u4f20\u4eba",
    "\u4e0a\u4f20\u6587\u4ef6\u540d",
    "\u6587\u4ef6\u5927\u5c0f",
    "\u6587\u4ef6\u8def\u5f84",
    "pdf\u8def\u5f84",
    "swf\u8def\u5f84",
    "\u5907\u6ce8"
})
public class Ba文档 {

    protected String oid;
    @XmlElement(name = "\u7cfb\u7edfid")
    protected String 系统Id;
    protected String 表名;
    @XmlElement(name = "\u4e1a\u52a1id")
    protected String 业务Id;
    @XmlElement(name = "\u4e0a\u4f20\u4ebaid")
    protected String 上传人Id;
    protected String 上传人;
    protected String 上传文件名;
    protected String 文件大小;
    protected String 文件路径;
    protected String pdf路径;
    protected String swf路径;
    protected String 备注;
    @XmlAttribute
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar 上传时间;

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
     * 获取系统Id属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String get系统Id() {
        return 系统Id;
    }

    /**
     * 设置系统Id属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void set系统Id(String value) {
        this.系统Id = value;
    }

    /**
     * 获取表名属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String get表名() {
        return 表名;
    }

    /**
     * 设置表名属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void set表名(String value) {
        this.表名 = value;
    }

    /**
     * 获取业务Id属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String get业务Id() {
        return 业务Id;
    }

    /**
     * 设置业务Id属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void set业务Id(String value) {
        this.业务Id = value;
    }

    /**
     * 获取上传人Id属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String get上传人Id() {
        return 上传人Id;
    }

    /**
     * 设置上传人Id属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void set上传人Id(String value) {
        this.上传人Id = value;
    }

    /**
     * 获取上传人属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String get上传人() {
        return 上传人;
    }

    /**
     * 设置上传人属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void set上传人(String value) {
        this.上传人 = value;
    }

    /**
     * 获取上传文件名属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String get上传文件名() {
        return 上传文件名;
    }

    /**
     * 设置上传文件名属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void set上传文件名(String value) {
        this.上传文件名 = value;
    }

    /**
     * 获取文件大小属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String get文件大小() {
        return 文件大小;
    }

    /**
     * 设置文件大小属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void set文件大小(String value) {
        this.文件大小 = value;
    }

    /**
     * 获取文件路径属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String get文件路径() {
        return 文件路径;
    }

    /**
     * 设置文件路径属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void set文件路径(String value) {
        this.文件路径 = value;
    }

    /**
     * 获取pdf路径属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPdf路径() {
        return pdf路径;
    }

    /**
     * 设置pdf路径属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPdf路径(String value) {
        this.pdf路径 = value;
    }

    /**
     * 获取swf路径属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSwf路径() {
        return swf路径;
    }

    /**
     * 设置swf路径属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSwf路径(String value) {
        this.swf路径 = value;
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
     * 获取上传时间属性的值。
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar get上传时间() {
        return 上传时间;
    }

    /**
     * 设置上传时间属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void set上传时间(XMLGregorianCalendar value) {
        this.上传时间 = value;
    }

}
