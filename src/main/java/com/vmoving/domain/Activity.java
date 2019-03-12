package com.vmoving.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ACTIVITY_DETAIL",schema="vmoving")
public class Activity  implements Serializable  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int ACT_ID;
	private String ACT_NAME;
	private int ACT_TYPE_ID;
	private String ACT_DATE;
	private String ACT_START_TIME;
	private String  ACT_End_Time;
	private String ACT_JOIN_EXPIRE_Date;
	private String ACT_PLACE_ADDRESS;
	private String ACT_PLACE_GPS;
	private String ACT_PLAYER_NUM;
	private int  REQUIRE_COMPETENCY_ID;
	private int ACT_FEE_TYPE;
	private int ACT_STATUS_ID;
	private String PICTURE_LINK;
	private int COURT_BOOKING_STATUS;
	private String COURTS;
	private int ORGANZIER_ID;
	private int RELEASE_TARGET_ID;
	private String WECHAT_GROUP_ID;
	private int MATCH_METHOD_TYPE;
	private String ACT_DETAIL;
	private String ACT_REMARK;
	private String act_place_location;
	private String openid;
	
	public Activity() {}

	public int getACT_ID() {
		return ACT_ID;
	}

	public void setACT_ID(int aCT_ID) {
		ACT_ID = aCT_ID;
	}

	public String getACT_NAME() {
		return ACT_NAME;
	}

	public void setACT_NAME(String aCT_NAME) {
		ACT_NAME = aCT_NAME;
	}

	public int getACT_TYPE_ID() {
		return ACT_TYPE_ID;
	}

	public void setACT_TYPE_ID(int aCT_TYPE_ID) {
		ACT_TYPE_ID = aCT_TYPE_ID;
	}

	public String getACT_DATE() {
		return ACT_DATE;
	}

	public void setACT_DATE(String aCT_DATE) {
		ACT_DATE = aCT_DATE;
	}

	public String getACT_START_TIME() {
		return ACT_START_TIME;
	}

	public void setACT_START_TIME(String aCT_START_TIME) {
		ACT_START_TIME = aCT_START_TIME;
	}

	public String getACT_End_Time() {
		return ACT_End_Time;
	}

	public void setACT_End_Time(String aCT_End_Time) {
		ACT_End_Time = aCT_End_Time;
	} 

	public String getACT_JOIN_EXPIRE_Date() {
		return ACT_JOIN_EXPIRE_Date;
	}

	public void setACT_JOIN_EXPIRE_Date(String aCT_JOIN_EXPIRE_Date) {
		ACT_JOIN_EXPIRE_Date = aCT_JOIN_EXPIRE_Date;
	}

	public String getACT_PLACE_ADDRESS() {
		return ACT_PLACE_ADDRESS;
	}

	public void setACT_PLACE_ADDRESS(String aCT_PLACE_ADDRESS) {
		ACT_PLACE_ADDRESS = aCT_PLACE_ADDRESS;
	}

	public String getACT_PLACE_GPS() {
		return ACT_PLACE_GPS;
	}

	public void setACT_PLACE_GPS(String aCT_PLACE_GPS) {
		ACT_PLACE_GPS = aCT_PLACE_GPS;
	}

	public String getACT_PLAYER_NUM() {
		return ACT_PLAYER_NUM;
	}

	public void setACT_PLAYER_NUM(String aCT_PLAYER_NUM) {
		ACT_PLAYER_NUM = aCT_PLAYER_NUM;
	}

	public int getREQUIRE_COMPETENCY_ID() {
		return REQUIRE_COMPETENCY_ID;
	}

	public void setREQUIRE_COMPETENCY_ID(int rEQUIRE_COMPETENCY_ID) {
		REQUIRE_COMPETENCY_ID = rEQUIRE_COMPETENCY_ID;
	}

	public int getACT_FEE_TYPE() {
		return ACT_FEE_TYPE;
	}

	public void setACT_FEE_TYPE(int aCT_FEE_TYPE) {
		ACT_FEE_TYPE = aCT_FEE_TYPE;
	}

	public int getACT_STATUS_ID() {
		return ACT_STATUS_ID;
	}

	public void setACT_STATUS_ID(int aCT_STATUS_ID) {
		ACT_STATUS_ID = aCT_STATUS_ID;
	}

	public String getPICTURE_LINK() {
		return PICTURE_LINK;
	}

	public void setPICTURE_LINK(String pICTURE_LINK) {
		PICTURE_LINK = pICTURE_LINK;
	}

	public int getCOURT_BOOKING_STATUS() {
		return COURT_BOOKING_STATUS;
	}

	public void setCOURT_BOOKING_STATUS(int cOURT_BOOKING_STATUS) {
		COURT_BOOKING_STATUS = cOURT_BOOKING_STATUS;
	}

	public String getCOURTS() {
		return COURTS;
	}

	public void setCOURTS(String cOURTS) {
		COURTS = cOURTS;
	}

	public int getRELEASE_TARGET_ID() {
		return RELEASE_TARGET_ID;
	}

	public void setRELEASE_TARGET_ID(int rELEASE_TARGET_ID) {
		RELEASE_TARGET_ID = rELEASE_TARGET_ID;
	}

	public int getORGANZIER_ID() {
		return ORGANZIER_ID;
	}

	public void setORGANZIER_ID(int oRGANZIER_ID) {
		ORGANZIER_ID = oRGANZIER_ID;
	}

 
	public String getWECHAT_GROUP_ID() {
		return WECHAT_GROUP_ID;
	}

	public void setWECHAT_GROUP_ID(String wECHAT_GROUP_ID) {
		WECHAT_GROUP_ID = wECHAT_GROUP_ID;
	}

	public int getMATCH_METHOD_TYPE() {
		return MATCH_METHOD_TYPE;
	}

	public void setMATCH_METHOD_TYPE(int mATCH_METHOD_TYPE) {
		MATCH_METHOD_TYPE = mATCH_METHOD_TYPE;
	}

	public String getACT_DETAIL() {
		return ACT_DETAIL;
	}

	public void setACT_DETAIL(String aCT_DETAIL) {
		ACT_DETAIL = aCT_DETAIL;
	}

	public String getACT_REMARK() {
		return ACT_REMARK;
	}

	public void setACT_REMARK(String aCT_REMARK) {
		ACT_REMARK = aCT_REMARK;
	}

	public String getAct_place_location() {
		return act_place_location;
	}

	public void setAct_place_location(String act_place_location) {
		this.act_place_location = act_place_location;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

}
