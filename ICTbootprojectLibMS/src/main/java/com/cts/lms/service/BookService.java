
package com.cts.lms.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.cts.lms.model.Book;

@Service
public class BookService {
	private static List<Book> library = new ArrayList<>();
	static {
		library.add(new Book("Java 8 Reference", "Karl Susan", "java", 6));
		library.add(new Book("Learn Java 8", "Ashok Tandon", "java", 3));
		library.add(new Book("ASP Simplified", "Sridhar reddy", "asp", 10));
		library.add(new Book("COBOL for you", "john ferguson", "cobol", 2));
		library.add(new Book("Learn C++", "Amol Bhatnagar", "c++", 5));
		library.add(new Book("Advanced C++", "Amol Bhatnagar", "c++", 12));
		library.add(new Book("Java Programming Tricks", "Patrik Naughton", "java", 3));
		library.add(new Book("Learn C#", "Narayan Murthy", "asp", 8));
	}

	public Book getBookOnTitle(String title) {
		for (Book b : library) {
			if (b.getTitle().equalsIgnoreCase(title))
				return b;
		}
		return null;
	}

	public List<Book> getBooksOnSubject(String subject) {
		List<Book> list = new ArrayList<>();
		for (Book b : library) {
			if (b.getSubject().equalsIgnoreCase(subject))
				list.add(b);
		}

		return list;
	}

}
