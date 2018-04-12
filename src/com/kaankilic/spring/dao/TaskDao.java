package com.kaankilic.spring.dao;

import java.util.List;

import com.kaankilic.spring.entity.Task;

public interface TaskDao {
	
	public void saveTask(Task task);
	
	public List<Task> getTasks(int id);
	
	public void deleteTask(int id, int userId);
	
	public Task getTask(int id);
	
	public void updateTask(Task theTask);

}
