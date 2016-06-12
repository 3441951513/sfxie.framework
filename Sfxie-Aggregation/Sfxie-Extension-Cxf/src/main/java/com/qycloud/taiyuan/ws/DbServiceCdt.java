
package com.qycloud.taiyuan.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>dbServiceCdt complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="dbServiceCdt">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="value" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="className" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="listJsonStr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fkField" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sql" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sqls" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="hqls" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="hql" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="one2ManyUpdateFlag" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dbServiceCdt", propOrder = {
    "name",
    "value",
    "className",
    "listJsonStr",
    "fkField",
    "sql",
    "sqls",
    "hqls",
    "hql"
})
public class DbServiceCdt {

    protected String name;
    protected String value;
    protected String className;
    protected String listJsonStr;
    protected String fkField;
    protected String sql;
    protected String sqls;
    protected String hqls;
    protected String hql;
    @XmlAttribute(name = "one2ManyUpdateFlag")
    protected Integer one2ManyUpdateFlag;

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
     * 获取value属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValue() {
        return value;
    }

    /**
     * 设置value属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValue(String value) {
        this.value = value;
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
     * 获取listJsonStr属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getListJsonStr() {
        return listJsonStr;
    }

    /**
     * 设置listJsonStr属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setListJsonStr(String value) {
        this.listJsonStr = value;
    }

    /**
     * 获取fkField属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFkField() {
        return fkField;
    }

    /**
     * 设置fkField属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFkField(String value) {
        this.fkField = value;
    }

    /**
     * 获取sql属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSql() {
        return sql;
    }

    /**
     * 设置sql属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSql(String value) {
        this.sql = value;
    }

    /**
     * 获取sqls属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSqls() {
        return sqls;
    }

    /**
     * 设置sqls属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSqls(String value) {
        this.sqls = value;
    }

    /**
     * 获取hqls属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHqls() {
        return hqls;
    }

    /**
     * 设置hqls属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHqls(String value) {
        this.hqls = value;
    }

    /**
     * 获取hql属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHql() {
        return hql;
    }

    /**
     * 设置hql属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHql(String value) {
        this.hql = value;
    }

    /**
     * 获取one2ManyUpdateFlag属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getOne2ManyUpdateFlag() {
        return one2ManyUpdateFlag;
    }

    /**
     * 设置one2ManyUpdateFlag属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setOne2ManyUpdateFlag(Integer value) {
        this.one2ManyUpdateFlag = value;
    }

}
