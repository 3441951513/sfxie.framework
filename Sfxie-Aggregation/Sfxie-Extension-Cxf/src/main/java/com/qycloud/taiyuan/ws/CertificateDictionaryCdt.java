
package com.qycloud.taiyuan.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * 证书字典查询条件类
 * 
 * <p>certificateDictionaryCdt complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="certificateDictionaryCdt">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="certificateCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="certificateType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="certificateName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="certificateUnit" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="zhProject" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="flag" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "certificateDictionaryCdt", propOrder = {
    "certificateCode",
    "certificateType",
    "certificateName",
    "certificateUnit",
    "zhProject"
})
public class CertificateDictionaryCdt {

    protected String certificateCode;
    protected String certificateType;
    protected String certificateName;
    protected String certificateUnit;
    protected String zhProject;
    @XmlAttribute(name = "flag", required = true)
    protected int flag;

    /**
     * 获取certificateCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCertificateCode() {
        return certificateCode;
    }

    /**
     * 设置certificateCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCertificateCode(String value) {
        this.certificateCode = value;
    }

    /**
     * 获取certificateType属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCertificateType() {
        return certificateType;
    }

    /**
     * 设置certificateType属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCertificateType(String value) {
        this.certificateType = value;
    }

    /**
     * 获取certificateName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCertificateName() {
        return certificateName;
    }

    /**
     * 设置certificateName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCertificateName(String value) {
        this.certificateName = value;
    }

    /**
     * 获取certificateUnit属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCertificateUnit() {
        return certificateUnit;
    }

    /**
     * 设置certificateUnit属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCertificateUnit(String value) {
        this.certificateUnit = value;
    }

    /**
     * 获取zhProject属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZhProject() {
        return zhProject;
    }

    /**
     * 设置zhProject属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZhProject(String value) {
        this.zhProject = value;
    }

    /**
     * 获取flag属性的值。
     * 
     */
    public int getFlag() {
        return flag;
    }

    /**
     * 设置flag属性的值。
     * 
     */
    public void setFlag(int value) {
        this.flag = value;
    }

}
