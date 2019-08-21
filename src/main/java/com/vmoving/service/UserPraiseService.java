package com.vmoving.service;

import java.util.List;

import com.vmoving.domain.UserPraise;
import com.vmoving.dto.UserPraiseDto;

public interface UserPraiseService {
	UserPraise saveUserPraise(UserPraiseDto praise);
	List<UserPraise> getUserPraises();
	UserPraise getOneUserPraise(int uPraiseid);
	UserPraise cancelPraise(String openid, int actCommentId);
	List<UserPraise> getUserPraisesByActPraiseId(int actPraiseId);
}
