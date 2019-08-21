package com.vmoving.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_favor_act_data", schema = "vmoving")
public class User_favor_act_data implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int USER_FAVOR_ACT_ID;
	private int User_ID;
	private int ACT_TYPE_ID;
	private int COMPETENCY_ID;
	private int PARTICIPANT_ACT_COUNT;
	private int ORGANIZED_ACT_COUNT;
	private int TOTAL_HOURS;
	private int TOTAL_EXPERIENCE;
	private int total_setps;
	private int total_calorie;

	public int getUSER_FAVOR_ACT_ID() {
		return USER_FAVOR_ACT_ID;
	}

	public void setUSER_FAVOR_ACT_ID(int uSER_FAVOR_ACT_ID) {
		USER_FAVOR_ACT_ID = uSER_FAVOR_ACT_ID;
	}

	public int getUser_ID() {
		return User_ID;
	}

	public void setUser_ID(int user_ID) {
		User_ID = user_ID;
	}

	public int getACT_TYPE_ID() {
		return ACT_TYPE_ID;
	}

	public void setACT_TYPE_ID(int aCT_TYPE_ID) {
		ACT_TYPE_ID = aCT_TYPE_ID;
	}

	public int getCOMPETENCY_ID() {
		return COMPETENCY_ID;
	}

	public void setCOMPETENCY_ID(int cOMPETENCY_ID) {
		COMPETENCY_ID = cOMPETENCY_ID;
	}

	public int getPARTICIPANT_ACT_COUNT() {
		return PARTICIPANT_ACT_COUNT;
	}

	public void setPARTICIPANT_ACT_COUNT(int pARTICIPANT_ACT_COUNT) {
		PARTICIPANT_ACT_COUNT = pARTICIPANT_ACT_COUNT;
	}

	public int getORGANIZED_ACT_COUNT() {
		return ORGANIZED_ACT_COUNT;
	}

	public void setORGANIZED_ACT_COUNT(int oRGANIZED_ACT_COUNT) {
		ORGANIZED_ACT_COUNT = oRGANIZED_ACT_COUNT;
	}

	public int getTOTAL_HOURS() {
		return TOTAL_HOURS;
	}

	public void setTOTAL_HOURS(int tOTAL_HOURS) {
		TOTAL_HOURS = tOTAL_HOURS;
	}

	public int getTOTAL_EXPERIENCE() {
		return TOTAL_EXPERIENCE;
	}

	public void setTOTAL_EXPERIENCE(int tOTAL_EXPERIENCE) {
		TOTAL_EXPERIENCE = tOTAL_EXPERIENCE;
	}

	public int getTotal_setps() {
		return total_setps;
	}

	public void setTotal_setps(int total_setps) {
		this.total_setps = total_setps;
	}

	public int getTotal_calorie() {
		return total_calorie;
	}

	public void setTotal_calorie(int total_calorie) {
		this.total_calorie = total_calorie;
	}

}
