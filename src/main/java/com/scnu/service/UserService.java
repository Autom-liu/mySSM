package com.scnu.service;

import com.scnu.contanst.LoginCodeEnum;
import com.scnu.dto.UserDto;

public interface UserService {
	
	public LoginCodeEnum checkLogin(UserDto user);
}
