
package com.qycloud.taiyuan.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Ge掘进通风 entity. @author MyEclipse Persistence Tools
 * 
 * <p>ba掘进通风 complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="ba掘进通风">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="巷道地质id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="风扇型号" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="功率" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="风筒直径" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="供风距离" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="局扇最大吸风量" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="ch4" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="co2" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="炸药最大用量" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="断面" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="温度" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="风速" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="全风压供风量" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="人数" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ba\u6398\u8fdb\u901a\u98ce", propOrder = {
    "\u5df7\u9053\u5730\u8d28Id",
    "\u98ce\u6247\u578b\u53f7"
})
public class Ba掘进通风 {

    @XmlElement(name = "\u5df7\u9053\u5730\u8d28id")
    protected String 巷道地质Id;
    protected String 风扇型号;
    @XmlAttribute
    protected Integer 功率;
    @XmlAttribute
    protected Integer 风筒直径;
    @XmlAttribute
    protected Integer 供风距离;
    @XmlAttribute
    protected Integer 局扇最大吸风量;
    @XmlAttribute(name = "ch4")
    protected Integer ch4;
    @XmlAttribute(name = "co2")
    protected Integer co2;
    @XmlAttribute
    protected Integer 炸药最大用量;
    @XmlAttribute
    protected Integer 断面;
    @XmlAttribute
    protected Integer 温度;
    @XmlAttribute
    protected Integer 风速;
    @XmlAttribute
    protected Integer 全风压供风量;
    @XmlAttribute
    protected Integer 人数;

    /**
     * 获取巷道地质Id属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String get巷道地质Id() {
        return 巷道地质Id;
    }

    /**
     * 设置巷道地质Id属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void set巷道地质Id(String value) {
        this.巷道地质Id = value;
    }

    /**
     * 获取风扇型号属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String get风扇型号() {
        return 风扇型号;
    }

    /**
     * 设置风扇型号属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void set风扇型号(String value) {
        this.风扇型号 = value;
    }

    /**
     * 获取功率属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer get功率() {
        return 功率;
    }

    /**
     * 设置功率属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void set功率(Integer value) {
        this.功率 = value;
    }

    /**
     * 获取风筒直径属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer get风筒直径() {
        return 风筒直径;
    }

    /**
     * 设置风筒直径属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void set风筒直径(Integer value) {
        this.风筒直径 = value;
    }

    /**
     * 获取供风距离属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer get供风距离() {
        return 供风距离;
    }

    /**
     * 设置供风距离属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void set供风距离(Integer value) {
        this.供风距离 = value;
    }

    /**
     * 获取局扇最大吸风量属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer get局扇最大吸风量() {
        return 局扇最大吸风量;
    }

    /**
     * 设置局扇最大吸风量属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void set局扇最大吸风量(Integer value) {
        this.局扇最大吸风量 = value;
    }

    /**
     * 获取ch4属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCh4() {
        return ch4;
    }

    /**
     * 设置ch4属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCh4(Integer value) {
        this.ch4 = value;
    }

    /**
     * 获取co2属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCo2() {
        return co2;
    }

    /**
     * 设置co2属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCo2(Integer value) {
        this.co2 = value;
    }

    /**
     * 获取炸药最大用量属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer get炸药最大用量() {
        return 炸药最大用量;
    }

    /**
     * 设置炸药最大用量属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void set炸药最大用量(Integer value) {
        this.炸药最大用量 = value;
    }

    /**
     * 获取断面属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer get断面() {
        return 断面;
    }

    /**
     * 设置断面属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void set断面(Integer value) {
        this.断面 = value;
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
     * 获取全风压供风量属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer get全风压供风量() {
        return 全风压供风量;
    }

    /**
     * 设置全风压供风量属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void set全风压供风量(Integer value) {
        this.全风压供风量 = value;
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

}
