package com.vmoving.service;

import java.util.List;

import com.vmoving.domain.Private_Message;
import com.vmoving.dto.MessageDto;

public interface PrivateMessageService {
	public Private_Message savePrivate_Message(Private_Message message);
	public Private_Message savePrivate_Message(int sender,int receiver,int actId ,String actName,int actStatus,String msg, int messagetype);
	public void updatePrivate_Message(String openId) ;
	public List<Private_Message> findAllPrivate_Messages();
	public List<MessageDto> findMessagesByUserId(int userId);
	public int findMessagesCountByOpenId(String openId);
}
