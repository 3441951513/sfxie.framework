
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
 *         &lt;element name="ba导入表字典" type="{http://oup.rockontrol.com}ba导入表字典" minOccurs="0"/>
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
    "ba\u5bfc\u5165\u8868\u5b57\u5178"
})
@XmlRootElement(name = "getTheImportDicResponse")
public class GetTheImportDicResponse {

    protected Ba导入表字典 ba导入表字典;

    /**
     * 获取ba导入表字典属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Ba导入表字典 }
     *     
     */
    public Ba导入表字典 getBa导入表字典() {
        return ba导入表字典;
    }

    /**
     * 设置ba导入表字典属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Ba导入表字典 }
     *     
     */
    public void setBa导入表字典(Ba导入表字典 value) {
        this.ba导入表字典 = value;
    }

}
