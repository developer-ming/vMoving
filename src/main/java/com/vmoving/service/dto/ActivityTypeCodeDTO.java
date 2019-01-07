package com.vmoving.service.dto;

import java.io.Serializable;

public class ActivityTypeCodeDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int actTypeId;
	private String activityTypeCode;
	public int getActTypeId() {
		return actTypeId;
	}
	public void setActTypeId(Integer actTypeId) {
		this.actTypeId = actTypeId;
	}
	public String getActivityTypeCode() {
		return activityTypeCode;
	}
	public void setActivityTypeCode(String activityTypeCode) {
		this.activityTypeCode = activityTypeCode;
	}
	 
}