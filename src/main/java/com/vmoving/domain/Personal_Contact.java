package com.vmoving.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="personal_contact",schema="vmoving")
public class Personal_Contact implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int pcid;
	private String openid;
	private String concatway;
	private String concattype;
	public int getPcid() {
		return pcid;
	}
	public void setPcid(int pcid) {
		this.pcid = pcid;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public String getConcatway() {
		return concatway;
	}
	public void setConcatway(String concatway) {
		this.concatway = concatway;
	}
	public String getConcattype() {
		return concattype;
	}
	public void setConcattype(String concattype) {
		this.concattype = concattype;
	}
}
