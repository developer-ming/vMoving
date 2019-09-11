package com.vmoving.service.impl;

import com.vmoving.service.UserService;
import com.vmoving.service.WeChatApiService;

import net.sf.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.codec.json.Jackson2JsonDecoder;
import org.springframework.stereotype.Service;
import org.apache.commons.beanutils.*;
import org.apache.commons.codec.binary.Base64;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.*;

import com.vmoving.config.WxConfig;
import com.vmoving.domain.ActivityTypeCode;
import com.vmoving.domain.Personal_Achievements;
import com.vmoving.domain.Personal_Contact;
import com.vmoving.domain.Personal_Maxim;
import com.vmoving.domain.UserBasicData;
import com.vmoving.domain.User_favor_act_data;
import com.vmoving.dto.CollectUserGroupParams;
import com.vmoving.dto.LikeActivity;
import com.vmoving.dto.UserFavorDto;
import com.vmoving.dto.WeChatApiResult;
import com.vmoving.repository.PersonalAchievementsRepository;
import com.vmoving.repository.PersonalContactRepository;
import com.vmoving.repository.PersonalMaximRepository;
import com.vmoving.repository.UserBasicDataRepository;
import com.vmoving.repository.UserFavorActData;

@Service
public class UserServiceImpl implements UserService {

	private static boolean hasInited = false;

	@Autowired
	private UserBasicDataRepository userBasicRepository;

	@Autowired
	private UserFavorActData userFavorDataRepo;

	@Autowired
	private PersonalAchievementsRepository personalAchieRepo;

	@Autowired
	private PersonalContactRepository personalContactRepo;

	@Autowired
	private PersonalMaximRepository personalMaximRepo;

	@Autowired
	private WxConfig wxConfig;

	@Autowired
	private WeChatApiService weChatApiService;
	
	@Autowired
	private ActivityTypeCodeServiceImpl actTypeCodeService;

	@Override
	public UserBasicData saveUser(UserBasicData userBasicData) {
		if (userBasicRepository.findByOpenID(userBasicData.getOpenid()) != null)
			return new UserBasicData();

		return userBasicRepository.save(userBasicData);
	}

	@Override
	public UserBasicData findUserByOpenId(String openId) {
		if (openId.isEmpty())
			return null;

		return userBasicRepository.findByOpenID(openId);
	}

	@Override
	public UserBasicData findUserByUserId(int userId) {
		return userBasicRepository.findByUserID(userId);
	}

	@Override
	public Personal_Achievements savePersonalAchievement(String openid, String achievement) {
		if (openid == null)
			return null;

		Personal_Achievements pachiev = new Personal_Achievements();

		pachiev.setOpenid(openid);
		pachiev.setAchievement_content(achievement);

		return personalAchieRepo.save(pachiev);
	}

	@Override
	public Personal_Contact savPersonalContact(String openid, String contact, String contacttype) {
		if (openid == null)
			return null;

		Personal_Contact pconcat = new Personal_Contact();
		pconcat.setOpenid(openid);
		pconcat.setConcatway(contact);
		pconcat.setConcattype(contacttype);

		return personalContactRepo.save(pconcat);
	}

	@Override
	public List<Personal_Achievements> findAllPersonalAchievements(String openid) {
		return personalAchieRepo.findAllAchievements(openid);
	}

	@Override
	public List<Personal_Contact> findAllPersonalContacts(String openid) {
		return personalContactRepo.findAllContacts(openid);
	}

	@Override
	public List<Personal_Maxim> findAllPersonalMaxims(String openid) {
		return personalMaximRepo.findAllPersonalMaxims(openid);
	}

	@Override
	public Personal_Maxim savPersonalMaxim(String openid, String maximcontent) {
		if (openid == null)
			return null;

		Personal_Maxim pm = new Personal_Maxim();
		pm.setOpenid(openid);
		pm.setMaximcontent(maximcontent);
		return personalMaximRepo.save(pm);
	}

	@Override
	public List<LikeActivity> getActTypeList(int userid) {

		return userFavorDataRepo.getActTypeList(userid);
	}

	public static void init() {
		if (hasInited) {
			return;
		}
		Security.addProvider(new BouncyCastleProvider());
		hasInited = true;
	}

