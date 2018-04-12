package com.kaankilic.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kaankilic.spring.dao.TaskDao;
import com.kaankilic.spring.entity.Task;

@Service
public class TaskServiceImpl implements TaskService {

	@Autowired
	private TaskDao taskDao;
	
	@Override
	@Transactional
	public void saveTask(Task task) {
		taskDao.saveTask(task);
	}

	@Override
	@Transactional
	public List<Task> getTasks(int id) {
		return taskDao.getTasks(id);
	}

	@Override
	@Transactional
	public void deleteTask(int id , int userId) {
		taskDao.deleteTask(id, userId);
	}

	@Override
	@Transactional
	public Task getTask(int id) {
		return taskDao.getTask(id);
	}

	@Override
	@Transactional
	public void updateTask(Task theTask) {
		taskDao.updateTask(theTask);
		
	}

	@Override
	@Transactional
	public List<Object[]> getJoined() {
		return taskDao.getJoined();
		
	}

	@Override
	@Transactional
	public void adminDeleteTask(int id) {
		taskDao.adminDeleteTask(id);
		
	}

}
