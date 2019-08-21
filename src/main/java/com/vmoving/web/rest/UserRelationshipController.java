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
import com.vmoving.service.UserRelationshipService;

@RestController
public class UserRelationshipController {
	
	@Autowired
	private UserRelationshipService relationshipServ;
	
	@PostMapping(path="/api/saveFriends")	
	public User_Relationship_Hub saveFriends(@RequestBody User_Relationship_Hub relationship) {
			return relationshipServ.saveFirends(relationship);
	}
	
	@GetMapping(path="/api/getMyFriends")
	public List<UserBasicData> getMyFriends(@RequestParam int userid){
		return relationshipServ.getMyFriends(userid);
	}
}
