package com.cts.lms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cts.lms.skeleton.SkeletonValidator;


@SpringBootApplication
public class BookApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(BookApplication.class, args);
		
		SkeletonValidator skl = new SkeletonValidator();
	}

}
