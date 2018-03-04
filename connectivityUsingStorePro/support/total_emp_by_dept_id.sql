CREATE OR REPLACE PROCEDURE TOTAL_EMP_BY_DEPT_ID
(e_dpt_id IN employees.department_id%TYPE, 
e_emp_count OUT NUMBER) IS 
BEGIN
  SELECT COUNT(*) INTO e_emp_count
  FROM employees 
  WHERE department_id = e_dpt_id;
END TOTAL_EMP_BY_DEPT_ID;