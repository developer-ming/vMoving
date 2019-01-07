package com.vmoving.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ACT_FEE_TYPE_CODE", schema = "vmoving")
public class ACT_FEE_TYPE_CODE implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int ACT_FEE_TYPE_ID;
	private String ACT_FEE_TYPE;
	public int getACT_FEE_TYPE_ID() {
		return ACT_FEE_TYPE_ID;
	}
	public void setACT_FEE_TYPE_ID(int aCT_FEE_TYPE_ID) {
		ACT_FEE_TYPE_ID = aCT_FEE_TYPE_ID;
	}
	public String getACT_FEE_TYPE() {
		return ACT_FEE_TYPE;
	}
	public void setACT_FEE_TYPE(String aCT_FEE_TYPE) {
		ACT_FEE_TYPE = aCT_FEE_TYPE;
	}
}
