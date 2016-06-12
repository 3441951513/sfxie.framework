
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
 *         &lt;element name="ba" type="{http://oup.rockontrol.com}ba文档" minOccurs="0"/>
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
    "ba"
})
@XmlRootElement(name = "updateTheFileUpload")
public class UpdateTheFileUpload {

    protected Ba文档 ba;

    /**
     * 获取ba属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Ba文档 }
     *     
     */
    public Ba文档 getBa() {
        return ba;
    }

    /**
     * 设置ba属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Ba文档 }
     *     
     */
    public void setBa(Ba文档 value) {
        this.ba = value;
    }

}
