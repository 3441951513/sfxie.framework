
package com.qycloud.taiyuan.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * BaRoleAuthority entity.
 * 
 * <p>baRoleAuthority complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="baRoleAuthority">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="oid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="roleId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="funcId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="role" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="oid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="sysresId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="sysId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="note" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="baSys" type="{http://oup.rockontrol.com}baSys" minOccurs="0"/>
 *                   &lt;element name="res" type="{http://oup.rockontrol.com}baSysRes" minOccurs="0"/>
 *                   &lt;element name="pathParams" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="local" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="funcHierarchy" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="dealWay" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="oid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="sysId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="fatherId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="icon" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="code" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="sysresId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="status" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="goalArea" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="goalId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="programName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="outputType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="promptMessage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="sysRes" type="{http://oup.rockontrol.com}baSysRes" minOccurs="0"/>
 *                   &lt;element name="pathParams" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="releateSysresId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="releateSysresPathParams" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="hasChild" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                 &lt;/sequence>
 *                 &lt;attribute name="submenu" type="{http://www.w3.org/2001/XMLSchema}int" />
 *                 &lt;attribute name="beginGroup" type="{http://www.w3.org/2001/XMLSchema}int" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "baRoleAuthority", propOrder = {
    "oid",
    "roleId",
    "funcId",
    "role",
    "funcHierarchy"
})
public class BaRoleAuthority {

    protected String oid;
    protected String roleId;
    protected String funcId;
    protected BaRoleAuthority.Role role;
    protected BaRoleAuthority.FuncHierarchy funcHierarchy;

    /**
     * 获取oid属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOid() {
        return oid;
    }

    /**
     * 设置oid属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOid(String value) {
        this.oid = value;
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
     * 获取role属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BaRoleAuthority.Role }
     *     
     */
    public BaRoleAuthority.Role getRole() {
        return role;
    }

    /**
     * 设置role属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BaRoleAuthority.Role }
     *     
     */
    public void setRole(BaRoleAuthority.Role value) {
        this.role = value;
    }

    /**
     * 获取funcHierarchy属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BaRoleAuthority.FuncHierarchy }
     *     
     */
    public BaRoleAuthority.FuncHierarchy getFuncHierarchy() {
        return funcHierarchy;
    }

