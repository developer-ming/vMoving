package com.vmoving.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vmoving.domain.ACT_FEE_TYPE_CODE;
import com.vmoving.domain.ACT_MATCH_METHOD_CODE;
import com.vmoving.domain.ACT_STATUS_CODE;
import com.vmoving.domain.ACT_STD_COMMENT_CODE;
import com.vmoving.domain.ActivityTypeCode;
import com.vmoving.domain.BADGE_CODE;
import com.vmoving.domain.COMPETENCY_CODE;
import com.vmoving.domain.Release_target_code;
import com.vmoving.domain.USER_STATUS_CODE;
import com.vmoving.domain.USER_STD_COMMENT_CODE;
import com.vmoving.repository.ActFeeTypeCodeRepository;
import com.vmoving.repository.ActMatchMethodCodeRepository;
import com.vmoving.repository.ActStatusCodeRepository;
import com.vmoving.repository.ActStdCommentCodeRepository;
import com.vmoving.repository.ActivityTypeCodeRepository;
import com.vmoving.repository.BadgeCodeRepository;
import com.vmoving.repository.CompetencyCodeRepository;
import com.vmoving.repository.ReleaseTargetCodeRepository;
import com.vmoving.repository.UserStatusCodeRepository;
import com.vmoving.repository.UserStdCommentCodeRepository;
import com.vmoving.service.BasicDataService;

@Service
public class BasicDataServiceImpl implements BasicDataService {
	@Autowired
	private ActFeeTypeCodeRepository actFeeTypeRepo;
	@Autowired
	private ActivityTypeCodeRepository actTypeRepo;
	@Autowired
	private ActMatchMethodCodeRepository actMatchMethodRepo;
	@Autowired
	private ActStatusCodeRepository actStatusRepo;
	@Autowired
	private ActStdCommentCodeRepository actStdCommentRepo;
	@Autowired
	private BadgeCodeRepository badgeRepo;
	@Autowired
	private CompetencyCodeRepository competencyRepo;
	@Autowired
	private UserStatusCodeRepository userStatusRepo;
	@Autowired
	private UserStdCommentCodeRepository userStdCommentRepo;
	@Autowired
	private ReleaseTargetCodeRepository releaseTargetCodeRepo;
	
	@Override
	public List<ACT_FEE_TYPE_CODE> getAllFeeTypes() {
		return actFeeTypeRepo.findAll();
	}

	@Override
	public List<ACT_MATCH_METHOD_CODE> getAllMatchMethods() {
		return actMatchMethodRepo.findAll();
	}

	@Override
	public List<ACT_STATUS_CODE> getAllActStatus() {
		return actStatusRepo.findAll();
	}

	@Override
	public List<ACT_STD_COMMENT_CODE> getAllComments() {
		return actStdCommentRepo.findAll();
	}

	@Override
	public List<BADGE_CODE> getAllBadges() {
		return badgeRepo.findAll();
	}

	@Override
	public List<COMPETENCY_CODE> getAllCompetencies() {
		return competencyRepo.findAll();
	}

	@Override
	public List<USER_STATUS_CODE> getAllUserStatus() {
		return userStatusRepo.findAll();
	}

	@Override
	public List<USER_STD_COMMENT_CODE> getAllUserStdComments() {
		return userStdCommentRepo.findAll();
	}

	@Override
	public List<ActivityTypeCode> getAllActivityTypes() {
		return actTypeRepo.findAll();
	}
	

	@Override
	public List<Release_target_code> getAllReleaseTargets() {
		return releaseTargetCodeRepo.findAll();
	}


	@Override
	public int getFeeTypeIdByCode(String code) {
		int feeTypeId = 0;
		List<ACT_FEE_TYPE_CODE> allFeeTypes = actFeeTypeRepo.findAll();
		 for (ACT_FEE_TYPE_CODE act_FEE_TYPE_CODE : allFeeTypes) {
			if(act_FEE_TYPE_CODE.getACT_FEE_TYPE().equals(code)) {
				feeTypeId= act_FEE_TYPE_CODE.getACT_FEE_TYPE_ID();
				break;
			}
		}
		 
		return feeTypeId;
	}

