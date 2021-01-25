package com.cg.bookevent.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.bookevent.dao.BookEventDao;
import com.cg.bookevent.entity.BookEvent;
import com.cg.bookevent.exception.BookEventNotFoundException;
import com.cg.bookevent.exception.EmptyListException;
import com.cg.bookevent.exception.NullEventException;

@Service
public class BookEventService {
	
	@Autowired
	BookEventDao book;
	
	public BookEvent addEvent(BookEvent event) throws NullEventException {
		if(event.getStatus() == null)
			throw new NullEventException("Null Value");
		else
		return book.save(event);

	}

	public BookEvent SearchBookedEvent(Integer id) throws BookEventNotFoundException {
		
		return book.findById(id).orElseThrow(() -> new BookEventNotFoundException("Booking for this Event i : "+id+" Not Found"));

	}

	public List<BookEvent> listBookedEvents() throws EmptyListException {
		List<BookEvent> bookeventlist =  book.findAll();
		if(bookeventlist.isEmpty())
			throw new EmptyListException("No Bookings Till Yet!!");
		return bookeventlist;

	}
	
	public void deleteEvent(Integer id) {
		 book.deleteById(id);

	}
	
	

}
