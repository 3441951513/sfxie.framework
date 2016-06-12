
package com.qycloud.taiyuan.ws;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * Ba导入表字典 entity. @author MyEclipse Persistence Tools
 * 
 * <p>ba导入表字典 complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="ba导入表字典">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="oid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="表名" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="录入人id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="录入人" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="importDetail" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="字段日期格式" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="属性名" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="oid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="导入表字典id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="字段名" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="可以为空" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="字段数据库类型" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="字段excel类型" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="字段描述" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="状态描述" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="固定值" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="反查目标表表名" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="反查目标表字段名" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="目标表与本表对应字段" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                 &lt;/sequence>
 *                 &lt;attribute name="导入操作类型" type="{http://www.w3.org/2001/XMLSchema}int" />
 *                 &lt;attribute name="长度" type="{http://www.w3.org/2001/XMLSchema}int" />
 *                 &lt;attribute name="小数位长度" type="{http://www.w3.org/2001/XMLSchema}int" />
 *                 &lt;attribute name="排序" type="{http://www.w3.org/2001/XMLSchema}int" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="程序名" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="描述" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="应用系统" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="应用系统id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="录入时间" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ba\u5bfc\u5165\u8868\u5b57\u5178", propOrder = {
    "oid",
    "\u8868\u540d",
    "\u5f55\u5165\u4ebaId",
    "\u5f55\u5165\u4eba",
    "importDetail",
    "\u7a0b\u5e8f\u540d",
    "\u63cf\u8ff0",
    "\u5e94\u7528\u7cfb\u7edf",
    "\u5e94\u7528\u7cfb\u7edfId"
})
public class Ba导入表字典 {

    protected String oid;
    protected String 表名;
    @XmlElement(name = "\u5f55\u5165\u4ebaid")
    protected String 录入人Id;
    protected String 录入人;
    protected List<Ba导入表字典.ImportDetail> importDetail;
    protected String 程序名;
    protected String 描述;
    protected String 应用系统;
    @XmlElement(name = "\u5e94\u7528\u7cfb\u7edfid")
    protected String 应用系统Id;
    @XmlAttribute
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar 录入时间;

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
     * 获取表名属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String get表名() {
        return 表名;
    }

    /**
     * 设置表名属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void set表名(String value) {
        this.表名 = value;
    }

    /**
     * 获取录入人Id属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String get录入人Id() {
        return 录入人Id;
    }

    /**
     * 设置录入人Id属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void set录入人Id(String value) {
        this.录入人Id = value;
    }

    /**
     * 获取录入人属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String get录入人() {
        return 录入人;
    }

    /**
     * 设置录入人属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void set录入人(String value) {
        this.录入人 = value;
    }

    /**
     * Gets the value of the importDetail property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the importDetail property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getImportDetail().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Ba导入表字典.ImportDetail }
     * 
     * 
     */
    public List<Ba导入表字典.ImportDetail> getImportDetail() {
        if (importDetail == null) {
            importDetail = new ArrayList<Ba导入表字典.ImportDetail>();
        }
        return this.importDetail;
    }

