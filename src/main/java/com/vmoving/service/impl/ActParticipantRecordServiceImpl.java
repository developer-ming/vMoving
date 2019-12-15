package com.vmoving.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vmoving.domain.Act_Participant_Record;
import com.vmoving.domain.UserBasicData;
import com.vmoving.dto.ParticipantInfo;
import com.vmoving.repository.ActParticipantRecordRepository;
import com.vmoving.service.ActParticipantRecordService;
import com.vmoving.service.UserService;

@Service
public class ActParticipantRecordServiceImpl implements ActParticipantRecordService {
	
	@Autowired
	private ActParticipantRecordRepository actPRecordRepo;
	
	@Autowired
	private UserService userService;

	@Override
	public Act_Participant_Record saveAct_Participant_Record(Act_Participant_Record apRecord) {
		return actPRecordRepo.save(apRecord);
	}

	@Override
	public boolean isExistedInActParticipant(int userId, int actId) {
		Act_Participant_Record  apr =  actPRecordRepo.getAct_Participant_RecordByUserIdAndActId(actId, userId);
		return apr== null ? false: true;
	}

	@Override
	public List<Act_Participant_Record> getAct_ParticipantRecordsByactId(int actId) {
		List<Act_Participant_Record> act_Participant_Records = new ArrayList<Act_Participant_Record>();

		act_Participant_Records = actPRecordRepo.getAct_ParticipantRecordsByactId(actId);

		return act_Participant_Records;
		 
	}
	
	@Override
	public int getAct_ParticipantRecordsCountByactId(int actId) {
		int count = 0;
		List<Act_Participant_Record> act_Participant_Records = new ArrayList<Act_Participant_Record>();

		act_Participant_Records = actPRecordRepo.getAct_ParticipantRecordsByactId(actId);
		 if(act_Participant_Records != null)
			 count = act_Participant_Records.size();
		 
		return count;
		 
	}
	
	
	
	@Override
	public List<ParticipantInfo> getAct_ParticipantInfos(int actId) {
		List<ParticipantInfo> act_Participant_Records = new ArrayList<ParticipantInfo>();

		act_Participant_Records = actPRecordRepo.getAct_ParticipantInfos(actId);
		 
		return act_Participant_Records;
		 
	}

	@Override
	public List<Act_Participant_Record> getAllJoinedActs(String openid) {
		UserBasicData user = userService.findUserByOpenId(openid);
		
		return actPRecordRepo.getAllJoinedActs(user.getUser_id());
	}

	@Override
	public Act_Participant_Record updateAct_Participant_Record(Act_Participant_Record ptpEntity) {
		return actPRecordRepo.saveAndFlush(ptpEntity);
	}
	
	@Override
	public boolean isClockSuccefully(int actId, String openid) {
		UserBasicData user = userService.findUserByOpenId(openid);
		Act_Participant_Record  apr =  actPRecordRepo.getAct_Participant_RecordByUserIdAndActId(actId, user.getUser_id());
		if(apr != null && apr.getDaka_status() == 1)
			return true;
		
		return false;
	}

	@Override
	public boolean deleteActParticipant(int actid, int userid) {
		boolean isDelete = false;
		try {
			Act_Participant_Record  apr =  actPRecordRepo.getAct_Participant_RecordByUserIdAndActId(actid, userid);
			actPRecordRepo.delete(apr);
			isDelete = true;
		} catch (Exception e) {
			throw e;
		}
		return isDelete;
	}

}
