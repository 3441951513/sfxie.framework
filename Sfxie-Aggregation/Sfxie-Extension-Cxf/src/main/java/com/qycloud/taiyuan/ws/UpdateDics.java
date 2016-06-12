
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
 *         &lt;element name="dics" type="{http://oup.rockontrol.com}dicList" minOccurs="0"/>
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
    "dics"
})
@XmlRootElement(name = "updateDics")
public class UpdateDics {

    protected DicList dics;

    /**
     * 获取dics属性的值。
     * 
     * @return
     *     possible object is
     *     {@link DicList }
     *     
     */
    public DicList getDics() {
        return dics;
    }

    /**
     * 设置dics属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link DicList }
     *     
     */
    public void setDics(DicList value) {
        this.dics = value;
    }

}
