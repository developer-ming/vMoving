package com.vmoving.dto;

import java.io.Serializable;
import java.util.Date;

public class ParticipantInfo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int userId;
	private int actStatusId;
	private String nickName;
	private String avatarUrl;
	private String joindate;
	private int userStatus;
	 
	public ParticipantInfo() {}
	
	public ParticipantInfo(int userId,int actStatusId,String name,String avatar,String joindate,int userStatus) {
		super();
		this.userId = userId;
		this.actStatusId = actStatusId;
		this.nickName = name;
		this.avatarUrl = avatar;
		this.joindate = joindate;
		this.userStatus = userStatus;
		 
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
	public String getJoindate() {
		return joindate;
	}
	public void setJoindate(String joindate) {
		this.joindate = joindate;
	}

	public int getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(int userStatus) {
		this.userStatus = userStatus;
	}

	public int getActStatusId() {
		return actStatusId;
	}

	public void setActStatusId(int actStatusId) {
		this.actStatusId = actStatusId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
}
