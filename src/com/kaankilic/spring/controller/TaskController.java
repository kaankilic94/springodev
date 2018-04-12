package com.kaankilic.spring.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kaankilic.spring.entity.Task;
import com.kaankilic.spring.enums.Status;
import com.kaankilic.spring.service.TaskService;

@Controller
public class TaskController {

	@Autowired
	private TaskService taskService;

	@GetMapping("/task")
	public String task(Model model, HttpServletRequest request) {

		boolean control = request.getSession().getAttribute("userId") == null;

		if (!control) {
			model.addAttribute("userId", request.getSession().getAttribute("userId").toString());
		} else {
			return "redirect:/";
		}

		Task task = new Task();
		model.addAttribute("task", task);

		return "task";
	}

	@PostMapping("/task")
	public String taskAdd(@ModelAttribute("task") Task task, @RequestParam(name = "userId") String userId,
			Model model) {

		if (task.getName().trim().equals("") || task.getDescription().trim().equals("")) {

			model.addAttribute("notNull", "Please don't leave empty space");
			return "task";

		}

		task.setUserId(Integer.valueOf(userId));
		taskService.saveTask(task);
		return "redirect:/user";

	}

	@GetMapping("/deletetask")
	public String deleteTask(@RequestParam(name = "taskID") int id, HttpServletRequest request) {

		System.out.println("Task ID: " + id);
		Integer userId = (Integer) request.getSession().getAttribute("userId");

		if (userId != null) {
			taskService.deleteTask(id, userId);
		}

		return "redirect:/user";
	}

	@GetMapping("/showupdateform")
	public String showUpdateForm(@RequestParam(name = "taskID") int id, Model model, HttpServletRequest request) {

		boolean control = request.getSession().getAttribute("userId") == null;
		if (control) {
			return "redirect:/";
		}
		//model.addAttribute("theTaskId", id);
		Task theTask = taskService.getTask(id);
		
		if (theTask.getUserId() != (int)request.getSession().getAttribute("userId")) {
			return "redirect:/user";
		}
		
		model.addAttribute("task", theTask);

		// Option Select
		Map<String, String> hMap = new HashMap<String, String>();

		for (Status status : Status.values()) {
			hMap.put(status.toString(), status.toString());
		}

		model.addAttribute("status", hMap);
		//Option Select

		return "updateform";
	}
	
	@PostMapping("/updatetask")
	public String updateTask(@ModelAttribute("task") Task task, HttpServletRequest request) {
		
		task.setUserId((int)request.getSession().getAttribute("userId"));
		taskService.updateTask(task);
		
		return "redirect:/user";
	}

}
