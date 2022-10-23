package com.robin.service.impl;

import org.springframework.stereotype.Service;

import com.robin.entity.User;
import com.robin.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Override
	public User getUser(long id) {
		User user = new User();
		user.setId(id);
		return user;
	}

}
