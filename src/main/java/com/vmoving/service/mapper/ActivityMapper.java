package com.vmoving.service.mapper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vmoving.domain.Activity;
import com.vmoving.domain.UserBasicData;
import com.vmoving.dto.ActivityDTO;
import com.vmoving.repository.UserBasicDataRepository;
import com.vmoving.service.BasicDataService;

@Component
public class ActivityMapper {

	private static final Logger log = LoggerFactory.getLogger(ActivityMapper.class);

	@Autowired
	private BasicDataService bsDataServ;

	@Autowired
	private UserBasicDataRepository userBasicReop;

	public Activity dtoToEntity(ActivityDTO actDTO) throws ParseException {
		Activity activity = new Activity();
		try {
			activity.setACT_ID(actDTO.getAct_Id() == 0?0:actDTO.getAct_Id());
			activity.setOpenid(actDTO.getOpenId() == null ? "" : actDTO.getOpenId());
			activity.setACT_NAME(actDTO.getAct_title());
			activity.setACT_TYPE_ID(bsDataServ.getActTypeIdByCode(actDTO.getAct_type()));
			if (actDTO.getAct_start_date() != null) {
				String startDateVal = actDTO.getAct_start_date().replace('-', '/');
				activity.setACT_DATE(startDateVal);
			}

			activity.setACT_START_TIME(actDTO.getAct_start_time());
			activity.setACT_End_Time(actDTO.getAct_end_time());
			 
			if (actDTO.getAct_join_expire_date() != null) {
				String expireDateVal = actDTO.getAct_join_expire_date().replace('-', '/');
				activity.setACT_JOIN_EXPIRE_Date(expireDateVal);
			}

			activity.setACT_PLACE_ADDRESS(actDTO.getAddress() == null ? "" : actDTO.getAddress());
			activity.setACT_PLACE_GPS(actDTO.getGps() == null ? "" : actDTO.getGps().toString());
			activity.setACT_PLAYER_NUM(actDTO.getPersonnums());
			activity.setREQUIRE_COMPETENCY_ID(bsDataServ.getCompetencyIdByCode(actDTO.getAbility()));
			activity.setACT_FEE_TYPE(bsDataServ.getFeeTypeIdByCode(actDTO.getAvg_fee()));
			 
			int act_status = Integer.parseInt(actDTO.getAct_status() == null ? "0" : actDTO.getAct_status());
			activity.setACT_STATUS_ID(act_status);
			activity.setPICTURE_LINK(actDTO.getCoverImage());
			activity.setCOURT_BOOKING_STATUS(0);
			activity.setCOURTS("0");
			UserBasicData userBasicData = userBasicReop.findByOpenID(actDTO.getOpenId());
			if (userBasicData != null && userBasicData.getUser_id() > 0) {
				activity.setORGANZIER_ID(userBasicData.getUser_id());
			} else {
				activity.setORGANZIER_ID(1);
			}
			activity.setRELEASE_TARGET_ID(bsDataServ.getReleaseTargetCode(actDTO.getRelease_target()));
			activity.setWECHAT_GROUP_ID("");
			activity.setMATCH_METHOD_TYPE(bsDataServ.getMatchMethodIdByCode(actDTO.getMatch_method()));
			activity.setACT_DETAIL(actDTO.getActivity_details());
			activity.setACT_REMARK(actDTO.getTips());
			activity.setAct_place_location(actDTO.getAct_place_location());
		} catch (Exception e) {
			log.error(e.getMessage());
			throw e;
		}

		return activity;
	}

}
