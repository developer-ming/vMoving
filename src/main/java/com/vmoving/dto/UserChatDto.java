package com.vmoving.dto;

import java.io.Serializable;

public class UserChatDto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int actid;
	private String openid;
	private int userid;
	private String userNickame;
	private String userAvatorurl;
	private String userchatcomment;
	private String chatDate;
	private int isCancel;
	public int getActid() {
		return actid;
	}
	public void setActid(int actid) {
		this.actid = actid;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getUserNickame() {
		return userNickame;
	}
	public void setUserNickame(String userNickame) {
		this.userNickame = userNickame;
	}
	public String getUserAvatorurl() {
		return userAvatorurl;
	}
	public void setUserAvatorurl(String userAvatorurl) {
		this.userAvatorurl = userAvatorurl;
	}
	 
	public String getChatDate() {
		return chatDate;
	}
	public void setChatDate(String chatDate) {
		this.chatDate = chatDate;
	}
	public int getIsCancel() {
		return isCancel;
	}
	public void setIsCancel(int isCancel) {
		this.isCancel = isCancel;
	}
	public String getUserchatcomment() {
		return userchatcomment;
	}
	public void setUserchatcomment(String userchatcomment) {
		this.userchatcomment = userchatcomment;
	}
}
