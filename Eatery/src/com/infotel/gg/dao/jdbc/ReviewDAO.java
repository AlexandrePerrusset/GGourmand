package com.infotel.gg.dao.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.infotel.gg.model.Review;

public class ReviewDAO extends AbstractDAO<Review, Integer>{

	@Override
	public String getTableName() {
		// TODO Auto-generated method stub
		return "review";
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
		return " (id,booking_id, rating, comment) VALUES(?,?,?,?)";
	}

	@Override
	public void createPrepareFromObject(PreparedStatement p, Review obj) {
		try{
			if(obj.getId()>0){
				p.setInt(1, obj.getId());
				p.setInt(2, 1);
				p.setInt(3, obj.getRating());
				p.setString(4, obj.getComment());
			}
		}catch(SQLException e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Review> listAll() {
		return null;
	}

	@Override
	public Integer getId(Review obj) {
		return obj.getId();
	}

	@Override
	public void setId(Integer id, Review obj) {
		obj.setId(id);;
	}

	@Override
	public String getIdFormated(Integer id) {
		return "id ="+id;
	}

}
