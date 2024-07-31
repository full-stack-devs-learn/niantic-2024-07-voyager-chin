DROP DATABASE IF EXISTS school;

CREATE DATABASE school;

USE school;

CREATE TABLE students
(
	id CHAR(36) NOT NULL,
    student_name VARCHAR(200) NOT NULL,
    PRIMARY KEY (id)
);

-- add students 
INSERT INTO students(id, student_name)
VALUES (UUID(), 'John Anderson')
	, (UUID(), 'Emily Turner')
	, (UUID(), 'Michael Harris')
	, (UUID(), 'Sarah Bennett')
	, (UUID(), 'David Walker');

