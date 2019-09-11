package com.vmoving.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema="vmoving",name="chat_room")
public class Chat_room implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private int char_room_id;
	private int actid;
	private int userid;
	private String usernickname;
	private String commenttdate;
	private String useravatorurl;
	private int iscancel;
	private String chatcontent;
	public int getChar_room_id() {
		return char_room_id;
	}
	public void setChar_room_id(int char_room_id) {
		this.char_room_id = char_room_id;
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
	public String getUsernickname() {
		return usernickname;
	}
	public void setUsernickname(String usernickname) {
		this.usernickname = usernickname;
	}
	public String getCommenttdate() {
		return commenttdate;
	}
	public void setCommenttdate(String commenttdate) {
		this.commenttdate = commenttdate;
	}
	public String getUseravatorurl() {
		return useravatorurl;
	}
	public void setUseravatorurl(String useravatorurl) {
		this.useravatorurl = useravatorurl;
	}
	public int getIscancel() {
		return iscancel;
	}
	public void setIscancel(int iscancel) {
		this.iscancel = iscancel;
	}
	public String getChatcontent() {
		return chatcontent;
	}
	public void setChatcontent(String chatcontent) {
		this.chatcontent = chatcontent;
	}

}
