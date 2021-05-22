package com.test;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController 
{
	@RequestMapping("/hello")
	public String sayHello()
	{
		return "greeting";
	}
	
	@RequestMapping("/login")
	public String loginPage()
	{
		return "login";
	}
	
	@RequestMapping("reg")
	public String regPage()
	{
		return "register";
	}
	
	@RequestMapping("/logindetails")
	public String submitForm(HttpServletRequest request, Model model)
	{
		String user = request.getParameter("user");
		String pass = request.getParameter("pwd");
		
		String userD = user+" "+pass;
		
		model.addAttribute("info", userD);
		
		return "userdetails";
	}
}
