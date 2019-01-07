package com.vmoving.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BADGE_CODE", schema = "vmoving")
public class BADGE_CODE implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int BADGE_ID;
	private String BADGE_NAME;
	private int ACT_TYPE_ID;
	public int getBADGE_ID() {
		return BADGE_ID;
	}
	public void setBADGE_ID(int bADGE_ID) {
		BADGE_ID = bADGE_ID;
	}
	public String getBADGE_NAME() {
		return BADGE_NAME;
	}
	public void setBADGE_NAME(String bADGE_NAME) {
		BADGE_NAME = bADGE_NAME;
	}
	public int getACT_TYPE_ID() {
		return ACT_TYPE_ID;
	}
	public void setACT_TYPE_ID(int aCT_TYPE_ID) {
		ACT_TYPE_ID = aCT_TYPE_ID;
	}
}
