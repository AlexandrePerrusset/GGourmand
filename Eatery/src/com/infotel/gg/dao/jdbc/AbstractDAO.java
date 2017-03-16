package com.infotel.gg.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.infotel.gg.dao.DAO;
import com.infotel.gg.exception.DAOException;


public abstract class AbstractDAO<T,K> implements DAO<T,K>{

	
	/* (non-Javadoc)
	 * @see com.infotel.gg.dao.jdbc.DAO#create(T)
	 */
	@Override
	public void create(T obj) throws DAOException {
		Connection cn =SqlUtils.getConnection();
		String sql = "INSERT INTO "+ getTableName() + getInsert(obj);
		try {
			PreparedStatement st = cn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			createPrepareFromObject(st,obj);
			st.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DAOException("Impossible de creer l'�l�ment.");
		}
	}

	
	/* (non-Javadoc)
	 * @see com.infotel.gg.dao.jdbc.DAO#read(int)
	 */
	@Override
	public T read(K i) {
		T result = null;
		try {
			Connection cn =SqlUtils.getConnection();
			Statement st= cn.createStatement();
			
			ResultSet rs = st.executeQuery("Select * from "+ getTableName()+" where "+getIdFormated(i)+"");
			
			if(rs.next()) result = getModelObject(rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	
	/* (non-Javadoc)
	 * @see com.infotel.gg.dao.jdbc.DAO#update(T)
	 */
	@Override
	public void update(T obj) {
		Connection cn =SqlUtils.getConnection();
		String sql = "Update "+ getTableName() + " SET "+ getUpdate(obj)+" Where "+getIdFormated(getId(obj));
		try{
			PreparedStatement st = cn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			st.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	
	/* (non-Javadoc)
	 * @see com.infotel.gg.dao.jdbc.DAO#delete(T)
	 */
	@Override
	public void delete(T obj) {
		try {
			Connection cn =SqlUtils.getConnection();
			Statement st = cn.createStatement();
			st.execute("DELETE FROM"+ getTableName() +"where "+getIdFormated(getId(obj))+"");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	
	/* (non-Javadoc)
	 * @see com.infotel.gg.dao.jdbc.DAO#delete(long)
	 */
	@Override
	public void deleteById(K id) {
		try {
			Connection cn =SqlUtils.getConnection();
			Statement st = cn.createStatement();
			st.execute("DELETE FROM "+ getTableName() +" where "+getIdFormated(id)+"");
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
	public abstract String getIdFormated(K id);


}
