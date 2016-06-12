
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
 *         &lt;element name="emps" type="{http://oup.rockontrol.com}employeeList" minOccurs="0"/>
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
    "emps"
})
@XmlRootElement(name = "updateEmployees")
public class UpdateEmployees {

    protected EmployeeList emps;

    /**
     * 获取emps属性的值。
     * 
     * @return
     *     possible object is
     *     {@link EmployeeList }
     *     
     */
    public EmployeeList getEmps() {
        return emps;
    }

    /**
     * 设置emps属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link EmployeeList }
     *     
     */
    public void setEmps(EmployeeList value) {
        this.emps = value;
    }

}
