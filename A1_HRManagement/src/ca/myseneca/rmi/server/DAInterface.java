
package ca.myseneca.rmi.server;

import ca.myseneca.model.Employee;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/*
 * @author : Jonathan Chik
 * 			 Anaswara Naderi Vadakkeperatta
 * 			
 * 			 This is an interface to implement the RMI client-server application
 * 			 that contains all the method declarations .
 */

public interface DAInterface extends Remote {
	/*
	 * Checks if the provided User and Password are valid
	 * 
	 * @param user the username of an Employee
	 * 
	 * @param password the Password of an Employee
	 * 
	 * @return the Employee ID of a valid user
	 */
	public int getEmployeeID(String user, String password) throws RemoteException;

	/*
	 * Adds the Employee to the Database
	 * 
	 * @param the Employee to be added
	 */
	public void addEmployee(Employee emp) throws RemoteException;

	/*
	 * Get the Employee from the Database
	 * 
	 * @param empid the Employee ID to be searched
	 * 
	 * @return the Employee corresponding to the ID
	 */
	public Employee getEmployeeByID(int empid) throws RemoteException;

	/*
	 * Gets the Employees that are in a specific Department in the Database
	 * 
	 * @param depid the Department ID to be searched
	 * 
	 * @return an ArrayList of Employees in the corresponding Department
	 */
	public ArrayList<Employee> getEmployeesByDepartmentID(int depid) throws RemoteException;

	/*
	 * Gets all Employees in the Database
	 * 
	 * @return an ArrayList of Employees in the Database
	 */
	public ArrayList<Employee> getAllEmployees() throws RemoteException;

	/*
	 * Updates an Employee in the Database
	 * 
	 * @param emp the Employee to Update
	 * 
	 * @return the Employee ID of the updated Employee
	 */
	public int updateEmployee(Employee emp) throws RemoteException;

	/*
	 * Deletes an Employee from the Database
	 * 
	 * @param empid the Employee ID to delete
	 * 
	 * @return the Employee ID of the deleted Employee
	 */
	public int deleteEmployeeByID(int empid) throws RemoteException;

	/*
	 * Checks if the all SQL Statements execute
	 * 
	 * @param SQLs an array of SQL Statements
	 * 
	 * @return true or false depending if successful or not
	 */
	public boolean batchUpdate(String[] SQLs) throws RemoteException;
}
