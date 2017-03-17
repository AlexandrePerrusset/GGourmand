package com.infotel.gg.dao.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.infotel.gg.booking.Booking;
import com.infotel.gg.city.Region;

public class BookingDAO extends AbstractDAO<Booking, Integer>{

	@Override
	public String getTableName() {
		// TODO Auto-generated method stub
		return "Booking";
	}

	@Override
	public Booking getModelObject(ResultSet rs) {
		CustomerDAO cd = new CustomerDAO();
		EateryDAO ed = new EateryDAO();
		Booking temp = null;
//		
//		try {
//			temp = new Booking(rs.getInt("id"), rs.getDate("date_time"), rs.getInt("nb_people"),rs.getInt("Eatery_id") , rs.getInt("customer_id") );
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		return temp;
	}

	@Override
	public String getUpdate(Booking obj) {
		return null;
	}

	@Override
	public String getInsert(Booking obj) {
		if(obj.getId() > 0){
			return "(id, date_time, nb_people, eatery_id, customer_id) VALUES(?,?,?,?,?)";
		}
		return "(date_time, nb_people, eatery_id, customer_id) VALUES(?,?,?,?)";
	}

	@Override
	public void createPrepareFromObject(PreparedStatement p, Booking obj) {
		Calendar d = Calendar.getInstance();
		d = obj.getDateTime();
		java.sql.Date sd = new java.sql.Date(d.getTimeInMillis());
		try{
			if(obj.getId()> 0){
				p.setLong(1, obj.getId());
				p.setDate(2,  sd);
				p.setInt(3, obj.getNbOfCustomer() );
				p.setLong(4, obj.getEatery().getId() );
				p.setString(5, obj.getCustomer().getEmail() );
				System.out.println(p);
			}else{
				p.setDate(1, sd);
				p.setInt(2, obj.getNbOfCustomer() );
				p.setLong(3, obj.getEatery().getId() );
				p.setString(4, obj.getCustomer().getEmail() );
			}
		}catch(SQLException e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
		obj.setId(id);
	}

	@Override
	public String getIdFormated(Integer id) {
		return "id ="+id;
	}

	

}
