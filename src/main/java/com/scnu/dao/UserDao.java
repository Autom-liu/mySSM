package com.scnu.dao;

import java.util.List;

import com.scnu.bean.User;

public interface UserDao {
	List<User> selectByCond(User user);
}
