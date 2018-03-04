package ca.myseneca.update;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Scanner;


import java.sql.Statement;

public class InsertTableQuery {

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
			//String query = "INSERT INTO Country Values('INS', 'abcde', 'Asia', 'South Asia', 3287263.00, 1947, 13240000,68.35, 8594000, 55788800,'Bharat','Democracy', 'Anaswara', 345, 'ND');";
			String query = "INSERT INTO Country Values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )";
			System.out.println(query);
			String tableName = getTableName(query);
			//int numberOfColumns = getNumberOfColumns(query, connection);
			ResultSetMetaData rsmd = getTableMetadata(tableName, connection);			
			//read the values to be inserted into database from user
			Object[] values = readValues(pstatement, rsmd);
			
			//execute query using statement object
			pstatement=connection.prepareStatement(query);  
			
			setValues(pstatement, values);
		
			int result=pstatement.executeUpdate();
			
			if(result == 1 ) {
				System.out.println("Insertion successful!");
			} else if(result == 0) {
				System.out.println("Insertion not successful!");
			}

		}catch(SQLException se) {
			System.out.println("Insertion not successful!");
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
	
	private static String getTableName(String query) {
		String[] words = query.split("\\s");//splits the string based on whitespace  
				
		String tableName = words[2];
		return tableName;
	}

	private static ResultSetMetaData  getTableMetadata(String tableName, Connection connection) throws SQLException {
			
				String sql="SELECT * FROM " + tableName;
			    Statement st=connection.createStatement();
			    ResultSet rs=st.executeQuery(sql);
			    ResultSetMetaData rsmd = rs.getMetaData();
			    
			    return rsmd;			
	}

	private static Object[] readValues(PreparedStatement pstatement, ResultSetMetaData rsmd) throws SQLException {
		
		int numOfColumns=0;
	    numOfColumns=rsmd.getColumnCount();
    
		Object[] values = new Object[numOfColumns];
		System.out.println("Please enter values for the columns in the table:");
		Scanner keyboard = new Scanner(System.in);
	
		for (int i = 1; i <= values.length; i++) {
	       // pstatement.setObject(i + 1, values[i]);
			System.out.println("Column type of below column : " + rsmd.getColumnTypeName(i) + " " + rsmd.getColumnType(i));
			if ( i == 3 ) {
				System.out.println("Continet can be :('Asia','Europe','North America','Africa','Oceania','Antarctica','South America')");
			}
			System.out.print(rsmd.getColumnName(i) + " : ");
			values[i-1] = keyboard.nextLine();
	    }
		keyboard.close();
		return values;
	}

	public static void setValues(PreparedStatement preparedStatement, Object[] values) throws SQLException {

	    for (int i = 1; i <= values.length; i++) {
	        preparedStatement.setObject(i, values[i-1]);
	    }
	    
	}
	
} //End class
