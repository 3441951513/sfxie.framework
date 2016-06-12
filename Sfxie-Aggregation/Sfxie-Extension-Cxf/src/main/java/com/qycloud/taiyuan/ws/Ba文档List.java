
package com.qycloud.taiyuan.ws;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>ba文档List complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="ba文档List">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ba文档" type="{http://oup.rockontrol.com}ba文档" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ba\u6587\u6863List", propOrder = {
    "ba\u6587\u6863"
})
public class Ba文档List {

    protected List<Ba文档> ba文档;

    /**
     * Gets the value of the ba文档 property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ba文档 property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBa文档().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Ba文档 }
     * 
     * 
     */
    public List<Ba文档> getBa文档() {
        if (ba文档 == null) {
            ba文档 = new ArrayList<Ba文档>();
        }
        return this.ba文档;
    }

}
