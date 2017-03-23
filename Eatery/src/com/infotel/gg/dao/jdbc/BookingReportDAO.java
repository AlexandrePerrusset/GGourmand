package com.infotel.gg.dao.jdbc;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import com.infotel.gg.model.BookingReport;
import com.infotel.gg.model.Review;

public class BookingReportDAO extends AbstractDAO<BookingReport, Integer>{

	@Override
	public String getTableName() {

		return "booking_report";
	}

	@Override
	public BookingReport getModelObject(ResultSet rs) {
		BookingReport temp = null;
		try {
			Date sqldate = rs.getDate("date_time");
			Calendar cal = new GregorianCalendar();
			cal.setTime(sqldate);
			temp = new BookingReport(rs.getInt("id"), cal, rs.getBoolean("fulfilled"), rs.getString("comment"), rs.getDouble("taking_amount"), rs.getDouble("due_amount") );
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
