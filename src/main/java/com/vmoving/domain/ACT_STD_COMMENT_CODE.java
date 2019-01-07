package com.vmoving.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ACT_STD_COMMENT_CODE", schema = "vmoving")
public class ACT_STD_COMMENT_CODE implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ACT_STD_COMMENT_CONTENT_ID;
	private String COMMENT_CONTENT;

	public int getACT_STD_COMMENT_CONTENT_ID() {
		return ACT_STD_COMMENT_CONTENT_ID;
	}

	public void setACT_STD_COMMENT_CONTENT_ID(int aCT_STD_COMMENT_CONTENT_ID) {
		ACT_STD_COMMENT_CONTENT_ID = aCT_STD_COMMENT_CONTENT_ID;
	}

	public String getCOMMENT_CONTENT() {
		return COMMENT_CONTENT;
	}

	public void setCOMMENT_CONTENT(String cOMMENT_CONTENT) {
		COMMENT_CONTENT = cOMMENT_CONTENT;
	}
}
