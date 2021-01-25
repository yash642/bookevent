package com.cg.bookevent.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;


@Entity
public class BookEvent {

	@Id
	@SequenceGenerator(name = "booking_id_sequence", initialValue = 1, allocationSize = 1)
	@GeneratedValue(generator = "booking_id_sequence", strategy = GenerationType.SEQUENCE)
	@Min(1)
	@Max(999)
	private Integer bookId;

	
	@ManyToOne(cascade = { CascadeType.MERGE })
	@JoinColumn(name = "custId")
	private Customer customer;
	
//	@NotEmpty(message = "first name must not be empty")
	@Column(nullable = true, length = 255)
	private String status;

	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinColumn(name = "participantId")
	private List<Participant> participants;

	@ManyToOne(cascade = { CascadeType.MERGE })
	@JoinColumn(name = "eventId")
	private Event event;

	public BookEvent() {
		// TODO Auto-generated constructor stub
	}

	public BookEvent(Customer customer, String status, List<Participant> participants, Event event) {
		super();
		this.customer = customer;
		this.status = status;
		this.participants = participants;
		this.event = event;
	}

	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<Participant> getParticipants() {
		return participants;
	}

	public void setParticipants(List<Participant> participants) {
		this.participants = participants;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	@Override
	public String toString() {
		return "BookEvent [bookId=" + bookId + ", customer=" + customer + ", status=" + status + ", participants="
				+ participants + ", event=" + event + "]";
	}

}
