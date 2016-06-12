
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
 *         &lt;element name="fid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "fid",
    "fn"
})
@XmlRootElement(name = "createTheFunc")
public class CreateTheFunc {

    protected String fid;
    protected Func fn;

    /**
     * 获取fid属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFid() {
        return fid;
    }

    /**
     * 设置fid属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFid(String value) {
        this.fid = value;
    }

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
