package com.vmoving.dto;

import java.io.Serializable;
import java.util.List;

import com.vmoving.domain.UserComment;
import com.vmoving.domain.UserPraise;

public class ActCommentDto  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int actCommentId;
	private String opendid;
	private String nickName;
	private String avatarUrl;
	private int actid;
	private int acttypeid;
	private int userid;
	private int steps;
    private String spenthour;
    private int calorie;
	private String comments;
	private String uploadimagepaths;
	private String commentdate;
	private List<UserComment> userComments;
	private List<UserPraise> userPraises;
	private int likethiscount;
	private int isPraised;
	public String getOpendid() {
		return opendid;
	}
	public void setOpendid(String opendid) {
		this.opendid = opendid;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getAvatarUrl() {
		return avatarUrl;
	}
	public void setAvatarUrl(String avatarUrl) {
		this.avatarUrl = avatarUrl;
	}
	public int getActid() {
		return actid;
	}
	public void setActid(int actid) {
		this.actid = actid;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public String getUploadimagepaths() {
		return uploadimagepaths;
	}
	public void setUploadimagepaths(String uploadimagepaths) {
		this.uploadimagepaths = uploadimagepaths;
	}
	public String getCommentdate() {
		return commentdate;
	}
	public void setCommentdate(String commentdate) {
		this.commentdate = commentdate;
	}
	 
	public String getSpenthour() {
		return spenthour;
	}
	public void setSpenthour(String spenthour) {
		this.spenthour = spenthour;
	}
	public int getCalorie() {
		return calorie;
	}
	public void setCalorie(int calorie) {
		this.calorie = calorie;
	}
	public int getSteps() {
		return steps;
	}
	public void setSteps(int steps) {
		this.steps = steps;
	}
	public int getActtypeid() {
		return acttypeid;
	}
	public void setActtypeid(int acttypeid) {
		this.acttypeid = acttypeid;
	}
	public int getActCommentId() {
		return actCommentId;
	}
	public void setActCommentId(int actCommentId) {
		this.actCommentId = actCommentId;
	}
	public List<UserComment> getUserComments() {
		return userComments;
	}
	public void setUserComments(List<UserComment> userComments) {
		this.userComments = userComments;
	}
	public List<UserPraise> getUserPraises() {
		return userPraises;
	}
	public void setUserPraises(List<UserPraise> userPraises) {
		this.userPraises = userPraises;
	}
	
	public void setLikethiscount(int likethiscount) {
		this.likethiscount = likethiscount;
	}
	
	public int getLikethiscount() {
		return likethiscount;
	}
	public int getIsPraised() {
		return isPraised;
	}
	public void setIsPraised(int isPraised) {
		this.isPraised = isPraised;
	}
	
	
}
