package com.vmoving.dto;

import java.io.Serializable;

public class UserFavorDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public int acttypeid;
	public int userid;
	public int compenencyid;
	public int getActtypeid() {
		return acttypeid;
	}
	public void setActtypeid(int acttypeid) {
		this.acttypeid = acttypeid;
	}
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
	
}
