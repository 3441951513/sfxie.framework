
package com.qycloud.taiyuan.ws;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * BaEmployee entity. @author MyEclipse Persistence Tools
 * 
 * <p>baEmployee complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="baEmployee">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="oid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="code" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="orgId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dicJobId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dicTitleId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="title" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sex" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="political" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="politicalCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="operatorId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="operatorName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nationCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="education" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="educationCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="origin" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="idCard" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="phone" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="qq" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="email" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="marriage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="marriageCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="status" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="statusCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="household" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="householdPlace" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="schoolName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="major" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ifIntowell" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="labor" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="laborCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="laborTerm" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="workerTechLevel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="workerTechLevelCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="familyAddress" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cellphone" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="address" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="phyExamNum" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="xnum" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="photo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="idcardCopy" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="empIdcard" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="empIdcardCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="recruitNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="note" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="baOrg" type="{http://oup.rockontrol.com}baEmployeeOrg" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="baDic" type="{http://oup.rockontrol.com}baEmployeeJob" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="baWork" type="{http://oup.rockontrol.com}ba工作经历" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="baEducation" type="{http://oup.rockontrol.com}ba教育经历" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="baRelation" type="{http://oup.rockontrol.com}ba社会关系" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="baCertificate" type="{http://oup.rockontrol.com}ba证书信息" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="org" type="{http://oup.rockontrol.com}baOrg" minOccurs="0"/>
 *         &lt;element name="job" type="{http://oup.rockontrol.com}baJob" minOccurs="0"/>
 *         &lt;element name="bankName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="bankCard" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="electronicSignature" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="internalSmall" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="attendance" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="goTo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="whereLoan" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="local" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="degree" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="singleCard" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="社保编号" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="住房公积金账号" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="source" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="工资分类" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="entryDatetime" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
 *       &lt;attribute name="birthDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
 *       &lt;attribute name="multiOrg" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="multiJob" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="workDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
 *       &lt;attribute name="enterpriseDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
 *       &lt;attribute name="vacation" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="leavingDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
 *       &lt;attribute name="graduateDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
 *       &lt;attribute name="partyDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
 *       &lt;attribute name="fullQualityDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
 *       &lt;attribute name="基础工资" type="{http://www.w3.org/2001/XMLSchema}double" />
 *       &lt;attribute name="部门排序" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "baEmployee", propOrder = {
    "oid",
    "code",
    "name",
    "orgId",
    "dicJobId",
    "dicTitleId",
    "title",
    "sex",
    "political",
    "politicalCode",
    "operatorId",
    "operatorName",
    "nation",
    "nationCode",
    "education",
    "educationCode",
    "origin",
    "idCard",
    "phone",
    "qq",
    "email",
    "marriage",
    "marriageCode",
    "status",
    "statusCode",
    "household",
    "householdPlace",
    "schoolName",
    "major",
    "ifIntowell",
    "labor",
    "laborCode",
    "laborTerm",
    "workerTechLevel",
    "workerTechLevelCode",
    "familyAddress",
    "cellphone",
    "address",
    "phyExamNum",
    "xnum",
    "photo",
    "idcardCopy",
    "empIdcard",
    "empIdcardCode",
    "recruitNo",
    "note",
    "baOrg",
    "baDic",
    "baWork",
    "baEducation",
    "baRelation",
    "baCertificate",
    "org",
    "job",
    "bankName",
    "bankCard",
    "electronicSignature",
    "internalSmall",
    "attendance",
    "goTo",
    "whereLoan",
    "local",
    "degree",
    "singleCard",
    "\u793e\u4fdd\u7f16\u53f7",
    "\u4f4f\u623f\u516c\u79ef\u91d1\u8d26\u53f7",
    "source",
    "\u5de5\u8d44\u5206\u7c7b"
})
public class BaEmployee {

