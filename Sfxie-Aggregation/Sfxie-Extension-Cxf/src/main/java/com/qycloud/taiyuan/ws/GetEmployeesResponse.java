
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
 *         &lt;element name="员工对象数组" type="{http://oup.rockontrol.com}employeeList" minOccurs="0"/>
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
    "\u5458\u5de5\u5bf9\u8c61\u6570\u7ec4"
})
@XmlRootElement(name = "getEmployeesResponse")
public class GetEmployeesResponse {

    protected EmployeeList 员工对象数组;

    /**
     * 获取员工对象数组属性的值。
     * 
     * @return
     *     possible object is
     *     {@link EmployeeList }
     *     
     */
    public EmployeeList get员工对象数组() {
        return 员工对象数组;
    }

    /**
     * 设置员工对象数组属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link EmployeeList }
     *     
     */
    public void set员工对象数组(EmployeeList value) {
        this.员工对象数组 = value;
    }

}
