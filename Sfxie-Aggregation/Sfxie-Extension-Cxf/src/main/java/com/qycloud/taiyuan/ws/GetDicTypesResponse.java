
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
 *         &lt;element name="数据字典类型集合" type="{http://oup.rockontrol.com}dicTypeList" minOccurs="0"/>
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
    "\u6570\u636e\u5b57\u5178\u7c7b\u578b\u96c6\u5408"
})
@XmlRootElement(name = "getDicTypesResponse")
public class GetDicTypesResponse {

    protected DicTypeList 数据字典类型集合;

    /**
     * 获取数据字典类型集合属性的值。
     * 
     * @return
     *     possible object is
     *     {@link DicTypeList }
     *     
     */
    public DicTypeList get数据字典类型集合() {
        return 数据字典类型集合;
    }

    /**
     * 设置数据字典类型集合属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link DicTypeList }
     *     
     */
    public void set数据字典类型集合(DicTypeList value) {
        this.数据字典类型集合 = value;
    }

}
