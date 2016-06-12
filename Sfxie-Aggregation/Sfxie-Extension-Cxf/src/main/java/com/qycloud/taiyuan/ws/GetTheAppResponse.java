
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
 *         &lt;element name="应用系统对象" type="{http://oup.rockontrol.com}app" minOccurs="0"/>
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
    "\u5e94\u7528\u7cfb\u7edf\u5bf9\u8c61"
})
@XmlRootElement(name = "getTheAppResponse")
public class GetTheAppResponse {

    protected App 应用系统对象;

    /**
     * 获取应用系统对象属性的值。
     * 
     * @return
     *     possible object is
     *     {@link App }
     *     
     */
    public App get应用系统对象() {
        return 应用系统对象;
    }

    /**
     * 设置应用系统对象属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link App }
     *     
     */
    public void set应用系统对象(App value) {
        this.应用系统对象 = value;
    }

}
