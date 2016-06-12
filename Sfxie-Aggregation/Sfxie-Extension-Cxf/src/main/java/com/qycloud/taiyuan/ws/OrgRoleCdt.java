
package com.qycloud.taiyuan.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>orgRoleCdt complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="orgRoleCdt">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="orgRoleIds" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="orgRoleName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="orgRoleNames" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="userId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="levelFlag" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "orgRoleCdt", propOrder = {
    "orgRoleIds",
    "orgRoleName",
    "orgRoleNames",
    "userId"
})
public class OrgRoleCdt {

    protected String orgRoleIds;
    protected String orgRoleName;
    protected String orgRoleNames;
    protected String userId;
    @XmlAttribute(name = "levelFlag", required = true)
    protected int levelFlag;

    /**
     * 获取orgRoleIds属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrgRoleIds() {
        return orgRoleIds;
    }

    /**
     * 设置orgRoleIds属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrgRoleIds(String value) {
        this.orgRoleIds = value;
    }

    /**
     * 获取orgRoleName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrgRoleName() {
        return orgRoleName;
    }

    /**
     * 设置orgRoleName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrgRoleName(String value) {
        this.orgRoleName = value;
    }

    /**
     * 获取orgRoleNames属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrgRoleNames() {
        return orgRoleNames;
    }

    /**
     * 设置orgRoleNames属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrgRoleNames(String value) {
        this.orgRoleNames = value;
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

}
