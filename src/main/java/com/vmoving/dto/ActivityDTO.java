package com.vmoving.dto;

import java.io.Serializable;

public class ActivityDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int act_Id;
	private String act_title;
	private String act_type;
	private String ability;
	private String act_join_expire_date;
	private String act_start_date;
	private String act_start_time;
	private String act_end_time;
	private String activity_details;
	private String address;
	private Object gps;
	private String act_place_location;
	private String coverImage;
	private String avg_fee;
	private String closing_time;
	private String match_method;
	private String personnums;
	private String release_target;
	private String tips;
	private String openId;
	private String act_status;
 
	public String getAct_title() {
		return act_title;
	}
	public void setAct_title(String act_title) {
		this.act_title = act_title;
	}
	public String getAct_type() {
		return act_type;
	}
	public void setAct_type(String act_type) {
		this.act_type = act_type;
	}
	public String getAbility() {
		return ability;
	}
	public void setAbility(String ability) {
		this.ability = ability;
	}
	public String getAct_end_time() {
		return act_end_time;
	}
	public void setAct_end_time(String act_end_time) {
		this.act_end_time = act_end_time;
	}
	public String getAct_join_expire_date() {
		return act_join_expire_date;
	}
	public void setAct_join_expire_date(String act_join_expire_date) {
		this.act_join_expire_date = act_join_expire_date;
	}
	public String getAct_start_date() {
		return act_start_date;
	}
	public void setAct_start_date(String act_start_date) {
		this.act_start_date = act_start_date;
	}
	public String getAct_start_time() {
		return act_start_time;
	}
	public void setAct_start_time(String act_start_time) {
		this.act_start_time = act_start_time;
	}
	public String getActivity_details() {
		return activity_details;
	}
	public void setActivity_details(String activity_details) {
		this.activity_details = activity_details;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAvg_fee() {
		return avg_fee;
	}
	public void setAvg_fee(String avg_fee) {
		this.avg_fee = avg_fee;
	}
	public String getClosing_time() {
		return closing_time;
	}
	public void setClosing_time(String closing_time) {
		this.closing_time = closing_time;
	}
	public String getMatch_method() {
		return match_method;
	}
	public void setMatch_method(String match_method) {
		this.match_method = match_method;
	}
	public String getPersonnums() {
		return personnums;
	}
	public void setPersonnums(String personnums) {
		this.personnums = personnums;
	}
	public String getRelease_target() {
		return release_target;
	}
	public void setRelease_target(String release_target) {
		this.release_target = release_target;
	}
	public String getTips() {
		return tips;
	}
	public void setTips(String tips) {
		this.tips = tips;
	}
	 
	public String getOpenId() {
		return openId;
	}
	public void setOpenId(String openId) {
		this.openId = openId;
	}
	public String getAct_place_location() {
		return act_place_location;
	}
	public void setAct_place_location(String act_place_location) {
		this.act_place_location = act_place_location;
	}
	public Object getGps() {
		return gps;
	}
	public void setGps(Object gps) {
		this.gps = gps;
	}
	public String getCoverImage() {
		return coverImage;
	}
	public void setCoverImage(String coverImage) {
		this.coverImage = coverImage;
	}
	public String getAct_status() {
		return act_status;
	}
	public void setAct_status(String act_status) {
		this.act_status = act_status;
	}
	public int getAct_Id() {
		return act_Id;
	}
	public void setAct_Id(int act_Id) {
		this.act_Id = act_Id;
	}
}
