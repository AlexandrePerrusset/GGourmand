package com.infotel.gg.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.infotel.gg.dao.UserDAO;
import com.infotel.gg.execption.UserException;

public abstract class AbstractUserDAO<T extends IEmail> implements UserDAO<T> {
	/* (non-Javadoc)
	 * @see com.infotel.gg.dao.jdbc.UserDAO#create(T)
	 */
	@Override
	public void create(T obj) throws UserException{
		Connection cn =SqlUtils.getConnection();
		String sql = "INSERT INTO "+ getTableName() + getInsert(obj);
		try {
			PreparedStatement st = cn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			createPrepareFromObject(st,obj);
			st.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new UserException("Impossible de creer l'élément.");
		}
	}

	
	/* (non-Javadoc)
	 * @see com.infotel.gg.dao.jdbc.UserDAO#read(java.lang.String)
	 */
	@Override
	public T read(String i) {
		T result = null;
		try {
			Connection cn =SqlUtils.getConnection();
			Statement st= cn.createStatement();
			
			ResultSet rs = st.executeQuery("Select * from "+ getTableName()+" where username like '"+i+"'");
			
			if(rs.next()) result = getModelObject(rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	
	/* (non-Javadoc)
	 * @see com.infotel.gg.dao.jdbc.UserDAO#update(T)
	 */
	@Override
	public void update(T obj) {
		Connection cn =SqlUtils.getConnection();
		String sql = "Update "+ getTableName() + " SET "+ getUpdate(obj)+" Where username like '"+obj.getEmail()+"'";
		try{
			PreparedStatement st = cn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			st.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	
	/* (non-Javadoc)
	 * @see com.infotel.gg.dao.jdbc.UserDAO#delete(T)
	 */
	@Override
	public void delete(T obj) {
		try {
			Connection cn =SqlUtils.getConnection();
			Statement st = cn.createStatement();
			st.execute("DELETE FROM "+ getTableName() +" where username like '"+obj.getEmail()+"'");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
}

	
	/* (non-Javadoc)
	 * @see com.infotel.gg.dao.jdbc.UserDAO#delete(java.lang.String)
	 */
	@Override
	public void delete(String id) {
		try {
			Connection cn =SqlUtils.getConnection();
			Statement st = cn.createStatement();
			st.execute("DELETE FROM "+ getTableName() +" where username like '"+id+"'");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public abstract String getTableName();
	public abstract T getModelObject(ResultSet rs);
	public abstract String getUpdate(T obj);
	public abstract String getInsert(T obj);
	public abstract void createPrepareFromObject(PreparedStatement p, T obj);

}
