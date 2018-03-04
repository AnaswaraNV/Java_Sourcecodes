import java.sql.CallableStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

/*
 * thin driver example
 */
public class ShowTotalEmpByDeptID {


	public static void main(String[] args) {
		Connection connection = null;
		CallableStatement cstatement = null;
		ResultSet resultSet = null;
		String ThinDriverConnectDescriptorURL = "jdbc:oracle:thin:@//myoracle12c.senecacollege.ca/oracle12c";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection(ThinDriverConnectDescriptorURL, "cjv805_181a09", "qjYA6332");
			
			//call procedure with prepareCall
			cstatement = connection.prepareCall("{ call CJV805_181A09.TOTAL_EMP_BY_DEPT_ID(?, ?)}" );
			
			//read department
			int depId = readDeptID();
			
			cstatement.setInt(1,depId);
			//registering out parameter
			cstatement.registerOutParameter(2, Types.INTEGER);
			cstatement.execute();
			
			int count = cstatement.getInt(2);
			
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

	private static int readDeptID() {
		int deptID;
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Please enter department ID");
		deptID = keyboard.nextInt();
		
		keyboard.close();
		return deptID;
	}
} //end class
