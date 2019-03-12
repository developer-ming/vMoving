package com.vmoving.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vmoving.domain.Private_Message;

public interface PrivateMessageRepository extends JpaRepository<Private_Message, Integer> {

}
