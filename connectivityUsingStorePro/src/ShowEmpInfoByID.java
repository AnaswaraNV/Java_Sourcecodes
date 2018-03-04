/**
 * @author Anaswara Naderi Vadakkeperatta
 */


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * This example shows Oracle OCI driver to implement database connection
 */
public class ShowEmpInfoByID  {
	public static void main(String[] args) {
		Connection connection = null;
		PreparedStatement pstatement = null;
		ResultSet resultSet = null;

		String OCIDriverConnectDescriptorURL = "jdbc:oracle:oci:@//myoracle12c.senecacollege.ca/oracle12c";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection(OCIDriverConnectDescriptorURL, "cjv805_181a09", "qjYA6332");
			String query = "SELECT first_name||' '|| last_name As fullName, email, salary FROM employees WHERE employee_id = ?";

			//execute query using statement object
			pstatement=connection.prepareStatement(query);

			int eID = readEmployeeID();

			pstatement=connection.prepareStatement(query);  


			//set the eID in the query
			pstatement.setInt(1, eID);

			System.out.println("Executing query...");
			ResultSet result=pstatement.executeQuery();

			while (result.next()) {

				String fullName = result.getString("fullName");
				System.out.println("First Name is : " + fullName );
				String email = result.getString("email");
				System.out.println("Email is : " + email );
				String salary = result.getString("salary");
				System.out.println("Salary is : " + salary );
			}

		}
		catch (ClassNotFoundException cnfex) {
			System.err.println("Failed to load JDBC/ODBC driver.");
		} catch (SQLException e) {
			System.out.println("The error is:  " + e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close(); 
				}
				if (pstatement != null) {
					pstatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				System.out.println("Exception caught in StatementExample.main() finally block");
				System.out.println("Exception: " + e.getMessage());
				e.printStackTrace();
			}
		} // Finally
	} // Main

	private static int readEmployeeID() {
		int eID = 0;

		//reading employee id 
		System.out.println("Please enter employee id:");
		Scanner keyboard = new Scanner(System.in);
		eID = keyboard.nextInt();
		keyboard.close();

		return eID;

	}

} // Class
