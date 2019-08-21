package com.vmoving.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.vmoving.domain.ActivityTypeCode;

public interface ActivityTypeCodeRepository extends JpaRepository<ActivityTypeCode, Integer> {
	@Query("SELECT atc FROM ActivityTypeCode atc where atc.activityTypeCode =?1")
	public ActivityTypeCode getActivityTypeByType(String activityTypeCode);
}
