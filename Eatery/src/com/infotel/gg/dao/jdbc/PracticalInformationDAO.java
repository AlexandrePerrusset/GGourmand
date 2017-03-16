package com.infotel.gg.dao.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.infotel.gg.eatery.CookingStyle;
import com.infotel.gg.eatery.PracticalInformation;

public class PracticalInformationDAO extends AbstractDAO<PracticalInformation, Integer>{

	@Override
	public String getTableName() {
		// TODO Auto-generated method stub
		return "practical_information";
	}

	@Override
	public PracticalInformation getModelObject(ResultSet rs) {
		PracticalInformation temp = null;
		try {
			temp = new PracticalInformation(rs.getInt("id"), rs.getString("hours_of_operation1"), rs.getString("hours_of_operation2"), rs.getString("payment_options"), rs.getString("price"), rs.getString("getting_there"), rs.getString("parking"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return temp;
	}

	

	@Override
	public String getUpdate(PracticalInformation obj) {
		return null;
	}

	@Override
	public String getInsert(PracticalInformation obj) {
		return null;
	}

	@Override
	public void createPrepareFromObject(PreparedStatement p, PracticalInformation obj) {
	}

	@Override
	public List<PracticalInformation> listAll() {
		return null;
	}

	@Override
	public Integer getId(PracticalInformation obj) {
		return obj.getId();
	}

	@Override
	public void setId(Integer id, PracticalInformation obj) {
		obj.setId(id);
	}

	@Override
	public String getIdFormated(Integer id) {
		return "id ="+id;
	}
	

}
