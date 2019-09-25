-- If database already exists then remove it
DROP DATABASE IF EXISTS EMPLOYEES;

-- create database
CREATE DATABASE EMPLOYEES;

USE EMPLOYEES;

-- create tables
CREATE TABLE REGISTRATION 
	(id INTEGER not NULL, 
	 first VARCHAR(255),
	 last VARCHAR(255),
	 age INTEGER,
	 PRIMARY KEY ( id ));
	 
-- fill tables
INSERT INTO REGISTRATION VALUES (100, 'Zara', 'Ali', 18);
INSERT INTO REGISTRATION VALUES (101, 'Mahnaz', 'Fatma', 25);
INSERT INTO REGISTRATION VALUES (102, 'Zaid', 'Khan', 30);
INSERT INTO REGISTRATION VALUES(103, 'Sumit', 'Mittal', 28);

select * from REGISTRATION;
