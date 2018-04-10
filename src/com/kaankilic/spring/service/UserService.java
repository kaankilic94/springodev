package com.kaankilic.spring.service;

import java.util.List;

import com.kaankilic.spring.entity.User;

public interface UserService {

	public List<User> getUsers();
	
	public void saveUser(User user);
	
}
