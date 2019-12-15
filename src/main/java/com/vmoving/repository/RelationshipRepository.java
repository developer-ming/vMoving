package com.vmoving.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.vmoving.domain.User_Relationship_Hub;
import com.vmoving.dto.MyFriendsDto;

public interface RelationshipRepository extends JpaRepository<User_Relationship_Hub,Integer> {

	@Query("select new com.vmoving.dto.MyFriendsDto(ubd.user_id,ubd.openid,ubd.gender,ubd.nickName,ubd.avatarUrl,urh.acttype) from User_Relationship_Hub  urh left join UserBasicData  ubd on urh.user2_id = ubd.user_id where urh.user_id = ?1")
	public List<MyFriendsDto> getFriends(int user_id);
	
	@Query("SELECT urh FROM User_Relationship_Hub urh where urh.user2_id = ?1")
	public List<User_Relationship_Hub> getFriendsRelationship(int userfriend_id);
	
	@Query("SELECT urh FROM User_Relationship_Hub urh where urh.user_id = ?1 and urh.user2_id = ?2")
	public List<User_Relationship_Hub> getFriendsRelationshipByIds(int userid,int userfriend_id);
	
	@Query("SELECT urh FROM User_Relationship_Hub urh where urh.user_id = ?1 and urh.user2_id = ?2 and urh.acttype=?3")
	public List<User_Relationship_Hub> getFriendsRelationshipByIds(int userid,int userfriend_id,int acttype);
}
