package com.vmoving.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "private_message", schema = "vmoving")
public class Private_Message {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int private_message_id;
	private int SENDER_ID;
	private int RECEIVER_ID;
	private String PRIVATE_MESSAGE_CONTENT;
	private int READ_UNREAD;
	private Date TIME_STAMP;
	private String ActName;
	private int ActId;
	private int ActStatus;
	private int messagetype;

	public int getPrivate_message_id() {
		return private_message_id;
	}

	public void setPrivate_message_id(int private_message_id) {
		this.private_message_id = private_message_id;
	}

	public int getSENDER_ID() {
		return SENDER_ID;
	}

	public void setSENDER_ID(int sENDER_ID) {
		SENDER_ID = sENDER_ID;
	}

	public int getRECEIVER_ID() {
		return RECEIVER_ID;
	}

	public void setRECEIVER_ID(int rECEIVER_ID) {
		RECEIVER_ID = rECEIVER_ID;
	}

	public String getPRIVATE_MESSAGE_CONTENT() {
		return PRIVATE_MESSAGE_CONTENT;
	}

	public void setPRIVATE_MESSAGE_CONTENT(String pRIVATE_MESSAGE_CONTENT) {
		PRIVATE_MESSAGE_CONTENT = pRIVATE_MESSAGE_CONTENT;
	}

	public int getREAD_UNREAD() {
		return READ_UNREAD;
	}

	public void setREAD_UNREAD(int rEAD_UNREAD) {
		READ_UNREAD = rEAD_UNREAD;
	}

	public Date getTIME_STAMP() {
		return TIME_STAMP;
	}

	public void setTIME_STAMP(Date tIME_STAMP) {
		TIME_STAMP = tIME_STAMP;
	}

	public String getActName() {
		return ActName;
	}

	public void setActName(String actName) {
		ActName = actName;
	}

	public int getActId() {
		return ActId;
	}

	public void setActId(int actId) {
		ActId = actId;
	}

	public int getActStatus() {
		return ActStatus;
	}

	public void setActStatus(int actStatus) {
		ActStatus = actStatus;
	}

	public int getMessagetype() {
		return messagetype;
	}

	public void setMessagetype(int messagetype) {
		this.messagetype = messagetype;
	}
}
