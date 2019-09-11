package com.vmoving.dto;

import java.io.Serializable;

public class MyFriendsDto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int user_id;
	private String openid;
	private String gender;
	private String nickName;
	private String avatarUrl;
	private int acttype;
	
	public MyFriendsDto(int user_id,String openid,String gender,String nickName,String avatarUrl, int acttype) {
		this.user_id = user_id;
		this.openid = openid;
		this.gender = gender;
		this.nickName = nickName;
		this.avatarUrl = avatarUrl;
		this.acttype = acttype;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getAvatarUrl() {
		return avatarUrl;
	}
	public void setAvatarUrl(String avatarUrl) {
		this.avatarUrl = avatarUrl;
	}
	public int getActtype() {
		return acttype;
	}
	public void setActtype(int acttype) {
		this.acttype = acttype;
	}
 
}
