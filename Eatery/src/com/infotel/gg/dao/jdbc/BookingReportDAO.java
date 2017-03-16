package com.infotel.gg.dao.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.infotel.gg.booking.Review;
import com.infotel.gg.bookingreport.BookingReport;

public class BookingReportDAO extends AbstractDAO<BookingReport, Integer>{

	@Override
	public String getTableName() {

		return "booking_report";
	}

	@Override
	public BookingReport getModelObject(ResultSet rs) {
		BookingReport temp = null;
		try {
			temp = new BookingReport(rs.getInt("id"), rs.getDate("input_date"), rs.getBoolean("fulfilled"), rs.getString("comment"), rs.getDouble("taking_amount"), rs.getDouble("due_amount") );
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return temp;
	}

	@Override
	public List<BookingReport> listAll() {
		return null;
	}

	@Override
	public Integer getId(BookingReport obj) {
		return null;
	}

	@Override
	public void setId(Integer id, BookingReport obj) {
	}

	@Override
	public String getUpdate(BookingReport obj) {
		return null;
	}

	@Override
	public String getInsert(BookingReport obj) {
		return null;
	}

	@Override
	public void createPrepareFromObject(PreparedStatement p, BookingReport obj) {
	}

	@Override
	public String getIdFormated(Integer id) {
		return "id ="+id;
	}

	

}
