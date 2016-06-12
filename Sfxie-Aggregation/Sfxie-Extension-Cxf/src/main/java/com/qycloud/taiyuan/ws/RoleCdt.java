
package com.qycloud.taiyuan.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * 功能选项类
 * 
 * <p>roleCdt complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="roleCdt">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="roleAppId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="funcId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="userId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="appId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="roleTypes" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="funcTypes" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="appName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="roleId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="roleName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sysresId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sysresName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sysresPath" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sysresPid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="roleIds" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="notContainRoleTypes" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="roleLocals" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="notContainRoleLocals" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="notContainAppIds" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="funcIds" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="appShortName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="appNames" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="funcFlag" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="funcLevelFlag" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="containOwnFlag" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "roleCdt", propOrder = {
    "roleAppId",
    "funcId",
    "userId",
    "appId",
    "roleTypes",
    "funcTypes",
    "appName",
    "roleId",
    "roleName",
    "sysresId",
    "sysresName",
    "sysresPath",
    "sysresPid",
    "roleIds",
    "notContainRoleTypes",
    "roleLocals",
    "notContainRoleLocals",
    "notContainAppIds",
    "funcIds",
    "appShortName",
    "appNames"
})
public class RoleCdt {

    protected String roleAppId;
    protected String funcId;
    protected String userId;
    protected String appId;
    protected String roleTypes;
    protected String funcTypes;
    protected String appName;
    protected String roleId;
    protected String roleName;
    protected String sysresId;
    protected String sysresName;
    protected String sysresPath;
    protected String sysresPid;
    protected String roleIds;
    protected String notContainRoleTypes;
    protected String roleLocals;
    protected String notContainRoleLocals;
    protected String notContainAppIds;
    protected String funcIds;
    protected String appShortName;
    protected String appNames;
    @XmlAttribute(name = "funcFlag", required = true)
    protected int funcFlag;
    @XmlAttribute(name = "funcLevelFlag", required = true)
    protected int funcLevelFlag;
    @XmlAttribute(name = "containOwnFlag")
    protected Integer containOwnFlag;

    /**
     * 获取roleAppId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRoleAppId() {
        return roleAppId;
    }

    /**
     * 设置roleAppId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRoleAppId(String value) {
        this.roleAppId = value;
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
     * 获取userId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 设置userId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserId(String value) {
        this.userId = value;
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
     * 获取roleTypes属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRoleTypes() {
        return roleTypes;
    }

    /**
     * 设置roleTypes属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRoleTypes(String value) {
        this.roleTypes = value;
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
     * 获取appName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAppName() {
        return appName;
    }

    /**
     * 设置appName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAppName(String value) {
        this.appName = value;
    }

    /**
     * 获取roleId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRoleId() {
        return roleId;
    }

    /**
     * 设置roleId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRoleId(String value) {
        this.roleId = value;
    }

    /**
     * 获取roleName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * 设置roleName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRoleName(String value) {
        this.roleName = value;
    }

    /**
     * 获取sysresId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSysresId() {
        return sysresId;
    }

    /**
     * 设置sysresId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSysresId(String value) {
        this.sysresId = value;
    }

    /**
     * 获取sysresName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSysresName() {
        return sysresName;
    }

    /**
     * 设置sysresName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSysresName(String value) {
        this.sysresName = value;
    }

    /**
     * 获取sysresPath属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSysresPath() {
        return sysresPath;
    }

    /**
     * 设置sysresPath属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSysresPath(String value) {
        this.sysresPath = value;
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
     * 获取roleIds属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRoleIds() {
        return roleIds;
    }

    /**
     * 设置roleIds属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRoleIds(String value) {
        this.roleIds = value;
    }

    /**
     * 获取notContainRoleTypes属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNotContainRoleTypes() {
        return notContainRoleTypes;
    }

    /**
     * 设置notContainRoleTypes属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNotContainRoleTypes(String value) {
        this.notContainRoleTypes = value;
    }

    /**
     * 获取roleLocals属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRoleLocals() {
        return roleLocals;
    }

    /**
     * 设置roleLocals属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRoleLocals(String value) {
        this.roleLocals = value;
    }

    /**
     * 获取notContainRoleLocals属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNotContainRoleLocals() {
        return notContainRoleLocals;
    }

    /**
     * 设置notContainRoleLocals属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNotContainRoleLocals(String value) {
        this.notContainRoleLocals = value;
    }

    /**
     * 获取notContainAppIds属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNotContainAppIds() {
        return notContainAppIds;
    }

    /**
     * 设置notContainAppIds属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNotContainAppIds(String value) {
        this.notContainAppIds = value;
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
     * 获取appShortName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAppShortName() {
        return appShortName;
    }

    /**
     * 设置appShortName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAppShortName(String value) {
        this.appShortName = value;
    }

    /**
     * 获取appNames属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAppNames() {
        return appNames;
    }

    /**
     * 设置appNames属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAppNames(String value) {
        this.appNames = value;
    }

    /**
     * 获取funcFlag属性的值。
     * 
     */
    public int getFuncFlag() {
        return funcFlag;
    }

    /**
     * 设置funcFlag属性的值。
     * 
     */
    public void setFuncFlag(int value) {
        this.funcFlag = value;
    }

    /**
     * 获取funcLevelFlag属性的值。
     * 
     */
    public int getFuncLevelFlag() {
        return funcLevelFlag;
    }

    /**
     * 设置funcLevelFlag属性的值。
     * 
     */
    public void setFuncLevelFlag(int value) {
        this.funcLevelFlag = value;
    }

    /**
     * 获取containOwnFlag属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getContainOwnFlag() {
        return containOwnFlag;
    }

    /**
     * 设置containOwnFlag属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setContainOwnFlag(Integer value) {
        this.containOwnFlag = value;
    }

}
