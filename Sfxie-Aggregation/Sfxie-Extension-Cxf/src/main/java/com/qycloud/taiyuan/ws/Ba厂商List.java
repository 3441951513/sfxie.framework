
package com.qycloud.taiyuan.ws;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>ba厂商List complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="ba厂商List">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ba厂商" type="{http://oup.rockontrol.com}ba厂商" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ba\u5382\u5546List", propOrder = {
    "ba\u5382\u5546"
})
public class Ba厂商List {

    protected List<Ba厂商> ba厂商;

    /**
     * Gets the value of the ba厂商 property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ba厂商 property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBa厂商().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Ba厂商 }
     * 
     * 
     */
    public List<Ba厂商> getBa厂商() {
        if (ba厂商 == null) {
            ba厂商 = new ArrayList<Ba厂商>();
        }
        return this.ba厂商;
    }

}
