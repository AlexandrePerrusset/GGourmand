package com.infotel.gg.dao.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.infotel.gg.city.Country;
import com.infotel.gg.exception.ModelException;

public class CountryDAO extends AbstractDAO<Country, Integer>{

	@Override
	public String getTableName() {
		// TODO Auto-generated method stub
		return "Country";
	}

	@Override
	public Country getModelObject(ResultSet rs) throws ModelException {
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

	@Override
	public List<Country> listAll() {
		return null;
	}

	@Override
	public Integer getId(Country obj) {
		return obj.getId();
	}

	@Override
	public void setId(Integer id, Country obj) {
	}

	@Override
	public String getIdFormated(Integer id) {
		return "id ="+id;
	}
	

}
