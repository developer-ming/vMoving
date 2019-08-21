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
import com.vmoving.dto.UserCommentDto;
import com.vmoving.repository.UserCommentRepository;
import com.vmoving.service.UserCommentService;
import com.vmoving.service.UserService;

import javassist.expr.NewArray;

@Service
public class UserCommentServiceImpl implements UserCommentService {
	private static String  datFormat = "yyy-MM-dd hh:mm:ss";
	private static SimpleDateFormat sdf = new SimpleDateFormat(datFormat);
	
	@Autowired
	private UserCommentRepository uCommentRepo;
	
	@Autowired
	private UserService userService;
	
	@Override
	public UserComment saveUserComment(UserCommentDto commentDto){
		UserComment comment = new UserComment();
		comment.setAct_comment_id(commentDto.getActCommentId());
		String  commentdate = sdf.format(new Date());
		comment.setCommentdate(commentdate);
		comment.setIscancel(0);
		comment.setUsercomments(commentDto.getUserComments());
		try {
		 UserBasicData user	= userService.findUserByOpenId(commentDto.getOpenid());
		 if(user != null) {
			 comment.setUserid(user.getUser_id());
			 comment.setUsernickname(user.getNickName());
			 comment.setUseravatorurl(user.getAvatarUrl());
		 }
		} catch (Exception e) {
			throw e;
		}
		
		return uCommentRepo.save(comment);
	}

	@Override
	public List<UserComment> getUserComments() {
		return uCommentRepo.findAll();
	}

	@Override
	public UserComment getOneUserComment(int ucommentid) {
		return uCommentRepo.getOne(ucommentid);
	}

	@Override
	public UserComment cancelComment(int ucommentid) {
		UserComment uc = uCommentRepo.getOne(ucommentid);
		if(uc!= null && uc.getU_comment_id() > 0 && uc.getIscancel() == 1) {
			uc.setIscancel(0);
			uCommentRepo.saveAndFlush(uc);
		}
		return uc;
	}

	@Override
	public List<UserComment> getUserCommentsByActCommentId(int actCommentId) {
		return uCommentRepo.findAll().stream()
				.filter(uc -> uc.getAct_comment_id() == actCommentId)
				.sorted(Comparator.comparing(UserComment::getAct_comment_id).reversed())
				.collect(Collectors.toList());
	}

}
