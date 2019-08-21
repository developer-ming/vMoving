package com.vmoving.web.rest;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vmoving.domain.Act_Participant_Record;
import com.vmoving.domain.Activity;
import com.vmoving.service.ActParticipantRecordService;

@RestController
public class ParticipantController {
	
	@Autowired
	private ActParticipantRecordService actParticipantRecordService;
	
	public Act_Participant_Record updateParticipant(Act_Participant_Record ptUpdate) {
		return actParticipantRecordService.updateAct_Participant_Record(ptUpdate);
	}
	
	private static final Logger log = LoggerFactory.getLogger(ParticipantController.class);
	
	@GetMapping(path = "/api/getAct_ParticipantRecordsCountByactId")
	public int getAct_ParticipantRecordsCountByactId(@RequestParam int actId) {
		try {
			return actParticipantRecordService.getAct_ParticipantRecordsCountByactId(actId);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return 0;
	}
}
