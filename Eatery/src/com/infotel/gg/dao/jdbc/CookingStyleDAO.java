package com.infotel.gg.dao.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.infotel.gg.city.City;
import com.infotel.gg.eatery.CookingStyle;
import com.infotel.gg.exception.ModelException;

public class CookingStyleDAO extends AbstractDAO<CookingStyle, Integer>{

	@Override
	public String getTableName() {
		// TODO Auto-generated method stub
		return "cookingstyle";
	}

	@Override
	public CookingStyle getModelObject(ResultSet rs) throws ModelException {
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
	public String getUpdate(CookingStyle obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createPrepareFromObject(PreparedStatement p, CookingStyle obj) {
		// TODO Auto-generated method stub
	
	}

	@Override
	public String getInsert(CookingStyle obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CookingStyle> listAll() {
		return null;
	}

	@Override
	public Integer getId(CookingStyle obj) {
		return obj.getId();
	}

	@Override
	public void setId(Integer id, CookingStyle obj) throws ModelException {
		obj.setId(id);
	}

	@Override
	public String getIdFormated(Integer id) {
		return "id ="+id;
	}
	

}
