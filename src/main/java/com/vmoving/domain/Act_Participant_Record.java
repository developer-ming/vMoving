package com.vmoving.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema = "vmoving", name = "act_participant_record")
public class Act_Participant_Record {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int act_participant_record_id;
	
	private int act_id;
	private int act_type_id;
	private int user_id;
	private int user_status_id;
	private String step_count;
	private String calorie;
	private String hours;
	private String joindate;
	private int is_canceled;
	private int daka_status;
	private String comments;
	public int getAct_participant_record_id() {
		return act_participant_record_id;
	}
	public void setAct_participant_record_id(int act_participant_record_id) {
		this.act_participant_record_id = act_participant_record_id;
	}
	public int getAct_id() {
		return act_id;
	}
	public void setAct_id(int act_id) {
		this.act_id = act_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getUser_status_id() {
		return user_status_id;
	}
	public void setUser_status_id(int user_status_id) {
		this.user_status_id = user_status_id;
	}
	public String getStep_count() {
		return step_count;
	}
	public void setStep_count(String step_count) {
		this.step_count = step_count;
	}
	public String getCalorie() {
		return calorie;
	}
	public void setCalorie(String calorie) {
		this.calorie = calorie;
	}
 
	public String getJoindate() {
		return joindate;
	}
	public void setJoindate(String joindate) {
		this.joindate = joindate;
	}
	public int getIs_canceled() {
		return is_canceled;
	}
	public void setIs_canceled(int is_canceled) {
		this.is_canceled = is_canceled;
	}
	public String getHours() {
		return hours;
	}
	public void setHours(String hours) {
		this.hours = hours;
	}
	public int getAct_type_id() {
		return act_type_id;
	}
	public void setAct_type_id(int act_type_id) {
		this.act_type_id = act_type_id;
	}
	public int getDaka_status() {
		return daka_status;
	}
	public void setDaka_status(int daka_status) {
		this.daka_status = daka_status;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	 
}
