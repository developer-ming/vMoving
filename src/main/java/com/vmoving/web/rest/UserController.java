package com.vmoving.web.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vmoving.domain.Personal_Achievements;
import com.vmoving.domain.Personal_Contact;
import com.vmoving.domain.Personal_Maxim;
import com.vmoving.domain.UserBasicData;
import com.vmoving.domain.User_favor_act_data;
import com.vmoving.dto.CollectUserGroupParams;
import com.vmoving.dto.UserFavorDto;
import com.vmoving.repository.UserBasicDataRepository;
import com.vmoving.repository.UserFavorActData;
import com.vmoving.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private UserBasicDataRepository userBasicRepo;
	
	@Autowired
	private UserFavorActData userFavorActRepo;

	@RequestMapping(value = "/api/saveUser")
	public UserBasicData saveUser(@RequestBody UserBasicData user) {
		if (user.getOpenid() == null || user.getOpenid().isEmpty())
			return null;
		if (userBasicRepo.findByOpenID(user.getOpenid()) != null)
			return new UserBasicData();

		return userService.saveUser(user);
	}
	
	@RequestMapping(value = "/api/collectUserGroupInfo")
	public Map collectUserGroupInfo(@RequestBody CollectUserGroupParams cugps) {
		if (cugps.getCode() == null || cugps.getEncryptedData().isEmpty())
			return null;
		 

		return userService.collectUserGroupInfo(cugps);
	}
	
	

	@GetMapping(path = "/api/getUserByOpenId")
	public UserBasicData findUserDataByOpenId(@RequestParam String openId) {
		if (openId.isEmpty())
			return null;
		return userBasicRepo.findByOpenID(openId);
	}

	@GetMapping(path = "/api/findAllPersonalMaxims")
	public List<Personal_Maxim> findAllPersonalMaxims(@RequestParam String openid) {
		return userService.findAllPersonalMaxims(openid);
	}

	@GetMapping(path = "/api/savPersonalMaxim")
	public Personal_Maxim savPersonalMaxim(@RequestParam String openid, String maximcontent) {
		return userService.savPersonalMaxim(openid, maximcontent);
	}

	@GetMapping(path = "/api/findAllPersonalAchievements")
	public List<Personal_Achievements> findAllPersonalAchievements(@RequestParam String openid) {
		return userService.findAllPersonalAchievements(openid);
	}

	@GetMapping(path = "/api/savePersonalAchievement")
	public Personal_Achievements savePersonalAchievement(@RequestParam String openid, String achievement) {
		return userService.savePersonalAchievement(openid, achievement);
	}

	@GetMapping(path = "/api/findAllPersonalConcats")
	public List<Personal_Contact> findAllPersonalConcats(@RequestParam String openid) {
		return userService.findAllPersonalContacts(openid);
	}

	@GetMapping(path = "/api/savePersonalConcat")
	public Personal_Contact savePersonalConcat(@RequestParam String openid, String contact, String contacttype) {
		return userService.savPersonalContact(openid, contact, contacttype);
	}
	
	@GetMapping(path = "/api/getActTypeList")
	public List<String> getActTypeList(@RequestParam String userid) {
		
		int  useridVal = Integer.parseInt(userid);
		return userService.getActTypeList(useridVal);
	}
	
	@RequestMapping(value = "/api/saveLikeSports")
	public HashMap<String, String> saveLikeSports(@RequestBody UserFavorDto userfavor) {
		if (userfavor == null)
			return null;
		User_favor_act_data userfavorEntity = new User_favor_act_data();
		userfavorEntity.setUser_ID(userfavor.getUserid());
		userfavorEntity.setACT_TYPE_ID(userfavor.getActtypeid());
		userfavorEntity.setCOMPETENCY_ID(userfavor.getCompenencyid());
		return userService.saveLikeSports(userfavorEntity);
	}

}