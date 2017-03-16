package com.infotel.gg.dao.jdbc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class SqlUtils {
	
	private SqlUtils(){
		
	}
	private static Connection connectionC = null;
	
	public static Connection getConnection(){
		try {
			if(connectionC == null){
				Class.forName("com.mysql.jdbc.Driver");
				Properties pro  = new Properties();
				InputStream is = new FileInputStream("properties/gastronome.properties");
				pro.load(is);
				String url = pro.getProperty("database");
				// Obtention de la connexion
				//String url = "jdbc:mysql://localhost:3306/battest";
				// Recupere la connection
				
				connectionC = DriverManager.getConnection(url, "root", "");
			}
			
		}catch (ClassNotFoundException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connectionC;
	}
}
