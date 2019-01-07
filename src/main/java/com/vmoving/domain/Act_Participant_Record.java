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
	private int user_id;
	private int user_status_id;
	private int step_count;
	private int calorie;
	private int overall_exp_gain;
	private Date joindate;
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
	public int getStep_count() {
		return step_count;
	}
	public void setStep_count(int step_count) {
		this.step_count = step_count;
	}
	public int getCalorie() {
		return calorie;
	}
	public void setCalorie(int calorie) {
		this.calorie = calorie;
	}
	public int getOverall_exp_gain() {
		return overall_exp_gain;
	}
	public void setOverall_exp_gain(int overall_exp_gain) {
		this.overall_exp_gain = overall_exp_gain;
	}
	public Date getJoindate() {
		return joindate;
	}
	public void setJoindate(Date joindate) {
		this.joindate = joindate;
	}
}
