
package com.ict.springboot.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;


import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.cts.lms.model.Book;
import com.cts.lms.service.BookService;

@RunWith(MockitoJUnitRunner.class)
public class BookServiceTest {
	
	@InjectMocks
	private BookService bookService;
	
	@BeforeMethod
	public void setUp()
	{
		bookService = new BookService();
	
	}
	
	@Test
	public void testGetBookOnTitle() {
		Book book = bookService.getBookOnTitle("COBOL for you");
		assertNotNull(book);
	}
	@Test
	public void testGetBooksOnSubject() {
		List<Book> bookList = bookService.getBooksOnSubject("JAVA");
		assertEquals(3, bookList.size());
	
	}
	@Test
	public void testGetBooksOnSubjectNotAvailable() {
		List<Book> bookList = bookService.getBooksOnSubject("Python");
		assertEquals(0, bookList.size());

	}
	@Test
	public void testGetBookOnTitleNotAvailable() {
		Book book = bookService.getBookOnTitle("Java made easy");
		assertNull(book);
	}
	

}
