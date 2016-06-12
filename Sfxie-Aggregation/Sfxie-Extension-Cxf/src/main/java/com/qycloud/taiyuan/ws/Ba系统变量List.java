
package com.qycloud.taiyuan.ws;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>ba系统变量List complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="ba系统变量List">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ba系统变量" type="{http://oup.rockontrol.com}ba系统变量" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ba\u7cfb\u7edf\u53d8\u91cfList", propOrder = {
    "ba\u7cfb\u7edf\u53d8\u91cf"
})
public class Ba系统变量List {

    protected List<Ba系统变量> ba系统变量;

    /**
     * Gets the value of the ba系统变量 property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ba系统变量 property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBa系统变量().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Ba系统变量 }
     * 
     * 
     */
    public List<Ba系统变量> getBa系统变量() {
        if (ba系统变量 == null) {
            ba系统变量 = new ArrayList<Ba系统变量>();
        }
        return this.ba系统变量;
    }

}
