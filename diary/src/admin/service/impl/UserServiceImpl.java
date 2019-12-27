package admin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import admin.mapper.UserMapper;
import admin.po.User;
import admin.service.UserService;


public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public int checkUser(User user) throws Exception {
	
		return userMapper.checkUser(user);
	}

}
