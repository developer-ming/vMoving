package com.vmoving.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.vmoving.domain.ActComment;

public interface ClockinRepository extends JpaRepository<ActComment, Integer> {

	@Query("SELECT ct FROM ActComment ct where ct.comment_provider_id = ?1 and ct.act_id = ?2")
	public List<ActComment> getClockingSummary(int userid,int actid); 
	
	@Query("SELECT ct FROM ActComment ct where ct.act_id = ?1")
	public List<ActComment> getActCommentsByActId(int actid); 
}
