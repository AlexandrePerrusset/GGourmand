package com.infotel.gg.dao;



import java.util.List;

import com.infotel.gg.model.Review;

public interface ReviewDAO extends DAO<Review, Integer>{

	Review findByBookingId(int bookingId);

	List<Review> listAllByEateryId(int id);

	List<Review> findByCustomer(String username);

	

}