    /**
     * 设置funcHierarchy属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BaRoleAuthority.FuncHierarchy }
     *     
     */
    public void setFuncHierarchy(BaRoleAuthority.FuncHierarchy value) {
        this.funcHierarchy = value;
    }


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
     *         &lt;element name="dealWay" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="oid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="sysId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="fatherId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="icon" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="code" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="sysresId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="status" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="goalArea" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="goalId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="programName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="outputType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="promptMessage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="sysRes" type="{http://oup.rockontrol.com}baSysRes" minOccurs="0"/>
     *         &lt;element name="pathParams" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="releateSysresId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="releateSysresPathParams" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="hasChild" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *       &lt;/sequence>
     *       &lt;attribute name="submenu" type="{http://www.w3.org/2001/XMLSchema}int" />
     *       &lt;attribute name="beginGroup" type="{http://www.w3.org/2001/XMLSchema}int" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "dealWay",
        "oid",
        "sysId",
        "fatherId",
        "name",
        "type",
        "icon",
        "code",
        "sysresId",
        "status",
        "goalArea",
        "goalId",
        "programName",
        "outputType",
        "promptMessage",
        "sysRes",
        "pathParams",
        "releateSysresId",
        "releateSysresPathParams",
        "hasChild"
    })
    public static class FuncHierarchy {

        protected String dealWay;
        protected String oid;
        protected String sysId;
        protected String fatherId;
        protected String name;
        protected String type;
        protected String icon;
        protected String code;
        protected String sysresId;
        protected String status;
        protected String goalArea;
        protected String goalId;
        protected String programName;
        protected String outputType;
        protected String promptMessage;
        protected BaSysRes sysRes;
        protected String pathParams;
        protected String releateSysresId;
        protected String releateSysresPathParams;
        protected String hasChild;
        @XmlAttribute(name = "submenu")
        protected Integer submenu;
        @XmlAttribute(name = "beginGroup")
        protected Integer beginGroup;

        /**
         * 获取dealWay属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDealWay() {
            return dealWay;
        }

        /**
         * 设置dealWay属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDealWay(String value) {
            this.dealWay = value;
        }

        /**
         * 获取oid属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getOid() {
            return oid;
        }

        /**
         * 设置oid属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setOid(String value) {
            this.oid = value;
        }

        /**
         * 获取sysId属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getSysId() {
            return sysId;
        }

        /**
         * 设置sysId属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setSysId(String value) {
            this.sysId = value;
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
         * 获取name属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getName() {
            return name;
        }

        /**
         * 设置name属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setName(String value) {
            this.name = value;
        }

        /**
         * 获取type属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getType() {
            return type;
        }

        /**
         * 设置type属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setType(String value) {
            this.type = value;
        }

        /**
         * 获取icon属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getIcon() {
            return icon;
        }

        /**
         * 设置icon属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setIcon(String value) {
            this.icon = value;
        }

        /**
         * 获取code属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCode() {
            return code;
        }

        /**
         * 设置code属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCode(String value) {
            this.code = value;
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
         * 获取status属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getStatus() {
            return status;
        }

        /**
         * 设置status属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setStatus(String value) {
            this.status = value;
        }

        /**
         * 获取goalArea属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getGoalArea() {
            return goalArea;
        }

        /**
         * 设置goalArea属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setGoalArea(String value) {
            this.goalArea = value;
        }

        /**
         * 获取goalId属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getGoalId() {
            return goalId;
        }

        /**
         * 设置goalId属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setGoalId(String value) {
            this.goalId = value;
        }

        /**
         * 获取programName属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getProgramName() {
            return programName;
        }

        /**
         * 设置programName属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setProgramName(String value) {
            this.programName = value;
        }

        /**
         * 获取outputType属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getOutputType() {
            return outputType;
        }

        /**
         * 设置outputType属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setOutputType(String value) {
            this.outputType = value;
        }

        /**
         * 获取promptMessage属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPromptMessage() {
            return promptMessage;
        }

        /**
         * 设置promptMessage属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPromptMessage(String value) {
            this.promptMessage = value;
        }

        /**
         * 获取sysRes属性的值。
         * 
         * @return
         *     possible object is
         *     {@link BaSysRes }
         *     
         */
        public BaSysRes getSysRes() {
            return sysRes;
        }

        /**
         * 设置sysRes属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link BaSysRes }
         *     
         */
        public void setSysRes(BaSysRes value) {
            this.sysRes = value;
        }

        /**
         * 获取pathParams属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPathParams() {
            return pathParams;
        }

        /**
         * 设置pathParams属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPathParams(String value) {
            this.pathParams = value;
        }

        /**
         * 获取releateSysresId属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getReleateSysresId() {
            return releateSysresId;
        }

        /**
         * 设置releateSysresId属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setReleateSysresId(String value) {
            this.releateSysresId = value;
        }

        /**
         * 获取releateSysresPathParams属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getReleateSysresPathParams() {
            return releateSysresPathParams;
        }

        /**
         * 设置releateSysresPathParams属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setReleateSysresPathParams(String value) {
            this.releateSysresPathParams = value;
        }

        /**
         * 获取hasChild属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getHasChild() {
            return hasChild;
        }

        /**
         * 设置hasChild属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setHasChild(String value) {
            this.hasChild = value;
        }

        /**
         * 获取submenu属性的值。
         * 
         * @return
         *     possible object is
         *     {@link Integer }
         *     
         */
        public Integer getSubmenu() {
            return submenu;
        }

        /**
         * 设置submenu属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link Integer }
         *     
         */
        public void setSubmenu(Integer value) {
            this.submenu = value;
        }

        /**
         * 获取beginGroup属性的值。
         * 
         * @return
         *     possible object is
         *     {@link Integer }
         *     
         */
        public Integer getBeginGroup() {
            return beginGroup;
        }

        /**
         * 设置beginGroup属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link Integer }
         *     
         */
        public void setBeginGroup(Integer value) {
            this.beginGroup = value;
        }

    }


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
     *         &lt;element name="oid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="sysresId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="sysId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="note" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="baSys" type="{http://oup.rockontrol.com}baSys" minOccurs="0"/>
     *         &lt;element name="res" type="{http://oup.rockontrol.com}baSysRes" minOccurs="0"/>
     *         &lt;element name="pathParams" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="local" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
        "oid",
        "sysresId",
        "sysId",
        "type",
        "name",
        "note",
        "baSys",
        "res",
        "pathParams",
        "local"
    })
    public static class Role {

        protected String oid;
        protected String sysresId;
        protected String sysId;
        protected String type;
        protected String name;
        protected String note;
        protected BaSys baSys;
        protected BaSysRes res;
        protected String pathParams;
        protected String local;

        /**
         * 获取oid属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getOid() {
            return oid;
        }

        /**
         * 设置oid属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setOid(String value) {
            this.oid = value;
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
         * 获取sysId属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getSysId() {
            return sysId;
        }

        /**
         * 设置sysId属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setSysId(String value) {
            this.sysId = value;
        }

        /**
         * 获取type属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getType() {
            return type;
        }

        /**
         * 设置type属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setType(String value) {
            this.type = value;
        }

        /**
         * 获取name属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getName() {
            return name;
        }

        /**
         * 设置name属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setName(String value) {
            this.name = value;
        }

        /**
         * 获取note属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getNote() {
            return note;
        }

        /**
         * 设置note属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setNote(String value) {
            this.note = value;
        }

        /**
         * 获取baSys属性的值。
         * 
         * @return
         *     possible object is
         *     {@link BaSys }
         *     
         */
        public BaSys getBaSys() {
            return baSys;
        }

        /**
         * 设置baSys属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link BaSys }
         *     
         */
        public void setBaSys(BaSys value) {
            this.baSys = value;
        }

        /**
         * 获取res属性的值。
         * 
         * @return
         *     possible object is
         *     {@link BaSysRes }
         *     
         */
        public BaSysRes getRes() {
            return res;
        }

        /**
         * 设置res属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link BaSysRes }
         *     
         */
        public void setRes(BaSysRes value) {
            this.res = value;
        }

        /**
         * 获取pathParams属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPathParams() {
            return pathParams;
        }

        /**
         * 设置pathParams属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPathParams(String value) {
            this.pathParams = value;
        }

        /**
         * 获取local属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getLocal() {
            return local;
        }

        /**
         * 设置local属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setLocal(String value) {
            this.local = value;
        }

    }

}
