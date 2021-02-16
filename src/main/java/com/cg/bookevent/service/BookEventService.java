package com.cg.bookevent.service;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.security.SecureRandom;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.bookevent.dao.BookEventDao;
import com.cg.bookevent.entity.BookEvent;
import com.cg.bookevent.entity.Customer;
import com.cg.bookevent.entity.Food;
import com.cg.bookevent.entity.Participant;
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
	
		public List<BookEvent> listBookedEventsbasedcustomers(Customer cust) throws EmptyListException {

		List<BookEvent> bookeventlist = book.findAll();

		List<BookEvent> custbookeventlist = new ArrayList<>();
		for (BookEvent bookEvent : bookeventlist) {
			if (bookEvent.getCustomer().getCustId() == cust.getCustId())
				custbookeventlist.add(bookEvent);

		}
		if (custbookeventlist.isEmpty())
			throw new EmptyListException("No Bookings Till Yet!!");
		return custbookeventlist;

	}

	
	public void deleteEvent(Integer id) {
		 book.deleteById(id);

	}
	public void export(Integer id) throws IOException {

	for (BookEvent event : book.findAll()) {
			if (event.getBookId() == id) {
				
					int i = LocalDateTime.now().getSecond();
				
				Writer	writer = new FileWriter("C:/Users/Isha Pawar/Desktop/CultureoFesto/"
						+ event.getCustomer().getCustName() + " " + event.getEvent().getName() + i + ".csv");	
				writer.write("CustName,MobileNo,EventName,venue,StartDate,EndDate,No. of Participants,Status\n");
					writer.write(event.getCustomer().getCustName() + "," + event.getCustomer().getMobile() + ","
							+ event.getEvent().getName() + "," + event.getEvent().getVenue() + ","
							+ event.getEvent().getDateFrom() + "," + event.getEvent().getDateTo() + ","
							+ event.getParticipants().size() + "," + "Booked");
				writer.close();
				}

			}

		}

	

	public double calculateAmount(BookEvent event) {
		double sum = 0;
		Integer l = event.getParticipants().size();
		sum = sum + (event.getEvent().getPrice() * l);
		for (Participant participant : event.getParticipants()) {
			if (participant.getFoods().isEmpty())
				continue;
			for (Food food : participant.getFoods()) {
				sum = sum + food.getPrice();
			}
		}

		return sum;
	}


}
