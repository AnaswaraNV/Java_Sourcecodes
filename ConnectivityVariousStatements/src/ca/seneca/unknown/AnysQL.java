package ca.seneca.unknown;

import java.sql.Connection;
import java.util.Scanner;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class AnysQL {
	static Connection connection = null;
	static Statement statement = null;
	static ResultSet resultSet = null;
	
	public static void main(String[] args) {
					
		
		final String DRIVER_NAME = "com.mysql.jdbc.Driver"; // JDBC driver
		final String SYS_NAME = "zenit.senecac.on.ca"; // database server
		final String DB_NAME = "cjv805_181a09"; // database name
		
		try { 
		//Step1: Load the driver	
		Class.forName(DRIVER_NAME);
		
		// database URL
		String connectionURL = "jdbc:mysql://" + SYS_NAME + "/" + DB_NAME;
								
		//Establishing connection
		connection = DriverManager.getConnection(connectionURL, "cjv805_181a09", "qjYA6332");
		
		//ProcessQuery
		String query  = readQuery(connection);
		
		//String tableName = getTableName(query);
		 Statement stmt = connection.createStatement();
		 
		 boolean status= stmt.execute(query);
		
		 int count = 0 ;
		 do  {
			 
				 if(status) {
						  ResultSet result = stmt.getResultSet();
						  if(result != null) { 
							  ResultSetMetaData rsmd = result.getMetaData();
							  if(rsmd != null) { 		
								  int numOfColumns=0;
								  numOfColumns=rsmd.getColumnCount();
								  System.out.println("Query Executed!! No of Columns = "+ numOfColumns); 
							     
								  while (result.next()) {
									
									  	for(int i=1; i<= numOfColumns ; i++) {
											System.out.print(rsmd.getColumnName(i) + " : ");
											System.out.println(result.getObject(i));
									  	}
								  } //while
							  } //rsmd null check
						  } //result null check
					  
				 } else {
			            count = stmt.getUpdateCount();
			            if(count != -1) {
			            	System.out.println("Table Updated count is " + count);
			            }
			            
			            if (count >= 0) {
			            	ResultSet result = stmt.getResultSet();
			            	
			            	if(result != null) {
			            		ResultSetMetaData rsmd = result.getMetaData();
			            		if(rsmd != null) {
			            			 int numOfColumns=0;
									 numOfColumns=rsmd.getColumnCount();
									  System.out.println("Query Executed!! No of Columns in the table is = "+ numOfColumns); 							  
			            		}
			            	}
			               //System.out.println("DDL or update data displayed here.");
			            } else {
			            	System.out.println("End of processing!");
			               System.out.println("No more results to process.");
			            }
				 }
				 status = stmt.getMoreResults();
	      } while (status || count != -1);
		  }catch(SQLException se) {
			System.out.println("SQL query that you entered is having wrong Syntax!");
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
					System.out.println("Connection Not successful!BYE...");
					e.printStackTrace();
				}
			}    //finally
		
	}//end main
	public static String readQuery(Connection connection) {
		//keyboard object
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Please enter the query:");
		//read  Query
		String query = keyboard.nextLine();
		keyboard.close();
		return query;
	} // method readQuery
	
} //End class
