
package com.qycloud.taiyuan.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * Ba系统变量 entity. @author MyEclipse Persistence Tools
 * 
 * <p>ba系统变量 complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="ba系统变量">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="oid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sysId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="变量名" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="变量值" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="备注" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="客户维护" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ba\u7cfb\u7edf\u53d8\u91cf", propOrder = {
    "oid",
    "sysId",
    "\u53d8\u91cf\u540d",
    "\u53d8\u91cf\u503c",
    "\u5907\u6ce8",
    "\u5ba2\u6237\u7ef4\u62a4"
})
public class Ba系统变量 {

    protected String oid;
    protected String sysId;
    protected String 变量名;
    protected String 变量值;
    protected String 备注;
    protected String 客户维护;

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
     * 获取sysId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSysId() {
        return sysId;
    }

    /**
     * 设置sysId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSysId(String value) {
        this.sysId = value;
    }

    /**
     * 获取变量名属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String get变量名() {
        return 变量名;
    }

    /**
     * 设置变量名属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void set变量名(String value) {
        this.变量名 = value;
    }

    /**
     * 获取变量值属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String get变量值() {
        return 变量值;
    }

    /**
     * 设置变量值属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void set变量值(String value) {
        this.变量值 = value;
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
     * 获取客户维护属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String get客户维护() {
        return 客户维护;
    }

    /**
     * 设置客户维护属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void set客户维护(String value) {
        this.客户维护 = value;
    }

}
