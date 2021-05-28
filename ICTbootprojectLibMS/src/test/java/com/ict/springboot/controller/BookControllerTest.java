package com.ict.springboot.controller;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.ui.Model;
import org.springframework.validation.support.BindingAwareModelMap;
import com.cts.lms.BookApplication;
import com.cts.lms.controller.BookController;
import com.cts.lms.exception.BookException;
import com.cts.lms.model.BookQuery;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = BookApplication.class, loader = AnnotationConfigContextLoader.class)
public class BookControllerTest {

	@Autowired
	private BookController welController;
	
	@InjectMocks
	BookQuery query;
	
	
	@Before
	public void setUp()
	{
		query = new BookQuery();
		
		
	}
	@After
	public void setDown()
	{
		welController = null;
		query = null;
	}
	
	@Test
	public void showSearchPageView()
	{
		String viewName = welController.showSearchPage();
		
		assertEquals("search", viewName);
	}

	@Test
	public void submitSearchPageView() {		
		
		query = new BookQuery("title", "Java 8 Reference");
		query = new BookQuery("subject", "java");
		Model model = new BindingAwareModelMap();
		try {
			if(query.getOption().equals("title"))
			{
			
			String viewName  = welController.submitSearchPage(query, model);
			assertEquals("title", viewName);//for title
			
			}
			else
			{
				String viewName  = welController.submitSearchPage(query, model);
				
				assertEquals("subject", viewName);//for subject
			}
			} catch (BookException e) {
			
			e.printStackTrace();
		}
	}
	
	@Test
	public void showFeedbackPageView()
	{
		String viewName = welController.showFeedbackPage();
		
		assertEquals("feedback", viewName);
	}
	@Test
	public void submitFeedbackPageView()
	{
		Model model = new BindingAwareModelMap();
		
		String viewName = welController.submitFeedbackPage(5, "Nice book for OCJP", model);
		
		assertEquals("feedbackresponse", viewName);
	}
}
