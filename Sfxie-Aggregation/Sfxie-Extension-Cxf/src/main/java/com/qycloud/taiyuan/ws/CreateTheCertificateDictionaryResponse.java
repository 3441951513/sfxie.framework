
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
 *         &lt;element name="证书字典OID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "\u8bc1\u4e66\u5b57\u5178OID"
})
@XmlRootElement(name = "createTheCertificateDictionaryResponse")
public class CreateTheCertificateDictionaryResponse {

    protected String 证书字典OID;

    /**
     * 获取证书字典OID属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String get证书字典OID() {
        return 证书字典OID;
    }

    /**
     * 设置证书字典OID属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void set证书字典OID(String value) {
        this.证书字典OID = value;
    }

}
