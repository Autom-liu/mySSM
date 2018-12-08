package com.scnu.contanst;

import java.util.HashMap;
import java.util.Map;

public enum LoginCodeEnum implements Constanst {
	
	SUCCESS(0,"登录成功"),
	CHECKCODE_ERROR(40003,"验证码错误"),
	LOCK_ERROR(40007,"账号被锁定，请联系管理员"),
	SESSION_EXPIRE(40015,"由于你长时间未操作，请尝试重新登录"),
	LOGIN_ERROR(40004,"账号密码错误");
	
	private Integer code;
	private String msg;
	private LoginCodeEnum(Integer code, String msg) {
		this.code = code;
		this.msg = msg;
	}
	public Integer getCode() {
		return code;
	}
	public String getMsg() {
		return msg;
	}
	
	@Override
	public Map<String, Object> convertToMap() {
		Map<String, Object> resultCode = new HashMap<String, Object>();
		resultCode.put("code", this.code);
		resultCode.put("msg", this.msg);
		return resultCode;
	}
	
}
