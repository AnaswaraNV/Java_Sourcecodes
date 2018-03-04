package ca.myseneca.query;

import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class QueryTableStaticsSQL {


	public static void main(String[] args) {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		// TODO Auto-generated method stub
		try { 
			
			final String DRIVER_NAME = "com.mysql.jdbc.Driver"; // JDBC driver
			final String SYS_NAME = "zenit.senecac.on.ca"; // database server
			final String DB_NAME = "cjv805_181a09"; // database name
			
			//Step1: Load the driver	
			Class.forName(DRIVER_NAME);
			
			// database URL
			String connectionURL = "jdbc:mysql://" + SYS_NAME + "/" + DB_NAME;
									
			//Establishing connection
			connection = DriverManager.getConnection(connectionURL, "cjv805_181a09", "qjYA6332");
			
			//Define Query
			String query = "SELECT * FROM Country WHERE LifeExpectancy BETWEEN 69 AND 70";
			
			//execute query using statement object
			statement = connection.createStatement();
			resultSet = statement.executeQuery(query);
			
			while (resultSet.next()) {

				String countryName = resultSet.getString("Name");
				String continent = resultSet.getString("Continent");
				String LifeE = resultSet.getString("LifeExpectancy");
				String LocalName = resultSet.getString("LocalName");
	            System.out.println("Country Name: " + countryName);
	            System.out.println("Continent: " + continent);
	            System.out.println("Life Expectancy: " + LifeE);
	            System.out.println("Local Name: " + LocalName);
	            System.out.println("**************************");
	
			}
		}catch(SQLException se) {
			se.printStackTrace();
		} 
		catch (ClassNotFoundException ce) {
			System.err.println("Failed to load JDBC/ODBC driver.");
			ce.printStackTrace();
		} 
		finally {
			
				try {
					if(connection != null) {
					connection.close();
					}
					if(statement != null) {
						statement.close();
					}
					if(resultSet != null) {
						resultSet.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} //finally
			

	} //End main
} //End class
