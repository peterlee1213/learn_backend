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


-- one way one to one example tables setup start -----------------------------------------
DROP TABLE IF EXISTS `tb_account`;
CREATE TABLE `tb_account`(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255),
    password VARCHAR(255)
);

DROP TABLE IF EXISTS `tb_customer`;
CREATE TABLE `tb_customer`(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    cust_address VARCHAR(255),
    cust_name VARCHAR(255),
    account_id BIGINT,
    FOREIGN KEY (account_id) REFERENCES `tb_account` (id) ON DELETE CASCADE
);
INSERT INTO `tb_account`(username,password) values
("zhangsan","123"),
("lisi","123"),
("wangwu","123"),
("zhaoliu","123");

INSERT INTO `tb_customer` (cust_address,cust_name,account_id) values
("beijing","zhangsan_net_name",1),
("shanghai","lisi_net_name",2),
("guangzhou","wangwu_net_name",3),
("shenzhen","zhaoliu_net_name",4);

-- -- one to one example tables setup end--------------------------------


--  one to many example tables setup start -----------------------------------------
DROP TABLE IF EXISTS `tb_student_class`;
CREATE TABLE `tb_student_class`(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255)
);

DROP TABLE IF EXISTS `tb_student`;
CREATE TABLE `tb_student`(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    student_class_id BIGINT,
    FOREIGN KEY (student_class_id) REFERENCES tb_student_class(id)
);

INSERT INTO tb_student_class(name) values
("class one"),
("class two");

INSERT INTO tb_student(name, student_class_id) values
("zhangsan",1),
("lisi",2),
("wangwu",1),
("zhaoliu",2);

--  one to many example tables setup end -----------------------------------------

--  many to one example tables setup start -----------------------------------------

DROP TABLE IF EXISTS `tb_company`;
CREATE TABLE tb_company(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    com_name VARCHAR(255)
);

DROP TABLE IF EXISTS `tb_employee`;
CREATE TABLE tb_employee(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    emp_name VARCHAR(255),
    company_id BIGINT,
    FOREIGN KEY (company_id) REFERENCES tb_company(id)
);

INSERT INTO tb_company (com_name) values
("huawei"),
("samsung");

INSERT INTO tb_employee (emp_name, company_id) values
("zhangsan",1),
("lisi",2),
("wangwu",1),
("zhaoliu",2);

--  many to one example tables setup end -----------------------------------------

--  many to many example tables setup start -----------------------------------------

-- one user has multiple roles, one role can be assigned to multiple users
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user`(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
); 

DROP TABLE IF EXISTS `tb_role`;
CREATE TABLE `tb_role`(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

DROP TABLE IF EXISTS `tb_user_role`;
CREATE TABLE `tb_user_role`(
    user_id BIGINT NOT NULL,
    role_id BIGINT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES tb_user(id),
    FOREIGN KEY (role_id) REFERENCES tb_role(id),
    PRIMARY KEY(user_id,role_id)

);

INSERT INTO `tb_user`(name) values
("zhangsan"),
("lisi"),
("wangwu"),
("zhaoliu");

INSERT INTO `tb_role`(name) values
("manager"),
("worker");

INSERT INTO `tb_user_role`(user_id,role_id) VALUES
(1,1),
(2,2),
(3,1),
(4,2);



--  many to many example tables setup end -----------------------------------------