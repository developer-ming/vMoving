package com.vmoving.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.vmoving.domain.UserPraise;
public interface UserPraiseRepository extends JpaRepository<UserPraise, Integer> {
	
	@Query("select up from UserPraise up where up.openid = ?1 and up.act_comment_id = ?2")
	public UserPraise getOneUserPraiseByOpenid(String opeid, int act_comment_id);
	
	@Query("select up from UserPraise up where up.act_comment_id = ?1 and up.userid = ?2 and ispraise = 1")
	public UserPraise getOneUserPraiseByOpenid(int act_comment_id, int userid);
}
