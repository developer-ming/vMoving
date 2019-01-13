package com.vmoving.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vmoving.domain.Act_Participant_Record;
import com.vmoving.dto.ParticipantInfo;
import com.vmoving.repository.ActParticipantRecordRepository;
import com.vmoving.service.ActParticipantRecordService;

@Service
public class ActParticipantRecordServiceImpl implements ActParticipantRecordService {
	
	@Autowired
	private ActParticipantRecordRepository actPRecordRepo;

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
	public List<ParticipantInfo> getAct_ParticipantInfos(int actId) {
		List<ParticipantInfo> act_Participant_Records = new ArrayList<ParticipantInfo>();

		act_Participant_Records = actPRecordRepo.getAct_ParticipantInfos(actId);

		return act_Participant_Records;
		 
	}

}
