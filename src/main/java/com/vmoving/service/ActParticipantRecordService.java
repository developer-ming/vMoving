package com.vmoving.service;

import java.util.List;

import com.vmoving.domain.Act_Participant_Record;
import com.vmoving.dto.ParticipantInfo;

public interface ActParticipantRecordService {
	public Act_Participant_Record saveAct_Participant_Record(Act_Participant_Record apRecord);
	
	public boolean isExistedInActParticipant(int userId,int actId);
	
	public List<Act_Participant_Record> getAct_ParticipantRecordsByactId(int actId);
	
	public List<ParticipantInfo> getAct_ParticipantInfos(int actId);
}
