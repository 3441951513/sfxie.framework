
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
 *         &lt;element name="informs" type="{http://oup.rockontrol.com}ba通知List" minOccurs="0"/>
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
    "informs"
})
@XmlRootElement(name = "createInforms")
public class CreateInforms {

    protected Ba通知List informs;

    /**
     * 获取informs属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Ba通知List }
     *     
     */
    public Ba通知List getInforms() {
        return informs;
    }

    /**
     * 设置informs属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Ba通知List }
     *     
     */
    public void setInforms(Ba通知List value) {
        this.informs = value;
    }

}