    protected String oid;
    protected String code;
    protected String name;
    protected String orgId;
    protected String dicJobId;
    protected String dicTitleId;
    protected String title;
    protected String sex;
    protected String political;
    protected String politicalCode;
    protected String operatorId;
    protected String operatorName;
    protected String nation;
    protected String nationCode;
    protected String education;
    protected String educationCode;
    protected String origin;
    protected String idCard;
    protected String phone;
    protected String qq;
    protected String email;
    protected String marriage;
    protected String marriageCode;
    protected String status;
    protected String statusCode;
    protected String household;
    protected String householdPlace;
    protected String schoolName;
    protected String major;
    protected String ifIntowell;
    protected String labor;
    protected String laborCode;
    protected String laborTerm;
    protected String workerTechLevel;
    protected String workerTechLevelCode;
    protected String familyAddress;
    protected String cellphone;
    protected String address;
    protected String phyExamNum;
    protected String xnum;
    protected String photo;
    protected String idcardCopy;
    protected String empIdcard;
    protected String empIdcardCode;
    protected String recruitNo;
    protected String note;
    protected List<BaEmployeeOrg> baOrg;
    protected List<BaEmployeeJob> baDic;
    protected List<Ba工作经历> baWork;
    protected List<Ba教育经历> baEducation;
    protected List<Ba社会关系> baRelation;
    protected List<Ba证书信息> baCertificate;
    protected BaOrg org;
    protected BaJob job;
    protected String bankName;
    protected String bankCard;
    protected String electronicSignature;
    protected String internalSmall;
    protected String attendance;
    protected String goTo;
    protected String whereLoan;
    protected String local;
    protected String degree;
    protected String singleCard;
    protected String 社保编号;
    protected String 住房公积金账号;
    protected String source;
    protected String 工资分类;
    @XmlAttribute(name = "entryDatetime")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar entryDatetime;
    @XmlAttribute(name = "birthDate")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar birthDate;
    @XmlAttribute(name = "multiOrg")
    protected Integer multiOrg;
    @XmlAttribute(name = "multiJob")
    protected Integer multiJob;
    @XmlAttribute(name = "workDate")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar workDate;
    @XmlAttribute(name = "enterpriseDate")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar enterpriseDate;
    @XmlAttribute(name = "vacation")
    protected Integer vacation;
    @XmlAttribute(name = "leavingDate")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar leavingDate;
    @XmlAttribute(name = "graduateDate")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar graduateDate;
    @XmlAttribute(name = "partyDate")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar partyDate;
    @XmlAttribute(name = "fullQualityDate")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fullQualityDate;
    @XmlAttribute
    protected Double 基础工资;
    @XmlAttribute
    protected Integer 部门排序;

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
     * 获取orgId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrgId() {
        return orgId;
    }

