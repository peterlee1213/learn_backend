CREATE DATABASE IF NOT EXISTS learn_jpa;
use learn_jpa;

DROP TABLE IF EXISTS employees;
CREATE TABLE employees (
    emp_no      INT             NOT NULL    AUTO_INCREMENT,  -- UNSIGNED AUTO_INCREMENT??
    birth_date  DATE            NOT NULL,
    first_name  VARCHAR(14)     NOT NULL,
    last_name   VARCHAR(16)     NOT NULL,
    gender      ENUM ('M','F')  NOT NULL,  -- Enumeration of either 'M' or 'F'  
    hire_date   DATE            NOT NULL,
    PRIMARY KEY (emp_no)                   -- Index built automatically on primary-key column
                                           -- INDEX (first_name)
                                           -- INDEX (last_name)
);
INSERT INTO employees
    (birth_date,first_name,last_name,gender,hire_date) 
values
    ("1995-12-25","peter","lee",'M',"2020-12-25"),
    ("1995-11-25","sheldon","cooper",'M',"2019-12-25"),
    ("1995-10-25","amy","feller",'F',"2018-12-25"),
    ("1995-09-25","leonard","hofstadter",'M',"2017-12-25"),
    ("1995-08-22","penny","white",'F',"2016-12-25"),
    ("1995-07-25","howard","wolowitz",'M',"2015-12-25"),
    ("1995-06-25","benerdette","roustinkouski",'M',"2014-12-25"),
    ("1995-05-25","rajash","kootherpolli",'M',"2013-12-25");

DROP TABLE IF EXISTS departments;
CREATE TABLE departments (
    dept_no     INT         NOT NULL    AUTO_INCREMENT,  -- in the form of 'dxxx'
    dept_name   VARCHAR(40)     NOT NULL,
    PRIMARY KEY (dept_no),                 -- Index built automatically
    UNIQUE  KEY (dept_name)                -- Build INDEX on this unique-value column
);
INSERT INTO departments
    (dept_name)
values
    ("hr"),
    ("it"),
    ("sales");

DROP TABLE IF EXISTS dept_emp;
CREATE TABLE dept_emp (
    emp_no      INT         NOT NULL,
    dept_no     INT     NOT NULL,
    KEY         (emp_no),   -- Build INDEX on this non-unique-value column
    KEY         (dept_no),  -- Build INDEX on this non-unique-value column
    FOREIGN KEY (emp_no) REFERENCES employees (emp_no) ON DELETE CASCADE,
           -- Cascade DELETE from parent table 'employee' to this child table
           -- If an emp_no is deleted from parent 'employee', all records
           --  involving this emp_no in this child table are also deleted
           -- ON UPDATE CASCADE??
    FOREIGN KEY (dept_no) REFERENCES departments (dept_no) ON DELETE CASCADE,
           -- ON UPDATE CASCADE??
    PRIMARY KEY (emp_no, dept_no)
           -- Might not be unique?? Need to include from_date
);
INSERT INTO dept_emp
    (emp_no,dept_no)
values
    (1,1),
    (2,2),
    (3,3),
    (4,1),
    (5,2),
    (6,3),
    (7,1),
    (8,2);

DROP TABLE IF EXISTS salaries;
CREATE TABLE salaries (
    emp_no      INT         NOT NULL,
    salary      INT         NOT NULL,
    PRIMARY KEY (emp_no),
    FOREIGN KEY (emp_no) REFERENCES employees (emp_no) on DELETE CASCADE
);
INSERT INTO salaries
    (emp_no, salary)
values
    (1,1000),
    (2,2000),
    (3,3000),
    (4,4000),
    (5,5000),
    (6,6000),
    (7,7000),
    (8,8000);