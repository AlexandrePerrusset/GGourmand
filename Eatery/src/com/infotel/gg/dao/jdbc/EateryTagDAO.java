package com.infotel.gg.dao.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.infotel.gg.city.City;
import com.infotel.gg.eatery.EateryTag;

public class EateryTagDAO extends AbstractDAO<EateryTag, Integer>{

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
	public List<EateryTag> listAll() {
		return null;
	}

	@Override
	public Integer getId(EateryTag obj) {
		return obj.getId();
	}

	@Override
	public void setId(Integer id, EateryTag obj) {
		obj.setId(id);
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

	@Override
	public String getIdFormated(Integer id) {
		return "id ="+id;
	}
	


	

}
