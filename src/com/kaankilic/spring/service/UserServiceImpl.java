package com.kaankilic.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kaankilic.spring.dao.UserDao;
import com.kaankilic.spring.entity.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	@Transactional
	public List<User> getUsers() {
		return userDao.getUsers();
	}

	@Override
	@Transactional
	public boolean saveUser(User user) {
		return userDao.saveUser(user);
	}

	@Override
	@Transactional
	public User getUser(String email, String password) {
		return userDao.getUser(email, password);
	}

}
