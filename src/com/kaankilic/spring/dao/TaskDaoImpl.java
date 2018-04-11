package com.kaankilic.spring.dao;


import java.util.List;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kaankilic.spring.entity.Task;

@Repository
public class TaskDaoImpl implements TaskDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void saveTask(Task task) {
	
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(task);
		
	}

	@Override
	public List<Task> getTasks(int id) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<Task> query  = currentSession.createQuery("from Task where userId = :id", Task.class);
		query.setParameter("id", id);
		
		return query.list();
	}

}
