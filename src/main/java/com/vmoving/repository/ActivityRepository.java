package com.vmoving.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.vmoving.domain.Activity;
import com.vmoving.dto.PersonalActivities;

public interface ActivityRepository extends JpaRepository<Activity, Integer> {
	@Query("select ac from Activity ac where ac.ACT_TYPE_ID=?1")
	public List<Activity> findActivitiesByType(int ACT_TYPE_ID);

	@Query("select ac from Activity ac where ac.ACT_ID=?1")
	public Activity findActivityByActId(int ACT_ID);

	@Modifying
	@Query("update Activity ac set ac.ACT_STATUS_ID = ?1 where ac.ACT_ID=?2")
	public void updateActivityStatus(@Param(value="ACT_STATUS_ID") int ACT_STATUS_ID, @Param(value = "ACT_ID") int ACT_ID);
	
	@Query("select ac from Activity ac where ac.ACT_STATUS_ID=?1")
	public List<Activity> findActivitiesByStatusId(int ACT_STATUS_ID);
	
	@Query("select ac from Activity ac where ac.ORGANZIER_ID=?1 and ac.isdelete = 0")
	public List<Activity> findActivitiesByOId(int ORGANZIER_ID);
	
	@Query("select ac from Activity ac where ac.ACT_ID in (select distinct apr.act_id from Act_Participant_Record apr where apr.user_id = ?1)")
	public List<Activity> findAllJoinedActivities(int user_id);
	
	@Query("select new com.vmoving.dto.PersonalActivities(ac.ACT_ID,ac.ACT_TYPE_ID,ac.ACT_NAME,ac.ACT_DATE,ac.ACT_START_TIME,ac.ACT_STATUS_ID,ac.ORGANZIER_ID,ac.PICTURE_LINK,ac.MATCH_METHOD_TYPE,apr.step_count,apr.hours,apr.calorie) from Activity ac left join Act_Participant_Record apr on ac.ACT_ID = apr.act_id where ac.isdelete = 0 and apr.user_id = ?1")
	public List<PersonalActivities> searchAllJoinedActivities(int user_id);
	
	
	@Query("SELECT ad FROM Activity ad left join Act_Participant_Record apr on ad.ACT_ID = apr.act_id \r\n" + 
			" where ad.ACT_STATUS_ID = ?1  and apr.user_id = ?2 and apr.daka_status = 0 order by ad.ACT_ID desc")
	public List<Activity> findNeededClockActivities(int ACT_STATUS_ID,int user_id);
}