package com.vmoving.service.impl;

import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vmoving.domain.UserBasicData;
import com.vmoving.domain.UserComment;
import com.vmoving.domain.UserPraise;
import com.vmoving.dto.UserPraiseDto;
import com.vmoving.repository.UserPraiseRepository;
import com.vmoving.service.UserPraiseService;
import com.vmoving.service.UserService;

@Service
public class UserPraiseImpl implements UserPraiseService {
	private static String datFormat = "yyy-MM-dd hh:mm:ss";
	private static SimpleDateFormat sdf = new SimpleDateFormat(datFormat);
	@Autowired
	private UserPraiseRepository userPraiseRepo;

	@Autowired
	private UserService userService;

	@Override
	public UserPraise saveUserPraise(UserPraiseDto praise) {
		// 查询UserPraise 表中是否已经存储了当前用户的点赞。
		UserPraise dbPraise = userPraiseRepo.getOneUserPraiseByOpenid(praise.getOpenid());
		// 如果存在点赞
		// 对于此活动的打卡，当前用户已经点赞了
		if (dbPraise != null && dbPraise.getPraiseid() > 0) {
			// 如果是之前取消的点赞，又重新选择点赞
			if (dbPraise.getIspraise() == 0 && dbPraise.getAct_comment_id() == praise.getAct_comment_id()) {
				dbPraise.setIspraise(1);
				dbPraise.setUserpraise(1);
				return userPraiseRepo.saveAndFlush(dbPraise);
			} else {
				// 否则说明数据库中已经存在当前用户已经点赞过了。直接返回当前数据库中的对象。
				return dbPraise;
			}
		} else {
		//否则，数据中没有这条点赞记录，需要添加新的。	
		UserPraise uPraise = new UserPraise();
		uPraise.setAct_comment_id(praise.getAct_comment_id());
		String praisedate = sdf.format(new Date());
		uPraise.setPraisedate(praisedate);
		uPraise.setUserpraise(1);
		uPraise.setIspraise(1);
		uPraise.setOpenid(praise.getOpenid());
		try {
			UserBasicData user = userService.findUserByOpenId(praise.getOpenid());
			if (user != null) {
				uPraise.setUserid(user.getUser_id());
				uPraise.setUsernickname(user.getNickName());
				uPraise.setUseravatorurl(user.getAvatarUrl());
			}
		} catch (Exception e) {
			throw e;
		}
		return userPraiseRepo.save(uPraise);
		}
	}

	@Override
	public List<UserPraise> getUserPraises() {
		return userPraiseRepo.findAll();
	}

	@Override
	public UserPraise getOneUserPraise(int uPraiseid) {
		return userPraiseRepo.getOne(uPraiseid);
	}

	@Override
	public UserPraise cancelPraise(String openid,int actCommentId) {
		UserPraise uPraise = userPraiseRepo.getOneUserPraiseByOpenid(openid,actCommentId);
		if (uPraise != null && uPraise.getPraiseid() > 0 && uPraise.getUserpraise() == 1) {
			uPraise.setIspraise(0);
			uPraise.setUserpraise(0);
		}

		return userPraiseRepo.saveAndFlush(uPraise);
	}

	@Override
	public List<UserPraise> getUserPraisesByActPraiseId(int actCommentId) {
		return userPraiseRepo.findAll().stream().filter(uc -> uc.getAct_comment_id() == actCommentId)
				.filter(uc -> uc.getIspraise() == 1).filter(uc -> uc.getUserpraise() == 1)
				.sorted(Comparator.comparing(UserPraise::getAct_comment_id).reversed()).collect(Collectors.toList());
	}

}
