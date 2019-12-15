package com.vmoving.service.mapper;

import java.util.Date;

import com.vmoving.domain.Act_Participant_Record;
import com.vmoving.domain.Activity;

public class ActParticipantRecordMapper {
	public static Act_Participant_Record toEntity(Activity act, int userid,int userStatus,String comments) {
		Act_Participant_Record apr = new Act_Participant_Record();
		apr.setAct_id(act.getACT_ID());
		apr.setAct_type_id(act.getACT_TYPE_ID());
		apr.setUser_id(userid);
		apr.setUser_status_id(userStatus);// 报名成功
		apr.setStep_count("0");
		apr.setCalorie("0");
		apr.setHours("0");
		apr.setJoindate(new Date().toString());
		apr.setIs_canceled(0);
		apr.setDaka_status(0);
		apr.setComments(comments);
		return apr;
	}
}
