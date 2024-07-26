CREATE DATABASE VLSDB;

USE VLSDB;

CREATE TABLE Login(loginID VARCHAR(50) PRIMARY KEY, password VARCHAR(50) NOT NULL);

CREATE TABLE Course(courseID INT AUTO_INCREMENT PRIMARY KEY, courseName VARCHAR(50) NOT NULL,
                    authorName VARCHAR(50) NOT NULL, duration INT NOT NULL,
                    availability BOOLEAN NOT NULL);

INSERT INTO Login(loginId, password) VALUES('varshi', 'varshi123');


SELECT * FROM Login;

INSERT INTO Course(courseName, authorName, duration, availability) VALUES('Python', 'Varshitha', 20, TRUE),('Java', 'Likhitha', 30, TRUE);

SELECT * FROM Course;

DROP Table Course;