
package com.qycloud.taiyuan.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>deptAdministratorCdt complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="deptAdministratorCdt">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="名字" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="用户id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="用户名" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="名字s" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="权限" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="用户ids" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="appId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "deptAdministratorCdt", propOrder = {
    "\u540d\u5b57",
    "\u7528\u6237Id",
    "\u7528\u6237\u540d",
    "\u540d\u5b57S",
    "\u6743\u9650",
    "\u7528\u6237Ids",
    "appId"
})
public class DeptAdministratorCdt {

    protected String 名字;
    @XmlElement(name = "\u7528\u6237id")
    protected String 用户Id;
    protected String 用户名;
    @XmlElement(name = "\u540d\u5b57s")
    protected String 名字S;
    protected String 权限;
    @XmlElement(name = "\u7528\u6237ids")
    protected String 用户Ids;
    protected String appId;

    /**
     * 获取名字属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String get名字() {
        return 名字;
    }

    /**
     * 设置名字属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void set名字(String value) {
        this.名字 = value;
    }

    /**
     * 获取用户Id属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String get用户Id() {
        return 用户Id;
    }

    /**
     * 设置用户Id属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void set用户Id(String value) {
        this.用户Id = value;
    }

    /**
     * 获取用户名属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String get用户名() {
        return 用户名;
    }

    /**
     * 设置用户名属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void set用户名(String value) {
        this.用户名 = value;
    }

    /**
     * 获取名字S属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String get名字S() {
        return 名字S;
    }

    /**
     * 设置名字S属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void set名字S(String value) {
        this.名字S = value;
    }

    /**
     * 获取权限属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String get权限() {
        return 权限;
    }

    /**
     * 设置权限属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void set权限(String value) {
        this.权限 = value;
    }

    /**
     * 获取用户Ids属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String get用户Ids() {
        return 用户Ids;
    }

    /**
     * 设置用户Ids属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void set用户Ids(String value) {
        this.用户Ids = value;
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

}
