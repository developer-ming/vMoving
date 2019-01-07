package com.vmoving.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USER_STD_COMMENT_CODE", schema = "vmoving")
public class USER_STD_COMMENT_CODE implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int USER_STD_COMMENT_ID;
	private String COMMENT_CONTENT;

	public int getUSER_STD_COMMENT_ID() {
		return USER_STD_COMMENT_ID;
	}

	public void setUSER_STD_COMMENT_ID(int uSER_STD_COMMENT_ID) {
		USER_STD_COMMENT_ID = uSER_STD_COMMENT_ID;
	}

	public String getCOMMENT_CONTENT() {
		return COMMENT_CONTENT;
	}

	public void setCOMMENT_CONTENT(String cOMMENT_CONTENT) {
		COMMENT_CONTENT = cOMMENT_CONTENT;
	}
}
