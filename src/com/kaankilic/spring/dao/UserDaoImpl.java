package com.kaankilic.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kaankilic.spring.entity.User;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<User> getUsers() {

		Session currentSession = sessionFactory.getCurrentSession();

		Query<User> theQuery = currentSession.createQuery("from User", User.class);

		List<User> users = theQuery.getResultList();

		return users;
	}

	@Override
	public boolean saveUser(User user) {
		Session currentSession = sessionFactory.getCurrentSession();

		Query<User> query = currentSession.createQuery("from User where email = :email ", User.class);
		query.setParameter("email", user.getEmail());

		List<User> list = query.list();

		if (list.size() == 0) {
			currentSession.saveOrUpdate(user);
			return true;
		} else {
			return false;
		}

		

	}

	@Override
	public User getUser(String email, String password) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<User> query = currentSession.createQuery("from User where email = :email and password = :password ", User.class);
		query.setParameter("email", email);
		query.setParameter("password",password);
		User user = null;
//		try {
//			user = query.getSingleResult();
//		} catch (Exception e) {
//			System.out.println("No result exc:" + e.getMessage());
//		}
		
		List<User> list = query.list();
		
		if (list.size() == 1) {
			return list.get(0);
		}else {
			return null;
		}
		
		
		
	}

}
