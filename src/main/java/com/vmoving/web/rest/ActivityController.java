package com.vmoving.web.rest;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vmoving.domain.Act_Participant_Record;
import com.vmoving.domain.Activity;
import com.vmoving.dto.ActivityDTO;
import com.vmoving.dto.JoinToActParams;
import com.vmoving.dto.ParticipantInfo;
import com.vmoving.dto.UserStatusParams;
import com.vmoving.service.ActParticipantRecordService;
import com.vmoving.service.ActivityService;
import com.vmoving.service.mapper.ActivityMapper;

import lombok.experimental.var;

@RestController
public class ActivityController {
	private static final Logger log = LoggerFactory.getLogger(ActivityController.class);

	@Autowired
	private ActivityService act_service;

	@Autowired
	private ActivityMapper actMapper;
	
	@Autowired
	private ActParticipantRecordService actParticipantService;

	@GetMapping(path = "/api/greeting")
	public String greeting(@RequestParam String name) {
		log.info("Greeting is ok");
		return "Hello world!, " + name;
	}

	@PostMapping(path = "/api/createActivity")
	public Activity CreateActivity(@RequestBody ActivityDTO act) {
		try {
			Activity activity = actMapper.dtoToEntity(act);
			Activity returnedAct = act_service.saveActivity(activity);
	 
			if (returnedAct != null && returnedAct.getACT_ID() > 0) {
				int userStatus = 0;
				if(returnedAct.getACT_STATUS_ID() == 2) {
					userStatus = 2;
				}else if(returnedAct.getACT_STATUS_ID() == 1) {
					userStatus = 1;
				}
				Activity joinActStus =  act_service.jointoThisActivity(act.getOpenId(),returnedAct.getACT_ID(),returnedAct.getACT_STATUS_ID(),userStatus);
				if(joinActStus != null) {
					log.info("Join successfully");
				}
			}
				return returnedAct;
			
			
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return null;
	}

	@GetMapping(path = "/api/getAllActivities")
	public List<Activity> getAllActivities() {
		try {
			return act_service.searchAllActivities();
		} catch (Exception e) {
			log.error(e.getMessage());
		}

		return null;
	}

	@GetMapping(path = "/api/getSpecificActivities")
	public List<Activity> getActivitiesByActType(@RequestParam int actType) {

		try {
		  return act_service.searchActivitiesByActType(actType);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return null;
	}

	@GetMapping(path = "/api/getOneActivity")
	public Optional<Activity> getOneActivity(@RequestParam int actId) {
		try {
			return act_service.findOneActById(actId);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return null;
	}
	
	@PostMapping(path="/api/jointoActivity")
	public Activity jointoThisActivity(@RequestBody JoinToActParams jtp){
		Activity act = null;
		try {
			act = act_service.jointoThisActivity(jtp.getOpenid(),jtp.getActid(),jtp.getActstatus(),jtp.getUserStatus());
			 
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return act;
	}
	

	@GetMapping(path = "/api/getParticipantList")
	public List<ParticipantInfo> getAct_ParticipantRecordsByactId(@RequestParam int actId) {
		try {
			return actParticipantService.getAct_ParticipantInfos(actId);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return null;
	}
	
	@GetMapping(path="/api/getActivitiesByActStatus")
	public List<Activity> getActivitiesByActStatus(@RequestParam int actStatusId){
		try {
			return act_service.getActivitiesByActStatus(actStatusId);
		} catch (Exception e) {
			log.error(e.getMessage(),e);
		}
		return null;
	}
	
	@GetMapping(path="/api/getActivitiesByOId")
	public List<Activity> getActivitiesByOId(@RequestParam String openId){
		try {
			return act_service.getActivitiesByOId(openId);
		} catch (Exception e) {
			log.error(e.getMessage(),e);
		}
		return null;
	}
	
	@PostMapping(path = "/api/updateUserStatus")
	public boolean UpdateUserStatus(@RequestBody UserStatusParams userStatus) {
		
		try {
			 int userId = userStatus.getUser_id();
			 int act_id = userStatus.getAct_status_id();
			 int userStatus_id = userStatus.getUser_status_id();
			 
			 return act_service.updateUserStatus(act_id,userId,userStatus_id);
			
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		
		return false;
	}

}