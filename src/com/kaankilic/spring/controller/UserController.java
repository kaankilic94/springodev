package com.kaankilic.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kaankilic.spring.entity.User;
import com.kaankilic.spring.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/list")
	public String showUser(Model model) {
		
		List<User> users = userService.getUsers();
		
		model.addAttribute("users", users);
		
		
		return "user";
	}

}
