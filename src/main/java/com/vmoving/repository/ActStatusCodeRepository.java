package com.vmoving.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vmoving.domain.ACT_STATUS_CODE;

public interface ActStatusCodeRepository extends JpaRepository<ACT_STATUS_CODE, Integer> {

}
