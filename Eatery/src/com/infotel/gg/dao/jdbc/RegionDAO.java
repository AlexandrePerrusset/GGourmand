package com.infotel.gg.dao.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.infotel.gg.exception.ModelException;
import com.infotel.gg.model.Region;

public class RegionDAO extends AbstractDAO<Region, Integer>{

	@Override
	public String getTableName() {
		// TODO Auto-generated method stub
		return "Region";
	}

	@Override
	public Region getModelObject(ResultSet rs) throws ModelException {
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

	@Override
	public List<Region> listAll() {
		return null;
	}

	@Override
	public Integer getId(Region obj) {
		return obj.getId();
	}

	@Override
	public void setId(Integer id, Region obj) {
	}

	@Override
	public String getIdFormated(Integer id) {
		return "id ="+id;
	}

	
	

}
