package ca.myseneca.update;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateTableQuery {

	public static void main(String[] args) {
		Connection connection = null;
		PreparedStatement pstatement = null;
		ResultSet resultSet = null;
	
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
			
		
			String newQuery = setSQLQuery(pstatement);
			//execute query using statement object
			pstatement=connection.prepareStatement(newQuery);  
		
			int result=pstatement.executeUpdate();
			System.out.println("Table affected row count is :  " + result);
			if(result == 1 ) {
				System.out.println("Updation successful!");
			} else if(result == 0) {
				System.out.println("Updation not successful!");
			}

		}catch(SQLException se) {
			System.out.println("Updation not successful!");
			System.out.println("Sorry! Something went wrong in input! Please find below details!");
			se.printStackTrace();
			
		} 
		catch (ClassNotFoundException ce) {
			System.err.println("Failed to load JDBC/ODBC driver.");
			ce.printStackTrace();
		} 
		catch(Exception e) {
			e.printStackTrace();
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
					System.out.println("Error occured~BYE...");
					e.printStackTrace();
				}
			} //finally
			

	} //End main

	private static String setSQLQuery(PreparedStatement pstatement) throws SQLException {
	
		System.out.println("Please enter details to update:");
		Scanner keyboard = new Scanner(System.in);
		
		System.out.print("Column Name to update : ");
		String columnNameUpd = keyboard.nextLine();
		System.out.print("Value to be updated: ");
		String value= keyboard.nextLine();
		
		System.out.print("Column name of condition : ");
		String columnNameCond = keyboard.nextLine();
		System.out.print("Value of Condition: ");
		String valueCond= keyboard.nextLine();
		
		String newQuery = "UPDATE Country SET " + columnNameUpd + " = " + value +   " WHERE " + columnNameCond + " = " + "'" + valueCond + "'";

		System.out.println("Query is " + newQuery);
		keyboard.close();
		return newQuery;
		
	}

	
} //End class
