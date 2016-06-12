
package com.qycloud.taiyuan.ws;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>ba地点位置List complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="ba地点位置List">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ba地点位置" type="{http://oup.rockontrol.com}ba地点位置" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ba\u5730\u70b9\u4f4d\u7f6eList", propOrder = {
    "ba\u5730\u70b9\u4f4d\u7f6e"
})
public class Ba地点位置List {

    protected List<Ba地点位置> ba地点位置;

    /**
     * Gets the value of the ba地点位置 property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ba地点位置 property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBa地点位置().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Ba地点位置 }
     * 
     * 
     */
    public List<Ba地点位置> getBa地点位置() {
        if (ba地点位置 == null) {
            ba地点位置 = new ArrayList<Ba地点位置>();
        }
        return this.ba地点位置;
    }

}