	@Override
	public int getMatchMethodIdByCode(String code) {
		int MatchId = 0;
		List<ACT_MATCH_METHOD_CODE> allMatchMethods = actMatchMethodRepo.findAll();
		 for (ACT_MATCH_METHOD_CODE act_Match_CODE : allMatchMethods) {
			if(act_Match_CODE.getACT_MATCH_METHOD().equals(code)) {
				MatchId= act_Match_CODE.getACT_MATCH_METHOD_ID();
				break;
			}
		}
		 
		return MatchId;
	}

	@Override
	public int getActStatusIdByCode(String code) {
		int actStatusId = 0;
		List<ACT_STATUS_CODE> allFeeTypes = actStatusRepo.findAll();
		 for (ACT_STATUS_CODE act_STATUS_CODE : allFeeTypes) {
			if(act_STATUS_CODE.getACT_STATUS().equals(code)) {
				actStatusId= act_STATUS_CODE.getACT_STATUS_ID();
				break;
			}
		}
		 
		return actStatusId;
	}

	@Override
	public int getActStdCommentIdByCode(String code) {
		int actStdCommentId = 0;
		List<ACT_STD_COMMENT_CODE> allFeeTypes = actStdCommentRepo.findAll();
		 for (ACT_STD_COMMENT_CODE act_STD_COMMENT_CODE : allFeeTypes) {
			if(act_STD_COMMENT_CODE.getCOMMENT_CONTENT().equals(code)) {
				actStdCommentId= act_STD_COMMENT_CODE.getACT_STD_COMMENT_CONTENT_ID();
				break;
			}
		}
		 
		return actStdCommentId;
	}

	@Override
	public int getBadgeIdByCode(String code) {
		int badgeId = 0;
		List<BADGE_CODE> allBadges = badgeRepo.findAll();
		 for (BADGE_CODE badge_CODE : allBadges) {
			if(badge_CODE.getBADGE_NAME().equals(code)) {
				badgeId= badge_CODE.getBADGE_ID();
				break;
			}
		}
		 
		return badgeId;
	}

	@Override
	public int getCompetencyIdByCode(String code,int actid) {
		int competencyId = 0;
		List<COMPETENCY_CODE> allFeeTypes = competencyRepo.findAll();
		 for (COMPETENCY_CODE competency_CODE : allFeeTypes) {
			if(competency_CODE.getCOMPETENCY_TYPE().equals(code) && competency_CODE.getActTypeId() == actid) {
				competencyId= competency_CODE.getCOMPETENCY_ID();
				break;
			}
		}
		 
		return competencyId;
	}

	@Override
	public int getUserStatusIdByCode(String code) {
		int userStatusId = 0;
		List<USER_STATUS_CODE> allUrStatus = userStatusRepo.findAll();
		 for (USER_STATUS_CODE user_STATUS_CODE : allUrStatus) {
			if(user_STATUS_CODE.getUSER_STATUS_STATUS().equals(code)) {
				userStatusId= user_STATUS_CODE.getUSER_STATUS_ID();
				break;
			}
		}
		 
		return userStatusId;
	}

	@Override
	public int getUserStdCommentIdByCode(String code) {
		int userStdCommentId = 0;
		List<USER_STD_COMMENT_CODE> allFeeTypes = userStdCommentRepo.findAll();
		 for (USER_STD_COMMENT_CODE user_STD_COMMENT_CODE : allFeeTypes) {
			if(user_STD_COMMENT_CODE.getCOMMENT_CONTENT().equals(code)) {
				userStdCommentId= user_STD_COMMENT_CODE.getUSER_STD_COMMENT_ID();
				break;
			}
		}
		 
		return userStdCommentId;
	}

	@Override
	public int getActTypeIdByCode(String code) {
		int actTypeId = 0;
		List<ActivityTypeCode> allFeeTypes = actTypeRepo.findAll();
		 for (ActivityTypeCode activityTypeCode : allFeeTypes) {
			if(activityTypeCode.getActivityTypeCode().equals(code)) {
				actTypeId= activityTypeCode.getActTypeId();
				break;
			}
		}
		 
		return actTypeId;
	}

	@Override
	public int getReleaseTargetCode(String code) {
		 
		int releaseTargetId = 0;
		List<Release_target_code> allReleaseTargets = releaseTargetCodeRepo.findAll();
		 for (Release_target_code releaseTarget : allReleaseTargets) {
			if(releaseTarget.getRelease_target_type().equals(code)) {
				releaseTargetId= releaseTarget.getRelease_target_id();
				break;
			}
		}
		 
		return releaseTargetId;
	}

}
