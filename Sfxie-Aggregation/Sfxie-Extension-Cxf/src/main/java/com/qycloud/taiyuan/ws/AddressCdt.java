
package com.qycloud.taiyuan.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>addressCdt complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="addressCdt">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="srcId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="destId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="addrId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="addrName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="addrCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="addrTypes" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="addrNames" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="projectStatus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="notContainsOids" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="notContainsNames" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="addrIds" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="addrFullName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="addrFullNames" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="notContainsFullNames" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fatherId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="orgIds" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="通风系统" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="appId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="levelFlag" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="size" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="moveFlag" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="detailFlag" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "addressCdt", propOrder = {
    "srcId",
    "destId",
    "addrId",
    "addrName",
    "addrCode",
    "addrTypes",
    "addrNames",
    "projectStatus",
    "notContainsOids",
    "notContainsNames",
    "addrIds",
    "addrFullName",
    "addrFullNames",
    "notContainsFullNames",
    "fatherId",
    "orgIds",
    "\u901a\u98ce\u7cfb\u7edf",
    "appId"
})
public class AddressCdt {

    protected String srcId;
    protected String destId;
    protected String addrId;
    protected String addrName;
    protected String addrCode;
    protected String addrTypes;
    protected String addrNames;
    protected String projectStatus;
    protected String notContainsOids;
    protected String notContainsNames;
    protected String addrIds;
    protected String addrFullName;
    protected String addrFullNames;
    protected String notContainsFullNames;
    protected String fatherId;
    protected String orgIds;
    protected String 通风系统;
    protected String appId;
    @XmlAttribute(name = "levelFlag", required = true)
    protected int levelFlag;
    @XmlAttribute(name = "size", required = true)
    protected int size;
    @XmlAttribute(name = "moveFlag", required = true)
    protected int moveFlag;
    @XmlAttribute(name = "detailFlag", required = true)
    protected int detailFlag;

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
     * 获取addrId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddrId() {
        return addrId;
    }

    /**
     * 设置addrId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddrId(String value) {
        this.addrId = value;
    }

    /**
     * 获取addrName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddrName() {
        return addrName;
    }

    /**
     * 设置addrName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddrName(String value) {
        this.addrName = value;
    }

    /**
     * 获取addrCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddrCode() {
        return addrCode;
    }

    /**
     * 设置addrCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddrCode(String value) {
        this.addrCode = value;
    }

    /**
     * 获取addrTypes属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddrTypes() {
        return addrTypes;
    }

    /**
     * 设置addrTypes属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddrTypes(String value) {
        this.addrTypes = value;
    }

    /**
     * 获取addrNames属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddrNames() {
        return addrNames;
    }

    /**
     * 设置addrNames属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddrNames(String value) {
        this.addrNames = value;
    }

    /**
     * 获取projectStatus属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProjectStatus() {
        return projectStatus;
    }

    /**
     * 设置projectStatus属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProjectStatus(String value) {
        this.projectStatus = value;
    }

    /**
     * 获取notContainsOids属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNotContainsOids() {
        return notContainsOids;
    }

    /**
     * 设置notContainsOids属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNotContainsOids(String value) {
        this.notContainsOids = value;
    }

    /**
     * 获取notContainsNames属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNotContainsNames() {
        return notContainsNames;
    }

    /**
     * 设置notContainsNames属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNotContainsNames(String value) {
        this.notContainsNames = value;
    }

    /**
     * 获取addrIds属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddrIds() {
        return addrIds;
    }

    /**
     * 设置addrIds属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddrIds(String value) {
        this.addrIds = value;
    }

    /**
     * 获取addrFullName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddrFullName() {
        return addrFullName;
    }

    /**
     * 设置addrFullName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddrFullName(String value) {
        this.addrFullName = value;
    }

    /**
     * 获取addrFullNames属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddrFullNames() {
        return addrFullNames;
    }

    /**
     * 设置addrFullNames属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddrFullNames(String value) {
        this.addrFullNames = value;
    }

    /**
     * 获取notContainsFullNames属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNotContainsFullNames() {
        return notContainsFullNames;
    }

    /**
     * 设置notContainsFullNames属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNotContainsFullNames(String value) {
        this.notContainsFullNames = value;
    }

    /**
     * 获取fatherId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFatherId() {
        return fatherId;
    }

    /**
     * 设置fatherId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFatherId(String value) {
        this.fatherId = value;
    }

    /**
     * 获取orgIds属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrgIds() {
        return orgIds;
    }

    /**
     * 设置orgIds属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrgIds(String value) {
        this.orgIds = value;
    }

    /**
     * 获取通风系统属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String get通风系统() {
        return 通风系统;
    }

    /**
     * 设置通风系统属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void set通风系统(String value) {
        this.通风系统 = value;
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
     * 获取size属性的值。
     * 
     */
    public int getSize() {
        return size;
    }

    /**
     * 设置size属性的值。
     * 
     */
    public void setSize(int value) {
        this.size = value;
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

    /**
     * 获取detailFlag属性的值。
     * 
     */
    public int getDetailFlag() {
        return detailFlag;
    }

    /**
     * 设置detailFlag属性的值。
     * 
     */
    public void setDetailFlag(int value) {
        this.detailFlag = value;
    }

}
