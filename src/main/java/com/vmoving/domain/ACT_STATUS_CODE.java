package com.vmoving.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ACT_STATUS_CODE", schema = "vmoving")
public class ACT_STATUS_CODE implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ACT_STATUS_ID;
	private String ACT_STATUS;

	public int getACT_STATUS_ID() {
		return ACT_STATUS_ID;
	}

	public void setACT_STATUS_ID(int aCT_STATUS_ID) {
		ACT_STATUS_ID = aCT_STATUS_ID;
	}

	public String getACT_STATUS() {
		return ACT_STATUS;
	}

	public void setACT_STATUS(String aCT_STATUS) {
		ACT_STATUS = aCT_STATUS;
	}
}
