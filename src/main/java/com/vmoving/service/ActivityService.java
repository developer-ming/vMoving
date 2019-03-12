package com.vmoving.service;

import java.util.List;
import java.util.Optional;

import com.vmoving.domain.Activity;
import com.vmoving.dto.ParticipantInfo;

public interface ActivityService {

	public List<Activity> searchAllActivities();
	public List<Activity> searchActivitiesByActType(int actType);

	public Activity saveActivity(Activity act);

	public void deleteActivity(Activity act);

	public void deleteActivityByID(int actId);
	
	public Optional<Activity> findOneActById(int actId);
	
	public Activity findActivityByActId(int actId);
	
	public Activity refreshActivityStatus(int actId ,int act_atatus);
	
	public Activity jointoThisActivity(String openid,int actid,int actStatus,int userStatus);
	
	public List<Activity> getActivitiesByActStatus(int actStatusId);
	
	public List<Activity> getActivitiesByOId(String openId);
	
	public boolean updateUserStatus(int act_id, int user_id,int userStatusId);
	
	public ParticipantInfo isUserJoinedAct(String openId,int actId);
	
	public boolean cancelJoinedAct(String openId,int actId);
	
	public boolean cancelActivity(int actStatusId,int actId);
	
 
	
}