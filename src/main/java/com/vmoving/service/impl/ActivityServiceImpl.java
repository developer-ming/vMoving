package com.vmoving.service.impl;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.stereotype.Service;

import com.vmoving.domain.Act_Participant_Record;
import com.vmoving.domain.Activity;
import com.vmoving.domain.Private_Message;
import com.vmoving.domain.UserBasicData;
import com.vmoving.dto.ParticipantInfo;
import com.vmoving.repository.ActParticipantRecordRepository;
import com.vmoving.repository.ActivityRepository;
import com.vmoving.repository.UserBasicDataRepository;
import com.vmoving.service.ActParticipantRecordService;
import com.vmoving.service.ActivityService;
import com.vmoving.service.PrivateMessageService;
import com.vmoving.service.UserService;
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
	private UserService userService;
	
	@Autowired
	private PrivateMessageService pMsgService;

	@Override
	public List<Activity> searchAllActivities() {
		// Sort sort = new Sort(Sort.Direction.DESC, "ACT_ID");
		return (List<Activity>) activityRepository.findAll().stream().filter(act -> act.getACT_STATUS_ID() == 2)
//				.filter(act -> act.getACT_STATUS_ID() != 3)
//				.filter(act -> act.getACT_STATUS_ID() != 5)
//				.filter(act -> act.getACT_STATUS_ID() != 6)
//				.filter(act -> act.getACT_STATUS_ID() != 7)
				.sorted(Comparator.comparing(Activity::getACT_ID).reversed())
				.collect(Collectors.toList());
	}

	@Override
	public Activity saveActivity(Activity act) {
		Activity existedAct = activityRepository.findActivityByActId(act.getACT_ID());
		if(existedAct!= null && existedAct.getACT_ID() > 0) {
			//if the name,date,person numbers and place address same as new activity, it should show to user that you have duplicated activity
			if(existedAct.getACT_NAME()== act.getACT_NAME() && existedAct.getACT_DATE()  == act.getACT_DATE()
			   &&existedAct.getACT_PLAYER_NUM() == act.getACT_PLAYER_NUM() 
			   && existedAct.getACT_PLACE_ADDRESS() == act.getACT_PLACE_ADDRESS()) {
				
				 existedAct.setACT_STATUS_ID(9999);
			}

		   return existedAct;
		}
		
		return activityRepository.save(act);
	}
	
	@Override
	public Activity editActivity(Activity act) {
		return activityRepository.saveAndFlush(act);
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
			Activity  resActivity = activityRepository.saveAndFlush(act);
			 
			List<Act_Participant_Record> actpList = actParticipantService.getAct_ParticipantRecordsByactId(act.getACT_ID());
			 
			if(act_atatus == 6) {
				try {
					//所加入的人发送打卡信息,排除已经取消的人
					for (Act_Participant_Record userp : actpList) {
						if(userp.getIs_canceled() != 1) {
							//如果活动已经完成，自动更新用户状态
							userp.setUser_status_id(5); //已完成活动
							actPRecordRepo.saveAndFlush(userp);
							
							String msgContent = resActivity.getACT_NAME()+"活动已经完成，请及时打卡!";
							
							pMsgService.savePrivate_Message(act.getORGANZIER_ID(),userp.getUser_id(), actId,act.getACT_NAME(),act.getACT_STATUS_ID(),msgContent);
						}
					}
				} catch (Exception e) {
					throw e;
				}
				
			}
			 
			return resActivity;
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
			
			Act_Participant_Record searchedApr = actPRecordRepo.getAct_Participant_RecordByUserIdAndActId(actid,user.getUser_id());
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
			List<Act_Participant_Record> actpList = actParticipantService.getAct_ParticipantRecordsByactId(actid);
			actpList = actpList.stream().filter(a-> a.getIs_canceled() != 1).collect(Collectors.toList());
			 
			if(act != null && act.getACT_ID() > 0 && act.getORGANZIER_ID() != user.getUser_id()) {
				//If the current user joined this activity,then the current user needs to send a message to organizer.
				String msgContent  = "";
				//由我来定
			    int playNum = act.getACT_PLAYER_NUM() == "人数不限"?99999:Integer.parseInt(act.getACT_PLAYER_NUM());
				if(act.getMATCH_METHOD_TYPE() == 2 ) {
					 msgContent =  "参与者\""+user.getNickName()+"\"报名了"+act.getACT_NAME()+",需要你的审核！";
				}else {
					if(actpList.size() > playNum)
					{
						msgContent =  "参与者\""+user.getNickName()+"\"报名了"+act.getACT_NAME()+",需要你的审核！";
					}
					else {
						msgContent =  "参与者\""+user.getNickName()+"\"报名接龙已成功！";
					}
				}
				 
				pMsgService.savePrivate_Message(user.getUser_id(), act.getORGANZIER_ID(), actid,act.getACT_NAME(),act.getACT_STATUS_ID() ,msgContent);
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
				
				Activity act = activityRepository.findActivityByActId(act_id);
				UserBasicData user = userService.findUserByUserId(user_id);
				String msgContent =  "你的活动"+act.getACT_NAME()+"申请审核已通过！";

				pMsgService.savePrivate_Message(act.getORGANZIER_ID(),user_id, act_id,act.getACT_NAME(),act.getACT_STATUS_ID(), msgContent);
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
					participant.setAvatarUrl(user.getAvatarUrl());
					participant.setNickName(user.getNickName());
					participant.setJoindate(actPartRecord.getJoindate());
					
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
					String msgContent = "参与者\""+user.getNickName()+ "\"取消了活动"+act.getACT_NAME()+"的报名！";

					pMsgService.savePrivate_Message(user.getUser_id(), act.getORGANZIER_ID(),act.getACT_ID(), act.getACT_NAME(),act.getACT_STATUS_ID(), msgContent);
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
				UserBasicData user = userBasicRepository.findByOpenID(activity.getOpenid());
				// If the current user canceled this activity,then the current user needs to
				// send a message to organizer.
				String msgContent = "发起人\""+ user.getNickName()+ "\"取消了活动"+activity.getACT_NAME()+"!";
				for (ParticipantInfo participantInfo : participantInfos) {
					if(participantInfo.getUserId() == activity.getORGANZIER_ID()) 
						continue;
					pMsgService.savePrivate_Message(activity.getORGANZIER_ID(), participantInfo.getUserId(), activity.getACT_ID()
							,activity.getACT_NAME(),activity.getACT_STATUS_ID(),msgContent);
				}
			}

			return true;
		}

		return false;
	}
}
