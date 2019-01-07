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
import com.vmoving.service.ActParticipantRecordService;
import com.vmoving.service.ActivityService;
import com.vmoving.service.mapper.ActivityMapper;

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
	 
			if (returnedAct != null && returnedAct.getACT_ID() > 0)
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
			act = act_service.jointoThisActivity(jtp.getOpenid(),jtp.getActid(),jtp.getActstatus());
			 
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
	

}