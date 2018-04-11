package com.kaankilic.spring.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kaankilic.spring.accesscontroller.AccessControl;
import com.kaankilic.spring.entity.User;
import com.kaankilic.spring.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private AccessControl accessControl;
	
	@RequestMapping("/user")
	public String showUser(Model model, HttpServletRequest request) {
		
		List<User> users = userService.getUsers();
		
		model.addAttribute("users", users);
		
		//return accessControl.accessControl(request, "user");
		return "user";
	}
	
	@GetMapping("/admin")
	public String showAdmin(HttpServletRequest request) {
		
		return accessControl.accessControl(request, "admin");
	}

}
