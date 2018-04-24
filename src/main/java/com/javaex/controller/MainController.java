package com.javaex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	@RequestMapping("/hi")
	public String hi() {
		System.out.println("guestbook3/hi");
		return "WEB-INF/views/index.jsp";
	}
	
	
}
