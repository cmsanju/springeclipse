package com.test.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.test.model.User;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Controller
@Api(value = "UserController for validating the user fields")
public class UserController {

	@RequestMapping("/")
	public String home() {

		return "index";
	}

	@ApiOperation(value = "it will display user form and taking the user inputs")
	@GetMapping("/register")
	public String showForm(Model model, User user) {

		model.addAttribute("user", user);

		return "register_form";
	}

	@PostMapping("/register")
	@ApiOperation(value = "validating and printing user details in success page")
	public String submitForm(@Valid @ModelAttribute("user") User user ,BindingResult bindindResult, Model model ) {

		if(bindindResult.hasErrors())
		{

			return "register_form";
		}

		return "register_success";
	}
}
/*
 * 
 * When Spring Boot finds an argument annotated with 
 * @Valid, it automatically bootstraps the default 
 * JSR 380 implementation — Hibernate Validator — and validates 
 * the argument. When the target argument fails to pass the validation,
 *  Spring Boot throws a MethodArgumentNotValidException exception
 *  
 */
