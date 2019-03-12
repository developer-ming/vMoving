package com.vmoving.service.impl;

import com.vmoving.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vmoving.domain.UserBasicData;
import com.vmoving.repository.UserBasicDataRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserBasicDataRepository userBasicRepository;

	@Override
	public UserBasicData saveUser(UserBasicData userBasicData) {
		if (userBasicRepository.findByOpenID(userBasicData.getOpenid()) != null)
			return new UserBasicData();

		return userBasicRepository.save(userBasicData);
	}

	@Override
	public UserBasicData findUserByOpenId(String openId) {
		 if(openId.isEmpty())
			 return null;
		 
		return userBasicRepository.findByOpenID(openId);
	}

	@Override
	public UserBasicData findUserByUserId(int userId) {
		return userBasicRepository.findByUserID(userId);
	}
}