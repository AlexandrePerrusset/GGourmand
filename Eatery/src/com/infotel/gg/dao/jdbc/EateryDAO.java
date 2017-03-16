package com.infotel.gg.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.infotel.gg.eatery.Eatery;
import com.infotel.gg.eatery.Menu;
import com.infotel.gg.exception.ModelException;

public class EateryDAO extends AbstractDAO<Eatery, Integer>{

	@Override
	public String getTableName() {
		// TODO Auto-generated method stub
		return "Eatery";
	}

	@Override
	public Eatery getModelObject(ResultSet rs) throws ModelException {
		Eatery temp = null;
		try {
			temp = new Eatery(rs.getInt("id"), rs.getString("name"), rs.getString("description"), rs.getString("executive_chef") );
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return temp;
	}
	
	public List<Eatery> find(String key) throws ModelException{
		List<Eatery> eateries = new ArrayList<Eatery>();
		try {
			Connection cn =SqlUtils.getConnection();
			Statement st= cn.createStatement();
			
			ResultSet rs = st.executeQuery("Select * from "+ getTableName() + " where name like '%"+key+"%' or description like '%"+key
					+"%' or executive_chef like '%"+key+"%' order by name");
			
			while(rs.next()){
				Eatery e = getModelObject(rs);
				eateries.add(e);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return eateries;
	}

	@Override
	public String getUpdate(Eatery obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createPrepareFromObject(PreparedStatement p, Eatery obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getInsert(Eatery obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Eatery> listAll() {
		return null;
	}

	@Override
	public Integer getId(Eatery obj) {
		return obj.getId();
	}

	@Override
	public void setId(Integer id, Eatery obj) throws ModelException {
		obj.setId(id);
	}

	@Override
	public String getIdFormated(Integer id) {
		return "id ="+id;
	}
}
