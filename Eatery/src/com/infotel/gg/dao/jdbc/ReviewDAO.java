package com.infotel.gg.dao.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.infotel.gg.booking.Booking;
import com.infotel.gg.booking.Review;

public class ReviewDAO extends AbstractDAO<Review>{

	@Override
	public String getTableName() {
		// TODO Auto-generated method stub
		return "Review";
	}

	@Override
	public Review getModelObject(ResultSet rs) {
		Review temp = null;
		try {
			temp = new Review(rs.getInt("id"), rs.getInt("rating"), rs.getString("comment") );
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return temp;
	}

	

	@Override
	public String getUpdate(Review obj) {
		return null;
	}

	@Override
	public String getInsert(Review obj) {
		return null;
	}

	@Override
	public void createPrepareFromObject(PreparedStatement p, Review obj) {
	}

}
