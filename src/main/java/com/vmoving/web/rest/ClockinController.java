package com.vmoving.web.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vmoving.domain.ActComment;
import com.vmoving.domain.Activity;
import com.vmoving.dto.ActCommentDto;
import com.vmoving.service.ActParticipantRecordService;
import com.vmoving.service.impl.ClockinServiceImpl;

@RestController
public class ClockinController {
	@Autowired
	private ClockinServiceImpl clockService;
	
	@Autowired
	private ActParticipantRecordService aprService;
	
	@PostMapping(path="/api/saveComment")
	public ActComment saveComment(@RequestBody ActCommentDto actComment) {
		return clockService.saveComment(actComment);
	}
	
	@GetMapping(path="/api/deleteComment")
	public void deleteComment(@RequestParam int actCommentId) {
		
	}
	
	@GetMapping(path="/api/findAllComments")
	public List<ActCommentDto> findAllComments(@RequestParam int actid, String openId){
		return clockService.findAllActComment(actid, openId);
	}
	
	@GetMapping(path="/api/getClockingSummary")
	public List<ActComment> getClockingSummary(@RequestParam int actid, String openid){
		return clockService.getClockingSummary(actid, openid);
	}
	
	@GetMapping(path="/api/isClockSuccefully")
	public boolean isClockSuccefully(@RequestParam int actid, String openid){
		return aprService.isClockSuccefully(actid, openid);
	}
	
	@GetMapping(path="/api/findNeededClockActivities")
	public List<Activity> findNeededClockActivities(@RequestParam int userid){
		return clockService.findNeededClockActivities(userid);
	}
	
	@GetMapping(path="/api/findNeededClockActivitiesCount")
	public int findNeededClockActivitiesCount(@RequestParam int userid){
		return clockService.findNeededClockActivitiesCount(userid);
	}
	
	@GetMapping(path="/api/checkIsClockForActivity")
	public boolean checkIsClockForActivity(@RequestParam int userid, int actid){
		return clockService.checkIsClockForActivity(userid,actid);
	}
	
	
	
}
