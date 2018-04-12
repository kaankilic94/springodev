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

	@Override
	public void deleteTask(int id, int userId) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<Task> query  = currentSession.createQuery("delete Task where id = :id");
		query.setParameter("id", id);
		
		Query<Task> controlQuery  = currentSession.createQuery("from Task where id = :id", Task.class);
		controlQuery.setParameter("id", id);
		
		if (userId == controlQuery.list().get(0).getUserId()) {
			query.executeUpdate();
		}else {
			System.out.println("No authorization");
		}
		
		
		
	}

	@Override
	public Task getTask(int id) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Task> query  = currentSession.createQuery("from Task where id = :id", Task.class);
		query.setParameter("id", id);
		
		Task task = query.list().get(0);
		
		return task;
	}

	@Override
	public void updateTask(Task theTask) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(theTask);
		
	}

	@Override
	public List<Object[]> getJoined() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query query = currentSession.createSQLQuery("SELECT  users.first_name, users.last_name, tasks.* FROM users INNER JOIN tasks ON users.id = tasks.user_id");
		
		List<Object[]> rows = query.list();
		
//		for (Object[] row : rows) {
//			System.out.println(row[0].toString());
//		}
//		
		return rows;
		
		
	}

	@Override
	public void adminDeleteTask(int id) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Task> query  = currentSession.createQuery("delete Task where id = :id");
		query.setParameter("id", id);
		query.executeUpdate();
		
	}

}
