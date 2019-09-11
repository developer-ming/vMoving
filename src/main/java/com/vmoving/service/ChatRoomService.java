package com.vmoving.service;

import java.util.List;

import com.vmoving.domain.Chat_room;
import com.vmoving.dto.UserChatDto;

public interface ChatRoomService {
	Chat_room saveUserChat(UserChatDto comment);
	List<Chat_room> getUserChats();
	Chat_room getOneUserChat(int chatid);
	Chat_room cancelChat(int chatid);
	List<Chat_room> getUserChatsByActId(int actId);
}
