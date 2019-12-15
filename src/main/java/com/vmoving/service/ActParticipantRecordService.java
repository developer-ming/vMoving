package com.vmoving.service;

import java.util.List;

import com.vmoving.domain.Act_Participant_Record;
import com.vmoving.dto.ParticipantInfo;

public interface ActParticipantRecordService {
	public Act_Participant_Record saveAct_Participant_Record(Act_Participant_Record apRecord);
	
	public Act_Participant_Record updateAct_Participant_Record(Act_Participant_Record ptpDto);
	
	public boolean isExistedInActParticipant(int userId,int actId);
	
	public List<Act_Participant_Record> getAct_ParticipantRecordsByactId(int actId);
	
	public int getAct_ParticipantRecordsCountByactId(int actId);
	
	
	public List<ParticipantInfo> getAct_ParticipantInfos(int actId);
	
	public List<Act_Participant_Record> getAllJoinedActs(String openid);
	
	public boolean isClockSuccefully(int actId, String openid);
	
	public boolean deleteActParticipant(int actid, int userid);
}
