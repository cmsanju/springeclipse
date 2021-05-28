/***********************************************************************************************************
 * THIS CLASS BookQuery IS FOR MODEL USED TO RECEIVE QUERY FROM USER QUERY FORM
 * USE THIS CLASS TO MAP USER INPUT ATTRIBUTES TO BE SENT TO CONTROLLER
 * 
 * OPTION PROPERTY MAPS TO TYPE OF SEARCH - SUBJECT OR TITLE
 * TEXT PROPERTY MAPS TO BOOK TITLE OR SUBJECT NAME FOR SEARCH
 * 
 * DO NOT MAKE ANY CHANGES TO THIS CLASS
 *
 ***********************************************************************************************************/

package com.cts.lms.model;

public class BookQuery {

	private String option;
	private String text;

	public BookQuery() {
	}

	
	
	public BookQuery(String option, String text) {
		
		this.option = option;
		this.text = text;
	}



	public String getOption() {
		return option;
	}

	public void setOption(String option) {
		this.option = option;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}
