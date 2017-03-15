package com.infotel.gg.dao.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.infotel.gg.city.City;
import com.infotel.gg.eatery.EateryTag;

public class EateryTagDAO extends AbstractDAO<EateryTag>{

	@Override
	public String getTableName() {
		// TODO Auto-generated method stub
		return "Eatery_tag";
	}

	@Override
	public EateryTag getModelObject(ResultSet rs) {
		EateryTag temp = null;
		try {
			temp = new EateryTag(rs.getInt("id"), rs.getString("name"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return temp;
	}

	@Override
	public String getUpdate(EateryTag obj) {
		return null;
	}

	@Override
	public String getInsert(EateryTag obj) {
		return null;
	}

	@Override
	public void createPrepareFromObject(PreparedStatement p, EateryTag obj) {
	}

	

}
