
package com.qycloud.taiyuan.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>informCdt complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="informCdt">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="人员" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="人员id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="type" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "informCdt", propOrder = {
    "\u4eba\u5458",
    "\u4eba\u5458Id"
})
public class InformCdt {

    protected String 人员;
    @XmlElement(name = "\u4eba\u5458id")
    protected String 人员Id;
    @XmlAttribute(name = "type", required = true)
    protected int type;

    /**
     * 获取人员属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String get人员() {
        return 人员;
    }

    /**
     * 设置人员属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void set人员(String value) {
        this.人员 = value;
    }

    /**
     * 获取人员Id属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String get人员Id() {
        return 人员Id;
    }

    /**
     * 设置人员Id属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void set人员Id(String value) {
        this.人员Id = value;
    }

    /**
     * 获取type属性的值。
     * 
     */
    public int getType() {
        return type;
    }

    /**
     * 设置type属性的值。
     * 
     */
    public void setType(int value) {
        this.type = value;
    }

}
