package com.vmoving.service;

import com.vmoving.domain.UserBasicData;

public interface UserService {
	UserBasicData saveUser(UserBasicData userBasicData);
	UserBasicData findUserByOpenId(String openId);
}
