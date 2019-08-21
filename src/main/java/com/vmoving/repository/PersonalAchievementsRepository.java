package com.vmoving.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.vmoving.domain.Personal_Achievements;

public interface PersonalAchievementsRepository extends JpaRepository<Personal_Achievements, Integer> {

	@Query(value="SELECT pa FROM Personal_Achievements pa WHERE pa.openid=?1")
	public List<Personal_Achievements> findAllAchievements(@Param(value = "openid") String openid);
}
