
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
 *         &lt;element name="objs" type="{http://oup.rockontrol.com}ba系统变量List" minOccurs="0"/>
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
    "objs"
})
@XmlRootElement(name = "updateSystemVariables")
public class UpdateSystemVariables {

    protected Ba系统变量List objs;

    /**
     * 获取objs属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Ba系统变量List }
     *     
     */
    public Ba系统变量List getObjs() {
        return objs;
    }

    /**
     * 设置objs属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Ba系统变量List }
     *     
     */
    public void setObjs(Ba系统变量List value) {
        this.objs = value;
    }

}
