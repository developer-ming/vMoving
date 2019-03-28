package com.vmoving.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
 
import com.vmoving.domain.Private_Message;

public interface PrivateMessageRepository extends JpaRepository<Private_Message, Integer> {
	@Query("select pm from Private_Message pm where pm.ActId = ?1 and pm.ActStatus=?2 and pm.ActName=?3")
	public Private_Message getPrivateMessage(int ActId,int ActStatus,String ActName);
	
}
