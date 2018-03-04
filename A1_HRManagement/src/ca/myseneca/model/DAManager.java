package ca.myseneca.model;

import java.io.IOException;
import java.sql.BatchUpdateException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;

import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleResultSet;
import oracle.jdbc.OracleTypes;

/*
 * @author: Jonathan Chik 
 * 			Anaswara Naderi Vadakkeperatta
 * 
 *          This class manages the methods that are used to connect to the database,
 *          check for authorization, and manage Employees in the Database.
 */

public class DAManager {

	private static Connection connection = null;
	private static Statement statement = null;
	private static PreparedStatement pstatement = null;
	private static CallableStatement cstatement = null;
	private static OracleCallableStatement ocstatement = null;
	private static DBUtil DBUtilObj = null;

	private static ArrayList<Employee> employeeList = new ArrayList<Employee>();

	/*
	 * Default Constructor of DAManager
	 */
	public DAManager() {

	}

	/*
	 * Creates a Database Utility Object to connect to the Database
	 */
	public static void setConnection() {
		try {
			DBUtilObj = new DBUtil("database.properties");
			connection = DBUtilObj.getConnection();
		} catch (ClassNotFoundException | SQLException | IOException e) {
			e.printStackTrace();
		}
	}

	/*
	 * Checks if the provided User and Password are valid
	 * 
	 * @param user the username of an Employee
	 * 
	 * @param password the Password of an Employee
	 * 
	 * @return the Employee ID of a valid user
	 */
	public static int getEmployeeID(String user, String password) {
		// Get connection
		setConnection();

		int empID = 0;

		if (connection != null) {
			// call procedure with prepareCall
			try {
				cstatement = connection.prepareCall("{? = call P_SECURITY.F_SECURITY(?, ?)}");

				// setting the in values
				cstatement.setString(2, user);
				cstatement.setString(3, password);
				// out parameter
				cstatement.registerOutParameter(1, Types.INTEGER);
				cstatement.execute();
				empID = cstatement.getInt(1);

			} catch (SQLException e) {
				System.out.println("SQL Exception");
				e.printStackTrace();
			}
		}
		return empID;
	}

	// Add Employee - PreparedStatement
	/*
	 * Adds the Employee to the Database
	 * 
	 * @param the Employee to be added
	 */
	public static void addEmployee(Employee emp) {
		// Get connection
		setConnection();

		if (connection != null) {
			try {
				String query = "INSERT INTO EMPLOYEES VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

				//prepare the statement and set all the values
				pstatement = connection.prepareStatement(query);
				pstatement.setInt(1, emp.getEmployeeId());
				pstatement.setString(2, emp.getFirstName());
				pstatement.setString(3, emp.getLastName());
				pstatement.setString(4, emp.getEmail());
				pstatement.setString(5, emp.getPhoneNumber());
				pstatement.setString(6, emp.getHireDate());
				pstatement.setString(7, emp.getJobId());
				pstatement.setDouble(8, emp.getSalary());
				pstatement.setDouble(9, emp.getCommissionPct());
				pstatement.setInt(10, emp.getManagerId());
				pstatement.setInt(11, emp.getDepartmentId());
				pstatement.executeUpdate();

				System.out.println("Employee Added");
			} catch (SQLException e) {
				System.out.println("SQL Exception");
				e.printStackTrace();
			}
		}
	}

	// Get Employee - OracleCallableStatement
	/*
	 * Get the Employee from the Database
	 * 
	 * @param empid the Employee ID to be searched
	 * 
	 * @return the Employee corresponding to the ID
	 */
	public static Employee getEmployeeByID(int empid) {
		// Get connection
		setConnection();

		Employee emp = null;

		if (connection != null) {
			try {
				//call the procedure in the package
				ocstatement = (OracleCallableStatement) connection.prepareCall("{call P_SECURITY.P_EMP_INFO(?, ?)}");

				//set the values and register the output value
				ocstatement.setInt(1, empid);
				ocstatement.registerOutParameter(2, OracleTypes.CURSOR);
				ocstatement.execute();

				//get the cursor containing the result
				OracleResultSet oresultSet = (OracleResultSet) ocstatement.getCursor(2);

				while (oresultSet.next()) {
					emp = new Employee(oresultSet.getInt("EMPLOYEE_ID"), oresultSet.getString("FIRST_NAME"),
							oresultSet.getString("LAST_NAME"), oresultSet.getString("EMAIL"),
							oresultSet.getString("PHONE_NUMBER"), oresultSet.getString("HIRE_DATE"),
							oresultSet.getString("JOB_ID"), oresultSet.getDouble("SALARY"),
							oresultSet.getDouble("COMMISSION_PCT"), oresultSet.getInt("MANAGER_ID"),
							oresultSet.getInt("DEPARTMENT_ID"));
				}
			} catch (SQLException e) {
				System.out.println("SQL Exception");
				e.printStackTrace();
			}
		}

		return emp;
	}

