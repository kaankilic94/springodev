package com.kaankilic.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IncludeController {

	@RequestMapping("/bootstrap")
	public String bootsrapInclude() {
		
		return "inc/bootstrap";
	}
	
}
