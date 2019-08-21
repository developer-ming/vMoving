package com.vmoving.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vmoving.domain.ActivityTypeCode;
import com.vmoving.repository.ActivityTypeCodeRepository;
import com.vmoving.service.ActivityTypeCodeService;

@Service
public class ActivityTypeCodeServiceImpl implements ActivityTypeCodeService {
	
	@Autowired
	public ActivityTypeCodeRepository acttypeRepo;

	@Override
	public ActivityTypeCode getActivityCodeByTypeName(String activitytype) {
		return acttypeRepo.getActivityTypeByType(activitytype);
	}

}
