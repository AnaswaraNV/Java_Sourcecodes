package ca.myseneca.model;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.BatchUpdateException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;

/*
 * @author : Jonathan Chik 
 * 			 Anaswara Naderi Vadakkeperatta
 *           This utilities class provides the functionalities of loading properties file,
 *           setting up JDBC connection, retrieve SQLException and SQLWarning.
*/

public class DBUtil {

	//member variable 
	private Properties databaseProperties;

	//Constructor passing the properties file name as input
	public DBUtil(String propertiesFileName)
			throws FileNotFoundException, IOException,
			InvalidPropertiesFormatException {
		super();
		this.setProperties(propertiesFileName);
	}

	//Set properties method to load the properties to current class
	public void setProperties(String propertiesFileName) throws FileNotFoundException, IOException {		
		//Defining input as properties file
		//FileInputStream input = new FileInputStream(propertiesFileName);
		FileReader reader=new FileReader("Database.properties");  
		this.databaseProperties=new Properties();
		//load properties file
		this.databaseProperties.load(reader);			
	}

	//Get connection variables from properties file and define connection Object
	public Connection getConnection() throws SQLException, ClassNotFoundException {

		String driver = databaseProperties.getProperty("ORACLE_DB_DRIVER");
		String urlStringThin = databaseProperties.getProperty("ORACLE_DB_THIN_DRIVER_CONNECT_DESCRIPTOR_URL");
		@SuppressWarnings("unused")
		String urlStringOCI = databaseProperties.getProperty("ORACLE_DB_OCI_DRIVER_CONNECT_DESCRIPTOR_URL");
		String userName = databaseProperties.getProperty("ORACLE_DB_USERNAME");
		String password = databaseProperties.getProperty("ORACLE_DB_PASSWORD");

		//Define driver
		Class.forName(driver);

		//Define connection Object
		Connection connectionObject = DriverManager.getConnection(urlStringThin, userName, password );
		if (connectionObject != null) {
			System.out.println("Connected to database..."); }
		return connectionObject;
	}

	//Display All SQL warnings to user with detailed info such as state, error code etc
	public static void printWarnings(SQLWarning warning) throws SQLException {
		if (warning != null) {
			System.out.println("\n---Warning---\n");
			while (warning != null) {
				System.out.println("Message: " + warning.getMessage());
				System.out.println("SQLState: " + warning.getSQLState());
				System.out.print("Vendor error code: ");
				System.out.println(warning.getErrorCode());
				System.out.println("");
				warning = warning.getNextWarning();
			}
		}
	}

	//Display SQL Exceptions to user with detailed info such as state, error code, cause etc
	public static void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: "
						+ ((SQLException) e).getSQLState());
				System.err.println("Error Code: "
						+ ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}


	}

	//Display if any Batch update Exception occurs (A count is also displayed)
	public static void printBatchUpdateException(BatchUpdateException b) {
		System.err.println("----BatchUpdateException----");
		System.err.println("SQLState:  " + b.getSQLState());
		System.err.println("Message:  " + b.getMessage());
		System.err.println("Vendor:  " + b.getErrorCode());
		System.err.print("Update counts:  ");
		int[] updateCounts = b.getUpdateCounts();
		for (int i = 0; i < updateCounts.length; i++) {
			System.err.print(updateCounts[i] + "   ");
		}
	}


	//close Connection Object
	public static void closeConenction(Connection connectionObject) throws SQLException {
		if(connectionObject != null) {
			connectionObject.close();
		}
	}


} //End of class DBUtil
