
package com.infotel.gg.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.infotel.gg.DTO.BookingDTO;
import com.infotel.gg.dao.BookingDAO;
import com.infotel.gg.dao.BookingReportDAO;
import com.infotel.gg.dao.ReviewDAO;
import com.infotel.gg.exception.GGourmandException;
import com.infotel.gg.model.Booking;
import com.infotel.gg.model.BookingReport;
import com.infotel.gg.model.Review;


@Service("BookingService")
@Transactional
public class BookingServiceImpl implements BookingService{

	@Autowired
	private BookingDAO bookingDao;
	
	@Autowired
	private BookingReportDAO bookingReportDao;
	
	@Autowired
	private ReviewDAO reviewDAO;

	
	@Override
	public void saveBooking(Booking booking) throws GGourmandException {
		try {
			bookingDao.create(booking);	
		}
		catch(Exception e){
			throw new GGourmandException();
		}
	}
	

	
	@Override
	public Booking findBookingById(int id) throws GGourmandException {
		return bookingDao.read(id);
	}

	
	@Override
	public List<BookingDTO> findBookingsByCustomer(String username) throws GGourmandException {
		List<BookingDTO> result = new ArrayList<BookingDTO>();
		List<Booking> listBooking = bookingDao.findByCustomer(username);
		listBooking.stream().forEach(b -> result.add(transform(b)));
		return result;
	}

	
	@Override
	public List<BookingDTO> findBookingsByEatery(int eateryId) throws GGourmandException {
		List<BookingDTO> result = new ArrayList<BookingDTO>();
		List<Booking> listBooking = bookingDao.findByEateryId(eateryId);
		listBooking.stream().forEach(b -> result.add(transform(b)));
		return result;
	}
	
	public List<BookingDTO> findBookingsByEateryWithoutReport(int eateryId) throws GGourmandException {
		List<BookingDTO> result = new ArrayList<BookingDTO>();
		List<Booking> listBooking = bookingDao.findByEateryIdWithoutReport(eateryId);
		listBooking.stream().forEach(b -> result.add(transform(b)));
		return result;
	}

	
	@Override
	public void saveBookingReport(BookingReport bookingReport) throws GGourmandException {
		try {
			bookingReportDao.create(bookingReport);
		}
		catch(Exception e){
			throw new GGourmandException();
		}
	}
	
	private BookingDTO transform(Booking booking) {
		BookingDTO bookingDto = new BookingDTO();
		bookingDto.setId(Integer.toString(booking.getId()));
		bookingDto.setDateTime(booking.getDateTime());	
		bookingDto.setNumberOfPeople(Integer.toString(booking.getNbOfCustomer()));	
		bookingDto.setFirstName(booking.getCustomer().getFirstName());
		bookingDto.setLastName(booking.getCustomer().getLastName());
		bookingDto.setCustomerId(booking.getCustomer().getUsername());
		bookingDto.setEateryId(booking.getEatery().getId());
		bookingDto.setEateryName(booking.getEatery().getName());
		bookingDto.setPostcode(booking.getEatery().getAddress().getPostCode());
		bookingDto.setStreet(booking.getEatery().getAddress().getStreet());
		bookingDto.setCityName(booking.getEatery().getAddress().getCity().getName());
		Review bookreview= reviewDAO.findByBookingId(booking.getId());
		if(bookreview==null){
			bookingDto.setComment(false);
		}
		else{
			bookingDto.setComment(true);
			bookingDto.setRating(bookreview.getRating());
			bookingDto.setCommenttext(bookreview.getComment());
		}
		
		return bookingDto;
	}
}
