package com.vmoving.dto;

import java.io.Serializable;

public class UserFavorDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String actid;
	public String[] likesports;
	public int userid;
	public int compenencyid;
	 
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getCompenencyid() {
		return compenencyid;
	}
	public void setCompenencyid(int compenencyid) {
		this.compenencyid = compenencyid;
	}
	public String[] getLikesports() {
		return likesports;
	}
	public void setLikesports(String[] likesports) {
		this.likesports = likesports;
	}
	public String getActid() {
		return actid;
	}
	public void setActid(String actid) {
		this.actid = actid;
	}
}
