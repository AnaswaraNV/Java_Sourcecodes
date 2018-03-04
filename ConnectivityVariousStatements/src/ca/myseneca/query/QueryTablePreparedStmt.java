package ca.myseneca.query;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class QueryTablePreparedStmt {

	public static void main(String[] args) {
		Connection connection = null;
		PreparedStatement pstatement = null;
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
			String query = "SELECT * FROM Country WHERE LifeExpectancy BETWEEN ? AND ?";
			System.out.println("Please enter value for this query (eg: 78.4): " + query);
			//execute query using statement object
			pstatement=connection.prepareStatement(query);  
			
				Scanner keyboard = new Scanner(System.in);
				System.out.println("Please enter the first value");
				Float age1 = Float.parseFloat(keyboard.next());
				System.out.println("Please enter the second value");
				Float age2 = Float.parseFloat(keyboard.next());
			
			//Setting the placeholder
			pstatement.setFloat(1, age1);
			pstatement.setFloat(2, age2);
			
			ResultSet result=pstatement.executeQuery();
			
			if(result != null) {
				while (result.next()) {
					
					String countryName = result.getString("Name");
					String continent = result.getString("Continent");
					String LifeE = result.getString("LifeExpectancy");
					String LocalName = result.getString("LocalName");
					System.out.println("Country Name: " + countryName);
					System.out.println("Continent: " + continent);
					System.out.println("Life Expectancy: " + LifeE);
					System.out.println("Local Name: " + LocalName);
					System.out.println("**************************");
				}
			}

			
			keyboard.close();

			}catch(SQLException se) {
				se.printStackTrace();
			} 
			catch (ClassNotFoundException ce) {
				System.err.println("Failed to load JDBC/ODBC driver.");
				ce.printStackTrace();
			}
			catch(Exception e) {
				System.out.println("Something wrong happened!");
			}
			finally {

				try {
					if(connection != null) {
						connection.close();
					}
					if(pstatement != null) {
						pstatement.close();
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
