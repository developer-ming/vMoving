package com.vmoving.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.vmoving.domain.Personal_Contact;

public interface PersonalContactRepository extends JpaRepository<Personal_Contact, Integer> {

	@Query(value="SELECT pc FROM Personal_Contact pc WHERE pc.openid=?1")
	public List<Personal_Contact> findAllContacts(@Param(value="openid") String openid);
}
