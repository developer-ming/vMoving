package com.vmoving.dto;

import java.io.Serializable;

public class LikeActivity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String ACTIVITY_TYPE;
	private int COMPETENCY_ID;
	private String COMPETENCY_TYPE;
	
	public LikeActivity() {}
	public LikeActivity(String acttype,int competency_id,String competency_type) {
		this.ACTIVITY_TYPE = acttype;
		this.COMPETENCY_ID = competency_id;
		this.COMPETENCY_TYPE =competency_type;
	}
	public String getACTIVITY_TYPE() {
		return ACTIVITY_TYPE;
	}
	public void setACTIVITY_TYPE(String aCTIVITY_TYPE) {
		ACTIVITY_TYPE = aCTIVITY_TYPE;
	}
	public int getCOMPETENCY_ID() {
		return COMPETENCY_ID;
	}
	public void setCOMPETENCY_ID(int cOMPETENCY_ID) {
		COMPETENCY_ID = cOMPETENCY_ID;
	}
	public String getCOMPETENCY_TYPE() {
		return COMPETENCY_TYPE;
	}
	public void setCOMPETENCY_TYPE(String cOMPETENCY_TYPE) {
		COMPETENCY_TYPE = cOMPETENCY_TYPE;
	}
	 

}
