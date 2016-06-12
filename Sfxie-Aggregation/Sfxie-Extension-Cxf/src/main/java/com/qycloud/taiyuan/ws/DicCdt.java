
package com.qycloud.taiyuan.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>dicCdt complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="dicCdt">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="types" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="code" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="names" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="appId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="notContainsOids" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="notContainsNames" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="codeSpaceLength" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="levelFlag" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="codeLength" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="tag" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="size" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dicCdt", propOrder = {
    "name",
    "types",
    "code",
    "names",
    "appId",
    "notContainsOids",
    "notContainsNames",
    "type"
})
public class DicCdt {

    protected String name;
    protected String types;
    protected String code;
    protected String names;
    protected String appId;
    protected String notContainsOids;
    protected String notContainsNames;
    protected String type;
    @XmlAttribute(name = "codeSpaceLength", required = true)
    protected int codeSpaceLength;
    @XmlAttribute(name = "levelFlag", required = true)
    protected int levelFlag;
    @XmlAttribute(name = "codeLength", required = true)
    protected int codeLength;
    @XmlAttribute(name = "tag")
    protected Integer tag;
    @XmlAttribute(name = "size", required = true)
    protected int size;

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
     * 获取types属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTypes() {
        return types;
    }

    /**
     * 设置types属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTypes(String value) {
        this.types = value;
    }

    /**
     * 获取code属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置code属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCode(String value) {
        this.code = value;
    }

    /**
     * 获取names属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNames() {
        return names;
    }

    /**
     * 设置names属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNames(String value) {
        this.names = value;
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
     * 获取notContainsOids属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNotContainsOids() {
        return notContainsOids;
    }

    /**
     * 设置notContainsOids属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNotContainsOids(String value) {
        this.notContainsOids = value;
    }

    /**
     * 获取notContainsNames属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNotContainsNames() {
        return notContainsNames;
    }

    /**
     * 设置notContainsNames属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNotContainsNames(String value) {
        this.notContainsNames = value;
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
     * 获取codeSpaceLength属性的值。
     * 
     */
    public int getCodeSpaceLength() {
        return codeSpaceLength;
    }

    /**
     * 设置codeSpaceLength属性的值。
     * 
     */
    public void setCodeSpaceLength(int value) {
        this.codeSpaceLength = value;
    }

    /**
     * 获取levelFlag属性的值。
     * 
     */
    public int getLevelFlag() {
        return levelFlag;
    }

    /**
     * 设置levelFlag属性的值。
     * 
     */
    public void setLevelFlag(int value) {
        this.levelFlag = value;
    }

    /**
     * 获取codeLength属性的值。
     * 
     */
    public int getCodeLength() {
        return codeLength;
    }

    /**
     * 设置codeLength属性的值。
     * 
     */
    public void setCodeLength(int value) {
        this.codeLength = value;
    }

    /**
     * 获取tag属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getTag() {
        return tag;
    }

    /**
     * 设置tag属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setTag(Integer value) {
        this.tag = value;
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
