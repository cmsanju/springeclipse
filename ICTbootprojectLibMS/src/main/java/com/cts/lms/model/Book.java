/***********************************************************************************************************
 * THIS CLASS Book IS BEAN CLASS USED TO SEND/RECEIVE BOOK DATA
 * 
 * DO NOT MAKE ANY CHANGES TO THIS CLASS
 *
 ***********************************************************************************************************/

package com.cts.lms.model;

public class Book {

	private String title;
	private String author;
	private String subject;
	private int quantity;

	public Book() {
		super();
	}

	public Book(String title, String author, String subject, int quantity) {
		super();
		this.title = title;
		this.author = author;
		this.subject = subject;
		this.quantity = quantity;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
