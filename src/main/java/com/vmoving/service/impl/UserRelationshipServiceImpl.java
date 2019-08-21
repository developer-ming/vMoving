package com.vmoving.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vmoving.domain.UserBasicData;
import com.vmoving.domain.User_Relationship_Hub;
import com.vmoving.repository.RelationshipRepository;
import com.vmoving.service.UserRelationshipService;

@Service
public class UserRelationshipServiceImpl implements UserRelationshipService {

	@Autowired
	private RelationshipRepository relationshipRepo;

	@Override
	public User_Relationship_Hub saveFirends(User_Relationship_Hub relationship) {
		return relationshipRepo.save(relationship);
	}

	@Override
	public void removeFirends(int relationship_id) {
		User_Relationship_Hub relationship_Hub = relationshipRepo.getOne(relationship_id);
		if (relationship_Hub != null)
			relationshipRepo.delete(relationship_Hub);
	}
	@Override
	public List<UserBasicData> getMyFriends(int user_id) {
		return relationshipRepo.getFriends(user_id);
	}

}
