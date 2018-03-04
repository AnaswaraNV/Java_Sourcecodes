CREATE TABLE SECURITY (
         EMPLOYEE_ID  NUMBER(6,0) NOT NULL
                     CONSTRAINT SECURITY_EMPID_FK
                     REFERENCES cjv805_181a09.EMPLOYEES
                     (EMPLOYEE_ID),
         sec_id VARCHAR2(20),
         sec_password VARCHAR2(10),
         sec_status CHAR(1),
         CONSTRAINT security_pk PRIMARY KEY(EMPLOYEE_ID));
         
ALTER TABLE SECURITY
ADD CONSTRAINT check_sec_status CHECK (SEC_STATUS IN ('I', 'A'));