    /**
     * 设置orgId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrgId(String value) {
        this.orgId = value;
    }

    /**
     * 获取dicJobId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDicJobId() {
        return dicJobId;
    }

    /**
     * 设置dicJobId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDicJobId(String value) {
        this.dicJobId = value;
    }

    /**
     * 获取dicTitleId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDicTitleId() {
        return dicTitleId;
    }

    /**
     * 设置dicTitleId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDicTitleId(String value) {
        this.dicTitleId = value;
    }

    /**
     * 获取title属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置title属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTitle(String value) {
        this.title = value;
    }

    /**
     * 获取sex属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSex() {
        return sex;
    }

    /**
     * 设置sex属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSex(String value) {
        this.sex = value;
    }

    /**
     * 获取political属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPolitical() {
        return political;
    }

    /**
     * 设置political属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPolitical(String value) {
        this.political = value;
    }

    /**
     * 获取politicalCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPoliticalCode() {
        return politicalCode;
    }

    /**
     * 设置politicalCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPoliticalCode(String value) {
        this.politicalCode = value;
    }

    /**
     * 获取operatorId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOperatorId() {
        return operatorId;
    }

    /**
     * 设置operatorId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOperatorId(String value) {
        this.operatorId = value;
    }

    /**
     * 获取operatorName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOperatorName() {
        return operatorName;
    }

    /**
     * 设置operatorName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOperatorName(String value) {
        this.operatorName = value;
    }

    /**
     * 获取nation属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNation() {
        return nation;
    }

    /**
     * 设置nation属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNation(String value) {
        this.nation = value;
    }

    /**
     * 获取nationCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNationCode() {
        return nationCode;
    }

    /**
     * 设置nationCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNationCode(String value) {
        this.nationCode = value;
    }

    /**
     * 获取education属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEducation() {
        return education;
    }

    /**
     * 设置education属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEducation(String value) {
        this.education = value;
    }

    /**
     * 获取educationCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEducationCode() {
        return educationCode;
    }

    /**
     * 设置educationCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEducationCode(String value) {
        this.educationCode = value;
    }

    /**
     * 获取origin属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrigin() {
        return origin;
    }

    /**
     * 设置origin属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrigin(String value) {
        this.origin = value;
    }

    /**
     * 获取idCard属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdCard() {
        return idCard;
    }

    /**
     * 设置idCard属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdCard(String value) {
        this.idCard = value;
    }

    /**
     * 获取phone属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置phone属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPhone(String value) {
        this.phone = value;
    }

    /**
     * 获取qq属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getQq() {
        return qq;
    }

    /**
     * 设置qq属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setQq(String value) {
        this.qq = value;
    }

    /**
     * 获取email属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置email属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmail(String value) {
        this.email = value;
    }

    /**
     * 获取marriage属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMarriage() {
        return marriage;
    }

    /**
     * 设置marriage属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMarriage(String value) {
        this.marriage = value;
    }

    /**
     * 获取marriageCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMarriageCode() {
        return marriageCode;
    }

    /**
     * 设置marriageCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMarriageCode(String value) {
        this.marriageCode = value;
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
     * 获取statusCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatusCode() {
        return statusCode;
    }

    /**
     * 设置statusCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatusCode(String value) {
        this.statusCode = value;
    }

    /**
     * 获取household属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHousehold() {
        return household;
    }

    /**
     * 设置household属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHousehold(String value) {
        this.household = value;
    }

    /**
     * 获取householdPlace属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHouseholdPlace() {
        return householdPlace;
    }

    /**
     * 设置householdPlace属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHouseholdPlace(String value) {
        this.householdPlace = value;
    }

    /**
     * 获取schoolName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSchoolName() {
        return schoolName;
    }

    /**
     * 设置schoolName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSchoolName(String value) {
        this.schoolName = value;
    }

    /**
     * 获取major属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMajor() {
        return major;
    }

    /**
     * 设置major属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMajor(String value) {
        this.major = value;
    }

    /**
     * 获取ifIntowell属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIfIntowell() {
        return ifIntowell;
    }

    /**
     * 设置ifIntowell属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIfIntowell(String value) {
        this.ifIntowell = value;
    }

    /**
     * 获取labor属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLabor() {
        return labor;
    }

    /**
     * 设置labor属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLabor(String value) {
        this.labor = value;
    }

    /**
     * 获取laborCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLaborCode() {
        return laborCode;
    }

    /**
     * 设置laborCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLaborCode(String value) {
        this.laborCode = value;
    }

    /**
     * 获取laborTerm属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLaborTerm() {
        return laborTerm;
    }

    /**
     * 设置laborTerm属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLaborTerm(String value) {
        this.laborTerm = value;
    }

    /**
     * 获取workerTechLevel属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWorkerTechLevel() {
        return workerTechLevel;
    }

    /**
     * 设置workerTechLevel属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWorkerTechLevel(String value) {
        this.workerTechLevel = value;
    }

    /**
     * 获取workerTechLevelCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWorkerTechLevelCode() {
        return workerTechLevelCode;
    }

    /**
     * 设置workerTechLevelCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWorkerTechLevelCode(String value) {
        this.workerTechLevelCode = value;
    }

    /**
     * 获取familyAddress属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFamilyAddress() {
        return familyAddress;
    }

    /**
     * 设置familyAddress属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFamilyAddress(String value) {
        this.familyAddress = value;
    }

    /**
     * 获取cellphone属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCellphone() {
        return cellphone;
    }

    /**
     * 设置cellphone属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCellphone(String value) {
        this.cellphone = value;
    }

    /**
     * 获取address属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置address属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddress(String value) {
        this.address = value;
    }

    /**
     * 获取phyExamNum属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPhyExamNum() {
        return phyExamNum;
    }

    /**
     * 设置phyExamNum属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPhyExamNum(String value) {
        this.phyExamNum = value;
    }

    /**
     * 获取xnum属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getXnum() {
        return xnum;
    }

    /**
     * 设置xnum属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setXnum(String value) {
        this.xnum = value;
    }

    /**
     * 获取photo属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPhoto() {
        return photo;
    }

    /**
     * 设置photo属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPhoto(String value) {
        this.photo = value;
    }

    /**
     * 获取idcardCopy属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdcardCopy() {
        return idcardCopy;
    }

    /**
     * 设置idcardCopy属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdcardCopy(String value) {
        this.idcardCopy = value;
    }

    /**
     * 获取empIdcard属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmpIdcard() {
        return empIdcard;
    }

    /**
     * 设置empIdcard属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmpIdcard(String value) {
        this.empIdcard = value;
    }

    /**
     * 获取empIdcardCode属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmpIdcardCode() {
        return empIdcardCode;
    }

    /**
     * 设置empIdcardCode属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmpIdcardCode(String value) {
        this.empIdcardCode = value;
    }

    /**
     * 获取recruitNo属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRecruitNo() {
        return recruitNo;
    }

    /**
     * 设置recruitNo属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRecruitNo(String value) {
        this.recruitNo = value;
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
     * Gets the value of the baOrg property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the baOrg property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBaOrg().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BaEmployeeOrg }
     * 
     * 
     */
    public List<BaEmployeeOrg> getBaOrg() {
        if (baOrg == null) {
            baOrg = new ArrayList<BaEmployeeOrg>();
        }
        return this.baOrg;
    }

