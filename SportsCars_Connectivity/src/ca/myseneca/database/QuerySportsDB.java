package ca.myseneca.database;

import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import java.util.List;
import java.util.Map;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class QuerySportsDB {

	//for column names 
	ArrayList<String> colList = new ArrayList<String>();
	//ArrayList<String> colList = new ArrayList<String>();
	ArrayList<String> rowList = null;
	Map<Integer, List<String>> rowMap = null;


	public ArrayList<String> getColList() {
		return colList;
	}


	public void setColList(ArrayList<String> colList) {
		this.colList = colList;
	}

	public ArrayList<String> getObj() {
		return rowList;
	}


	public void setObj(ArrayList<String> obj) {
		this.rowList = obj;
	}

	public QuerySportsDB() {


	} //end of constrctor

	public Map<Integer, List<String>> executeDBFetch() { 
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try { 


			final String DRIVER_NAME = "oracle.jdbc.driver.OracleDriver"; // JDBC driver
			final String DB_NAME = "cjv805_181a09"; // database name

			//Step1: Load the driver	
			Class.forName(DRIVER_NAME);

			// database URL
			String ThinDriverConnectDescriptorURL = "jdbc:oracle:thin:@//myoracle12c.senecacollege.ca/oracle12c";

			//Establishing connection
			connection = DriverManager.getConnection(ThinDriverConnectDescriptorURL, DB_NAME, "qjYA6332");
			if (connection != null) { System.out.println("Connection not null");}

			//Define Query
			String query = "SELECT * FROM SportsCars";

			//execute query using statement object
			statement = connection.createStatement();
			resultSet = statement.executeQuery(query);
			int numOfColumns=0;
			ResultSetMetaData rsmd = null ;

			rowMap = new HashMap<Integer, List<String>>();
			int rowNumber = 0; 

			while (resultSet.next()) {
				
				rowList = new ArrayList<String>();
				if(resultSet != null) {
					rsmd = resultSet.getMetaData();
					if(rsmd != null) {

						numOfColumns=rsmd.getColumnCount();

					}
				}		 

				//Object[] objArray =  new Object[numOfColumns];
				System.out.println("Query Executed!! No of Columns in the table is = "+ numOfColumns); 	
				for(int i = 1; i<= numOfColumns ; i++) {
					if (!this.colList.contains(rsmd.getColumnName(i))) {
						//setting the list
						this.colList.add(rsmd.getColumnName(i));
					}
					//objArray[i-1] = resultSet.getObject(i);
					this.rowList.add(String.valueOf(resultSet.getObject(i)));

				}
				System.out.println("col list is " + colList);
				rowMap.put(rowNumber, rowList);
				System.out.println("row map is " + rowMap);
				rowNumber++;
			}//while

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
		return rowMap;

	}


} //End class

