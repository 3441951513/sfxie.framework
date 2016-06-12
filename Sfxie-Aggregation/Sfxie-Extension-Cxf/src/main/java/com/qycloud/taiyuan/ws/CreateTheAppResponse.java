
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
 *         &lt;element name="string应用系统ID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "string\u5e94\u7528\u7cfb\u7edfID"
})
@XmlRootElement(name = "createTheAppResponse")
public class CreateTheAppResponse {

    protected String string应用系统ID;

    /**
     * 获取string应用系统ID属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getString应用系统ID() {
        return string应用系统ID;
    }

    /**
     * 设置string应用系统ID属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setString应用系统ID(String value) {
        this.string应用系统ID = value;
    }

}
