
package com.qycloud.taiyuan.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * 查询条件选项类，本类主要用于给获取员工记录集提供查询选项条件
 * 
 * <p>employeeCdt complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="employeeCdt">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="code" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dicTitles" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dicJobIds" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dicTitleIds" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sex" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="political" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="education" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="marriage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="title" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="orgTypes" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="statues" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="orgIds" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="names" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="orgName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="jobName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="notContainsOids" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="notContainsNames" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="oid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dicJobNames" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="oids" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ifIntoWell" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="labor" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="enterpriseDateMin" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="enterpriseDateMax" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="idCard" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="jobType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="jobGrade" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="jobMajors" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="orgId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="locals" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="notContainLocals" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="notContainPoliticals" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="degree" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="社保编号" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="住房公积金账号" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="appId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="multipleLevelOrgFlag" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="size" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="hasUserFlag" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="orgFlag" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="jobFlag" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="detailFlag" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="leaderFlag" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="orgVirtualDeptFlag" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "employeeCdt", propOrder = {
    "code",
    "name",
    "dicTitles",
    "dicJobIds",
    "dicTitleIds",
    "sex",
    "political",
    "education",
    "marriage",
    "title",
    "orgTypes",
    "statues",
    "orgIds",
    "names",
    "orgName",
    "jobName",
    "notContainsOids",
    "notContainsNames",
    "oid",
    "dicJobNames",
    "oids",
    "ifIntoWell",
    "labor",
    "enterpriseDateMin",
    "enterpriseDateMax",
    "idCard",
    "jobType",
    "jobGrade",
    "jobMajors",
    "orgId",
    "locals",
    "notContainLocals",
    "notContainPoliticals",
    "degree",
    "\u793e\u4fdd\u7f16\u53f7",
    "\u4f4f\u623f\u516c\u79ef\u91d1\u8d26\u53f7",
    "appId"
})
public class EmployeeCdt {

    protected String code;
    protected String name;
    protected String dicTitles;
    protected String dicJobIds;
    protected String dicTitleIds;
    protected String sex;
    protected String political;
    protected String education;
    protected String marriage;
    protected String title;
    protected String orgTypes;
    protected String statues;
    protected String orgIds;
    protected String names;
    protected String orgName;
    protected String jobName;
    protected String notContainsOids;
    protected String notContainsNames;
    protected String oid;
    protected String dicJobNames;
    protected String oids;
    protected String ifIntoWell;
    protected String labor;
    protected String enterpriseDateMin;
    protected String enterpriseDateMax;
    protected String idCard;
    protected String jobType;
    protected String jobGrade;
    protected String jobMajors;
    protected String orgId;
    protected String locals;
    protected String notContainLocals;
    protected String notContainPoliticals;
    protected String degree;
    protected String 社保编号;
    protected String 住房公积金账号;
    protected String appId;
    @XmlAttribute(name = "multipleLevelOrgFlag")
    protected Integer multipleLevelOrgFlag;
    @XmlAttribute(name = "size", required = true)
    protected int size;
    @XmlAttribute(name = "hasUserFlag", required = true)
    protected int hasUserFlag;
    @XmlAttribute(name = "orgFlag", required = true)
    protected int orgFlag;
    @XmlAttribute(name = "jobFlag", required = true)
    protected int jobFlag;
    @XmlAttribute(name = "detailFlag", required = true)
    protected int detailFlag;
    @XmlAttribute(name = "leaderFlag", required = true)
    protected int leaderFlag;
    @XmlAttribute(name = "orgVirtualDeptFlag")
    protected Integer orgVirtualDeptFlag;

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
     * 获取dicTitles属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDicTitles() {
        return dicTitles;
    }

