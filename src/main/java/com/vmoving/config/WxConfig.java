package com.vmoving.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class WxConfig {
	@Value("${wx.appid}")
	private String appId;
 
	@Value("${wx.appsecret}")
	private String appSecret;
	
	@Value("${wx.api.code2Session}")
	private String codeToSessionApi;
	
	public String getAppId() {
		return appId;
	}
	 
	public String getAppSecret() {
		return appSecret;
	}

	public String getCodeToSessionApi(String code) {
		return codeToSessionApi.replace("$JSCODE", code);
	}
}
