package com.vmoving.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vmoving.domain.UserComment;

public interface UserCommentRepository extends JpaRepository<UserComment, Integer> {

}
