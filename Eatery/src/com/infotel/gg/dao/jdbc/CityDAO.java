package com.infotel.gg.dao.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.infotel.gg.city.City;
import com.infotel.gg.eatery.Eatery;

public class CityDAO extends AbstractDAO<City>{

	@Override
	public String getTableName() {
		// TODO Auto-generated method stub
		return "City";
	}

	@Override
	public City getModelObject(ResultSet rs) {
		City temp = null;
		try {
			temp = new City(rs.getInt("id"), rs.getString("name"), rs.getString("post_code"), rs.getBoolean("Foremost") );
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return temp;
	}

	@Override
	public String getUpdate(City obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createPrepareFromObject(PreparedStatement p, City obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getInsert(City obj) {
		// TODO Auto-generated method stub
		return null;
	}

}
