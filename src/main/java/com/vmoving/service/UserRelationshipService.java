package com.vmoving.service;

import java.util.List;

import com.vmoving.domain.UserBasicData;
import com.vmoving.domain.User_Relationship_Hub;
import com.vmoving.dto.MyFriendsDto;
import com.vmoving.dto.SendMessageToFriendsDto;

public interface UserRelationshipService {
	User_Relationship_Hub saveFirends(SendMessageToFriendsDto relationship);
	User_Relationship_Hub sendMessageToFirends(SendMessageToFriendsDto relationship);
	void removeFirends(int relationship_id);
	
	List<MyFriendsDto> getMyFriends(int user_id);
	
	List<User_Relationship_Hub> getFriendsRelationship(int userfriendid);
}
