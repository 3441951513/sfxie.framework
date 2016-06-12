
package com.qycloud.taiyuan.ws;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>ba过滤数据List complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="ba过滤数据List">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ba过滤数据" type="{http://oup.rockontrol.com}ba过滤数据" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ba\u8fc7\u6ee4\u6570\u636eList", propOrder = {
    "ba\u8fc7\u6ee4\u6570\u636e"
})
public class Ba过滤数据List {

    protected List<Ba过滤数据> ba过滤数据;

    /**
     * Gets the value of the ba过滤数据 property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ba过滤数据 property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBa过滤数据().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Ba过滤数据 }
     * 
     * 
     */
    public List<Ba过滤数据> getBa过滤数据() {
        if (ba过滤数据 == null) {
            ba过滤数据 = new ArrayList<Ba过滤数据>();
        }
        return this.ba过滤数据;
    }

}
