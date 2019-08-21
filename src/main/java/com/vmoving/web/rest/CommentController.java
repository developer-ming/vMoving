package com.vmoving.web.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vmoving.domain.UserComment;
import com.vmoving.domain.UserPraise;
import com.vmoving.dto.UserCommentDto;
import com.vmoving.dto.UserPraiseDto;
import com.vmoving.service.UserCommentService;
import com.vmoving.service.UserPraiseService;

@RestController
public class CommentController {
	@Autowired
	private UserCommentService userCommentServ;
	
	@Autowired
	private UserPraiseService userPraiseServ;
	
	@PostMapping(path="/api/saveUserComment")
	public UserComment saveUserComment(@RequestBody UserCommentDto comment) {
		return userCommentServ.saveUserComment(comment);
	}
	
	@GetMapping(path="/api/getUserCommentsById")
	public List<UserComment> getUserCommentsById(@RequestParam int actCommentId){
		return userCommentServ.getUserCommentsByActCommentId(actCommentId);
	}
	
	@PostMapping(path="/api/saveUserPraise")
	public UserPraise saveUserPraise(@RequestBody UserPraiseDto praise) {
		return userPraiseServ.saveUserPraise(praise);
	}
	
	@GetMapping(path="/api/getUserPraisesById")
	public List<UserPraise> getUserPraisesById(@RequestParam int actCommentId){
		return userPraiseServ.getUserPraisesByActPraiseId(actCommentId);
	}
	
	@GetMapping(path="/api/cancelPraise")
	public UserPraise cancelPraise(@RequestParam String openid, @RequestParam int actcommentid){
		return userPraiseServ.cancelPraise(openid,actcommentid);
	}
	
}
