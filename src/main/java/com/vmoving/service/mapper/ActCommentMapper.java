package com.vmoving.service.mapper;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.vmoving.domain.ActComment;
import com.vmoving.dto.ActCommentDto;

public class ActCommentMapper {
	public static ActComment commentDtoToEntity(ActCommentDto comDto) {
		ActComment actComment = new ActComment();
		actComment.setAct_id(comDto.getActid());
		actComment.setAct_comment_free_text(comDto.getComments());
		actComment.setUploadimagepath(comDto.getUploadimagepaths());
		actComment.setCommentdate(new Date());
		return actComment;
	}

	public static ActCommentDto entityToCommentsDto(ActComment actCom, String nikeName, String avatarUrl) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		ActCommentDto actComDto = new ActCommentDto();
		actComDto.setActCommentId(actCom.getAct_comment_id());
		actComDto.setActid(actCom.getAct_id());
		actComDto.setComments(actCom.getAct_comment_free_text());
		actComDto.setUploadimagepaths(actCom.getUploadimagepath());
		actComDto.setUserid(actCom.getComment_provider_id());
		String createDate = sdf.format(actCom.getCommentdate());
		actComDto.setCommentdate(createDate);
		
		actComDto.setNickName(nikeName);
		actComDto.setAvatarUrl(avatarUrl);
		
		return actComDto;
	}
}
