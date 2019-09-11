package com.vmoving.web.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vmoving.domain.UserBasicData;
import com.vmoving.domain.User_Relationship_Hub;
import com.vmoving.dto.MyFriendsDto;
import com.vmoving.dto.SendMessageToFriendsDto;
import com.vmoving.service.UserRelationshipService;

@RestController
public class UserRelationshipController {
	
	@Autowired
	private UserRelationshipService relationshipServ;
	
	
	@PostMapping(path="/api/sendMessageToFirends")	
	public User_Relationship_Hub sendMessageToFirends(@RequestBody SendMessageToFriendsDto relationship) {
			return relationshipServ.sendMessageToFirends(relationship);
	}
	
	@PostMapping(path="/api/saveFriends")	
	public User_Relationship_Hub saveFriends(@RequestBody SendMessageToFriendsDto relationship) {
			return relationshipServ.saveFirends(relationship);
	}
	
	@GetMapping(path="/api/getMyFriends")
	public List<MyFriendsDto> getMyFriends(@RequestParam int userid){
		return relationshipServ.getMyFriends(userid);
	}
	
	@GetMapping(path="/api/getFriendsRelationship")
	public List<User_Relationship_Hub> getFriendsRelationship(@RequestParam int frienduserid){
		return relationshipServ.getFriendsRelationship(frienduserid);
	}
	
	
}
