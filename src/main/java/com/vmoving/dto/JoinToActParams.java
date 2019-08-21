package com.vmoving.dto;

public class JoinToActParams {
	 private int actid;
	 private int actstatus;
	 private String openid;
	 private int userstatus;
	 private String usercomments;
	public int getActid() {
		return actid;
	}
	public void setActid(int actid) {
		this.actid = actid;
	}
	public int getActstatus() {
		return actstatus;
	}
	public void setActstatus(int actstatus) {
		this.actstatus = actstatus;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public int getUserstatus() {
		return userstatus;
	}
	public void setUserstatus(int userstatus) {
		this.userstatus = userstatus;
	}
	public String getUsercomments() {
		return usercomments;
	}
	public void setUsercomments(String usercomments) {
		this.usercomments = usercomments;
	}
	 
}
