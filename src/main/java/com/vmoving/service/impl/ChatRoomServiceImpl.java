package com.vmoving.service.impl;

import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.cache.spi.entry.UnstructuredCacheEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vmoving.domain.Chat_room;
import com.vmoving.domain.UserBasicData;
 
import com.vmoving.dto.UserChatDto;
import com.vmoving.repository.ChartRoomRepository;
import com.vmoving.service.ChatRoomService;
import com.vmoving.service.UserService;

@Service
public class ChatRoomServiceImpl implements ChatRoomService {
	
	private static String  datFormat = "yyy-MM-dd hh:mm:ss";
	private static SimpleDateFormat sdf = new SimpleDateFormat(datFormat);
	
	@Autowired
	private ChartRoomRepository chatRepo;
	
	@Autowired
	private UserService userService;

	@Override
	public Chat_room saveUserChat(UserChatDto chatDto) {
		Chat_room chat = new Chat_room();
		chat.setActid(chatDto.getActid());
		chat.setChatcontent(chatDto.getUserchatcomment());
		chat.setIscancel(0);
		 
		String  commentdate = sdf.format(new Date());
		chat.setCommenttdate(commentdate);
	 
		try {
		 UserBasicData user	= userService.findUserByOpenId(chatDto.getOpenid());
		 if(user != null) {
			 chat.setUserid(user.getUser_id());
			 chat.setUsernickname(user.getNickName());
			 chat.setUseravatorurl(user.getAvatarUrl());
		 }
		} catch (Exception e) {
			throw e;
		}
		
		return chatRepo.save(chat);
		 
	}

	@Override
	public List<Chat_room> getUserChats() {
		return chatRepo.findAll();
	}

	@Override
	public Chat_room getOneUserChat(int chatid) {
		return chatRepo.getOne(chatid);
	}

	@Override
	public Chat_room cancelChat(int chatid) {
		 Chat_room chat = chatRepo.getOne(chatid);
		 if(chat != null && chat.getChar_room_id() > 0 && chat.getIscancel() == 1) {
			 chat.setIscancel(1);
			 chatRepo.saveAndFlush(chat);
		 }
		return chat;
	}

	@Override
	public List<Chat_room> getUserChatsByActId(int actId) {
		return chatRepo.findAll().stream()
				.filter(uc -> uc.getActid() == actId)
				.sorted(Comparator.comparing(Chat_room::getChar_room_id))
				.collect(Collectors.toList());
	}

}
