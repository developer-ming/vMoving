package com.vmoving.dto;

import java.io.Serializable;

public class ParticipantInfo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int userId;
	private int actId;
	private String openid;
	private String nickName;
	private String avatarUrl;
	private String joindate;
	private int userStatus;
	private int isCanceled;
	private String comments;
	 
	public ParticipantInfo() {}
	
	public ParticipantInfo(int userId,int act_id,String openid,String name,String avatar,String joindate,int userStatus,String comments) {
		super();
		this.userId = userId;
		this.actId = act_id;
		this.openid = openid;
		this.nickName = name;
		this.avatarUrl = avatar;
		this.joindate = joindate;
		this.userStatus = userStatus;
		this.comments = comments; 
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

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getIsCanceled() {
		return isCanceled;
	}

	public void setIsCanceled(int isCanceled) {
		this.isCanceled = isCanceled;
	}

	public int getActId() {
		return actId;
	}

	public void setActId(int actId) {
		this.actId = actId;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}
}
