
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
 *         &lt;element name="obj" type="{http://oup.rockontrol.com}ba系统变量" minOccurs="0"/>
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
    "obj"
})
@XmlRootElement(name = "updateTheSystemVariable")
public class UpdateTheSystemVariable {

    protected Ba系统变量 obj;

    /**
     * 获取obj属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Ba系统变量 }
     *     
     */
    public Ba系统变量 getObj() {
        return obj;
    }

    /**
     * 设置obj属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Ba系统变量 }
     *     
     */
    public void setObj(Ba系统变量 value) {
        this.obj = value;
    }

}
