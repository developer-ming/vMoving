package com.vmoving.service;

import java.util.List;

import com.vmoving.domain.UserBasicData;
import com.vmoving.domain.User_Relationship_Hub;

public interface UserRelationshipService {
	User_Relationship_Hub saveFirends(User_Relationship_Hub relationship);
	void removeFirends(int relationship_id);
	
	List<UserBasicData> getMyFriends(int user_id);
}
