package com.vmoving.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vmoving.domain.UserBasicData;
import com.vmoving.domain.User_Relationship_Hub;
import com.vmoving.dto.MyFriendsDto;
import com.vmoving.dto.SendMessageToFriendsDto;
import com.vmoving.repository.RelationshipRepository;
import com.vmoving.service.PrivateMessageService;
import com.vmoving.service.UserRelationshipService;
import com.vmoving.service.UserService;

@Service
public class UserRelationshipServiceImpl implements UserRelationshipService {

	@Autowired
	private RelationshipRepository relationshipRepo;
	
	@Autowired
	private PrivateMessageService pMsgService;
	
	@Autowired
	private UserService userService;

	
	@Override
	public User_Relationship_Hub sendMessageToFirends(SendMessageToFriendsDto relationship) {
		User_Relationship_Hub relationshipEntity = new User_Relationship_Hub();
		try {
			UserBasicData user = userService.findUserByUserId(relationship.getUser_id());
			String msgContent =  user.getNickName() +",想加您为好友！";
			//NOTE THAT: 这个地方存储的acttype, 存在对应的column actid 上。 消息类型是2， 以此来区别。 在取朋友的时候会用到acttype 
			pMsgService.savePrivate_Message(relationship.getUser_id(),relationship.getUser2_id(),relationship.getActtype(),null,0,msgContent,2);
		} catch (Exception e) {
			throw e;
		}
		
		return relationshipEntity;
	}
	
	
	@Override
	public User_Relationship_Hub saveFirends(SendMessageToFriendsDto relationship) {
		User_Relationship_Hub relationshipEntity = new User_Relationship_Hub();
		relationshipEntity.setUser_id(relationship.getUser_id());
		relationshipEntity.setUser2_id(relationship.getUser2_id());
		relationshipEntity.setRelationship(relationship.getRelationship());
		relationshipEntity.setValid_status(relationship.getValid_status());
		relationshipEntity.setActtype(relationship.getActtype());
		try {
		   List<User_Relationship_Hub>  urhList	= relationshipRepo.getFriendsRelationshipByIds(relationship.getUser_id(),relationship.getUser2_id(),relationship.getActtype());
		   if(urhList!= null && urhList.size() == 0) {
			   return relationshipRepo.save(relationshipEntity);
		   }
		} catch (Exception e) {
			throw e;
		}
		
		relationshipEntity.setRelationship(-1);
		
		return relationshipEntity;
	}

	@Override
	public void removeFirends(int relationship_id) {
		User_Relationship_Hub relationship_Hub = relationshipRepo.getOne(relationship_id);
		if (relationship_Hub != null)
			relationshipRepo.delete(relationship_Hub);
	}
	@Override
	public List<MyFriendsDto> getMyFriends(int user_id) {
		return relationshipRepo.getFriends(user_id);
	}


	@Override
	public List<User_Relationship_Hub> getFriendsRelationship(int userfriendid) {
		return relationshipRepo.getFriendsRelationship(userfriendid);
	}

}
