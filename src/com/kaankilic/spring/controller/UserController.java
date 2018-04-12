package com.kaankilic.spring.controller;



import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kaankilic.spring.accesscontroller.AccessControl;
import com.kaankilic.spring.entity.Duty;
import com.kaankilic.spring.entity.Task;
import com.kaankilic.spring.service.TaskService;

@Controller
public class UserController {
	
	@Autowired
	private TaskService taskService;
	
	@Autowired
	private AccessControl accessControl;

	
	
	@RequestMapping("/user")
	public String showUser(Model model, HttpServletRequest request) {
		
		boolean control = request.getSession().getAttribute("userId") == null;
			
		if (!control) {
			int id = (int) request.getSession().getAttribute("userId");
			List<Task> list = taskService.getTasks(id);
			model.addAttribute("tasks", list);
			return "user";
		}else {
			return "redirect:/";
			
		}
		
		
	}
	
	@GetMapping("/admin")
	public String showAdmin(HttpServletRequest request, Model model) {
		
		List<Object[]> rows = taskService.getJoined();
		List<Duty> list = new ArrayList<>();
		
		
		for (Object[] row : rows) {
			
			Duty duty =  new Duty();
			
			duty.setFirstName(row[0].toString());
			duty.setLastName(row[1].toString());
			duty.setId((int)row[2]);
			duty.setUserId((int)row[3]);
			duty.setTaskName(row[4].toString());
			duty.setDate(row[5].toString());
			duty.setDescription(row[6].toString());
			duty.setStatus(row[7].toString());
			
			list.add(duty);
			
			
		}
		
		model.addAttribute("dutys", list);
		
		
		return accessControl.accessControl(request, "admin");
	}
	
//	@GetMapping("/deneme")
//	public String deneme(){
//		
//		taskService.getJoined();
//		
//		return "user";
//	}

}
