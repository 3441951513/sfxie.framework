
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
 *         &lt;element name="员工对象" type="{http://oup.rockontrol.com}employee" minOccurs="0"/>
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
    "\u5458\u5de5\u5bf9\u8c61"
})
@XmlRootElement(name = "getTheEmployeeResponse")
public class GetTheEmployeeResponse {

    protected Employee 员工对象;

    /**
     * 获取员工对象属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Employee }
     *     
     */
    public Employee get员工对象() {
        return 员工对象;
    }

    /**
     * 设置员工对象属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Employee }
     *     
     */
    public void set员工对象(Employee value) {
        this.员工对象 = value;
    }

}
