package com.vmoving.service;

import java.util.List;

import com.vmoving.domain.UserComment;
import com.vmoving.dto.UserCommentDto;

public interface UserCommentService {
	UserComment saveUserComment(UserCommentDto comment);
	List<UserComment> getUserComments();
	UserComment getOneUserComment(int ucommentid);
	UserComment cancelComment(int ucommentid);
	List<UserComment> getUserCommentsByActCommentId(int actCommentId);
}
