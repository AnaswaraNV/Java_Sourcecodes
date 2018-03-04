package ca.myseneca.test;

import ca.myseneca.model.DAManager;
import ca.myseneca.model.Employee;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * @author : Jonathan Chik
 * 			 Anaswara Naderi Vadakkeperatta
 *
 *           The HRManagement class is a test class that mimics an application. 
 *           Prompt user input a user name and a password from the console.
 *	         If pass the credential check, show the user’s info as employee. 
 */

public class HRManagement {

	static Scanner keyboard = new Scanner(System.in);

	public static void main(String[] args) throws SQLException {
		@SuppressWarnings("unused")
		String wait = " ";

		System.out.println("*************Employee Id validation*************");
		String username = readUsername();
		String password = readPassword();
		// Test scenario for getEmployeeId
		int employID = DAManager.getEmployeeID(username, password);

		boolean isUserValid = validation(employID);

		// If authorization successful , perform all functions
		if (isUserValid) {
			{
				System.out.println("*************Authorized Employee Info*************");
				// Get Employee Info
				DAManager.getEmployeeByID(employID).display();
				System.out.println("Press Enter to Continue");
				wait = keyboard.nextLine();

				// Test Employees
				Employee emp = new Employee(900, "TestFirst", "TestLast", "Email", "Phone", "2018-01-11", "IT_PROG",
						12.34, 0.00, 205, 270);
				Employee empupdate = new Employee(900, "FirstTest", "LastTest", "EmailTest", "PhoneTest", "2018-02-22",
						"IT_PROG", 43.21, 0.00, 205, 270);

				// Add Employee
				System.out.println("*************Add Employee Info*************");
				System.out.println("adding employee with id 900");
				DAManager.addEmployee(emp);
				System.out.println("Press Enter to Continue");
				wait = keyboard.nextLine();

				// Get Employee Info
				System.out.println("*************Get Employee Info*************");
				System.out.println("Employees with ID 900");
				DAManager.getEmployeeByID(900).display();
				System.out.println("Press Enter to Continue");
				wait = keyboard.nextLine();

				// Get Employees in Department
				System.out.println("Employees in Department 20");
				ArrayList<Employee> empListDep = DAManager.getEmployeesByDepartmentID(20);
				for (Employee e : empListDep) {
					e.display();
				}
				System.out.println("Press Enter to Continue");
				wait = keyboard.nextLine();

				// Update Employee
				System.out.println("*************Update Employee Info*************");
				DAManager.updateEmployee(empupdate);
				System.out.println("Press Enter to Continue");
				wait = keyboard.nextLine();

				// Get All Employee Info
				System.out.println("*************All Employee Info*************");
				ArrayList<Employee> empList = DAManager.getAllEmployees();
				for (Employee e : empList) {
					e.display();
				}
				System.out.println("Press Enter to Continue");
				wait = keyboard.nextLine();

				// Delete Employee
				System.out.println("*************Delete Employee Info*************");
				DAManager.deleteEmployeeByID(900);
				System.out.println("Press Enter to Continue");
				wait = keyboard.nextLine();

				// Batch Update
				System.out.println("*************Batch Update Employee Info*************");
				// Error scenario
				String[] SQLs = new String[6];
				SQLs[0] = "UPDATE Employees SET first_name='hello' where employee_id=108";
				SQLs[1] = "UPDATE Employees SET first_name='how' where employee_id=109";
				SQLs[2] = "UPDATE Employees SET first_name='are' where employee_id=110";
				SQLs[3] = "UPDATE Employees SET first_name='yoyu' where employee_id=111";
				SQLs[4] = "UPDATE Employees SET first_name='dfsf' employee_id=901";
				SQLs[5] = "UPDATE Employees SET first_name='dsfdf' wre employee_id=902";

				// Success scenario
				String[] SQL = new String[3];
				SQL[0] = "UPDATE Employees SET first_name='new7' WHERE employee_id=105";
				SQL[1] = "UPDATE Employees SET first_name='new8' WHERE employee_id=106";
				SQL[2] = "UPDATE Employees SET first_name='new9' WHERE employee_id=107";

				System.out.println("*************Batch Update Success Scenario*************");
				boolean status = DAManager.batchUpdate(SQL);
				if (status) {
					System.out.println("Successfully updated all the queries!");
				} else {
					System.out.println("Batch Update failed!");
				}

				System.out.println("*************Batch Update Error Scenario*************");
				boolean status1 = DAManager.batchUpdate(SQLs);
				if (status1) {
					System.out.println("Successfully updated all the queries!");
				} else {
					System.out.println("Batch Update failed!");
				}

				// Get All Employee Info
				System.out.println("*************All Employee Info*************");
				ArrayList<Employee> empList1 = DAManager.getAllEmployees();
				for (Employee e : empList1) {
					e.display();
				}
				System.out.println("Press Enter to Continue");
				wait = keyboard.nextLine();
			}
			System.out.println("*************Thank you!!*************");

			// Closing all the necessary resources
			DAManager.closeResources();
		}
	} // main

	/*
	 * Reads the username from the User
	 * 
	 * @return the username inputed from the User
	 */
	private static String readUsername() {

		System.out.println("Please Enter Username:");
		String username = keyboard.nextLine();
		return username;
	}

	/*
	 * Reads the password from the User
	 * 
	 * @return the password inputed from the User
	 */
	private static String readPassword() {

		System.out.println("Please Enter Password:");
		String password = keyboard.nextLine();
		return password;
	}

	/*
	 * Checks if the user is authorized
	 * 
	 * @param employeeId the Employee ID to check
	 * 
	 * @return true or false depending if authorized
	 */
	public static boolean validation(int employeeId) {
		boolean isUserValid = false;
		if (employeeId == 0) {
			System.out.println("Unauthorized User");
			System.out.println("*************Good Bye!*************");
		} else {
			isUserValid = true;
			System.out.println("Valid User - Employee ID is : " + employeeId);
		}
		return isUserValid;
	}

}
