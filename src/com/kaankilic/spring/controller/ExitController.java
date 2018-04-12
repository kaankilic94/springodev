package com.kaankilic.spring.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class ExitController {
	
	@GetMapping("/exit")
	public String exit(Model model,  HttpServletRequest req) {

		req.getSession().invalidate();

		return "redirect:/";
	}

}
