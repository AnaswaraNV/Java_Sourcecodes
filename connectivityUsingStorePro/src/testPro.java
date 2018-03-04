import java.sql.CallableStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

/*
 * thin driver example
 */
public class testPro {


	public static void main(String[] args) {
		Connection connection = null;
		CallableStatement cstatement = null;
		ResultSet resultSet = null;
		String OCIDriverConnectDescriptorURL = "jdbc:oracle:thin:@//myoracle12c.senecacollege.ca/oracle12c";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection(OCIDriverConnectDescriptorURL, "cjv805_181a09", "qjYA6332");
			
			//call procedure with prepareCall
			cstatement = connection.prepareCall("{ ? = call total_cancellations()}" );
			
			//registering out parameter
			cstatement.registerOutParameter(1, Types.INTEGER);
			cstatement.execute();
			
			int count = cstatement.getInt(1);
			
			System.out.println("count is : " + count);
			
		}catch(SQLException se) {
			System.out.println("Error in SQL !");
			se.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null) {				
						resultSet.close();	
				}
				if (cstatement != null) {
					cstatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} 
		}

	} //end main

} //end class
