package com.infotel.gg.dao;

import java.util.List;

import com.infotel.gg.DTO.CustomerDTO;
import com.infotel.gg.exception.GGourmandException;
import com.infotel.gg.model.Booking;

public interface BookingDAO extends DAO<Booking, Integer> {

	public List<Booking> listAll(CustomerDTO customerdto);

	public List<Booking> findByEateryId(int eateryId) throws GGourmandException;

	public List<Booking> findByCustomer(String username);

	public List<Booking> findByEateryIdWithoutReport(int eateryId) throws GGourmandException;
}
