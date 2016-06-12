package com.sfxie.extension.mybatis.test.entity;

public class User {
 
    private int id;
    private int state;
    private String nickname;
    private String xsf;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getState() {
        return state;
    }
    public void setState(int state) {
        this.state = state;
    }
    public String getNickname() {
        return nickname;
    }
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
	public String getXsf() {
		return xsf;
	}
	public void setXsf(String xsf) {
		this.xsf = xsf;
	}
    
}
