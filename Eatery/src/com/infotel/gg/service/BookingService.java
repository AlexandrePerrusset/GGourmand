/**
 * 
 */
package com.infotel.gg.service;

import java.util.List;

import com.infotel.gg.DTO.BookingDTO;
import com.infotel.gg.DTO.BookingReportDTO;
import com.infotel.gg.exception.GGourmandException;
import com.infotel.gg.model.Booking;
import com.infotel.gg.model.BookingReport;


public interface BookingService {
	
	
	public void saveBooking(BookingDTO booking) throws GGourmandException;
	
	public Booking findBookingById(int id) throws GGourmandException;
	
	public List<BookingDTO> findBookingsByCustomer(String username) throws GGourmandException;
	
	public List<BookingDTO> findBookingsByEatery(int eateryId) throws GGourmandException;
	
	public List<BookingDTO> findBookingsByEateryWithoutReport(int eateryId) throws GGourmandException;

	void saveBookingReport(BookingReportDTO bookingReport) throws GGourmandException;
	
	public List<BookingReportDTO> findBookingReportByManager(String managerName);

	void saveBookingRest(BookingDTO booking) throws GGourmandException;
}
