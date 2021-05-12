package com.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
	
	@RequestMapping("/")
	public String homePage()
	{
		return "home";
	}
	
	@RequestMapping("/login")
	public String loginPage()
	{
		return "login";
	}

}
