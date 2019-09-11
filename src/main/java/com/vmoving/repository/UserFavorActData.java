package com.vmoving.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.vmoving.domain.User_favor_act_data;
import com.vmoving.dto.LikeActivity;
 

public interface UserFavorActData extends JpaRepository<User_favor_act_data, Integer> {

	@Query("SELECT ufad FROM User_favor_act_data ufad where ufad.User_ID = ?1 and ufad.ACT_TYPE_ID = ?2")
	public User_favor_act_data findOneByUserIdActTypeId(int user_id, int act_type_id);
	
	@Query(value = "SELECT  new com.vmoving.dto.LikeActivity(atc.activityTypeCode,ufad.COMPETENCY_ID,cc.COMPETENCY_TYPE) FROM User_favor_act_data ufad left join ActivityTypeCode atc on ufad.ACT_TYPE_ID = atc.actTypeId left join COMPETENCY_CODE cc on cc.COMPETENCY_ID = ufad.COMPETENCY_ID \r\n" + 
			"WHERE ufad.User_ID = ?1")
	public List<LikeActivity> getActTypeList(int userid);
}
