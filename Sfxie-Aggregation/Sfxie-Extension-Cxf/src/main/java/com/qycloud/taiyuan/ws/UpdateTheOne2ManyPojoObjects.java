
package com.qycloud.taiyuan.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>anonymous complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="jsonString" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="className" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="list" type="{http://oup.rockontrol.com}dbServiceCdtList" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "jsonString",
    "className",
    "list"
})
@XmlRootElement(name = "updateTheOne2ManyPojoObjects")
public class UpdateTheOne2ManyPojoObjects {

    protected String jsonString;
    protected String className;
    protected DbServiceCdtList list;

    /**
     * 获取jsonString属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getJsonString() {
        return jsonString;
    }

    /**
     * 设置jsonString属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setJsonString(String value) {
        this.jsonString = value;
    }

    /**
     * 获取className属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClassName() {
        return className;
    }

    /**
     * 设置className属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClassName(String value) {
        this.className = value;
    }

    /**
     * 获取list属性的值。
     * 
     * @return
     *     possible object is
     *     {@link DbServiceCdtList }
     *     
     */
    public DbServiceCdtList getList() {
        return list;
    }

    /**
     * 设置list属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link DbServiceCdtList }
     *     
     */
    public void setList(DbServiceCdtList value) {
        this.list = value;
    }

}