	@Override
	public Map collectUserGroupInfo(CollectUserGroupParams cugps) {
		Map map = new HashMap();

		if (cugps.getCode().isEmpty()) {
			map.put("status", 0);
			map.put("msg", "code 不能为空");
			return map;
		}

		// String appId = wxConfig.getAppId();
		// String appSecret = wxConfig.getAppSecret();

		// 1、向微信服务器 使用登录凭证 code 获取 session_key 和 openid
		WeChatApiResult result = null;
		try {
			// 发送请求
			//result = weChatApiService.get(wxConfig.getCodeToSessionApi(cugps.getCode()), WeChatApiResult.class);
			// 获取会话密钥（session_key
			String session_key = cugps.getSession_key();
			// 用户的唯一标识（openid）
			//String opendId = result.getOpenid();
			// 2、对encryptedData加密数据进行AES解密

			try {
//				 
				String decryptResultString = "";
				init();
				byte[] sessionKeyByte = Base64.decodeBase64(session_key);
				byte[] ivByte = Base64.decodeBase64(cugps.getIv());
				byte[] encryptDataByte = Base64.decodeBase64(cugps.getEncryptedData());
				try {
					Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
					Key key = new SecretKeySpec(sessionKeyByte, "AES");
					AlgorithmParameters algorithmParameters = AlgorithmParameters.getInstance("AES");
					algorithmParameters.init(new IvParameterSpec(ivByte));
					cipher.init(Cipher.DECRYPT_MODE, key, algorithmParameters);
					byte[] bytes = cipher.doFinal(encryptDataByte);
					decryptResultString = new String(bytes);
				} catch (Exception e) {
					e.printStackTrace();
				}

				if (null != decryptResultString && decryptResultString.length() > 0) {
					map.put("status", 1);
					map.put("msg", "解密成功");
					JSONObject resultInfo = JSONObject.fromObject(decryptResultString);
					map.put("resData", resultInfo);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return map;
	}

	@Override
	public HashMap<String, String> saveLikeSports(UserFavorDto ufDto) {
		HashMap<String, String> result = new HashMap<String, String>();
		
		for (String sportName : ufDto.likesports) {
		   ActivityTypeCode atc = actTypeCodeService.getActivityCodeByTypeName(sportName.trim());
		   if(atc!=null && !atc.getActivityTypeCode().isEmpty()) {
			    User_favor_act_data userfavorEntity = new User_favor_act_data();
				userfavorEntity.setUser_ID(ufDto.getUserid());
				userfavorEntity.setACT_TYPE_ID(atc.getActTypeId());
				
				
				List<User_favor_act_data> existedUfaDatas = userFavorDataRepo.findAll().stream().filter(s -> s.getUser_ID()== ufDto.getUserid())
				.filter(s -> s.getACT_TYPE_ID() == atc.getActTypeId())
				.collect(Collectors.toList());
				 
				 if(existedUfaDatas.size() == 0)
				 {
					 switch (atc.getActTypeId()) {
						case 1:
							userfavorEntity.setCOMPETENCY_ID(1);
							break;
						case 2:
							userfavorEntity.setCOMPETENCY_ID(6);				
							break;
						case 3:
							userfavorEntity.setCOMPETENCY_ID(11);
							break;
						case 4:
							userfavorEntity.setCOMPETENCY_ID(16);	
							break;
			    	}
					 
					 userFavorDataRepo.save(userfavorEntity);
					 result.put("status", "OK"); 
				 }else {
					 
					 if(ufDto.getCompenencyid() > 0) {
						 User_favor_act_data existedufa = existedUfaDatas.get(0);
						 existedufa.setCOMPETENCY_ID(ufDto.getCompenencyid());
						 userFavorDataRepo.saveAndFlush(existedufa);
						 result.put("status", "OK"); 
					 }
				}
		   }
		}
 
		return result;
	}
	
	@Override
	public HashMap<String, String> deleteLikeSports(UserFavorDto ufDto) {
		HashMap<String, String> result = new HashMap<String, String>();
		
		for (String sportName : ufDto.likesports) {
		   ActivityTypeCode atc = actTypeCodeService.getActivityCodeByTypeName(sportName.trim());
		   if(atc!=null && !atc.getActivityTypeCode().isEmpty()) {
				List<User_favor_act_data> existedUfaDatas = userFavorDataRepo.findAll().stream().filter(s -> s.getUser_ID()== ufDto.getUserid())
				.filter(s -> s.getACT_TYPE_ID() == atc.getActTypeId())
				.collect(Collectors.toList());
				 
				 if(existedUfaDatas.size() > 0)
				 {
					 User_favor_act_data existedUfad = existedUfaDatas.get(0);
					 userFavorDataRepo.delete(existedUfad);
					 result.put("status", "Delete successfully"); 
					  
				 } 
		   }
		}
 
		return result;
	}
}