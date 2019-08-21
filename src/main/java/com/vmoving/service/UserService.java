package com.vmoving.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.vmoving.domain.Personal_Achievements;
import com.vmoving.domain.Personal_Contact;
import com.vmoving.domain.Personal_Maxim;
import com.vmoving.domain.UserBasicData;
import com.vmoving.domain.User_favor_act_data;
import com.vmoving.dto.CollectUserGroupParams;

public interface UserService {
	UserBasicData saveUser(UserBasicData userBasicData);
	Map collectUserGroupInfo(CollectUserGroupParams cugps);
	
	UserBasicData findUserByOpenId(String openId);
	UserBasicData findUserByUserId(int userId);
	List<Personal_Achievements> findAllPersonalAchievements(String openid);
	Personal_Achievements savePersonalAchievement(String openid, String achievement);
	List<Personal_Contact> findAllPersonalContacts(String openid); 
	Personal_Contact savPersonalContact(String openid, String contact,String contacttype);
	
	List<Personal_Maxim> findAllPersonalMaxims(String openid); 
	Personal_Maxim savPersonalMaxim(String openid, String maximcontent);
	
	List<String> getActTypeList(int userid);
	
	HashMap<String, String> saveLikeSports(User_favor_act_data userFavor);
	
}
