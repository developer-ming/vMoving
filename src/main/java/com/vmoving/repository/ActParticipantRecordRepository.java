package com.vmoving.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.vmoving.domain.Act_Participant_Record;
import com.vmoving.dto.ParticipantInfo;

public interface ActParticipantRecordRepository extends JpaRepository<Act_Participant_Record, Integer> {

	@Query("select apr from Act_Participant_Record apr where apr.act_id = ?1 and apr.user_id=?2")
	public Act_Participant_Record getAct_Participant_RecordByUserIdAndActId(int act_id,int user_id);
	
	@Query("select apr from Act_Participant_Record apr where apr.act_id = ?1 order by apr.joindate asc")
	public List<Act_Participant_Record> getAct_ParticipantRecordsByactId(int act_id);
	
	@Query(value="select new com.vmoving.dto.ParticipantInfo(u.nickName,u.avatarUrl,apr.joindate,count(*)) from Act_Participant_Record apr left join UserBasicData u on apr.user_id = u.user_id"
			+ " where apr.act_id = ?1 ")
	public List<ParticipantInfo> getAct_ParticipantInfos(int act_id);
}
