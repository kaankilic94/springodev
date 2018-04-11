package com.kaankilic.spring.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.kaankilic.spring.entity.User;
import com.kaankilic.spring.service.UserService;

@Controller
public class SignInController {

	@Autowired
	private UserService userService;

	@GetMapping("/")
	public String home(Model model) {

		User user = new User();
		model.addAttribute("user", user);
		return "signin";

	}

	@GetMapping("/signin")
	public String singInGet(Model model) {

		User user = new User();
		model.addAttribute("user", user);
		return "signin";

	}

	@PostMapping("/signin")
	public String sigIn(@ModelAttribute("user") User user, Model model, HttpServletRequest request) {

		User theUser = userService.getUser(user.getEmail().trim(), user.getPassword().trim());

		if (user.getEmail().trim() == "" || user.getPassword().trim() == "") {
			model.addAttribute("invalid", "please do not leave free space");
			return "/signin";
		} else {
			if (theUser == null) {
				System.out.println("Invalid");
				model.addAttribute("invalid", "Sign in invalid");
				return "/signin";
			} else {
				request.getSession().setAttribute("userId", theUser.getId());
				request.getSession().setAttribute("userFirstName", theUser.getFirstName());
				request.getSession().setAttribute("userLastName", theUser.getLastName());
				request.getSession().setAttribute("userEmail", theUser.getEmail());
				request.getSession().setAttribute("userRank", theUser.getRank());
				if (theUser.getRank() == 1) {
					System.out.println("Rank 1");
					return "redirect:/admin";
				} else {
					System.out.println("Rank 0");
					return "redirect:/user";
				}
			}

		}

	}

}
