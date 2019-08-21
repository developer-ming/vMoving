package com.vmoving.dto;

import java.io.Serializable;

public class UserCommentDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int uCommentId;
	private int actCommentId;
	private String openid;
	private int userId;
	private String userNickame;
	private String userAvatorurl;
	private String userComments;
	private String commentDate;
	private int isCancel;
	public int getuCommentId() {
		return uCommentId;
	}
	public void setuCommentId(int uCommentId) {
		this.uCommentId = uCommentId;
	}
	public int getActCommentId() {
		return actCommentId;
	}
	public void setActCommentId(int actCommentId) {
		this.actCommentId = actCommentId;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
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
	public String getUserComments() {
		return userComments;
	}
	public void setUserComments(String userComments) {
		this.userComments = userComments;
	}
	public String getCommentDate() {
		return commentDate;
	}
	public void setCommentDate(String commentDate) {
		this.commentDate = commentDate;
	}
	public int getIsCancel() {
		return isCancel;
	}
	public void setIsCancel(int isCancel) {
		this.isCancel = isCancel;
	}

}
