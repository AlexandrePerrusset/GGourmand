package com.infotel.gg.dao;


import java.util.List;

import com.infotel.gg.model.BookingReport;


public interface BookingReportDAO extends DAO<BookingReport, Integer>{

	List<BookingReport> listBookReportByBookId(int id);

}
