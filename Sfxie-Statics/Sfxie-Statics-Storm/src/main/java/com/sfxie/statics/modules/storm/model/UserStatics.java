package com.sfxie.statics.modules.storm.model;

import java.io.Serializable;
import java.util.Date;

import com.sfxie.extension.mybatis.annotation.ColumnName;
import com.sfxie.extension.mybatis.annotation.TableName;


@TableName("test_storm_user_statics")
public class UserStatics implements Serializable{
	@ColumnName(field="user_id")
	private String userId;       
	
	@ColumnName(field="channel_id")           
    private String channelId;       // 渠道id
	
	@ColumnName(field="channel_name")
    private String channelName;     // 渠道名称

	@ColumnName(field="create_time")
    private Date createTime;        // 创建时间 _年月日时分秒
	
	@ColumnName(field="china_time")
    private String chinaTime;    	//时间_年月日
	
	@ColumnName(field="tp")
    private Integer tp;				//曝光时长(单位秒)视频的播放进度时长
	
	@ColumnName(field="place_id")
    private String placeId;		//板块类型(实际上是广告位id)

	@ColumnName(field="reward")
    private Double reward;		//奖励

	@ColumnName(field="reward_type")
    private String rewardType;  //奖励类型
    
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getChannelId() {
		return channelId;
	}
	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}
	public String getChannelName() {
		return channelName;
	}
	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getChinaTime() {
		return chinaTime;
	}
	public void setChinaTime(String chinaTime) {
		this.chinaTime = chinaTime;
	}
	public Integer getTp() {
		return tp;
	}
	public void setTp(Integer tp) {
		this.tp = tp;
	}
	public String getPlaceId() {
		return placeId;
	}
	public void setPlaceId(String placeId) {
		this.placeId = placeId;
	}
	public Double getReward() {
		return reward;
	}
	public void setReward(Double reward) {
		this.reward = reward;
	}
	public String getRewardType() {
		return rewardType;
	}
	public void setRewardType(String rewardType) {
		this.rewardType = rewardType;
	}
}
