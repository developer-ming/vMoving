package com.vmoving.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vmoving.domain.Private_Message;
import com.vmoving.domain.UserBasicData;
import com.vmoving.dto.MessageDto;
import com.vmoving.repository.PrivateMessageRepository;
import com.vmoving.service.PrivateMessageService;
import com.vmoving.service.UserService;

@Service
public class PrivateMessageServiceImpl implements PrivateMessageService {

	private static final Logger log = LoggerFactory.getLogger(PrivateMessageServiceImpl.class);
	private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

	@Autowired
	private PrivateMessageRepository privateMessageRepo;

	@Autowired
	private UserService userService;

	@Override
	public Private_Message savePrivate_Message(Private_Message message) {
		return privateMessageRepo.save(message);
	}

	@Override
	public Private_Message savePrivate_Message(int sender, int receiver, String msg) {
		Private_Message message = new Private_Message();
		try {
			message.setREAD_UNREAD(0);
			message.setSENDER_ID(sender);
			message.setRECEIVER_ID(receiver);
			String createDate = sdf.format(new Date());
			message.setTIME_STAMP(sdf.parse(createDate));
			message.setPRIVATE_MESSAGE_CONTENT(msg);
			privateMessageRepo.save(message);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return message;
	}

	@Override
	public List<Private_Message> findAllPrivate_Messages() {
		List<Private_Message> messageLists = new ArrayList<Private_Message>();
		try {
			messageLists = privateMessageRepo.findAll();
		} catch (Exception e) {
			log.error(e.getMessage());
		}

		return messageLists;
	}

	@Override
	public List<MessageDto> findMessagesByUserId(int userId) {
		List<MessageDto> msgDtos = new ArrayList<MessageDto>();
		try {
			List<Private_Message> messageLists = privateMessageRepo.findAll().stream().filter(m -> m.getRECEIVER_ID() == userId)
					.collect(Collectors.toList());

			for (Private_Message pmsg : messageLists) {
				MessageDto msgDto = new MessageDto();
				msgDto.setCreatetime(sdf.format(pmsg.getTIME_STAMP()));
				msgDto.setIs_unread(pmsg.getREAD_UNREAD());
				msgDto.setMessage_content(pmsg.getPRIVATE_MESSAGE_CONTENT());

				int senderId = pmsg.getSENDER_ID();
				UserBasicData sendUser = userService.findUserByUserId(senderId);

				msgDto.setSender(sendUser != null ? sendUser.getNickName() : "");
				msgDto.setAvatarUrl(sendUser != null ? sendUser.getAvatarUrl() : "");
				msgDtos.add(msgDto);
			}

		} catch (Exception e) {
			log.error(e.getMessage());
		}

		return msgDtos;
	}
}
