package com.vmoving.service;

import java.util.List;
import java.util.Optional;

import com.vmoving.domain.Activity;

public interface ActivityService {

	public List<Activity> searchAllActivities();
	public List<Activity> searchActivitiesByActType(int actType);

	public Activity saveActivity(Activity act);

	public void deleteActivity(Activity act);

	public void deleteActivityByID(int actId);
	
	public Optional<Activity> findOneActById(int actId);
	
	public Activity refreshActivityStatus(int actId ,int act_atatus);
	
	public Activity jointoThisActivity(String openid,int actid,int actStatus);
	
	public List<Activity> getActivitiesByActStatus(int actStatusId);
	
	public List<Activity> getActivitiesByOId(String openId);
	
}