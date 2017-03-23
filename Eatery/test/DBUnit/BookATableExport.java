package DBUnit;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;

import org.dbunit.database.*;
import org.dbunit.database.search.TablesDependencyHelper;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.*;
import org.dbunit.operation.DatabaseOperation;

public class BookATableExport {

	static IDatabaseConnection connection;
	static String userHome;
	
	static {
		connection = null;
		userHome = System.getProperty("user.home")+System.getProperty("file.separator");
	}
	
	public static void main(String args[]) {
		try {
			BookATableExport.exporter();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void exporter() throws Exception
    {
        // database connection
		Class.forName("com.mysql.jdbc.Driver");
		// 	Obtention de la connexion
		String url = "jdbc:mysql://localhost:3306/bat";
		// Recupere la connection
        Connection jdbcConnection = DriverManager.getConnection(url,"root","");
        connection = new DatabaseConnection(jdbcConnection);

        // partial database export
        QueryDataSet partialDataSet = new QueryDataSet(connection);
        partialDataSet.addTable("user_data");
        partialDataSet.addTable("booking");
        partialDataSet.addTable("city");
        partialDataSet.addTable("cooking_style");
        partialDataSet.addTable("region");
        partialDataSet.addTable("country");
        partialDataSet.addTable("eatery","SELECT * FROM eatery WHERE id between 1 and 40");
        partialDataSet.addTable("menu","SELECT * FROM menu WHERE id between 1 and 40");
        partialDataSet.addTable("practical_information","SELECT * FROM practical_information WHERE id between 1 and 40");
        partialDataSet.addTable("image_data", "Select * from image_data where target_id between 1 and 40");
        String fileName = userHome+"partial.xml";
        System.out.println(fileName);
        FlatXmlDataSet.write(partialDataSet, new FileOutputStream(fileName));
/*
        // full database export
        IDataSet fullDataSet = connection.createDataSet();
        FlatXmlDataSet.write(fullDataSet, new FileOutputStream("full.xml"));
*/
        // dependent tables database export: export table X and all tables that
        // have a PK which is a FK on X, in the right order for insertion
//        String[] depTableNames = 
//          TablesDependencyHelper.getAllDependentTables( connection, "booking" );
//        
//        IDataSet depDataSet = connection.createDataSet( depTableNames );
//        FlatXmlDataSet.write(depDataSet, new FileOutputStream("dependents.xml"));          
 
    }
	
	public static void importer() throws Exception {	
		
		FlatXmlDataSet dataSet = new FlatXmlDataSetBuilder().build(new File("dataset.xml"));
		DatabaseOperation.CLEAN_INSERT.execute(connection, dataSet);
		
	}
}