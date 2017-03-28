package com.infotel.gg.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import com.infotel.gg.exception.DAOException;
import com.infotel.gg.exception.ModelException;
import com.infotel.gg.model.BookingReport;
import com.infotel.gg.model.Review;

public class BookingReportDAO implements DAO<BookingReport, Integer>{

	@Override
	public void create(BookingReport obj) throws DAOException {
	}

	@Override
	public BookingReport read(Integer i) throws ModelException {
		return null;
	}

	@Override
	public void update(BookingReport obj) {
	}

	@Override
	public void delete(BookingReport obj) throws DAOException {
	}

	@Override
	public List<BookingReport> listAll() {
		return null;
	}
}
