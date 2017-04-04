
package com.infotel.gg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.infotel.gg.DTO.BookingDTO;
import com.infotel.gg.dao.BookingDAO;
import com.infotel.gg.dao.BookingReportDAO;
import com.infotel.gg.dao.ReviewDAO;
import com.infotel.gg.exception.GGourmandException;
import com.infotel.gg.model.Booking;
import com.infotel.gg.model.BookingReport;




public class bookingServiceImpl implements BookingService{

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
		
		return null;
	}

	
	@Override
	public List<BookingDTO> findBookingsByEatery(int eateryId) throws GGourmandException {
		
		return null;
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
	

}
