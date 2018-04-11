package com.kaankilic.spring.dao;

import java.util.List;

import com.kaankilic.spring.entity.Task;

public interface TaskDao {
	
	public void saveTask(Task task);
	
	public List<Task> getTasks(int id);

}
