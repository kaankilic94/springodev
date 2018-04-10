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

}
