
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
 *         &lt;element name="fn" type="{http://oup.rockontrol.com}func" minOccurs="0"/>
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
    "fn"
})
@XmlRootElement(name = "updateTheFunc")
public class UpdateTheFunc {

    protected Func fn;

    /**
     * 获取fn属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Func }
     *     
     */
    public Func getFn() {
        return fn;
    }

    /**
     * 设置fn属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Func }
     *     
     */
    public void setFn(Func value) {
        this.fn = value;
    }

}
