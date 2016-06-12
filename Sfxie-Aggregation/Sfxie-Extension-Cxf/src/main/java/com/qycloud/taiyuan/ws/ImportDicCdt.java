
package com.qycloud.taiyuan.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>importDicCdt complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="importDicCdt">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="表名" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="表名s" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="程序名" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="程序名s" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="应用系统" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="应用系统id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="size" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "importDicCdt", propOrder = {
    "\u8868\u540d",
    "\u8868\u540dS",
    "\u7a0b\u5e8f\u540d",
    "\u7a0b\u5e8f\u540dS",
    "\u5e94\u7528\u7cfb\u7edf",
    "\u5e94\u7528\u7cfb\u7edfId"
})
public class ImportDicCdt {

    protected String 表名;
    @XmlElement(name = "\u8868\u540ds")
    protected String 表名S;
    protected String 程序名;
    @XmlElement(name = "\u7a0b\u5e8f\u540ds")
    protected String 程序名S;
    protected String 应用系统;
    @XmlElement(name = "\u5e94\u7528\u7cfb\u7edfid")
    protected String 应用系统Id;
    @XmlAttribute(name = "size", required = true)
    protected int size;

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
     * 获取表名S属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String get表名S() {
        return 表名S;
    }

    /**
     * 设置表名S属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void set表名S(String value) {
        this.表名S = value;
    }

    /**
     * 获取程序名属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String get程序名() {
        return 程序名;
    }

    /**
     * 设置程序名属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void set程序名(String value) {
        this.程序名 = value;
    }

    /**
     * 获取程序名S属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String get程序名S() {
        return 程序名S;
    }

    /**
     * 设置程序名S属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void set程序名S(String value) {
        this.程序名S = value;
    }

    /**
     * 获取应用系统属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String get应用系统() {
        return 应用系统;
    }

    /**
     * 设置应用系统属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void set应用系统(String value) {
        this.应用系统 = value;
    }

    /**
     * 获取应用系统Id属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String get应用系统Id() {
        return 应用系统Id;
    }

    /**
     * 设置应用系统Id属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void set应用系统Id(String value) {
        this.应用系统Id = value;
    }

    /**
     * 获取size属性的值。
     * 
     */
    public int getSize() {
        return size;
    }

    /**
     * 设置size属性的值。
     * 
     */
    public void setSize(int value) {
        this.size = value;
    }

}
