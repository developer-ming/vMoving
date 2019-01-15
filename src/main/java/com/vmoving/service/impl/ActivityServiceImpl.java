package com.vmoving.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.vmoving.domain.Act_Participant_Record;
import com.vmoving.domain.Activity;
import com.vmoving.domain.UserBasicData;
import com.vmoving.repository.ActivityRepository;
import com.vmoving.repository.UserBasicDataRepository;
import com.vmoving.service.ActParticipantRecordService;
import com.vmoving.service.ActivityService;
import com.vmoving.service.mapper.ActParticipantRecordMapper;
import com.vmoving.web.exceptions.RestServiceResultException;

@Service
public class ActivityServiceImpl implements ActivityService {

	private static final Logger log = LoggerFactory.getLogger(ActivityServiceImpl.class);

	@Autowired
	private ActivityRepository activityRepository;

	@Autowired
	private ActParticipantRecordService actParticipantRepo;

	@Autowired
	private UserBasicDataRepository userBasicRepository;

	@Override
	public List<Activity> searchAllActivities() {
		//Sort sort = new Sort(Sort.Direction.DESC, "ACT_ID");
		return (List<Activity>) activityRepository.findAll();
	}

	@Override
	public Activity saveActivity(Activity act) {
		return activityRepository.save(act);
	}

	@Override
	public void deleteActivity(Activity act) {
		activityRepository.delete(act);
	}

	@Override
	public void deleteActivityByID(int actId) {
		activityRepository.deleteById(actId);
	}

	@Override
	public Optional<Activity> findOneActById(int actId) {
		return activityRepository.findById(actId);
	}

	@Override
	public List<Activity> searchActivitiesByActType(int actType) {
		return activityRepository.findActivitiesByType(actType);
	}

	@Override
	public Activity refreshActivityStatus(int actId, int act_atatus) {
		Activity act = activityRepository.findActivityByActId(actId);
		if (act != null & act.getACT_ID() > 0) {
			act.setACT_STATUS_ID(act_atatus);
			return activityRepository.saveAndFlush(act);
		}
		return null;
	}

	public Activity jointoThisActivity(String openid, int actid, int actStatus) {
		// verification
		Activity act = null;
		try {
			UserBasicData user = userBasicRepository.findByOpenID(openid);
			if (user == null)
				throw new RestServiceResultException(5001, "您是否還沒有授權小程序");

			if (actParticipantRepo.isExistedInActParticipant(user.getUser_id(), actid))
				throw new RestServiceResultException(5002, "该用户已经加入了这个活动");
			// 1. refresh the current activity status
			if (actid == 0)
				return act;
			act = this.refreshActivityStatus(actid, actStatus);

			// 2. People who joined this activity
			Act_Participant_Record apr_entity = ActParticipantRecordMapper.toEntity(act, user.getUser_id());
			actParticipantRepo.saveAct_Participant_Record(apr_entity);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw e;
		}
		return act;
	}

	@Override
	public List<Activity> getActivitiesByActStatus(int actStatusId) {
		return activityRepository.findActivitiesByStatusId(actStatusId);
	}

	@Override
	public List<Activity> getActivitiesByOId(String openId) {
		UserBasicData user = userBasicRepository.findByOpenID(openId);
		return user != null && user.getUser_id() > 0 ? activityRepository.findActivitiesByOId(user.getUser_id()) : null;
	}
}
