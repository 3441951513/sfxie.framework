
package com.qycloud.taiyuan.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>entiAttr complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="entiAttr">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="mineDefault" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="isnull" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="len" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="deciLen" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="cuiLen" type="{http://www.w3.org/2001/XMLSchema}byte" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "entiAttr", propOrder = {
    "name",
    "type",
    "mineDefault",
    "isnull"
})
public class EntiAttr {

    protected String name;
    protected String type;
    protected String mineDefault;
    protected String isnull;
    @XmlAttribute(name = "len")
    protected Integer len;
    @XmlAttribute(name = "deciLen")
    protected Integer deciLen;
    @XmlAttribute(name = "cuiLen")
    protected Byte cuiLen;

    /**
     * 获取name属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * 设置name属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * 获取type属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType() {
        return type;
    }

    /**
     * 设置type属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(String value) {
        this.type = value;
    }

    /**
     * 获取mineDefault属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMineDefault() {
        return mineDefault;
    }

    /**
     * 设置mineDefault属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMineDefault(String value) {
        this.mineDefault = value;
    }

    /**
     * 获取isnull属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIsnull() {
        return isnull;
    }

    /**
     * 设置isnull属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsnull(String value) {
        this.isnull = value;
    }

    /**
     * 获取len属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getLen() {
        return len;
    }

    /**
     * 设置len属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setLen(Integer value) {
        this.len = value;
    }

    /**
     * 获取deciLen属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getDeciLen() {
        return deciLen;
    }

    /**
     * 设置deciLen属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setDeciLen(Integer value) {
        this.deciLen = value;
    }

    /**
     * 获取cuiLen属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Byte }
     *     
     */
    public Byte getCuiLen() {
        return cuiLen;
    }

    /**
     * 设置cuiLen属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Byte }
     *     
     */
    public void setCuiLen(Byte value) {
        this.cuiLen = value;
    }

}
