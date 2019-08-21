package com.vmoving.service;

import java.util.List;

import com.vmoving.domain.ActComment;
import com.vmoving.dto.ActCommentDto;

public interface ClockinService {
	public ActComment saveComment(ActCommentDto actComment);
	public void deleteComment(ActComment actComment);
	public void deleteComment(int commentId);
	public ActComment findOneActComment(int commentId);
	public List<ActCommentDto> findAllActComment(int actid, String openid);
	public List<ActComment> getClockingSummary(int actid, String openid);
	
}
