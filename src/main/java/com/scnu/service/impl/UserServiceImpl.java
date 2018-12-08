package com.scnu.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scnu.bean.User;
import com.scnu.contanst.LoginCodeEnum;
import com.scnu.dao.UserDao;
import com.scnu.dto.UserDto;
import com.scnu.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;

	@Override
	public LoginCodeEnum checkLogin(UserDto userDto) {
		User user = new User();
		BeanUtils.copyProperties(userDto, user);
		List<User> result = userDao.selectByCond(user);
		if(result.size() == 1) {
			BeanUtils.copyProperties(result.get(0),userDto);
			// TODO 需要更新登录信息
			return LoginCodeEnum.SUCCESS;
		}
		return LoginCodeEnum.LOGIN_ERROR;
	}

}
