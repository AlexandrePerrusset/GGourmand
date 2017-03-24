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
		return " (id, name, country_id) VALUES(?,?,?)";
	}

	//TODO
	@Override
	public void createPrepareFromObject(PreparedStatement p, Region obj) {
		try{
			if(obj.getId()>0){
				p.setString(1, obj.getName());
				p.setInt(2, 1);
			}
		}catch(SQLException e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
		obj.setId(id);
	}

	@Override
	public String getIdFormated(Integer id) {
		return "id ="+id;
	}

	
	

}
