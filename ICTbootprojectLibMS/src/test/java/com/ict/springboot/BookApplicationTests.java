
package com.ict.springboot;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.cts.lms.BookApplication;
import com.cts.lms.controller.BookController;




@SpringBootTest
@ContextConfiguration(classes = BookApplication.class, loader = AnnotationConfigContextLoader.class)
public class BookApplicationTests {

	@Autowired
	private BookController bookController;
	
	@Test
	void contextLoads() throws Exception {
		assertThat(bookController).isNotNull();
	}
}
