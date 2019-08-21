package com.vmoving.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_comment", schema = "vmoving")
public class UserComment implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private int u_comment_id;
	private int act_comment_id;
	private int userid;
	private String usernickname;
	private String useravatorurl;
	private String usercomments;
	private String commentdate;
	private int iscancel;

	public int getU_comment_id() {
		return u_comment_id;
	}

	public void setU_comment_id(int u_comment_id) {
		this.u_comment_id = u_comment_id;
	}

	public int getAct_comment_id() {
		return act_comment_id;
	}

	public void setAct_comment_id(int act_comment_id) {
		this.act_comment_id = act_comment_id;
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

	public String getUsercomments() {
		return usercomments;
	}

	public void setUsercomments(String usercomments) {
		this.usercomments = usercomments;
	}

	public String getCommentdate() {
		return commentdate;
	}

	public void setCommentdate(String commentdate) {
		this.commentdate = commentdate;
	}

	public int getIscancel() {
		return iscancel;
	}

	public void setIscancel(int iscancel) {
		this.iscancel = iscancel;
	}

}
