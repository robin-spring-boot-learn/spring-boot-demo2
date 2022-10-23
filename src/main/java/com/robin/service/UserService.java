package com.robin.service;

import org.springframework.stereotype.Service;

import com.robin.entity.User;

@Service
public interface UserService {
	
	public User getUser(long id);
}
