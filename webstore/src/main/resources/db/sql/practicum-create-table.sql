DROP TABLE students IF EXISTS;
DROP TABLE supervisors IF EXISTS;

CREATE TABLE students (
  student_id INTEGER,
  user_name VARCHAR(30),
  student_email VARCHAR(30),
  student_department VARCHAR(30),
  supervisor_id INTEGER
);

CREATE TABLE supervisors (
  supervisor_id INTEGER ,
  user_name VARCHAR(30),
  email VARCHAR(30),
  department VARCHAR(30)
);