    /**
     * 设置dicTitles属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDicTitles(String value) {
        this.dicTitles = value;
    }

    /**
     * 获取dicJobIds属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDicJobIds() {
        return dicJobIds;
    }

    /**
     * 设置dicJobIds属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDicJobIds(String value) {
        this.dicJobIds = value;
    }

    /**
     * 获取dicTitleIds属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDicTitleIds() {
        return dicTitleIds;
    }

    /**
     * 设置dicTitleIds属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDicTitleIds(String value) {
        this.dicTitleIds = value;
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
     * 获取orgTypes属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrgTypes() {
        return orgTypes;
    }

    /**
     * 设置orgTypes属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrgTypes(String value) {
        this.orgTypes = value;
    }

    /**
     * 获取statues属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatues() {
        return statues;
    }

    /**
     * 设置statues属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatues(String value) {
        this.statues = value;
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
     * 获取names属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNames() {
        return names;
    }

    /**
     * 设置names属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNames(String value) {
        this.names = value;
    }

    /**
     * 获取orgName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrgName() {
        return orgName;
    }

    /**
     * 设置orgName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrgName(String value) {
        this.orgName = value;
    }

    /**
     * 获取jobName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getJobName() {
        return jobName;
    }

    /**
     * 设置jobName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setJobName(String value) {
        this.jobName = value;
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
     * 获取dicJobNames属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDicJobNames() {
        return dicJobNames;
    }

    /**
     * 设置dicJobNames属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDicJobNames(String value) {
        this.dicJobNames = value;
    }

    /**
     * 获取oids属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOids() {
        return oids;
    }

    /**
     * 设置oids属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOids(String value) {
        this.oids = value;
    }

    /**
     * 获取ifIntoWell属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIfIntoWell() {
        return ifIntoWell;
    }

    /**
     * 设置ifIntoWell属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIfIntoWell(String value) {
        this.ifIntoWell = value;
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
     * 获取enterpriseDateMin属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEnterpriseDateMin() {
        return enterpriseDateMin;
    }

    /**
     * 设置enterpriseDateMin属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEnterpriseDateMin(String value) {
        this.enterpriseDateMin = value;
    }

    /**
     * 获取enterpriseDateMax属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEnterpriseDateMax() {
        return enterpriseDateMax;
    }

    /**
     * 设置enterpriseDateMax属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEnterpriseDateMax(String value) {
        this.enterpriseDateMax = value;
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
     * 获取jobType属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getJobType() {
        return jobType;
    }

    /**
     * 设置jobType属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setJobType(String value) {
        this.jobType = value;
    }

    /**
     * 获取jobGrade属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getJobGrade() {
        return jobGrade;
    }

    /**
     * 设置jobGrade属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setJobGrade(String value) {
        this.jobGrade = value;
    }

    /**
     * 获取jobMajors属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getJobMajors() {
        return jobMajors;
    }

    /**
     * 设置jobMajors属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setJobMajors(String value) {
        this.jobMajors = value;
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
     * 获取locals属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLocals() {
        return locals;
    }

    /**
     * 设置locals属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLocals(String value) {
        this.locals = value;
    }

    /**
     * 获取notContainLocals属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNotContainLocals() {
        return notContainLocals;
    }

    /**
     * 设置notContainLocals属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNotContainLocals(String value) {
        this.notContainLocals = value;
    }

    /**
     * 获取notContainPoliticals属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNotContainPoliticals() {
        return notContainPoliticals;
    }

    /**
     * 设置notContainPoliticals属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNotContainPoliticals(String value) {
        this.notContainPoliticals = value;
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
     * 获取multipleLevelOrgFlag属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMultipleLevelOrgFlag() {
        return multipleLevelOrgFlag;
    }

    /**
     * 设置multipleLevelOrgFlag属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMultipleLevelOrgFlag(Integer value) {
        this.multipleLevelOrgFlag = value;
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
     * 获取hasUserFlag属性的值。
     * 
     */
    public int getHasUserFlag() {
        return hasUserFlag;
    }

    /**
     * 设置hasUserFlag属性的值。
     * 
     */
    public void setHasUserFlag(int value) {
        this.hasUserFlag = value;
    }

    /**
     * 获取orgFlag属性的值。
     * 
     */
    public int getOrgFlag() {
        return orgFlag;
    }

    /**
     * 设置orgFlag属性的值。
     * 
     */
    public void setOrgFlag(int value) {
        this.orgFlag = value;
    }

    /**
     * 获取jobFlag属性的值。
     * 
     */
    public int getJobFlag() {
        return jobFlag;
    }

    /**
     * 设置jobFlag属性的值。
     * 
     */
    public void setJobFlag(int value) {
        this.jobFlag = value;
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

    /**
     * 获取leaderFlag属性的值。
     * 
     */
    public int getLeaderFlag() {
        return leaderFlag;
    }

    /**
     * 设置leaderFlag属性的值。
     * 
     */
    public void setLeaderFlag(int value) {
        this.leaderFlag = value;
    }

    /**
     * 获取orgVirtualDeptFlag属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getOrgVirtualDeptFlag() {
        return orgVirtualDeptFlag;
    }

    /**
     * 设置orgVirtualDeptFlag属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setOrgVirtualDeptFlag(Integer value) {
        this.orgVirtualDeptFlag = value;
    }

}
