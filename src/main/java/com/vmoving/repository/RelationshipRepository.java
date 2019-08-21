package com.vmoving.repository;

import com.vmoving.domain.UserBasicData;
import com.vmoving.domain.User_Relationship_Hub;

import java.util.List;

 
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RelationshipRepository extends JpaRepository<User_Relationship_Hub,Integer> {

	@Query("select ubd from UserBasicData ubd where ubd.user_id in (SELECT urh.user2_id FROM User_Relationship_Hub urh where urh.user_id = ?1)")
	public List<UserBasicData> getFriends(int user_id);
}
