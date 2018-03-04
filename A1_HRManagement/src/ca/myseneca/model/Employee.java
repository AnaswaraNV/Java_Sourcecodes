package ca.myseneca.model;

import java.io.Serializable;

/*
 * @author: Jonathan Chik 
 * 			Anaswara Naderi Vadakkeperatta
 * 
 *          This class creates a Serializable Employee class that has the 
 *          same attributes stored in the Database. 
 *          It contains a default constructor, the setters, and the getters.
 */

public class Employee implements Serializable {

	// To remove warning
	private static final long serialVersionUID = 1L;

	private int employee_id;
	private String first_name;
	private String last_name;
	private String email;
	private String phone_number;
	private String hire_date;
	private String job_id;
	private double salary;
	private double commission_pct;
	private int manager_id;
	private int department_id;

	/*
	 * Default Constructor for Employee
	 */
	public Employee() {

	}

	/*
	 * 11 Argument Constructor for Employee
	 * 
	 * @param employee_id the ID of the Employee
	 * 
	 * @param first_name the First Name of the Employee
	 * 
	 * @param last_name the Last Name of the Employee
	 * 
	 * @param email the Email of the Employee
	 * 
	 * @param phone_number the Phone Number of the Employee
	 * 
	 * @param hire_date the Hire Date of the Employee
	 * 
	 * @param job_id the Job ID of the Employee
	 * 
	 * @param salary the Salary of the Employee
	 * 
	 * @param commission_pct the Commission PCT of the Employee
	 * 
	 * @param manager_id the Manager ID of the Employee
	 * 
	 * @param department_id the Department ID of the Employee
	 */
	public Employee(int employee_id, String first_name, String last_name, String email, String phone_number,
			String hire_date, String job_id, double salary, double commission_pct, int manager_id, int department_id) {
		this.employee_id = employee_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.phone_number = phone_number;
		this.hire_date = hire_date;
		this.job_id = job_id;
		this.salary = salary;
		this.commission_pct = commission_pct;
		this.manager_id = manager_id;
		this.department_id = department_id;
	}

	// Setters
	/*
	 * Sets the Employee ID to a new ID
	 * 
	 * @param employee_id the new Employee ID to be set to
	 */
	public void setEmployeeId(int employee_id) {
		this.employee_id = employee_id;
	}

	/*
	 * Sets the First Name to a new First Name
	 * 
	 * @param first_name the new Employee ID to be set to
	 */
	public void setFirstName(String first_name) {
		this.first_name = first_name;
	}

	/*
	 * Sets the Last Name to a new Last Name
	 * 
	 * @param last_name the new Last Name to be set to
	 */
	public void setLast_Name(String last_name) {
		this.last_name = last_name;
	}

	/*
	 * Sets the Email to a new Email
	 * 
	 * @param email the new Email to be set to
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/*
	 * Sets the Phone Number to a new Phone Number
	 * 
	 * @param phone_number the new Phone Number to be set to
	 */
	public void setPhoneNumber(String phone_number) {
		this.phone_number = phone_number;
	}

	/*
	 * Sets the Hire Date to a new Date
	 * 
	 * @param hire_date the new Hire Date to be set to
	 */
	public void setHireDate(String hire_date) {
		this.hire_date = hire_date;
	}

	/*
	 * Sets the Job ID to a new ID
	 * 
	 * @param job_id the new Job ID to be set to
	 */
	public void setJobId(String job_id) {
		this.job_id = job_id;
	}

	/*
	 * Sets the Salary to a new Salary
	 * 
	 * @param salary the new Salary to be set to
	 */
	public void setSalary(double salary) {
		this.salary = salary;
	}

	/*
	 * Sets the Commission PCT to a new PCT
	 * 
	 * @param commission_pct the new Commission PCT to be set to
	 */
	public void setCommissionPct(double commission_pct) {
		this.commission_pct = commission_pct;
	}

	/*
	 * Sets the Manager ID to a new ID
	 * 
	 * @param manager_id the new Manager ID to be set to
	 */
	public void setManagerId(int manager_id) {
		this.manager_id = manager_id;
	}

	/*
	 * Sets the Department ID to a new ID
	 * 
	 * @param department_id the new Department ID to be set to
	 */
	public void setDepartmentId(int department_id) {
		this.department_id = department_id;
	}

	// Getters
	/*
	 * Gets the Employee ID of the Employee
	 * 
	 * @return the Employee ID of the Employee
	 */
	public int getEmployeeId() {
		return this.employee_id;
	}

	/*
	 * Gets the First Name of the Employee
	 * 
	 * @return the First Name of the Employee
	 */
	public String getFirstName() {
		return this.first_name;
	}

	/*
	 * Gets the Last Name of the Employee
	 * 
	 * @return the Last Name of the Employee
	 */
	public String getLastName() {
		return this.last_name;
	}

	/*
	 * Gets the Email of the Employee
	 * 
	 * @return the Email of the Employee 
	 */
	public String getEmail() {
		return this.email;
	}

	/*
	 * Gets the Phone Number of the Employee
	 * 
	 * @return the Phone Number of the Employee
	 */
	public String getPhoneNumber() {
		return this.phone_number;
	}

	/*
	 * Gets the Hire Date of the Employee
	 * 
	 * @return the Hire Date of the Employee
	 */
	public String getHireDate() {
		return this.hire_date;
	}

	/*
	 * Gets the Job ID of the Employee
	 * 
	 * @return the Job ID of the Employee
	 */
	public String getJobId() {
		return this.job_id;
	}

	/*
	 * Gets the Salary of the Employee
	 * 
	 * @return the Salary of the Employee
	 */
	public double getSalary() {
		return this.salary;
	}

	/*
	 * Gets the Commission PCT of the Employee
	 * 
	 * @return the Commission PCT of the Employee
	 */
	public double getCommissionPct() {
		return this.commission_pct;
	}

	/*
	 * Gets the Manager ID of the Employee
	 * 
	 * @return the Manager ID of the Employee
	 */
	public int getManagerId() {
		return this.manager_id;
	}

	/*
	 * Gets the Department ID of the Employee
	 * 
	 * @return the Department ID of the Employee
	 */
	public int getDepartmentId() {
		return this.department_id;
	}

	/*
	 * Displays all the Information of an Employee
	 */
	public void display() {
		System.out.println("EMPLOYEE_ID: " + employee_id + ", FIRST_NAME: " + first_name + ", LAST_NAME: " + last_name
				+ ", EMAIL: " + email + ", PHONE_NUMBER: " + phone_number + ", HIRE_DATE: " + hire_date + ", JOB_ID: "
				+ job_id + ", SALARY: " + salary + ", COMMISSION_PCT: " + commission_pct + ", MANAGER_ID: " + manager_id
				+ ", DEPARTMENT_ID: " + department_id);
	}
}
