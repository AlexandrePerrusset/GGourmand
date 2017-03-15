package com.infotel.gg.dao.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.infotel.gg.city.City;
import com.infotel.gg.eatery.CookingStyle;

public class CookingStyleDAO extends AbstractDAO{

	@Override
	public String getTableName() {
		// TODO Auto-generated method stub
		return "cookingstyle";
	}

	@Override
	public Identifiable getModelObject(ResultSet rs) {
		CookingStyle temp = null;
		try {
			temp = new CookingStyle(rs.getInt("id"), rs.getString("name"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return temp;
	}

	@Override
	public String getUpdate(Identifiable obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createPrepareFromObject(PreparedStatement p, Identifiable obj) {
		// TODO Auto-generated method stub
	
	}

	@Override
	public String getInsert(Identifiable obj) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
