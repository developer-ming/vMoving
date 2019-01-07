package com.vmoving.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
 

public interface UserBasicDataRepository  extends JpaRepository<com.vmoving.domain.UserBasicData, Integer>  {
	
	@Query("select u from UserBasicData u where u.openid=?1")
	public com.vmoving.domain.UserBasicData findByOpenID(String openId);
}
