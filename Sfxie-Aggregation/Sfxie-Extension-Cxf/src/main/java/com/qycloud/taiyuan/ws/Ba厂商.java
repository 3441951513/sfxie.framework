
package com.qycloud.taiyuan.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Ba厂商 entity. @author MyEclipse Persistence Tools
 * 
 * <p>ba厂商 complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="ba厂商">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="oid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="厂商分类id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="厂商分类" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="名称" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="全称" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="开户银行" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="地址" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="通讯地址" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="邮编" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="联系人" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="联系电话" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="传真号码" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="简介" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="账号" type="{http://www.w3.org/2001/XMLSchema}long" />
 *       &lt;attribute name="注册资金" type="{http://www.w3.org/2001/XMLSchema}long" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ba\u5382\u5546", propOrder = {
    "oid",
    "\u5382\u5546\u5206\u7c7bId",
    "\u5382\u5546\u5206\u7c7b",
    "\u540d\u79f0",
    "\u5168\u79f0",
    "\u5f00\u6237\u94f6\u884c",
    "\u5730\u5740",
    "\u901a\u8baf\u5730\u5740",
    "\u90ae\u7f16",
    "\u8054\u7cfb\u4eba",
    "\u8054\u7cfb\u7535\u8bdd",
    "\u4f20\u771f\u53f7\u7801",
    "\u7b80\u4ecb"
})
public class Ba厂商 {

    protected String oid;
    @XmlElement(name = "\u5382\u5546\u5206\u7c7bid")
    protected String 厂商分类Id;
    protected String 厂商分类;
    protected String 名称;
    protected String 全称;
    protected String 开户银行;
    protected String 地址;
    protected String 通讯地址;
    protected String 邮编;
    protected String 联系人;
    protected String 联系电话;
    protected String 传真号码;
    protected String 简介;
    @XmlAttribute
    protected Long 账号;
    @XmlAttribute
    protected Long 注册资金;

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
     * 获取厂商分类Id属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String get厂商分类Id() {
        return 厂商分类Id;
    }

    /**
     * 设置厂商分类Id属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void set厂商分类Id(String value) {
        this.厂商分类Id = value;
    }

    /**
     * 获取厂商分类属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String get厂商分类() {
        return 厂商分类;
    }

    /**
     * 设置厂商分类属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void set厂商分类(String value) {
        this.厂商分类 = value;
    }

    /**
     * 获取名称属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String get名称() {
        return 名称;
    }

    /**
     * 设置名称属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void set名称(String value) {
        this.名称 = value;
    }

    /**
     * 获取全称属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String get全称() {
        return 全称;
    }

    /**
     * 设置全称属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void set全称(String value) {
        this.全称 = value;
    }

    /**
     * 获取开户银行属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String get开户银行() {
        return 开户银行;
    }

    /**
     * 设置开户银行属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void set开户银行(String value) {
        this.开户银行 = value;
    }

    /**
     * 获取地址属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String get地址() {
        return 地址;
    }

    /**
     * 设置地址属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void set地址(String value) {
        this.地址 = value;
    }

    /**
     * 获取通讯地址属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String get通讯地址() {
        return 通讯地址;
    }

    /**
     * 设置通讯地址属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void set通讯地址(String value) {
        this.通讯地址 = value;
    }

    /**
     * 获取邮编属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String get邮编() {
        return 邮编;
    }

    /**
     * 设置邮编属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void set邮编(String value) {
        this.邮编 = value;
    }

    /**
     * 获取联系人属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String get联系人() {
        return 联系人;
    }

    /**
     * 设置联系人属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void set联系人(String value) {
        this.联系人 = value;
    }

    /**
     * 获取联系电话属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String get联系电话() {
        return 联系电话;
    }

    /**
     * 设置联系电话属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void set联系电话(String value) {
        this.联系电话 = value;
    }

    /**
     * 获取传真号码属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String get传真号码() {
        return 传真号码;
    }

    /**
     * 设置传真号码属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void set传真号码(String value) {
        this.传真号码 = value;
    }

    /**
     * 获取简介属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String get简介() {
        return 简介;
    }

    /**
     * 设置简介属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void set简介(String value) {
        this.简介 = value;
    }

    /**
     * 获取账号属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long get账号() {
        return 账号;
    }

    /**
     * 设置账号属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void set账号(Long value) {
        this.账号 = value;
    }

    /**
     * 获取注册资金属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long get注册资金() {
        return 注册资金;
    }

    /**
     * 设置注册资金属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void set注册资金(Long value) {
        this.注册资金 = value;
    }

}