    /**
     * 获取程序名属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String get程序名() {
        return 程序名;
    }

    /**
     * 设置程序名属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void set程序名(String value) {
        this.程序名 = value;
    }

    /**
     * 获取描述属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String get描述() {
        return 描述;
    }

    /**
     * 设置描述属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void set描述(String value) {
        this.描述 = value;
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
     * 获取录入时间属性的值。
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar get录入时间() {
        return 录入时间;
    }

    /**
     * 设置录入时间属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void set录入时间(XMLGregorianCalendar value) {
        this.录入时间 = value;
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
     *         &lt;element name="字段日期格式" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="属性名" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="oid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="导入表字典id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="字段名" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="可以为空" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="字段数据库类型" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="字段excel类型" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="字段描述" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="状态描述" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="固定值" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="反查目标表表名" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="反查目标表字段名" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="目标表与本表对应字段" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *       &lt;/sequence>
     *       &lt;attribute name="导入操作类型" type="{http://www.w3.org/2001/XMLSchema}int" />
     *       &lt;attribute name="长度" type="{http://www.w3.org/2001/XMLSchema}int" />
     *       &lt;attribute name="小数位长度" type="{http://www.w3.org/2001/XMLSchema}int" />
     *       &lt;attribute name="排序" type="{http://www.w3.org/2001/XMLSchema}int" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "\u5b57\u6bb5\u65e5\u671f\u683c\u5f0f",
        "\u5c5e\u6027\u540d",
        "oid",
        "\u5bfc\u5165\u8868\u5b57\u5178Id",
        "\u5b57\u6bb5\u540d",
        "\u53ef\u4ee5\u4e3a\u7a7a",
        "\u5b57\u6bb5\u6570\u636e\u5e93\u7c7b\u578b",
        "\u5b57\u6bb5Excel\u7c7b\u578b",
        "\u5b57\u6bb5\u63cf\u8ff0",
        "\u72b6\u6001\u63cf\u8ff0",
        "\u56fa\u5b9a\u503c",
        "\u53cd\u67e5\u76ee\u6807\u8868\u8868\u540d",
        "\u53cd\u67e5\u76ee\u6807\u8868\u5b57\u6bb5\u540d",
        "\u76ee\u6807\u8868\u4e0e\u672c\u8868\u5bf9\u5e94\u5b57\u6bb5"
    })
    public static class ImportDetail {

        protected String 字段日期格式;
        protected String 属性名;
        protected String oid;
        @XmlElement(name = "\u5bfc\u5165\u8868\u5b57\u5178id")
        protected String 导入表字典Id;
        protected String 字段名;
        protected String 可以为空;
        protected String 字段数据库类型;
        @XmlElement(name = "\u5b57\u6bb5excel\u7c7b\u578b")
        protected String 字段Excel类型;
        protected String 字段描述;
        protected String 状态描述;
        protected String 固定值;
        protected String 反查目标表表名;
        protected String 反查目标表字段名;
        protected String 目标表与本表对应字段;
        @XmlAttribute
        protected Integer 导入操作类型;
        @XmlAttribute
        protected Integer 长度;
        @XmlAttribute
        protected Integer 小数位长度;
        @XmlAttribute
        protected Integer 排序;

        /**
         * 获取字段日期格式属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String get字段日期格式() {
            return 字段日期格式;
        }

        /**
         * 设置字段日期格式属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void set字段日期格式(String value) {
            this.字段日期格式 = value;
        }

        /**
         * 获取属性名属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String get属性名() {
            return 属性名;
        }

        /**
         * 设置属性名属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void set属性名(String value) {
            this.属性名 = value;
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
         * 获取导入表字典Id属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String get导入表字典Id() {
            return 导入表字典Id;
        }

        /**
         * 设置导入表字典Id属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void set导入表字典Id(String value) {
            this.导入表字典Id = value;
        }

        /**
         * 获取字段名属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String get字段名() {
            return 字段名;
        }

        /**
         * 设置字段名属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void set字段名(String value) {
            this.字段名 = value;
        }

        /**
         * 获取可以为空属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String get可以为空() {
            return 可以为空;
        }

        /**
         * 设置可以为空属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void set可以为空(String value) {
            this.可以为空 = value;
        }

        /**
         * 获取字段数据库类型属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String get字段数据库类型() {
            return 字段数据库类型;
        }

        /**
         * 设置字段数据库类型属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void set字段数据库类型(String value) {
            this.字段数据库类型 = value;
        }

        /**
         * 获取字段Excel类型属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String get字段Excel类型() {
            return 字段Excel类型;
        }

        /**
         * 设置字段Excel类型属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void set字段Excel类型(String value) {
            this.字段Excel类型 = value;
        }

        /**
         * 获取字段描述属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String get字段描述() {
            return 字段描述;
        }

        /**
         * 设置字段描述属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void set字段描述(String value) {
            this.字段描述 = value;
        }

        /**
         * 获取状态描述属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String get状态描述() {
            return 状态描述;
        }

        /**
         * 设置状态描述属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void set状态描述(String value) {
            this.状态描述 = value;
        }

        /**
         * 获取固定值属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String get固定值() {
            return 固定值;
        }

        /**
         * 设置固定值属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void set固定值(String value) {
            this.固定值 = value;
        }

        /**
         * 获取反查目标表表名属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String get反查目标表表名() {
            return 反查目标表表名;
        }

        /**
         * 设置反查目标表表名属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void set反查目标表表名(String value) {
            this.反查目标表表名 = value;
        }

        /**
         * 获取反查目标表字段名属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String get反查目标表字段名() {
            return 反查目标表字段名;
        }

        /**
         * 设置反查目标表字段名属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void set反查目标表字段名(String value) {
            this.反查目标表字段名 = value;
        }

        /**
         * 获取目标表与本表对应字段属性的值。
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String get目标表与本表对应字段() {
            return 目标表与本表对应字段;
        }

        /**
         * 设置目标表与本表对应字段属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void set目标表与本表对应字段(String value) {
            this.目标表与本表对应字段 = value;
        }

        /**
         * 获取导入操作类型属性的值。
         * 
         * @return
         *     possible object is
         *     {@link Integer }
         *     
         */
        public Integer get导入操作类型() {
            return 导入操作类型;
        }

        /**
         * 设置导入操作类型属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link Integer }
         *     
         */
        public void set导入操作类型(Integer value) {
            this.导入操作类型 = value;
        }

        /**
         * 获取长度属性的值。
         * 
         * @return
         *     possible object is
         *     {@link Integer }
         *     
         */
        public Integer get长度() {
            return 长度;
        }

        /**
         * 设置长度属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link Integer }
         *     
         */
        public void set长度(Integer value) {
            this.长度 = value;
        }

        /**
         * 获取小数位长度属性的值。
         * 
         * @return
         *     possible object is
         *     {@link Integer }
         *     
         */
        public Integer get小数位长度() {
            return 小数位长度;
        }

        /**
         * 设置小数位长度属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link Integer }
         *     
         */
        public void set小数位长度(Integer value) {
            this.小数位长度 = value;
        }

        /**
         * 获取排序属性的值。
         * 
         * @return
         *     possible object is
         *     {@link Integer }
         *     
         */
        public Integer get排序() {
            return 排序;
        }

        /**
         * 设置排序属性的值。
         * 
         * @param value
         *     allowed object is
         *     {@link Integer }
         *     
         */
        public void set排序(Integer value) {
            this.排序 = value;
        }

    }

}
