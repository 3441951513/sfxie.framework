
package com.qycloud.taiyuan.ws;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>ba证书字典List complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="ba证书字典List">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ba证书字典" type="{http://oup.rockontrol.com}ba证书字典" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ba\u8bc1\u4e66\u5b57\u5178List", propOrder = {
    "ba\u8bc1\u4e66\u5b57\u5178"
})
public class Ba证书字典List {

    protected List<Ba证书字典> ba证书字典;

    /**
     * Gets the value of the ba证书字典 property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ba证书字典 property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBa证书字典().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Ba证书字典 }
     * 
     * 
     */
    public List<Ba证书字典> getBa证书字典() {
        if (ba证书字典 == null) {
            ba证书字典 = new ArrayList<Ba证书字典>();
        }
        return this.ba证书字典;
    }

}
