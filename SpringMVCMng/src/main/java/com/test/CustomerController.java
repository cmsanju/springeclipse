package com.test;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CustomerController {
	
	@RequestMapping("/customer")
	public String customerForm(Model model)
	{
		model.addAttribute("info", new Customer());
		
		return "customer";
	}
	
	//HttpServletRequest 
	//@RequestParam(id) int id, 
	@RequestMapping(value = "/customer", method = RequestMethod.POST)
	public String submitForm(@Valid@ModelAttribute("info") Customer cst, BindingResult result)
	{
		
		if(result.hasErrors())
		{
			return "customer";
		}
		
		return "details";
	}
}
