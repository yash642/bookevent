package com.cg.bookevent.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 
 * @author Shubham Sharma
 *
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class BookEventNotFoundException extends Exception{

	public BookEventNotFoundException(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}
	
}