	// Get Employees by Department - PreparedStatement
	/*
	 * Gets the Employees that are in a specific Department in the Database
	 * 
	 * @param depid the Department ID to be searched
	 * 
	 * @return an ArrayList of Employees in the corresponding Department
	 */
	public static ArrayList<Employee> getEmployeesByDepartmentID(int depid) {
		// Get connection
		setConnection();

		employeeList.clear();
		if (connection != null) {
			try {
				ResultSet resultSet = null;

				String query = "SELECT * FROM EMPLOYEES WHERE DEPARTMENT_ID = ? ORDER BY EMPLOYEE_ID";

				//prepare the statement and set all the values
				pstatement = connection.prepareStatement(query);
				pstatement.setInt(1, depid);

				resultSet = pstatement.executeQuery();

				while (resultSet.next()) {
					Employee e = new Employee(resultSet.getInt("EMPLOYEE_ID"), resultSet.getString("FIRST_NAME"),
							resultSet.getString("LAST_NAME"), resultSet.getString("EMAIL"),
							resultSet.getString("PHONE_NUMBER"), resultSet.getString("HIRE_DATE"),
							resultSet.getString("JOB_ID"), resultSet.getDouble("SALARY"),
							resultSet.getDouble("COMMISSION_PCT"), resultSet.getInt("MANAGER_ID"),
							resultSet.getInt("DEPARTMENT_ID"));
					employeeList.add(e);
				}
			} catch (SQLException e) {
				System.out.println("SQL Exception");
				e.printStackTrace();
			}
		}

		return employeeList;
	}

	// Get All Employees - Statement
	/*
	 * Gets all Employees in the Database
	 * 
	 * @return an ArrayList of Employees in the Database
	 */
	public static ArrayList<Employee> getAllEmployees() {
		// Get connection
		setConnection();

		employeeList.clear();
		if (connection != null) {
			try {
				ResultSet resultSet = null;

				String query = "SELECT * FROM EMPLOYEES ORDER BY EMPLOYEE_ID";

				statement = connection.createStatement();
				resultSet = statement.executeQuery(query);

				while (resultSet.next()) {
					Employee e = new Employee(resultSet.getInt("EMPLOYEE_ID"), resultSet.getString("FIRST_NAME"),
							resultSet.getString("LAST_NAME"), resultSet.getString("EMAIL"),
							resultSet.getString("PHONE_NUMBER"), resultSet.getString("HIRE_DATE"),
							resultSet.getString("JOB_ID"), resultSet.getDouble("SALARY"),
							resultSet.getDouble("COMMISSION_PCT"), resultSet.getInt("MANAGER_ID"),
							resultSet.getInt("DEPARTMENT_ID"));
					employeeList.add(e);
				}
			} catch (SQLException e) {
				System.out.println("SQL Exception");
				e.printStackTrace();
			}
		}

		return employeeList;
	}

	// Update Employee - UpdatableResultSet
	/*
	 * Updates an Employee in the Database
	 * 
	 * @param emp the Employee to Update
	 * 
	 * @return the Employee ID of the updated Employee
	 */
	public static int updateEmployee(Employee emp) {
		// Get connection
		setConnection();

		if (connection != null) {
			try {
				ResultSet resultSet = null;

				String query = "SELECT EMPLOYEES.* FROM EMPLOYEES";

				//create an updatable resultset
				statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
				resultSet = statement.executeQuery(query);

				while (resultSet.next()) {
					if (resultSet.getInt("EMPLOYEE_ID") == emp.getEmployeeId()) {
						resultSet.updateString("FIRST_NAME", emp.getFirstName());
						resultSet.updateString("LAST_NAME", emp.getLastName());
						resultSet.updateString("EMAIL", emp.getEmail());
						resultSet.updateString("PHONE_NUMBER", emp.getPhoneNumber());
						resultSet.updateString("HIRE_DATE", emp.getHireDate());
						resultSet.updateString("JOB_ID", emp.getJobId());
						resultSet.updateDouble("SALARY", emp.getSalary());
						resultSet.updateDouble("COMMISSION_PCT", emp.getCommissionPct());
						resultSet.updateInt("MANAGER_ID", emp.getManagerId());
						resultSet.updateInt("DEPARTMENT_ID", emp.getDepartmentId());
						resultSet.updateRow();
					}
				}

				System.out.println("Employee Updated");
			} catch (SQLException e) {
				System.out.println("SQL Exception");
				e.printStackTrace();
			}
		}

		return emp.getEmployeeId();
	}

	// Delete Employee - PreparedStatement
	/*
	 * Deletes an Employee from the Database
	 * 
	 * @param empid the Employee ID to delete
	 * 
	 * @return the Employee ID of the deleted Employee
	 */
	public static int deleteEmployeeByID(int empid) {
		// Get connection
		setConnection();

		if (connection != null) {
			try {
				String query = "DELETE FROM EMPLOYEES WHERE EMPLOYEE_ID = ?";

				//prepare the statement and set all the values
				pstatement = connection.prepareStatement(query);
				pstatement.setInt(1, empid);
				pstatement.executeUpdate();

				System.out.println("Employee Deleted");
			} catch (SQLException e) {
				System.out.println("SQL Exception");
				e.printStackTrace();
			}
		}

		return empid;
	}

	/*
	 * Checks if the all SQL Statements execute
	 * 
	 * @param SQLs an array of SQL Statements
	 * 
	 * @return true or false depending if successful or not
	 */
	public static boolean batchUpdate(String[] SQLs) throws SQLException {
		boolean status = true;
		// set connection
		setConnection();

		try {
			connection.setAutoCommit(false);
			statement = connection.createStatement();

			for (int i = 0; i < SQLs.length - 1; i++) {
				statement.addBatch(SQLs[i]);
			}

			statement.executeBatch();
			// committing the updates if all the batch is executed
			connection.commit();

		} catch (BatchUpdateException be) {
			try {

				// if any updates failed , connection is rolled back
				status = false;
				connection.rollback();
				DBUtil.printBatchUpdateException(be);
			} catch (SQLException e1) {
				status = false;
				DBUtil.printSQLException(e1);
			}
		} catch (SQLException e) {
			// handle SQL exception
			status = false;
			connection.rollback();
			DBUtil.printSQLException(e);
		}

		return status;
	}

	/*
	 * Closes all the resources used in the program
	 */
	public static void closeResources() {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				DBUtil.printSQLException(e);
			}
		}
	}
}
