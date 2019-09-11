package com.vmoving.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "COMPETENCY_CODE", schema = "vmoving")
public class COMPETENCY_CODE implements Serializable {
	/**
		 * 
		 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int COMPETENCY_ID;
	private int ActTypeId;
	private String COMPETENCY_TYPE;
	private String Competency_Description;

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

	public int getActTypeId() {
		return ActTypeId;
	}

	public void setActTypeId(int actTypeId) {
		ActTypeId = actTypeId;
	}

	public String getCompetency_Description() {
		return Competency_Description;
	}

	public void setCompetency_Description(String competency_Description) {
		Competency_Description = competency_Description;
	}
}
