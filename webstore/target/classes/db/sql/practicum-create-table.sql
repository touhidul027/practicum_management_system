DROP TABLE students IF EXISTS;
DROP TABLE supervisors IF EXISTS;

CREATE TABLE students (
  id VARCHAR(25) ,
  user_name VARCHAR(30),
  supervisor VARCHAR(30)
);

CREATE TABLE supervisors (
  supervisor_id VARCHAR(25) ,
  user_name VARCHAR(30),
);