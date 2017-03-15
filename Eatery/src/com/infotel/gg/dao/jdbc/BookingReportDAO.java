package com.infotel.gg.dao.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.infotel.gg.booking.Review;
import com.infotel.gg.bookingreport.BookingReport;

public class BookingReportDAO extends AbstractDAO{

	@Override
	public String getTableName() {

		return "Booking_report";
	}

	@Override
	public Identifiable getModelObject(ResultSet rs) {
		BookingReport temp = null;
		try {
			temp = new BookingReport(rs.getInt("id"), rs.getDate("input_date"), rs.getBoolean("fulfilled"), rs.getString("comment"), rs.getDouble("taking_amount"), rs.getDouble("due_amount") );
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return temp;
	}

	@Override
	public String getUpdate(Identifiable obj) {
	
		return null;
	}

	@Override
	public void createPrepareFromObject(PreparedStatement p, Identifiable obj) {

	}

	@Override
	public String getInsert(Identifiable obj) {

		return null;
	}

}
