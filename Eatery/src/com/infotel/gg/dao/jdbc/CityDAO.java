package com.infotel.gg.dao.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.infotel.gg.model.City;
import com.infotel.gg.model.Eatery;

public class CityDAO extends AbstractDAO<City, Integer>{

	@Override
	public String getTableName() {
		// TODO Auto-generated method stub
		return "City";
	}

	@Override
	public City getModelObject(ResultSet rs) {
		City temp = null;
		try {
			temp = new City(rs.getInt("id"), rs.getString("name"), rs.getString("post_code"), rs.getBoolean("foremost") );
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return temp;
	}

	@Override
	public List<City> listAll() {
		return null;
	}

	@Override
	public Integer getId(City obj) {
		return obj.getId();
	}

	@Override
	public void setId(Integer id, City obj) {
		obj.setId(id);
	}

	@Override
	public String getUpdate(City obj) {
		return null;
	}

	@Override
	public String getInsert(City obj) {
		return " (id, name, post_code, foremost, country_id, region_id) VALUES(?,?,?,?,?,?)";
	}

	@Override
	public void createPrepareFromObject(PreparedStatement p, City obj) {
		try{
			if(obj.getId() > 0){
				p.setInt(1, obj.getId());
				p.setString(2, obj.getName());
				p.setString(3, obj.getPostCode());
				p.setBoolean(4, obj.isForemost());
				p.setInt(5, 1);
				p.setInt(6, 5);
			}
		}catch(SQLException e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public String getIdFormated(Integer id) {
		return "id ="+id;
	}



}
