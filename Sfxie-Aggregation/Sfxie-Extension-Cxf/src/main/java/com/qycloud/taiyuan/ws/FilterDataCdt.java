
package com.qycloud.taiyuan.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>filterDataCdt complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="filterDataCdt">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="过滤子节点" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="业务字段名" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="appId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="业务ID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="业务名称" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="业务编码" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="表别名" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="表字段名" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="是否过滤" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="typeFlag" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="sentenceFlag" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "filterDataCdt", propOrder = {
    "\u8fc7\u6ee4\u5b50\u8282\u70b9",
    "\u4e1a\u52a1\u5b57\u6bb5\u540d",
    "appId",
    "\u4e1a\u52a1ID",
    "\u4e1a\u52a1\u540d\u79f0",
    "\u4e1a\u52a1\u7f16\u7801",
    "\u8868\u522b\u540d",
    "\u8868\u5b57\u6bb5\u540d",
    "\u662f\u5426\u8fc7\u6ee4"
})
public class FilterDataCdt {

    protected String 过滤子节点;
    protected String 业务字段名;
    protected String appId;
    protected String 业务ID;
    protected String 业务名称;
    protected String 业务编码;
    protected String 表别名;
    protected String 表字段名;
    protected String 是否过滤;
    @XmlAttribute(name = "typeFlag")
    protected Integer typeFlag;
    @XmlAttribute(name = "sentenceFlag")
    protected Integer sentenceFlag;

    /**
     * 获取过滤子节点属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String get过滤子节点() {
        return 过滤子节点;
    }

    /**
     * 设置过滤子节点属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void set过滤子节点(String value) {
        this.过滤子节点 = value;
    }

    /**
     * 获取业务字段名属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String get业务字段名() {
        return 业务字段名;
    }

    /**
     * 设置业务字段名属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void set业务字段名(String value) {
        this.业务字段名 = value;
    }

    /**
     * 获取appId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAppId() {
        return appId;
    }

    /**
     * 设置appId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAppId(String value) {
        this.appId = value;
    }

    /**
     * 获取业务ID属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String get业务ID() {
        return 业务ID;
    }

    /**
     * 设置业务ID属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void set业务ID(String value) {
        this.业务ID = value;
    }

    /**
     * 获取业务名称属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String get业务名称() {
        return 业务名称;
    }

    /**
     * 设置业务名称属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void set业务名称(String value) {
        this.业务名称 = value;
    }

    /**
     * 获取业务编码属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String get业务编码() {
        return 业务编码;
    }

    /**
     * 设置业务编码属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void set业务编码(String value) {
        this.业务编码 = value;
    }

    /**
     * 获取表别名属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String get表别名() {
        return 表别名;
    }

    /**
     * 设置表别名属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void set表别名(String value) {
        this.表别名 = value;
    }

    /**
     * 获取表字段名属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String get表字段名() {
        return 表字段名;
    }

    /**
     * 设置表字段名属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void set表字段名(String value) {
        this.表字段名 = value;
    }

    /**
     * 获取是否过滤属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String get是否过滤() {
        return 是否过滤;
    }

    /**
     * 设置是否过滤属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void set是否过滤(String value) {
        this.是否过滤 = value;
    }

    /**
     * 获取typeFlag属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getTypeFlag() {
        return typeFlag;
    }

    /**
     * 设置typeFlag属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setTypeFlag(Integer value) {
        this.typeFlag = value;
    }

    /**
     * 获取sentenceFlag属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getSentenceFlag() {
        return sentenceFlag;
    }

    /**
     * 设置sentenceFlag属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setSentenceFlag(Integer value) {
        this.sentenceFlag = value;
    }

}
