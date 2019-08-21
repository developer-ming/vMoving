package com.vmoving.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_relationship_hub",schema="vmoving")
public class User_Relationship_Hub implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private int user_relationship_id;
	private int user_id;
	private int user2_id;
	private int relationship;
	private int valid_status;
	public int getUser_relationship_id() {
		return user_relationship_id;
	}
	public void setUser_relationship_id(int user_relationship_id) {
		this.user_relationship_id = user_relationship_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getUser2_id() {
		return user2_id;
	}
	public void setUser2_id(int user2_id) {
		this.user2_id = user2_id;
	}
	public int getRelationship() {
		return relationship;
	}
	public void setRelationship(int relationship) {
		this.relationship = relationship;
	}
	public int getValid_status() {
		return valid_status;
	}
	public void setValid_status(int valid_status) {
		this.valid_status = valid_status;
	}
	
}
