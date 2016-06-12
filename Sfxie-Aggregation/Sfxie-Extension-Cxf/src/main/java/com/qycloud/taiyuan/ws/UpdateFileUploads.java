
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
 *         &lt;element name="baList" type="{http://oup.rockontrol.com}ba文档List" minOccurs="0"/>
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
    "baList"
})
@XmlRootElement(name = "updateFileUploads")
public class UpdateFileUploads {

    protected Ba文档List baList;

    /**
     * 获取baList属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Ba文档List }
     *     
     */
    public Ba文档List getBaList() {
        return baList;
    }

    /**
     * 设置baList属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Ba文档List }
     *     
     */
    public void setBaList(Ba文档List value) {
        this.baList = value;
    }

}
