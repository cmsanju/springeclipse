/***********************************************************************************************************
  This class BookController is Spring MVC controller 
 * 
 * DO NOT CHANGE THE CLASS NAME, SIGNATURE OF METHODS, EXCEPTION CLASSES, RETURN TYPES
 * ADD ANNOTATIONS WHEREVER REQUIRED FOR CONTROLLER 
 * DO NOT SUBMIT THE CODE WITH COMPILATION ERRORS
 * CHANGE THE RETURN TYPE FROM NULL OF THE METHODS TO DATA TYPE RETURNED
 * DO NOT ADD ANY THROWS CLASS TO THE METHODS. IF NEED BE, 
 * YOU CAN CATCH THEM AND THROW ONLY THE APPLICATION SPECIFIC EXCEPTION AS PER EXCEPTION CLAUSE
 * ADD REQUEST MAPPING URI AND RETURN TYPE AS PER DESIGN DOCUMENT
 *
 ***********************************************************************************************************/

package com.cts.lms.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.cts.lms.exception.BookException;
import com.cts.lms.model.Book;
import com.cts.lms.model.BookQuery;
import com.cts.lms.service.BookService;

@Controller
public class BookController {
	@Autowired
	private BookService bookService;

	@GetMapping("/")
	public String showSearchPage() {
		return "search";
	}

	@PostMapping("/")
	public String submitSearchPage(@ModelAttribute BookQuery query, Model model) throws BookException {
		if (query.getOption() == null)
			throw new BookException("Option not selected");
		if (query.getText().contentEquals(""))
			throw new BookException("Text field is empty");

		if (query.getOption().equals("title")) {
			Book bk = bookService.getBookOnTitle(query.getText());
			if (bk == null) {
				model.addAttribute("error", "Book with title " + query.getText() + " not available");
				return "search";
			}
			model.addAttribute("book", bk);
			return "title";
		} else {
			List<Book> list = bookService.getBooksOnSubject(query.getText());
			if (list.size() == 0) {
				model.addAttribute("error", "Books with subject " + query.getText() + " not available");
				return "search";
			}

			model.addAttribute("bookList", list);
			return "subject";
		}

	}

	@GetMapping("/feedback")
	public String showFeedbackPage() {
		return "feedback";
	}

	@PostMapping("/feedback")
	public String submitFeedbackPage(@PathParam("rating") int rating, @PathParam("comment") String comment,
			Model model) {
		String grade[] = { "", "Poor", "Average", "Good", "Very Good", "Excellent" };

		model.addAttribute("grade", grade[rating]);
		model.addAttribute("comment", comment);
		return "feedbackresponse";

	}

}
