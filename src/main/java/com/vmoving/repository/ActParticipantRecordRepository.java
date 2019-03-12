package com.vmoving.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.vmoving.domain.Act_Participant_Record;
import com.vmoving.dto.ParticipantInfo;

public interface ActParticipantRecordRepository extends JpaRepository<Act_Participant_Record, Integer> {

	@Query("select apr from Act_Participant_Record apr where apr.act_id = ?1 and apr.user_id=?2")
	public Act_Participant_Record getAct_Participant_RecordByUserIdAndActId(int act_id,int user_id);
	
	@Query("select apr from Act_Participant_Record apr where apr.act_id = ?1 order by apr.joindate asc")
	public List<Act_Participant_Record> getAct_ParticipantRecordsByactId(int act_id);
	
	@Query(value="select new com.vmoving.dto.ParticipantInfo(apr.user_id,apr.act_id,u.nickName,u.avatarUrl,apr.joindate,apr.user_status_id) from Act_Participant_Record apr left join UserBasicData u on apr.user_id = u.user_id"
			+ " where apr.act_id = ?1 order by apr.act_participant_record_id ")
	public List<ParticipantInfo> getAct_ParticipantInfos(int act_id);
	
	@Modifying
	@Query("update Act_Participant_Record apr set apr.user_status_id = ?1 where apr.act_participant_record_id = ?2")
	@Transactional
	public void updateAct_Participant_RecordByUserIdAndActId(@Param(value="user_status_id") int user_status_id,@Param(value="act_participant_record_id") int act_participant_record_id);
}
