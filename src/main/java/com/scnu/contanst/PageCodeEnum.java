package com.scnu.contanst;

import java.util.HashMap;
import java.util.Map;

public enum PageCodeEnum {
	
	SUCCESS(10000, "success"),
	PARAM_WRONG(10401, "参数错误"),
	PARAM_FILE(10012, "请上传图片"),
	EXCEPTION(9999, "服务器内部错误");
	
	private Integer code;
	private String msg;
	
	public static final String KEY = "pageCode";
	
	private PageCodeEnum(Integer code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public Integer getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}
	
	public Map<?,?> convertToMap() {
		Map<String, String> resultCode = new HashMap<String, String>();
		resultCode.put("code", this.code.toString());
		resultCode.put("msg", this.msg);
		return resultCode;
	}
	
}
