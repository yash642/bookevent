package com.cg.bookevent.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.bookevent.entity.BookEvent;

/**
 * 
 * @author Shubham Sharma
 *
 */
@Repository
public interface BookEventDao extends JpaRepository<BookEvent, Integer> {

}
