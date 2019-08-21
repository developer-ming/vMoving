package com.vmoving.dto;

import java.io.Serializable;

public class CollectUserGroupParams implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String session_key;
	private String code;
	private String encryptedData;
	private String iv;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getEncryptedData() {
		return encryptedData;
	}
	public void setEncryptedData(String encryptedData) {
		this.encryptedData = encryptedData;
	}
	public String getIv() {
		return iv;
	}
	public void setIv(String iv) {
		this.iv = iv;
	}
	public String getSession_key() {
		return session_key;
	}
	public void setSession_key(String session_key) {
		this.session_key = session_key;
	}
}
