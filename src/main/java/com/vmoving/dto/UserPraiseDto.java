package com.vmoving.dto;

import java.io.Serializable;

public class UserPraiseDto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String openid;
	private int praiseid;
	private int act_comment_id;
	private int userpraise;
	private int userid;
	private String usernickname;
	private String useravatorurl;
	private String praisedate;
	private int ispraise;
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	 
	public int getAct_comment_id() {
		return act_comment_id;
	}
	public void setAct_comment_id(int act_comment_id) {
		this.act_comment_id = act_comment_id;
	}
	public int getUserpraise() {
		return userpraise;
	}
	public void setUserpraise(int userpraise) {
		this.userpraise = userpraise;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getUsernickname() {
		return usernickname;
	}
	public void setUsernickname(String usernickname) {
		this.usernickname = usernickname;
	}
	public String getUseravatorurl() {
		return useravatorurl;
	}
	public void setUseravatorurl(String useravatorurl) {
		this.useravatorurl = useravatorurl;
	}
	public String getPraisedate() {
		return praisedate;
	}
	public void setPraisedate(String praisedate) {
		this.praisedate = praisedate;
	}
	public int getIspraise() {
		return ispraise;
	}
	public void setIspraise(int ispraise) {
		this.ispraise = ispraise;
	}
	public int getPraiseid() {
		return praiseid;
	}
	public void setPraiseid(int praiseid) {
		this.praiseid = praiseid;
	}
}
