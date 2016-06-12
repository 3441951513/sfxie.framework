package com.sfxie.website.modules.api3.common.pojo;


import java.io.Serializable;
import java.util.*;

/**
 * 广告位表
 *
 *
 */
public class AdPlacePO implements Serializable {
    /**
     * 主键ID
     *
     *
     */
    private Integer id;
    /**
     * 编码
     *
     *
     */
    private String code;
    /**
     * 广告位名称
     *
     *
     */
    private String name;
    /**
     * 英语别名
     */
    private String enName;

    /**
     * 广告位封面路径
     *
     *
     */
    private String cover;
    /**
     * 窗口组件(1倒计时，2静音，3关闭，4赞一个，5踩一个，6跳过广告)
     * 多个组件，逗号分割
     *
     *
     */
    private String windowKit;
    /**
     * 关闭方式(1返回键关闭，2内容开始前，3广告结束后，4不关闭)
     *
     *
     */
    private Short closeType;
    /**
     * 竞争机制(0随机2权重)
     *
     *
     */
    private Short contend;
    /**
     * 广告位描述
     *
     *
     */
    private String description;
    /**
     * 状态（0关闭1激活）
     *
     *
     */
    private Short state;
    /**
     * 创建时间
     *
     *
     */
    private Date createTime;
    /**
     * 广告位类型ID
     */
    private Short placeTypeId;
    /**
     * 广告位规格ID
     */
    private Integer standardId;
    
    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEnName() {
		return enName;
	}
	public void setEnName(String enName) {
		this.enName = enName;
	}
	public String getCover() {
		return cover;
	}
	public void setCover(String cover) {
		this.cover = cover;
	}
	public String getWindowKit() {
		return windowKit;
	}
	public void setWindowKit(String windowKit) {
		this.windowKit = windowKit;
	}
	public Short getCloseType() {
		return closeType;
	}
	public void setCloseType(Short closeType) {
		this.closeType = closeType;
	}
	public Short getContend() {
		return contend;
	}
	public void setContend(Short contend) {
		this.contend = contend;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Short getState() {
		return state;
	}
	public void setState(Short state) {
		this.state = state;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Short getPlaceTypeId() {
		return placeTypeId;
	}
	public void setPlaceTypeId(Short placeTypeId) {
		this.placeTypeId = placeTypeId;
	}
	public Integer getStandardId() {
		return standardId;
	}
	public void setStandardId(Integer standardId) {
		this.standardId = standardId;
	}
    
    

}