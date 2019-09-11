package com.vmoving.service;

import java.util.List;

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

/**
 * @author a255719
 *
 */
public interface BasicDataService {
	public List<ACT_FEE_TYPE_CODE> getAllFeeTypes();
	public int getFeeTypeIdByCode(String code);
	
	public List<ACT_MATCH_METHOD_CODE> getAllMatchMethods();
	public int getMatchMethodIdByCode(String code);
	
	public List<ACT_STATUS_CODE> getAllActStatus();
	public int getActStatusIdByCode(String code);

	public List<ACT_STD_COMMENT_CODE> getAllComments();
	public int getActStdCommentIdByCode(String code);

	public List<BADGE_CODE> getAllBadges();
	public int getBadgeIdByCode(String code);

	public List<COMPETENCY_CODE> getAllCompetencies();
	public int getCompetencyIdByCode(String code,int actid);

	public List<USER_STATUS_CODE> getAllUserStatus();
	public int getUserStatusIdByCode(String code);

	public List<USER_STD_COMMENT_CODE> getAllUserStdComments();
	public int getUserStdCommentIdByCode(String code);

	public List<ActivityTypeCode> getAllActivityTypes();
	public int getActTypeIdByCode(String code);
	
	public List<Release_target_code> getAllReleaseTargets();
	public int getReleaseTargetCode(String code);
}
