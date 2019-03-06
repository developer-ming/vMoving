package com.vmoving.dto;

public class UserStatusParams {
	private int user_id;
	private int act_status_id;
	private  int  user_status_id;
	public int getAct_status_id() {
		return act_status_id;
	}
	public void setAct_status_id(int act_status_id) {
		this.act_status_id = act_status_id;
	}
	public int getUser_status_id() {
		return user_status_id;
	}
	public void setUser_status_id(int user_status_id) {
		this.user_status_id = user_status_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	} 
}
