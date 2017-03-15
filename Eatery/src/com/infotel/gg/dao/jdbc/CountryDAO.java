package com.infotel.gg.dao.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.infotel.gg.city.City;
import com.infotel.gg.city.Country;

public class CountryDAO extends AbstractDAO<Country>{

	@Override
	public String getTableName() {
		// TODO Auto-generated method stub
		return "Country";
	}

	@Override
	public Country getModelObject(ResultSet rs) {
		Country temp = null;
		try {
			temp = new Country(rs.getInt("id"), rs.getString("name") );
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return temp;
	}

	

	@Override
	public String getUpdate(Country obj) {
		return null;
	}

	@Override
	public String getInsert(Country obj) {
		return null;
	}

	@Override
	public void createPrepareFromObject(PreparedStatement p, Country obj) {
	}
	

}
