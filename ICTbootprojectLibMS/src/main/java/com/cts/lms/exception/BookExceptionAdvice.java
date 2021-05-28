package com.cts.lms.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice()
public class BookExceptionAdvice {
	@ExceptionHandler(BookException.class)
	public String handleException(BookException error, Model model) {
		model.addAttribute("error", error.getMessage());
		return "search";
	}
}
