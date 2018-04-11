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

}
