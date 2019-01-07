package com.vmoving.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USER_STATUS_CODE", schema = "vmoving")
public class USER_STATUS_CODE implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int USER_STATUS_ID;
	private String USER_STATUS_STATUS;

	public int getUSER_STATUS_ID() {
		return USER_STATUS_ID;
	}

	public void setUSER_STATUS_ID(int uSER_STATUS_ID) {
		USER_STATUS_ID = uSER_STATUS_ID;
	}

	public String getUSER_STATUS_STATUS() {
		return USER_STATUS_STATUS;
	}

	public void setUSER_STATUS_STATUS(String uSER_STATUS_STATUS) {
		USER_STATUS_STATUS = uSER_STATUS_STATUS;
	}
}
