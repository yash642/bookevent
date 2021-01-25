package com.cg.bookevent.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.bookevent.entity.BookEvent;
import com.cg.bookevent.exception.BookEventNotFoundException;
import com.cg.bookevent.exception.EmptyListException;
import com.cg.bookevent.exception.NullEventException;
import com.cg.bookevent.service.BookEventService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/BookEventCtrl")
@Api(value = "BookEvent Service for CulturoFesto")
public class BookEventController {

	@Autowired
	BookEventService bookService;

	// http://localhost:8082/bookevent-service/BookEventCtrl/addevent
	@PostMapping("/addevent")
	public BookEvent addBookedEvent(@RequestBody BookEvent event) throws NullEventException {
		return bookService.addEvent(event);

	}

	// http://localhost:8082/bookevent-service/BookEventCtrl/getevent/1
	@GetMapping("/getevent/{id}")
	public BookEvent SearchEventById(@PathVariable Integer id) throws BookEventNotFoundException {
		return bookService.SearchBookedEvent(id);

	}

	// http://localhost:8082/bookevent-service/BookEventCtrl/getall
	@GetMapping("/getall")
	public List<BookEvent> listAllBookedEvents() throws EmptyListException {
		return bookService.listBookedEvents();

	}

	@DeleteMapping("/deleteevent")
	public void deleteBookedEvent(@PathVariable Integer id) {
		bookService.deleteEvent(id);

	}

}
