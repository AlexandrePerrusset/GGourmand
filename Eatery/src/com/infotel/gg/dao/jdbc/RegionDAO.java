package com.infotel.gg.dao.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.infotel.gg.city.Region;
import com.infotel.gg.eatery.Eatery;

public class RegionDAO extends AbstractDAO<Region>{

	@Override
	public String getTableName() {
		// TODO Auto-generated method stub
		return "Region";
	}

	@Override
	public Region getModelObject(ResultSet rs) {
		Region temp = null;
		try {
			temp = new Region(rs.getInt("id"), rs.getString("name") );
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return temp;
	}

	@Override
	public String getUpdate(Region obj) {
		return null;
	}

	@Override
	public String getInsert(Region obj) {
		return null;
	}

	@Override
	public void createPrepareFromObject(PreparedStatement p, Region obj) {
	}

	
	

}