    /**
     * Gets the value of the baDic property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the baDic property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBaDic().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BaEmployeeJob }
     * 
     * 
     */
    public List<BaEmployeeJob> getBaDic() {
        if (baDic == null) {
            baDic = new ArrayList<BaEmployeeJob>();
        }
        return this.baDic;
    }

    /**
     * Gets the value of the baWork property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the baWork property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBaWork().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Ba工作经历 }
     * 
     * 
     */
    public List<Ba工作经历> getBaWork() {
        if (baWork == null) {
            baWork = new ArrayList<Ba工作经历>();
        }
        return this.baWork;
    }

    /**
     * Gets the value of the baEducation property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the baEducation property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBaEducation().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Ba教育经历 }
     * 
     * 
     */
    public List<Ba教育经历> getBaEducation() {
        if (baEducation == null) {
            baEducation = new ArrayList<Ba教育经历>();
        }
        return this.baEducation;
    }

    /**
     * Gets the value of the baRelation property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the baRelation property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBaRelation().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Ba社会关系 }
     * 
     * 
     */
    public List<Ba社会关系> getBaRelation() {
        if (baRelation == null) {
            baRelation = new ArrayList<Ba社会关系>();
        }
        return this.baRelation;
    }

    /**
     * Gets the value of the baCertificate property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the baCertificate property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBaCertificate().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Ba证书信息 }
     * 
     * 
     */
    public List<Ba证书信息> getBaCertificate() {
        if (baCertificate == null) {
            baCertificate = new ArrayList<Ba证书信息>();
        }
        return this.baCertificate;
    }

    /**
     * 获取org属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BaOrg }
     *     
     */
    public BaOrg getOrg() {
        return org;
    }

    /**
     * 设置org属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BaOrg }
     *     
     */
    public void setOrg(BaOrg value) {
        this.org = value;
    }

    /**
     * 获取job属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BaJob }
     *     
     */
    public BaJob getJob() {
        return job;
    }

    /**
     * 设置job属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BaJob }
     *     
     */
    public void setJob(BaJob value) {
        this.job = value;
    }

