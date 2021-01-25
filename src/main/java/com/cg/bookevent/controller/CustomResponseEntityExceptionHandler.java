package com.cg.bookevent.controller;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.cg.bookevent.exception.BookEventNotFoundException;
import com.cg.bookevent.exception.EmptyListException;
import com.cg.bookevent.exception.ExceptionResponse;
import com.cg.bookevent.exception.NullEventException;


/**
 * 
 * @author Shubham Sharma
 */
@RestController
@ControllerAdvice
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
	private static final Logger logger = LoggerFactory.getLogger(CustomResponseEntityExceptionHandler.class);

	@ExceptionHandler({ BookEventNotFoundException.class })
	public final ResponseEntity<Object> handleBookEventNotFoundException(BookEventNotFoundException ex,
			WebRequest req) {
		logger.error(ex.toString());
		ExceptionResponse expResp = new ExceptionResponse(new Date(), ex.getMessage(),
				"Booking for this Event Not found");
		return new ResponseEntity(expResp, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler({ EmptyListException.class })
	public final ResponseEntity<Object> handleEmptyListException(EmptyListException ex, WebRequest req) {
		logger.error(ex.toString());
		ExceptionResponse expResp = new ExceptionResponse(new Date(), ex.getMessage(), "List is empty");
		return new ResponseEntity(expResp, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler({ NullEventException.class })
	public final ResponseEntity<Object> handleNullEventExceptionn(NullEventException ex, WebRequest req) {
		logger.error(ex.toString());
		ExceptionResponse expResp = new ExceptionResponse(new Date(), ex.getMessage(), "Not valid value");
		return new ResponseEntity(expResp, HttpStatus.NOT_FOUND);
	}
//	 @ExceptionHandler({MethodArgumentNotValidException.class})
//	    public ResponseEntity<ExceptionResponse> handleValidationExceptions(MethodArgumentNotValidException ex, WebRequest req) {
//
//		 ExceptionResponse expResp = new ExceptionResponse(new Date(), ex.getMessage(), "Not valid value");
//	        return new ResponseEntity(expResp, HttpStatus.BAD_REQUEST);
//	    }
//	@ExceptionHandler(MethodArgumentNotValidException.class)
//    public ResponseEntity<ExceptionResponse> handleValidationExceptions(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest req) {
////         List<String> details = new ArrayList<>();
////            for(ObjectError error : ex.getBindingResult().getAllErrors()) {
////                details.add(error.getDefaultMessage());
////            }
//           // ApiError error = new ApiError("Validation Failed",status) ;
//		logger.error(ex.toString());
//		ExceptionResponse expResp = new ExceptionResponse(new Date(), ex.getMessage(), "Not valid value");
//            return new ResponseEntity(expResp, status);
//    }
//	@Override
//    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
//        List<String> details = new ArrayList<>();
//        for(ObjectError error : ex.getBindingResult().getAllErrors()) {
//            details.add(error.getDefaultMessage());
//        }
//        ErrorResponse error = new ErrorResponse("Validation Failed", details);
//        return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
//    }

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest req) {
		logger.error(ex.toString());
		ExceptionResponse expResp = new ExceptionResponse(new Date(), ex.getMessage(), "Server down");
		return new ResponseEntity(expResp, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
