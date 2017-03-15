package com.infotel.gg.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import com.infotel.gg.eatery.Menu;


public class MenuDAO extends AbstractDAO<Menu> {

	
	@Override
	public String getTableName() {
		// TODO Auto-generated method stub
		return "Menu";
	}

	@Override
	public Menu getModelObject(ResultSet rs) {
		Menu menu = null;
		try {
			menu = new Menu(rs.getInt("id"), rs.getString("content"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return menu;
	}

	@Override
	public String getUpdate(Menu obj) {
		return "content = '"+ obj.getContent()+ "' ";
	}

	@Override
	public void createPrepareFromObject(PreparedStatement p, Menu obj) {
		try{
			if(obj.getId()> 0){
				p.setLong(1, obj.getId());
				p.setString(2, obj.getContent());
				System.out.println(p);
			}else{
				p.setString(1, obj.getContent());
			}
		}catch(SQLException e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public String getInsert(Menu obj) {
		if(obj.getId() > 0){
			return " (id, content) VALUES(?,?)";
		}
		return " (content) VALUES(?)";
	}
	
	public Map<Long, Menu> readAll(){
		Map<Long, Menu> listMenu = new HashMap<Long,Menu>();
		try {
			Connection cn =SqlUtils.getConnection();
			Statement st= cn.createStatement();
			
			ResultSet rs = st.executeQuery("Select * from "+ getTableName());
			
			while(rs.next()){
				Menu m = getModelObject(rs);
				listMenu.put(m.getId(), m);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listMenu;
	}
	
//	private Connection cn;
//	private Statement st;
//	
//	public MenuDAO(){
//		cn = SqlUtils.getConnection();
//		try {
//			st = cn.createStatement();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	
//	
//	/* (non-Javadoc)
//	 * @see com.infotel.gg.dao.DAO#create(com.infotel.gg.eatery.Menu)
//	 */
//	@Override
//	public void create(Menu menu){
//	
//		try {
//			
//			st.execute("INSERT INTO MENU( content) VALUES ( "+menu.getContent()+" )");
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		
//		
//	}
//	
//	//Select
//	/* (non-Javadoc)
//	 * @see com.infotel.gg.dao.DAO#read(int)
//	 */
//	@Override
//	public Menu read(int i){
//		Menu menu = null;
//		
//		try {
//			
//			ResultSet rs = st.executeQuery("Select * from Menu where id ="+i+"");
//			if(rs.next()) menu = new Menu(rs.getInt("id"), rs.getString("content"));
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return menu;
//		
//		
//	}
//	
//	/* (non-Javadoc)
//	 * @see com.infotel.gg.dao.DAO#update(com.infotel.gg.eatery.Menu)
//	 */
//	@Override
//	public void update(Menu menu){
//		
//		try {
//			
//			st.execute("UPDATE MENU SET content = '"+menu.getContent()+"' where id ="+menu.getId()+"");
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//	}
//	/* (non-Javadoc)
//	 * @see com.infotel.gg.dao.DAO#delete(com.infotel.gg.eatery.Menu)
//	 */
//	@Override
//	public void delete(Menu menu){
//	
//		try {
//		
//			st.execute("DELETE FROM MENU where id ="+menu.getId()+"");
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//	}
//	
//	/* (non-Javadoc)
//	 * @see com.infotel.gg.dao.DAO#delete(int)
//	 */
//	@Override
//	public void delete(int id){
//	
//		try {
//		
//			st.execute("DELETE FROM MENU where id ="+id+"");
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//	}
	
}
