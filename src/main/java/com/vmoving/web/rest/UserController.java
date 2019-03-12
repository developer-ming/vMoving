package com.vmoving.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vmoving.domain.UserBasicData;
import com.vmoving.repository.UserBasicDataRepository;
import com.vmoving.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserBasicDataRepository userBasicRepo;
	
	@RequestMapping(value="/api/saveUser")
	public UserBasicData saveUser(@RequestBody UserBasicData user) {
		if(user.getOpenid() == null || user.getOpenid().isEmpty())
			return null;
		if(userBasicRepo.findByOpenID(user.getOpenid()) != null)
			return new UserBasicData();
		
		return userService.saveUser(user);
	}
	
	@GetMapping(path="/api/getUserByOpenId")
	public UserBasicData findUserDataByOpenId(@RequestParam String openId) {
		if(openId.isEmpty())
			return null;
		return userBasicRepo.findByOpenID(openId);
	}
}