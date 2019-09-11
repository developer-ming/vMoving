package com.vmoving.web.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
import com.vmoving.service.BasicDataService;

@RestController
public class BasicDataController {

	@Autowired
	private BasicDataService basicDataService;

	@GetMapping(path = "/api/getAllActTypeCodes")
	public List<ActivityTypeCode> getAllActivityTypes() {
		List<ActivityTypeCode> activityTypes = basicDataService.getAllActivityTypes();
		return activityTypes;
	}

	@GetMapping(path = "/api/getAllFeeTypes")
	public List<ACT_FEE_TYPE_CODE> getAllFeeTypes() {
		List<ACT_FEE_TYPE_CODE> feeTypes = basicDataService.getAllFeeTypes();
		return feeTypes;
	}

	@GetMapping(path = "/api/getAllMatchMethods")
	public List<ACT_MATCH_METHOD_CODE> getAllMatchMethods() {
		List<ACT_MATCH_METHOD_CODE> allMatchMethods = basicDataService.getAllMatchMethods();
		return allMatchMethods;
	}

	@GetMapping(path = "/api/getAllActStatus")
	public List<ACT_STATUS_CODE> getAllActStatus() {
		List<ACT_STATUS_CODE> actStatus = basicDataService.getAllActStatus();
		return actStatus;
	}

	@GetMapping(path = "/api/getAllActStdComments")
	public List<ACT_STD_COMMENT_CODE> getAllActStdComments() {
		List<ACT_STD_COMMENT_CODE> allActStdComms = basicDataService.getAllComments();
		return allActStdComms;
	}

	@GetMapping(path = "/api/getAllBadges")
	public List<BADGE_CODE> getAllBadges() {
		List<BADGE_CODE> badges = basicDataService.getAllBadges();
		return badges;
	}

	@GetMapping(path = "/api/getAllCompetencies")
	public List<COMPETENCY_CODE> getAllCompetencies() {
		List<COMPETENCY_CODE> competencies = basicDataService.getAllCompetencies();
		return competencies;
	}

	@GetMapping(path = "/api/getAllUserStatus")
	public List<USER_STATUS_CODE> getAllUserStatus() {
		List<USER_STATUS_CODE> allUserStatus = basicDataService.getAllUserStatus();
		return allUserStatus;
	}

	@GetMapping(path = "/api/getAllUserStdComments")
	public List<USER_STD_COMMENT_CODE> getAllUserStdComments() {
		List<USER_STD_COMMENT_CODE> allUserStdComms = basicDataService.getAllUserStdComments();
		return allUserStdComms;
	}
	
	@GetMapping(path = "/api/getAllReleaseTargets")
	public List<Release_target_code> getAllReleaseTargets() {
		List<Release_target_code> allReleaseTargets = basicDataService.getAllReleaseTargets();
		return allReleaseTargets;
	}
}