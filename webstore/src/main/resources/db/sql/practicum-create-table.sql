DROP TABLE students IF EXISTS;
DROP TABLE supervisors IF EXISTS;
DROP TABLE notices IF EXISTS;
DROP TABLE notice_receiver IF EXISTS;

CREATE TABLE students (
  student_id INTEGER,
  user_name VARCHAR(30),
  student_email VARCHAR(30),
  student_department VARCHAR(30),
  supervisor_id INTEGER,
  cell_phone_number VARCHAR(30),
  password VARCHAR(20)
);

CREATE TABLE supervisors (
  supervisor_id INTEGER ,
  user_name VARCHAR(30),
  email VARCHAR(30),
  department VARCHAR(30)
);

CREATE TABLE notices (
  notice_id INTEGER ,
  publisher_id INTEGER,
  receiver_string VARCHAR(30),
  publish_time BIGINT,
  subject  VARCHAR(200),
  description VARCHAR(530)
);

CREATE TABLE notice_receiver(
  notice_id INTEGER ,
  receiver_id INTEGER
);