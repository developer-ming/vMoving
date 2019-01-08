package com.vmoving.dto;

import java.io.Serializable;
import java.util.Date;

public class ParticipantInfo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nickName;
	private String avatarUrl;
	private Date joindate;
	 
	public ParticipantInfo() {}
	
	public ParticipantInfo(String name,String avatar,Date joindate) {
		super();
		this.nickName = name;
		this.avatarUrl = avatar;
		this.joindate = joindate;
		 
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
	public Date getJoindate() {
		return joindate;
	}
	public void setJoindate(Date joindate) {
		this.joindate = joindate;
	}
}
