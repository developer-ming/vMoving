package com.vmoving.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vmoving.config.WxConfig;
import com.vmoving.dto.WeChatApiResult;
import com.vmoving.service.WeChatApiService;

@RestController
public class AuthenticationController {

	@Autowired
	private WxConfig wxConfig;

	@Autowired
	private WeChatApiService weChatApiService;

	@GetMapping(path = "/api/getOpenId")
	public WeChatApiResult getOpenId(@RequestParam String code) {
		if (StringUtils.isEmpty(code))
			return null;

		WeChatApiResult result = null;
		try {
			result = weChatApiService.get(wxConfig.getCodeToSessionApi(code), WeChatApiResult.class);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}
}
