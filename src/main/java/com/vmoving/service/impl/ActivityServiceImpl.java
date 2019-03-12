package com.vmoving.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vmoving.domain.Act_Participant_Record;
import com.vmoving.domain.Activity;
import com.vmoving.domain.UserBasicData;
import com.vmoving.dto.ParticipantInfo;
import com.vmoving.repository.ActParticipantRecordRepository;
import com.vmoving.repository.ActivityRepository;
import com.vmoving.repository.UserBasicDataRepository;
import com.vmoving.service.ActParticipantRecordService;
import com.vmoving.service.ActivityService;
import com.vmoving.service.PrivateMessageService;
import com.vmoving.service.mapper.ActParticipantRecordMapper;
import com.vmoving.web.exceptions.RestServiceResultException;

@Service
public class ActivityServiceImpl implements ActivityService {

	private static final Logger log = LoggerFactory.getLogger(ActivityServiceImpl.class);

	@Autowired
	private ActivityRepository activityRepository;

	@Autowired
	private ActParticipantRecordService actParticipantService;

	@Autowired
	private ActParticipantRecordRepository actPRecordRepo;

	@Autowired
	private UserBasicDataRepository userBasicRepository;

	@Autowired
	private PrivateMessageService pMsgService;

	@Override
	public List<Activity> searchAllActivities() {
		// Sort sort = new Sort(Sort.Direction.DESC, "ACT_ID");
		return (List<Activity>) activityRepository.findAll().stream().filter(act -> act.getACT_STATUS_ID() != 1)
				.filter(act -> act.getACT_STATUS_ID() != 7).collect(Collectors.toList());
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

	public Activity jointoThisActivity(String openid, int actid, int actStatus, int userStatus) {
		// verification
		Activity act = null;
		try {
			UserBasicData user = userBasicRepository.findByOpenID(openid);
			if (user == null)
				throw new RestServiceResultException(5001, "您是否還沒有授權小程序");

			// 1. refresh the current activity status
			if (actid == 0)
				return act;
			act = this.refreshActivityStatus(actid, actStatus);

			// 2. People who joined this activity
			Act_Participant_Record searchedApr = actPRecordRepo.getAct_Participant_RecordByUserIdAndActId(actid,
					user.getUser_id());
			if (searchedApr != null && searchedApr.getAct_participant_record_id() > 0) {
				searchedApr.setIs_canceled(0);
				searchedApr.setUser_status_id(userStatus);

				actPRecordRepo.saveAndFlush(searchedApr);
			} else {
				Act_Participant_Record apr_entity = ActParticipantRecordMapper.toEntity(act, user.getUser_id(),
						userStatus);
				actParticipantService.saveAct_Participant_Record(apr_entity);
			}
			//3. 报名成功以后给，组织者发送一条消息
			
			if(act != null && act.getACT_ID() > 0) {
				//If the current user joined this activity,then the current user needs to send a message to organizer.
				String msgContent = "xxxx,用户已经成功报名这个活动！请查看或需要你审核！";
				 
				pMsgService.savePrivate_Message(user.getUser_id(), act.getORGANZIER_ID(),msgContent);
			}

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

	@Override
	public Activity findActivityByActId(int actId) {
		return activityRepository.findActivityByActId(actId);
	}

	@Override
	public boolean updateUserStatus(int act_id, int user_id, int userStatusId) {
		boolean isSuccess = false;
		try {
			Act_Participant_Record apr = actPRecordRepo.getAct_Participant_RecordByUserIdAndActId(act_id, user_id);
			if (apr != null && apr.getUser_status_id() == 1) {
				apr.setUser_status_id(userStatusId);
//				 actPRecordRepo.updateAct_Participant_RecordByUserIdAndActId(apr.getAct_participant_record_id(),userStatusId);
				actPRecordRepo.saveAndFlush(apr);
			}

			isSuccess = true;
		} catch (Exception e) {
			isSuccess = false;
			log.error(e.getMessage());
		}

		return isSuccess;
	}

	@Override
	public ParticipantInfo isUserJoinedAct(String openId, int actId) {
		ParticipantInfo participant = new ParticipantInfo();
		try {
			UserBasicData user = userBasicRepository.findByOpenID(openId);
			if (user != null) {
				int userId = user.getUser_id();

				Act_Participant_Record actPartRecord = actPRecordRepo.getAct_Participant_RecordByUserIdAndActId(actId,
						userId);
				if (actPartRecord != null && actPartRecord.getUser_id() > 0
						&& actPartRecord.getAct_participant_record_id() > 0) {
					participant.setIsCanceled(actPartRecord.getIs_canceled());
					participant.setUserId(actPartRecord.getUser_id());
					participant.setUserStatus(actPartRecord.getUser_status_id());
				}
			}
		} catch (Exception e) {
			log.error(e.getMessage());
		}

		return participant;
	}

	@Override
	public boolean cancelJoinedAct(String openId, int actId) {
		boolean isCanceled = false;
		try {
			UserBasicData user = userBasicRepository.findByOpenID(openId);
			if (user != null) {
				int userId = user.getUser_id();

				Act_Participant_Record actPartRecord = actPRecordRepo.getAct_Participant_RecordByUserIdAndActId(actId,
						userId);
				if (actPartRecord != null && actPartRecord.getUser_id() > 0) {
					// actPRecordRepo.delete(actPartRecord);
					actPartRecord.setIs_canceled(1);
					actPartRecord.setUser_status_id(3); // 报名取消
					actPRecordRepo.saveAndFlush(actPartRecord);
					isCanceled = true;
				}

				Activity act = activityRepository.findActivityByActId(actId);
				if (act != null && act.getACT_ID() > 0) {
					// If the current user canceled this activity,then the current user needs to
					// send a message to organizer.
					String msgContent = "xxxx,参与者已经成功取消了这个活动！";

					pMsgService.savePrivate_Message(user.getUser_id(), act.getORGANZIER_ID(), msgContent);
				}
			}
		} catch (Exception e) {
			log.error(e.getMessage());
		}

		return isCanceled;
	}

	@Override
	public boolean cancelActivity(int actStatus, int actId) {
		Activity activity = this.refreshActivityStatus(actId, actStatus);
		// 如果更新完的活动状态和参数活动状态传入的一样，说明更新成功。
		if (activity.getACT_STATUS_ID() == actStatus) {
			List<ParticipantInfo> participantInfos = actPRecordRepo.getAct_ParticipantInfos(actId);
			if (activity != null && activity.getACT_ID() > 0) {
				// If the current user canceled this activity,then the current user needs to
				// send a message to organizer.
				String msgContent = "xxxx,发起人已经成功取消了这个活动！";
				for (ParticipantInfo participantInfo : participantInfos) {
					pMsgService.savePrivate_Message(activity.getORGANZIER_ID(), participantInfo.getUserId(), msgContent);
				}

			}

			return true;
		}

		return false;
	}
}
