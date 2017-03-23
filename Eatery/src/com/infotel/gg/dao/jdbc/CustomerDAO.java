package com.infotel.gg.dao.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.infotel.gg.model.Customer;
import com.infotel.gg.model.Menu;

public class CustomerDAO extends AbstractDAO<Customer, String>{

	@Override
	public String getTableName() {
		return "user_data";
	}

	@Override
	public Customer getModelObject(ResultSet rs) {
		Customer c = null;
		try {
			c = new Customer(rs.getString("First_name"), rs.getString("last_name"),  rs.getString("title"),  rs.getString("phone"),  rs.getString("username"),  rs.getString("password"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
	}

	@Override
	public String getUpdate(Customer obj) {
		return null;
	}

	@Override
	public String getInsert(Customer obj) {
		
		return " (username, password, type, first_name, last_name, title, phone) VALUES(?,?,?,?,?,?,?)";
	}

	@Override
	public void createPrepareFromObject(PreparedStatement p, Customer obj) {
		try{
			if(obj.getEmail()!= "" ){
				p.setString(1, obj.getEmail());
				p.setString(2, obj.getPassword());
				p.setString(3, "customer");
				p.setString(4, obj.getFirstName());
				p.setString(5, obj.getFirstName());
				p.setString(6, obj.getTitle());
				p.setString(7, obj.getPhone());
			
			}
		}catch(SQLException e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Customer> listAll() {
		return null;
	}

	@Override
	public String getId(Customer obj) {
		return obj.getEmail();
	}

	@Override
	public void setId(String id, Customer obj) {
		obj.setUsername(id);
	}

	@Override
	public String getIdFormated(String id) {
		return "username ='"+id+"'";
	}

	

}
