
package com.qycloud.taiyuan.ws;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>deptAdministrator complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="deptAdministrator">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="oid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="名字" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="用户id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="用户名" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="备注" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="管辖部门" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="oid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="系统管理员id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="系统管理员" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="组织机构id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="组织机构" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="备注" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="授权系统" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="oid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="系统管理员id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="系统管理员" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="应用系统id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="应用系统" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="备注" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="权限" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="appId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "deptAdministrator", propOrder = {
    "oid",
    "\u540d\u5b57",
    "\u7528\u6237Id",
    "\u7528\u6237\u540d",
    "\u5907\u6ce8",
    "\u7ba1\u8f96\u90e8\u95e8",
    "\u6388\u6743\u7cfb\u7edf",
    "\u6743\u9650",
    "appId"
})
public class DeptAdministrator {

    protected String oid;
    protected String 名字;
    @XmlElement(name = "\u7528\u6237id")
    protected String 用户Id;
    protected String 用户名;
    protected String 备注;
    protected List<DeptAdministrator.管辖部门> 管辖部门;
    protected List<DeptAdministrator.授权系统> 授权系统;
    protected String 权限;
    protected String appId;

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
     * 获取名字属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String get名字() {
        return 名字;
    }

    /**
     * 设置名字属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void set名字(String value) {
        this.名字 = value;
    }

    /**
     * 获取用户Id属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String get用户Id() {
        return 用户Id;
    }

    /**
     * 设置用户Id属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void set用户Id(String value) {
        this.用户Id = value;
    }

    /**
     * 获取用户名属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String get用户名() {
        return 用户名;
    }

    /**
     * 设置用户名属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void set用户名(String value) {
        this.用户名 = value;
    }

    /**
     * 获取备注属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String get备注() {
        return 备注;
    }

    /**
     * 设置备注属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void set备注(String value) {
        this.备注 = value;
    }

    /**
     * Gets the value of the 管辖部门 property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the 管辖部门 property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    get管辖部门().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DeptAdministrator.管辖部门 }
     * 
     * 
     */
    public List<DeptAdministrator.管辖部门> get管辖部门() {
        if (管辖部门 == null) {
            管辖部门 = new ArrayList<DeptAdministrator.管辖部门>();
        }
        return this.管辖部门;
    }

    /**
     * Gets the value of the 授权系统 property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the 授权系统 property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    get授权系统().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DeptAdministrator.授权系统 }
     * 
     * 
     */
    public List<DeptAdministrator.授权系统> get授权系统() {
        if (授权系统 == null) {
            授权系统 = new ArrayList<DeptAdministrator.授权系统>();
        }
        return this.授权系统;
    }

    /**
     * 获取权限属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String get权限() {
        return 权限;
    }

    /**
     * 设置权限属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void set权限(String value) {
        this.权限 = value;
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
     *         &lt;element name="系统管理员id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="系统管理员" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="应用系统id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="应用系统" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="备注" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
        "\u7cfb\u7edf\u7ba1\u7406\u5458Id",
        "\u7cfb\u7edf\u7ba1\u7406\u5458",
        "\u5e94\u7528\u7cfb\u7edfId",
        "\u5e94\u7528\u7cfb\u7edf",
        "\u5907\u6ce8"
    })
    public static class 授权系统 {

        protected String oid;
        @XmlElement(name = "\u7cfb\u7edf\u7ba1\u7406\u5458id")
        protected String 系统管理员Id;
        protected String 系统管理员;
        @XmlElement(name = "\u5e94\u7528\u7cfb\u7edfid")
        protected String 应用系统Id;
        protected String 应用系统;
        protected String 备注;

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
         * 获取系统管理员Id属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String get系统管理员Id() {
            return 系统管理员Id;
        }

        /**
         * 设置系统管理员Id属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void set系统管理员Id(String value) {
            this.系统管理员Id = value;
        }

        /**
         * 获取系统管理员属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String get系统管理员() {
            return 系统管理员;
        }

        /**
         * 设置系统管理员属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void set系统管理员(String value) {
            this.系统管理员 = value;
        }

        /**
         * 获取应用系统Id属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String get应用系统Id() {
            return 应用系统Id;
        }

        /**
         * 设置应用系统Id属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void set应用系统Id(String value) {
            this.应用系统Id = value;
        }

        /**
         * 获取应用系统属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String get应用系统() {
            return 应用系统;
        }

        /**
         * 设置应用系统属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void set应用系统(String value) {
            this.应用系统 = value;
        }

        /**
         * 获取备注属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String get备注() {
            return 备注;
        }

        /**
         * 设置备注属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void set备注(String value) {
            this.备注 = value;
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
     *         &lt;element name="系统管理员id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="系统管理员" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="组织机构id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="组织机构" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="备注" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
        "\u7cfb\u7edf\u7ba1\u7406\u5458Id",
        "\u7cfb\u7edf\u7ba1\u7406\u5458",
        "\u7ec4\u7ec7\u673a\u6784Id",
        "\u7ec4\u7ec7\u673a\u6784",
        "\u5907\u6ce8"
    })
    public static class 管辖部门 {

        protected String oid;
        @XmlElement(name = "\u7cfb\u7edf\u7ba1\u7406\u5458id")
        protected String 系统管理员Id;
        protected String 系统管理员;
        @XmlElement(name = "\u7ec4\u7ec7\u673a\u6784id")
        protected String 组织机构Id;
        protected String 组织机构;
        protected String 备注;

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
         * 获取系统管理员Id属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String get系统管理员Id() {
            return 系统管理员Id;
        }

        /**
         * 设置系统管理员Id属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void set系统管理员Id(String value) {
            this.系统管理员Id = value;
        }

        /**
         * 获取系统管理员属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String get系统管理员() {
            return 系统管理员;
        }

        /**
         * 设置系统管理员属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void set系统管理员(String value) {
            this.系统管理员 = value;
        }

        /**
         * 获取组织机构Id属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String get组织机构Id() {
            return 组织机构Id;
        }

        /**
         * 设置组织机构Id属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void set组织机构Id(String value) {
            this.组织机构Id = value;
        }

        /**
         * 获取组织机构属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String get组织机构() {
            return 组织机构;
        }

        /**
         * 设置组织机构属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void set组织机构(String value) {
            this.组织机构 = value;
        }

        /**
         * 获取备注属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String get备注() {
            return 备注;
        }

        /**
         * 设置备注属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void set备注(String value) {
            this.备注 = value;
        }

    }

}
