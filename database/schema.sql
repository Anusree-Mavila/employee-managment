CREATE DATABASE employee_db;
USE employee_db;

CREATE TABLE employee (
    emp_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50),
    dob DATE,
    address VARCHAR(100),
    email VARCHAR(50), 
    phone VARCHAR(15),
    designation VARCHAR(30),
    department VARCHAR(30),
    salary DOUBLE,
    qualification VARCHAR(30)
);
