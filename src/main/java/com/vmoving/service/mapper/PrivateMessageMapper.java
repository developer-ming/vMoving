package com.vmoving.service.mapper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.vmoving.domain.Private_Message;
import com.vmoving.dto.MessageDto;

@Component
public class PrivateMessageMapper {
	private static final Logger log = LoggerFactory.getLogger(PrivateMessageMapper.class);
	private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	
	public  Private_Message toEntityMessage(MessageDto mdt) {
		if(mdt == null)
			return null;
		Private_Message private_Message = new Private_Message();
		
		Date createDate;
		try {
			private_Message.setSENDER_ID(mdt.getSender_id());
			private_Message.setRECEIVER_ID(mdt.getReceiver_id());
			private_Message.setPRIVATE_MESSAGE_CONTENT(mdt.getMessage_content());
			private_Message.setREAD_UNREAD(mdt.getIs_unread());
			createDate = sdf.parse(mdt.getCreatetime());
			private_Message.setTIME_STAMP(createDate);
		} catch (ParseException e) {
			 log.error(e.getMessage());
			e.printStackTrace();
		}
		return private_Message;
	};
	
	public MessageDto toMessageDto(Private_Message msg) {
		MessageDto messageDto = new MessageDto();
		try {
			messageDto.setReceiver_id(msg.getRECEIVER_ID());
			messageDto.setSender_id(msg.getSENDER_ID());
			messageDto.setIs_unread(msg.getREAD_UNREAD());
			messageDto.setMessage_content(msg.getPRIVATE_MESSAGE_CONTENT());
			String createTime = sdf.format(msg.getTIME_STAMP());
			messageDto.setCreatetime(createTime);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		
		return messageDto;
	}
}
