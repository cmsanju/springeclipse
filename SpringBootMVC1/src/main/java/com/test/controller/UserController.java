package com.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.test.model.User;

@Controller
public class UserController {
	
	@RequestMapping("/userdata")
	public String userForm()
	{
		return "userform";
	}
	
	@RequestMapping(value = "/userdata", method = RequestMethod.POST)
	public String submitForm(@RequestParam("name") String name, @RequestParam("city") String city, Model model)
	{
		User u = new User();
		
		u.setName(name);
		u.setCity(city);
		
		model.addAttribute("userInfo", u);
		
		return "userdetails";
	}

}
