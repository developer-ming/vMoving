package com.vmoving.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ACT_MATCH_METHOD_CODE", schema = "vmoving")
public class ACT_MATCH_METHOD_CODE implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ACT_MATCH_METHOD_ID;
	private String ACT_MATCH_METHOD;

	public int getACT_MATCH_METHOD_ID() {
		return ACT_MATCH_METHOD_ID;
	}

	public void setACT_MATCH_METHOD_ID(int aCT_MATCH_METHOD_ID) {
		ACT_MATCH_METHOD_ID = aCT_MATCH_METHOD_ID;
	}

	public String getACT_MATCH_METHOD() {
		return ACT_MATCH_METHOD;
	}

	public void setACT_MATCH_METHOD(String aCT_MATCH_METHOD) {
		ACT_MATCH_METHOD = aCT_MATCH_METHOD;
	}
}
