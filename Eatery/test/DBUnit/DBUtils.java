package DBUnit;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;

import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;

public class DBUtils {
	
	static IDatabaseConnection connection;

	public static void startDB(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/battest?sessionVariables=FOREIGN_KEY_CHECKS=0";
			// Recupere la connection
	        Connection jdbcConnection = DriverManager.getConnection(url,"root","");
	        connection = new DatabaseConnection(jdbcConnection);
	        FlatXmlDataSetBuilder fb = new FlatXmlDataSetBuilder();
	        fb.setColumnSensing(true);
	        FlatXmlDataSet dataSet = fb.build(new File("dataset.xml"));
			DatabaseOperation.CLEAN_INSERT.execute(connection, dataSet);
	        
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void cleanDB(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/battest?sessionVariables=FOREIGN_KEY_CHECKS=0";
			// Recupere la connection
	        Connection jdbcConnection = DriverManager.getConnection(url,"root","");
	        connection = new DatabaseConnection(jdbcConnection);
	        FlatXmlDataSet dataSet = new FlatXmlDataSetBuilder().build(new File("dataset.xml"));
			DatabaseOperation.DELETE_ALL.execute(connection, dataSet);
	        
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
