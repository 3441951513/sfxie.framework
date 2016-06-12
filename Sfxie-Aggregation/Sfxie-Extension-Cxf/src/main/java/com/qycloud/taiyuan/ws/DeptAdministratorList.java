
package com.qycloud.taiyuan.ws;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>deptAdministratorList complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="deptAdministratorList">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="deptAdministrator" type="{http://oup.rockontrol.com}deptAdministrator" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "deptAdministratorList", propOrder = {
    "deptAdministrator"
})
public class DeptAdministratorList {

    protected List<DeptAdministrator> deptAdministrator;

    /**
     * Gets the value of the deptAdministrator property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the deptAdministrator property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDeptAdministrator().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DeptAdministrator }
     * 
     * 
     */
    public List<DeptAdministrator> getDeptAdministrator() {
        if (deptAdministrator == null) {
            deptAdministrator = new ArrayList<DeptAdministrator>();
        }
        return this.deptAdministrator;
    }

}
