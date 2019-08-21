package com.vmoving.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.vmoving.domain.Personal_Maxim;

public interface PersonalMaximRepository extends JpaRepository<Personal_Maxim, Integer> {
	@Query(value="SELECT pm FROM Personal_Maxim pm WHERE pm.openid=?1")
	public List<Personal_Maxim> findAllPersonalMaxims(@Param(value = "openid") String openid);
}
