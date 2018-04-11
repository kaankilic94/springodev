package com.kaankilic.spring.service;

import java.util.List;

import com.kaankilic.spring.entity.Task;

public interface TaskService {
	public void saveTask(Task task);
	public List<Task> getTasks(int id);
}
