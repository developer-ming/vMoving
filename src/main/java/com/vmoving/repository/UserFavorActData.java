package com.vmoving.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.vmoving.domain.User_favor_act_data;
 

public interface UserFavorActData extends JpaRepository<User_favor_act_data, Integer> {

	@Query("SELECT ufad FROM User_favor_act_data ufad where ufad.User_ID = ?1 and ufad.ACT_TYPE_ID = ?2")
	public User_favor_act_data findOneByUserIdActTypeId(int user_id, int act_type_id);
	
	@Query(value = "SELECT atc.ACTIVITY_TYPE FROM vmoving.user_favor_act_data ufad left join vmoving.activity_type_code atc on ufad.ACT_TYPE_ID = atc.ACT_TYPE_ID\r\n" + 
			"WHERE ufad.User_ID = ?1",nativeQuery=true)
	public List<String> getActTypeList(int userid);
}
