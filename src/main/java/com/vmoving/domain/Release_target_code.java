package com.vmoving.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="release_target_code",schema="vmoving")
public class Release_target_code implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int release_target_id;
	private String release_target_type;

	public int getRelease_target_id() {
		return release_target_id;
	}

	public void setRelease_target_id(int release_target_id) {
		this.release_target_id = release_target_id;
	}

	public String getRelease_target_type() {
		return release_target_type;
	}

	public void setRelease_target_type(String release_target_type) {
		this.release_target_type = release_target_type;
	}

}
