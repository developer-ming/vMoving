package com.vmoving.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="act_comment",schema="vmoving")
public class ActComment implements Serializable {
	 
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int act_comment_id;
	private int comment_provider_id;
	private int act_id;
	private String act_comment_free_text;
	private int star_rating;
	private String uploadimagepath;
	private Date commentdate;
	
	public int getAct_comment_id() {
		return act_comment_id;
	}
	public void setAct_comment_id(int act_comment_id) {
		this.act_comment_id = act_comment_id;
	}
	public int getComment_provider_id() {
		return comment_provider_id;
	}
	public void setComment_provider_id(int comment_provider_id) {
		this.comment_provider_id = comment_provider_id;
	}
	public int getAct_id() {
		return act_id;
	}
	public void setAct_id(int act_id) {
		this.act_id = act_id;
	}
	public String getAct_comment_free_text() {
		return act_comment_free_text;
	}
	public void setAct_comment_free_text(String act_comment_free_text) {
		this.act_comment_free_text = act_comment_free_text;
	}
	public int getStar_rating() {
		return star_rating;
	}
	public void setStar_rating(int star_rating) {
		this.star_rating = star_rating;
	}
	public String getUploadimagepath() {
		return uploadimagepath;
	}
	public void setUploadimagepath(String uploadimagepath) {
		this.uploadimagepath = uploadimagepath;
	}
	public Date getCommentdate() {
		return commentdate;
	}
	public void setCommentdate(Date commentdate) {
		this.commentdate = commentdate;
	}
}
