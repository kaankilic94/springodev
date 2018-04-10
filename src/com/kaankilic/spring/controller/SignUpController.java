package com.kaankilic.spring.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kaankilic.spring.entity.User;
import com.kaankilic.spring.service.UserService;

@Controller
public class SignUpController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/signup")
	public String showSignUpForm(Model model) {
		
		User user =  new User();
		model.addAttribute("user",user);
		
		return "signup";
	}
	
	//Form post edildikten sonra
	@PostMapping("/signup")
	public String signUp(@Valid @ModelAttribute("user") User user, BindingResult bindingResult) {
		
		if (bindingResult.hasErrors()) {
			return "/signup";
		}else {
			userService.saveUser(user);
			return "redirect:/list";
		}
		
		
		
		
	}

}
