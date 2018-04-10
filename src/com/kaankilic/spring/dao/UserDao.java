package com.kaankilic.spring.dao;

import java.util.List;

import com.kaankilic.spring.entity.User;

public interface UserDao {
	
	public List<User> getUsers();
	
	public void saveUser(User user);
		
	

}
