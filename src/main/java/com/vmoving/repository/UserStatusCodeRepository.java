package com.vmoving.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vmoving.domain.USER_STATUS_CODE;

public interface UserStatusCodeRepository extends JpaRepository<USER_STATUS_CODE, Integer> {

}
