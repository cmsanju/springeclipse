package com.test;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloController {
	
	@RequestMapping("/home")
	public String homePage()
	{
		return "home";
	}
	
	@RequestMapping("/login")
	public String loginPage()
	{
		return "login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String submitPage(HttpServletRequest request, Model model)
	{
		String user = request.getParameter("user");
		String pass = request.getParameter("pwd");
		
		String userDe = user+" "+pass;
		
		model.addAttribute("info", userDe);
		
		System.out.println(userDe);
		
		return "loginsuccess";
	}

}
