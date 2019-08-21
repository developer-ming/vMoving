package com.vmoving.service.impl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.validation.constraints.Null;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vmoving.domain.ActComment;
import com.vmoving.domain.Act_Participant_Record;
import com.vmoving.domain.Activity;
import com.vmoving.domain.UserBasicData;
import com.vmoving.domain.UserComment;
import com.vmoving.domain.UserPraise;
import com.vmoving.domain.User_favor_act_data;
import com.vmoving.dto.ActCommentDto;
import com.vmoving.repository.ActParticipantRecordRepository;
import com.vmoving.repository.ClockinRepository;
import com.vmoving.repository.UserFavorActData;
import com.vmoving.repository.UserPraiseRepository;
import com.vmoving.service.ActParticipantRecordService;
import com.vmoving.service.ActivityService;
import com.vmoving.service.ClockinService;
import com.vmoving.service.UserCommentService;
import com.vmoving.service.UserPraiseService;
import com.vmoving.service.UserService;
import com.vmoving.service.mapper.ActCommentMapper;

@Service
public class ClockinServiceImpl implements ClockinService {

	private static final Logger log = LoggerFactory.getLogger(ClockinServiceImpl.class);

	@Autowired
	public ClockinRepository clockinRepo;

	@Autowired
	private UserService userService;

	@Autowired
	private ActParticipantRecordService actPtService;

	@Autowired
	private ActParticipantRecordRepository actPRecordRepo;

	@Autowired
	private UserFavorActData userFavorActRepo;
	
	@Autowired
	private UserCommentService userCommentService;
	
	@Autowired
	private UserPraiseService userPraiseServ;
	
	@Autowired
	private UserPraiseRepository userPraiseRepo;

	@Override
	public ActComment saveComment(ActCommentDto comDto) {
		ActComment comment = new ActComment();
		try {
			// To find a user with the open ID
			UserBasicData user = userService.findUserByOpenId(comDto.getOpendid());
			// Sets the user who comment this activity
			comment = ActCommentMapper.commentDtoToEntity(comDto);
			comment.setComment_provider_id(user != null ? user.getUser_id() : 0);

			comment = clockinRepo.save(comment);

			if (comment.getAct_comment_id() > 0) {

				// To add a user favor record when current user clockin successfully.
				try {
						User_favor_act_data ufad = userFavorActRepo.findOneByUserIdActTypeId(user.getUser_id(),
								comDto.getActtypeid());
						if (ufad != null && ufad.getUSER_FAVOR_ACT_ID() > 0 && ufad.getACT_TYPE_ID() == comDto.getActtypeid()) {
							log.info("You have already chosed the activity");
						} else {
							User_favor_act_data uFavorAct = new User_favor_act_data();
							uFavorAct.setUser_ID(user.getUser_id());
							uFavorAct.setACT_TYPE_ID(comDto.getActtypeid());
							uFavorAct.setCOMPETENCY_ID(1);
							userFavorActRepo.save(uFavorAct);
						}
					 
				} catch (Exception e) {
					// TODO: handle exception
					log.error("Save the user favor activity data occured an exception", e);
				}

				try {
					// To update the calorie,hours,steps to the participant table
					Act_Participant_Record apr = actPRecordRepo
							.getAct_Participant_RecordByUserIdAndActId(comDto.getActid(), user.getUser_id());
					if (apr != null && apr.getAct_participant_record_id() > 0 && apr.getDaka_status() == 0) {

						apr.setCalorie(comDto.getCalorie());
						apr.setHours(comDto.getSpenthour());
						apr.setStep_count(comDto.getSteps());
						apr.setAct_type_id(comDto.getActtypeid());
						apr.setComments(comDto.getComments());
						apr.setDaka_status(1);
						apr = actPtService.updateAct_Participant_Record(apr);

						if (apr.getCalorie() != 0 || apr.getHours() != null || apr.getStep_count() != 0) {
							log.info("Update the participant successfully");
						}

					}
				} catch (Exception e) {
					log.error("Update the participant while save the comment", e);
				}

			}

		} catch (Exception e) {
			log.error("saveComment", e);
		}
		return comment;

	}

	@Override
	public void deleteComment(ActComment actComment) {
		try {
			clockinRepo.delete(actComment);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
	}

	@Override
	public void deleteComment(int commentId) {
		try {
			clockinRepo.deleteById(commentId);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
	}

	@Override
	public ActComment findOneActComment(int commentId) {
		return clockinRepo.getOne(commentId);
	}

	@Override
	public List<ActCommentDto> findAllActComment(int actid, String openid) {
		List<ActCommentDto> retrunActCommentDtos = new ArrayList<ActCommentDto>();

		// Recreate a new comment DTO for UI
		List<ActComment> comments = clockinRepo.getActCommentsByActId(actid);
		for (ActComment comment : comments) {
			UserBasicData comUser = userService.findUserByUserId(comment.getComment_provider_id());
			ActCommentDto dto = ActCommentMapper.entityToCommentsDto(comment, comUser.getNickName(),
					comUser.getAvatarUrl());
			dto.setOpendid(openid);
			List<UserComment> uComments = userCommentService.getUserCommentsByActCommentId(comment.getAct_comment_id());
			List<UserPraise>  uPraises = userPraiseServ.getUserPraisesByActPraiseId(comment.getAct_comment_id());
			UserPraise uPraise = userPraiseRepo.getOneUserPraiseByOpenid(openid,comment.getAct_comment_id());
			if(uPraise != null) {
				int isPraised = (uPraise.getIspraise() == 1 && uPraise.getUserpraise() == 1) ? 1 : 0;
				dto.setIsPraised(isPraised);
			}
			
			dto.setUserComments(uComments); 
			dto.setUserPraises(uPraises);
			dto.setLikethiscount(uPraises.size());
			
			retrunActCommentDtos.add(dto);
		}

		return retrunActCommentDtos.stream().filter(c -> c.getActid() == actid)
				.sorted(Comparator.comparing(ActCommentDto::getCommentdate).reversed()).collect(Collectors.toList());
	}
	
	@Override
	public List<ActComment> getClockingSummary(int actid, String openid) {
		UserBasicData user = userService.findUserByOpenId(openid);
		return clockinRepo.getClockingSummary(user.getUser_id(), actid);
	}
}
