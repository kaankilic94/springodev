package com.kaankilic.spring.accesscontroller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

@Component
public class AccessControl {
	
	public String accessControl(HttpServletRequest req, String page) {

		boolean control = req.getSession().getAttribute("userId") == null;
		Integer userRank = (Integer) req.getSession().getAttribute("userRank");

		if (control) {
			return "redirect:/";
		} else if (userRank == 0) {
			return "redirect:/";
		} else {
			return page;
		}

	}

}
