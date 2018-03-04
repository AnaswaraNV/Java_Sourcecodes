--Package body with implemntations are defined here
create or replace PACKAGE BODY P_SECURITY AS
--cursor
TYPE cur_EmpInfo IS REF CURSOR;

	 --Defining function
	 FUNCTION F_SECURITY(
	 P_SECID IN SECURITY.SEC_ID%TYPE,
	 P_SECPASSWORD IN SECURITY.SEC_PASSWORD%TYPE)
	 RETURN NUMBER IS P_EMPID  NUMBER (6,0);
	  BEGIN 
			 SELECT EMPLOYEE_ID INTO P_EMPID
			    FROM SECURITY
			    WHERE SEC_ID = P_SECID AND SEC_PASSWORD = P_SECPASSWORD;
			 RETURN P_EMPID;
	  --if no data found, function return 0 as emp id 
	  EXCEPTION
			WHEN NO_DATA_FOUND THEN
			    P_EMPID := 0;
			    DBMS_OUTPUT.PUT_LINE('Employee doesnt Exist');
			    RETURN P_EMPID;
	END F_SECURITY;
	
	--Procedure definition
	PROCEDURE P_EMP_INFO (
     P_EMPLOYEEID IN EMPLOYEES.EMPLOYEE_ID%TYPE,
     p_info OUT cur_EmpInfo) 
    IS
        cur_Emp cur_EmpInfo;
    BEGIN
    OPEN cur_Emp FOR SELECT EMPLOYEE_ID ,
                            FIRST_NAME ,
                            LAST_NAME ,
                            EMAIL ,
                            PHONE_NUMBER ,
                            HIRE_DATE ,
                            JOB_ID ,
                            SALARY ,
                            COMMISSION_PCT ,
                            MANAGER_ID ,
                            DEPARTMENT_ID  
    FROM EMPLOYEES WHERE EMPLOYEE_ID = P_EMPLOYEEID;
    p_info := cur_Emp;
    END P_EMP_INFO;
    
END P_SECURITY;