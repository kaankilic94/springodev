package com.kaankilic.spring.service;

import java.util.List;

import com.kaankilic.spring.entity.User;

public interface UserService {

	public List<User> getUsers();
	
	public boolean saveUser(User user);
	
	public User getUser(String email, String password);
	
}