    /**
     * 获取bankName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBankName() {
        return bankName;
    }

    /**
     * 设置bankName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBankName(String value) {
        this.bankName = value;
    }

    /**
     * 获取bankCard属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBankCard() {
        return bankCard;
    }

    /**
     * 设置bankCard属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBankCard(String value) {
        this.bankCard = value;
    }

    /**
     * 获取electronicSignature属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getElectronicSignature() {
        return electronicSignature;
    }

    /**
     * 设置electronicSignature属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setElectronicSignature(String value) {
        this.electronicSignature = value;
    }

    /**
     * 获取internalSmall属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInternalSmall() {
        return internalSmall;
    }

    /**
     * 设置internalSmall属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInternalSmall(String value) {
        this.internalSmall = value;
    }

    /**
     * 获取attendance属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAttendance() {
        return attendance;
    }

    /**
     * 设置attendance属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAttendance(String value) {
        this.attendance = value;
    }

    /**
     * 获取goTo属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGoTo() {
        return goTo;
    }

    /**
     * 设置goTo属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGoTo(String value) {
        this.goTo = value;
    }

    /**
     * 获取whereLoan属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWhereLoan() {
        return whereLoan;
    }

    /**
     * 设置whereLoan属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWhereLoan(String value) {
        this.whereLoan = value;
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

    /**
     * 获取degree属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDegree() {
        return degree;
    }

    /**
     * 设置degree属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDegree(String value) {
        this.degree = value;
    }

    /**
     * 获取singleCard属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSingleCard() {
        return singleCard;
    }

    /**
     * 设置singleCard属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSingleCard(String value) {
        this.singleCard = value;
    }

    /**
     * 获取社保编号属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String get社保编号() {
        return 社保编号;
    }

    /**
     * 设置社保编号属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void set社保编号(String value) {
        this.社保编号 = value;
    }

    /**
     * 获取住房公积金账号属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String get住房公积金账号() {
        return 住房公积金账号;
    }

    /**
     * 设置住房公积金账号属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void set住房公积金账号(String value) {
        this.住房公积金账号 = value;
    }

    /**
     * 获取source属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSource() {
        return source;
    }

    /**
     * 设置source属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSource(String value) {
        this.source = value;
    }

    /**
     * 获取工资分类属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String get工资分类() {
        return 工资分类;
    }

    /**
     * 设置工资分类属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void set工资分类(String value) {
        this.工资分类 = value;
    }

    /**
     * 获取entryDatetime属性的值。
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getEntryDatetime() {
        return entryDatetime;
    }

    /**
     * 设置entryDatetime属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setEntryDatetime(XMLGregorianCalendar value) {
        this.entryDatetime = value;
    }

    /**
     * 获取birthDate属性的值。
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getBirthDate() {
        return birthDate;
    }

    /**
     * 设置birthDate属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setBirthDate(XMLGregorianCalendar value) {
        this.birthDate = value;
    }

    /**
     * 获取multiOrg属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMultiOrg() {
        return multiOrg;
    }

    /**
     * 设置multiOrg属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMultiOrg(Integer value) {
        this.multiOrg = value;
    }

    /**
     * 获取multiJob属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMultiJob() {
        return multiJob;
    }

    /**
     * 设置multiJob属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMultiJob(Integer value) {
        this.multiJob = value;
    }

    /**
     * 获取workDate属性的值。
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getWorkDate() {
        return workDate;
    }

    /**
     * 设置workDate属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setWorkDate(XMLGregorianCalendar value) {
        this.workDate = value;
    }

    /**
     * 获取enterpriseDate属性的值。
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getEnterpriseDate() {
        return enterpriseDate;
    }

    /**
     * 设置enterpriseDate属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setEnterpriseDate(XMLGregorianCalendar value) {
        this.enterpriseDate = value;
    }

    /**
     * 获取vacation属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getVacation() {
        return vacation;
    }

    /**
     * 设置vacation属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setVacation(Integer value) {
        this.vacation = value;
    }

    /**
     * 获取leavingDate属性的值。
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getLeavingDate() {
        return leavingDate;
    }

    /**
     * 设置leavingDate属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setLeavingDate(XMLGregorianCalendar value) {
        this.leavingDate = value;
    }

    /**
     * 获取graduateDate属性的值。
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getGraduateDate() {
        return graduateDate;
    }

    /**
     * 设置graduateDate属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setGraduateDate(XMLGregorianCalendar value) {
        this.graduateDate = value;
    }

    /**
     * 获取partyDate属性的值。
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getPartyDate() {
        return partyDate;
    }

    /**
     * 设置partyDate属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setPartyDate(XMLGregorianCalendar value) {
        this.partyDate = value;
    }

    /**
     * 获取fullQualityDate属性的值。
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFullQualityDate() {
        return fullQualityDate;
    }

    /**
     * 设置fullQualityDate属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFullQualityDate(XMLGregorianCalendar value) {
        this.fullQualityDate = value;
    }

    /**
     * 获取基础工资属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double get基础工资() {
        return 基础工资;
    }

    /**
     * 设置基础工资属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void set基础工资(Double value) {
        this.基础工资 = value;
    }

    /**
     * 获取部门排序属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer get部门排序() {
        return 部门排序;
    }

    /**
     * 设置部门排序属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void set部门排序(Integer value) {
        this.部门排序 = value;
    }

}
