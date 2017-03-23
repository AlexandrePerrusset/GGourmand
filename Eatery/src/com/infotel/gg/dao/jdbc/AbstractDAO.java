package com.infotel.gg.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.infotel.gg.dao.DAO;
import com.infotel.gg.exception.DAOException;
import com.infotel.gg.exception.ModelException;


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
			throw new DAOException("Impossible de creer l'element.");
		}
	}

	
	/* (non-Javadoc)
	 * @see com.infotel.gg.dao.jdbc.DAO#read(int)
	 */
	@Override
	public T read(K i) throws ModelException {
		T result = null;
		try {
			Connection cn =SqlUtils.getConnection();
			Statement st= cn.createStatement();
			
			ResultSet rs = st.executeQuery("Select * from "+ getTableName()+" where "+getIdFormated(i)+"");
			System.out.println("Select * from "+ getTableName()+" where "+getIdFormated(i)+"");
			if(rs.next()) result = getModelObject(rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DAOException("Impossible de creer l'element.");
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
	public void delete(T obj) throws DAOException {
		
		try {
			Connection cn =SqlUtils.getConnection();
			Statement st = cn.createStatement();
			ResultSet rs =	st.executeQuery("Select * from "+ getTableName()+" where "+getIdFormated(getId(obj))+"");
			if(!rs.next()) throw new DAOException("Impossible de supprimer l'element.");
			st.execute("DELETE FROM "+ getTableName() +" where "+getIdFormated(getId(obj))+"");
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("Impossible de supprimer l'element.");
			
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
			ResultSet rs =	st.executeQuery("Select * from "+ getTableName()+" where "+getIdFormated(id)+"");
			if(!rs.next()) throw new DAOException("Impossible de supprimer l'element.");
			st.execute("DELETE FROM "+ getTableName() +" where "+getIdFormated(id)+"");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DAOException("Impossible de supprimer l'element.");
		}
		
	}
	
	
	public abstract String getTableName();
	public abstract T getModelObject(ResultSet rs) throws ModelException;
	public abstract String getUpdate(T obj);
	public abstract String getInsert(T obj);
	public abstract void createPrepareFromObject(PreparedStatement p, T obj);
	public abstract String getIdFormated(K id);


}
