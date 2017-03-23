package com.infotel.gg.dao.file;

import java.util.List;

import com.infotel.gg.model.Booking;

public class BookingDAO extends AbstractFileDAO<Booking, Integer>{

	@Override
	public String idToFileName(Integer id) {
		StringBuilder sb = new StringBuilder();
//		sb.append(System.getProperty("user_home"));
//		sb.append(System.getProperty("file.separator"));
		sb.append("Booking_");
		sb.append(id);
		sb.append(".ser");
		return sb.toString();
	}

	@Override
	public List<Booking> listAll() {
		return null;
	}

	@Override
	public Integer getId(Booking b) {
		return b.getId();
	}

	@Override
	public void setId(Integer id, Booking obj) {
	}

	

	
	
	
}
