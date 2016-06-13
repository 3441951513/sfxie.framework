
package com.qycloud.taiyuan.ws;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>dbServiceCdtList complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="dbServiceCdtList">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="dbServiceCdt" type="{http://oup.rockontrol.com}dbServiceCdt" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dbServiceCdtList", propOrder = {
    "dbServiceCdt"
})
public class DbServiceCdtList {

    protected List<DbServiceCdt> dbServiceCdt;

    /**
     * Gets the value of the dbServiceCdt property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dbServiceCdt property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDbServiceCdt().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DbServiceCdt }
     * 
     * 
     */
    public List<DbServiceCdt> getDbServiceCdt() {
        if (dbServiceCdt == null) {
            dbServiceCdt = new ArrayList<DbServiceCdt>();
        }
        return this.dbServiceCdt;
    }

}