package com.vmoving.dto;

import org.springframework.util.StringUtils;

/**
 * Invoking WeChat jscodeToSession API returned result
 */
public class WeChatApiResult {
	private String openid;
	private String session_key;
	private String unionid;
	private String errcode;
	private String errmsg;
	
	/**
	 * -1  system busy, please try again later.
	 *  0  request successfully.
	 *  40029 The code is invalid.
	 *  45011 limit to 100 each minutes.
	 * */
	
	public boolean hasError() {
		return !StringUtils.isEmpty(errcode) && !errcode.equals("0");
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getSession_key() {
		return session_key;
	}

	public void setSession_key(String session_key) {
		this.session_key = session_key;
	}

	public String getUnionid() {
		return unionid;
	}

	public void setUnionid(String unionid) {
		this.unionid = unionid;
	}

	public String getErrcode() {
		return errcode;
	}

	public void setErrcode(String errcode) {
		this.errcode = errcode;
	}

	public String getErrmsg() {
		return errmsg;
	}

	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}
}
