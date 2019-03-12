package com.vmoving.web.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vmoving.domain.Private_Message;
import com.vmoving.dto.MessageDto;
import com.vmoving.service.PrivateMessageService;
import com.vmoving.service.mapper.PrivateMessageMapper;

@RestController
public class PrivateMessageController {
	
	@Autowired
	private PrivateMessageService pMessageService;
	
	@Autowired
	private PrivateMessageMapper pMessageMpper;
	
	@PostMapping(path="/api/saveMessage")
	public Private_Message saveMessage(@RequestBody MessageDto message){
		Private_Message pMessageEntity = pMessageMpper.toEntityMessage(message);
		return pMessageService.savePrivate_Message(pMessageEntity);
	}
	
	@GetMapping(path="/api/findAllMessages")
	public List<Private_Message> findAllMessages(){
		return pMessageService.findAllPrivate_Messages();
	}
	
	@GetMapping(path="/api/findMessagesByUserId")
	public List<MessageDto> findMessagesByUserId(@RequestParam int userId){
		return pMessageService.findMessagesByUserId(userId);
	}
}
