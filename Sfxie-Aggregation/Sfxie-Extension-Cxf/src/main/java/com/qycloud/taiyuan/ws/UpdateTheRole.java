
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
 *         &lt;element name="rl" type="{http://oup.rockontrol.com}role" minOccurs="0"/>
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
    "rl"
})
@XmlRootElement(name = "updateTheRole")
public class UpdateTheRole {

    protected Role rl;

    /**
     * 获取rl属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Role }
     *     
     */
    public Role getRl() {
        return rl;
    }

    /**
     * 设置rl属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Role }
     *     
     */
    public void setRl(Role value) {
        this.rl = value;
    }

}
