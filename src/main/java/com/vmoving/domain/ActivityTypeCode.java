package com.vmoving.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "activity_type_code", schema = "vmoving")
public class ActivityTypeCode implements Serializable {
	
	public ActivityTypeCode() {}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ACT_TYPE_ID")
	private int actTypeId;

	@Column(name = "ACTIVITY_TYPE")
	private String activityTypeCode;

	public int getActTypeId() {
		return actTypeId;
	}

	public void setActTypeId(int actTypeId) {
		this.actTypeId = actTypeId;
	}

	public String getActivityTypeCode() {
		return activityTypeCode;
	}

	public void setActivityTypeCode(String activityTypeCode) {
		this.activityTypeCode = activityTypeCode;
	}
}

