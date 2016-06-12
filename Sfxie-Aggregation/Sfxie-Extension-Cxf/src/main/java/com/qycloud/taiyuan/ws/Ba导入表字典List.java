
package com.qycloud.taiyuan.ws;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>ba导入表字典List complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="ba导入表字典List">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ba导入表字典" type="{http://oup.rockontrol.com}ba导入表字典" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ba\u5bfc\u5165\u8868\u5b57\u5178List", propOrder = {
    "ba\u5bfc\u5165\u8868\u5b57\u5178"
})
public class Ba导入表字典List {

    protected List<Ba导入表字典> ba导入表字典;

    /**
     * Gets the value of the ba导入表字典 property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ba导入表字典 property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBa导入表字典().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Ba导入表字典 }
     * 
     * 
     */
    public List<Ba导入表字典> getBa导入表字典() {
        if (ba导入表字典 == null) {
            ba导入表字典 = new ArrayList<Ba导入表字典>();
        }
        return this.ba导入表字典;
    }

}
