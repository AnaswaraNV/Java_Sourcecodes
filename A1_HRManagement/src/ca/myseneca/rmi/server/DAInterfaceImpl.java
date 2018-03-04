package ca.myseneca.rmi.server;

import ca.myseneca.model.DAManager;
import ca.myseneca.model.Employee;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.ArrayList;

/*
 * @author : Jonathan Chik
 * 			 Anaswara Naderi Vadakkeperatta
 * 			
 * 			 This is a class that implements the interface which 
 * 			 computes the required methods.
 */

public class DAInterfaceImpl extends UnicastRemoteObject implements DAInterface {

	// To suppress warning
	private static final long serialVersionUID = 1L;

	/*
	 * Constructor for DAInterfaceImpl
	 */
	public DAInterfaceImpl() throws RemoteException {
		// super() calls the parent constructor with no arguments.
		super();
	}

	/*
	 * {@inheritDoc}
	 * 
	 * Calls the getEmployeeID method from DAManager
	 */
	@Override
	public int getEmployeeID(String user, String password) {
		return DAManager.getEmployeeID(user, password);
	}

	/*
	 * {@inheritDoc}
	 * 
	 * Calls the addEmployee method from DAManager
	 */
	@Override
	public void addEmployee(Employee emp) {
		DAManager.addEmployee(emp);
	}

	/*
	 * {@inheritDoc}
	 * 
	 * Calls the getEmployeeByID method from DAManager
	 */
	@Override
	public Employee getEmployeeByID(int empid) {
		return DAManager.getEmployeeByID(empid);
	}

	/*
	 * {@inheritDoc}
	 * 
	 * Calls the getEmployeesByDepartmentID method from DAManager
	 */
	@Override
	public ArrayList<Employee> getEmployeesByDepartmentID(int depid) {
		return DAManager.getEmployeesByDepartmentID(depid);
	}

	/*
	 * {@inheritDoc}
	 * 
	 * Calls the getAllEmployees method from DAManager
	 */
	@Override
	public ArrayList<Employee> getAllEmployees() {
		return DAManager.getAllEmployees();
	}

	/*
	 * {@inheritDoc}
	 * 
	 * Calls the updateEmployee method from DAManager
	 */
	@Override
	public int updateEmployee(Employee emp) {
		return DAManager.updateEmployee(emp);
	}

	/*
	 * {@inheritDoc}
	 * 
	 * Calls the deleteEmployeeByID method from DAManager
	 */
	@Override
	public int deleteEmployeeByID(int empid) {
		return DAManager.deleteEmployeeByID(empid);
	}

	/*
	 * {@inheritDoc}
	 * 
	 * Calls the batchUpdate method from DAManager
	 */
	@Override
	public boolean batchUpdate(String[] SQLs) {
		boolean status = true;
		try {
			status = DAManager.batchUpdate(SQLs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}
}
