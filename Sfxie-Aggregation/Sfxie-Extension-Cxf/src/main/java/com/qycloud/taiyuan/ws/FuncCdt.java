
package com.qycloud.taiyuan.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * 功能选项类
 * 
 * <p>funcCdt complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="funcCdt">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="funcName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="funcTypes" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="funcIds" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="appId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="funcId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="srcId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="destId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sysresPid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="levelFlag" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="moveFlag" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "funcCdt", propOrder = {
    "funcName",
    "funcTypes",
    "funcIds",
    "appId",
    "funcId",
    "srcId",
    "destId",
    "sysresPid"
})
public class FuncCdt {

    protected String funcName;
    protected String funcTypes;
    protected String funcIds;
    protected String appId;
    protected String funcId;
    protected String srcId;
    protected String destId;
    protected String sysresPid;
    @XmlAttribute(name = "levelFlag", required = true)
    protected int levelFlag;
    @XmlAttribute(name = "moveFlag", required = true)
    protected int moveFlag;

    /**
     * 获取funcName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFuncName() {
        return funcName;
    }

    /**
     * 设置funcName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFuncName(String value) {
        this.funcName = value;
    }

    /**
     * 获取funcTypes属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFuncTypes() {
        return funcTypes;
    }

    /**
     * 设置funcTypes属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFuncTypes(String value) {
        this.funcTypes = value;
    }

    /**
     * 获取funcIds属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFuncIds() {
        return funcIds;
    }

    /**
     * 设置funcIds属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFuncIds(String value) {
        this.funcIds = value;
    }

    /**
     * 获取appId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAppId() {
        return appId;
    }

    /**
     * 设置appId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAppId(String value) {
        this.appId = value;
    }

    /**
     * 获取funcId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFuncId() {
        return funcId;
    }

    /**
     * 设置funcId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFuncId(String value) {
        this.funcId = value;
    }

    /**
     * 获取srcId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSrcId() {
        return srcId;
    }

    /**
     * 设置srcId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSrcId(String value) {
        this.srcId = value;
    }

    /**
     * 获取destId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDestId() {
        return destId;
    }

    /**
     * 设置destId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDestId(String value) {
        this.destId = value;
    }

    /**
     * 获取sysresPid属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSysresPid() {
        return sysresPid;
    }

    /**
     * 设置sysresPid属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSysresPid(String value) {
        this.sysresPid = value;
    }

    /**
     * 获取levelFlag属性的值。
     * 
     */
    public int getLevelFlag() {
        return levelFlag;
    }

    /**
     * 设置levelFlag属性的值。
     * 
     */
    public void setLevelFlag(int value) {
        this.levelFlag = value;
    }

    /**
     * 获取moveFlag属性的值。
     * 
     */
    public int getMoveFlag() {
        return moveFlag;
    }

    /**
     * 设置moveFlag属性的值。
     * 
     */
    public void setMoveFlag(int value) {
        this.moveFlag = value;
    }

}
