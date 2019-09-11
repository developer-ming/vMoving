package com.vmoving.dto;

import java.io.Serializable;

public class SendMessageToFriendsDto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int user_id;
	private int user2_id;
	private int relationship;
	private int valid_status;
	private int acttype;
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getUser2_id() {
		return user2_id;
	}
	public void setUser2_id(int user2_id) {
		this.user2_id = user2_id;
	}
	public int getRelationship() {
		return relationship;
	}
	public void setRelationship(int relationship) {
		this.relationship = relationship;
	}
	public int getValid_status() {
		return valid_status;
	}
	public void setValid_status(int valid_status) {
		this.valid_status = valid_status;
	}
	public int getActtype() {
		return acttype;
	}
	public void setActtype(int acttype) {
		this.acttype = acttype;
	}
}
