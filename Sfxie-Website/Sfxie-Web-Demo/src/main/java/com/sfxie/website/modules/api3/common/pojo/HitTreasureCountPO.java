package com.sfxie.website.modules.api3.common.pojo;


import java.io.Serializable;
import java.util.Date;

/**
 * Created by wangquan on 2014/10/30.
 */
public class HitTreasureCountPO implements Serializable {
    private Integer ID;
    private Integer userID;
    private Integer count;
    private Integer rewardCount;
    private Date createDate;

    //
    private Integer totalCount;

    public Integer getRewardCount() {
        return rewardCount;
    }

    public void setRewardCount(Integer rewardCount) {
        this.rewardCount = rewardCount;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

}
