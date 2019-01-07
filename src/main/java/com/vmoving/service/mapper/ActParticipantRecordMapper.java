package com.vmoving.service.mapper;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.vmoving.domain.Act_Participant_Record;
import com.vmoving.domain.Activity;

public class ActParticipantRecordMapper {
	private static SimpleDateFormat sFormat = new SimpleDateFormat("yyyy-MM-dd");

	public static Act_Participant_Record toEntity(Activity act, int userid) {
		Act_Participant_Record apr = new Act_Participant_Record();
		apr.setAct_id(act.getACT_ID());
		apr.setUser_id(userid);
		apr.setUser_status_id(2);// 报名成功
		apr.setStep_count(0);
		apr.setCalorie(0);
		apr.setOverall_exp_gain(0);
		apr.setJoindate(new Date());
		return apr;
	}
}
