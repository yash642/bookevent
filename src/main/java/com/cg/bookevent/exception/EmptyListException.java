package com.cg.bookevent.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 
 * @author Shubham Sharma
 *
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class EmptyListException extends Exception {
	public EmptyListException(String arg0) {
		super(arg0);
	}
}
