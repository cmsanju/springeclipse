package com.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomerController {
	
	@RequestMapping("/customer")
	public String customerForm()
	{
		return "customer";
	}
}
