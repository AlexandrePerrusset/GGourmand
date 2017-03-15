package com.infotel.gg.dao.file;

import com.infotel.gg.booking.Booking;

public class BookingDAO extends AbstractFileDAO<Booking>{

	@Override
	public String idToFileName(int id) {
		StringBuilder sb = new StringBuilder();
//		sb.append(System.getProperty("user_home"));
//		sb.append(System.getProperty("file.separator"));
		sb.append("Booking_");
		sb.append(id);
		sb.append(".ser");
		return sb.toString();
	}

	
	
	
}
