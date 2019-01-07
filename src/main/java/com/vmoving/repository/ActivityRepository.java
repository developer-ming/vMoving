package com.vmoving.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.vmoving.domain.Activity;

public interface ActivityRepository extends JpaRepository<Activity, Integer> {
	@Query("select ac from Activity ac where ac.ACT_TYPE_ID=?1")
	public List<Activity> findActivitiesByType(int ACT_TYPE_ID);

	@Query("select ac from Activity ac where ac.ACT_ID=?1")
	public Activity findActivityByActId(int ACT_ID);

	@Modifying
	@Query("update Activity ac set ac.ACT_STATUS_ID = 2 where ac.ACT_ID=?1")
	public void updateActivityStatus(@Param(value = "ACT_ID") int ACT_ID);
}