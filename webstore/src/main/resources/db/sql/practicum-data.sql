INSERT INTO students VALUES 
	(15103199, 'Md. Touhidul Islam','15103199@iubat.edu','CSE',9990101,'',''),
	(15103198, 'Kamrul Hasan','15103198@iubat.edu','CSE',9990101,'',''),
	(15103191, 'Salman Khan','15103191@iubat.edu','CSE',9990102,'',''),
	(15103192, 'Vin Diesel','15103192@iubat.edu','CSE',9990103,'',''),
	(15103193, 'Shahid Afridi','15103193@iubat.edu','CSE',9990104,'',''),
	(15103194, 'Mahadi hasan','15103194@iubat.edu','CSE',9990104,'','');

INSERT INTO supervisors VALUES 
	(9990101, 'safwana haque','9990101@@iubat.edu','CSE'),
	(9990102, 'Arifa tur rahman','9990102@iubat.edu','CSE'),
	(9990103, 'Krishna Das','9990103@iubat.edu','CSE'),
	(9990104, 'Shaheen Alam','9990104@iubat.edu','CSE'),
	(9990105, 'homayon kabir','9990105@iubat.edu','CSE');

INSERT INTO notices VALUES (102,1510,'All',1349333576093,'Meeting with Co Supervisor','All students need to meet supervisor within October 10'),
(103,1510,'All',1549333576093,'Meeting for VC','All students need to seat for viva with VC');

INSERT INTO project_proposals(tbl_id,student_id,supervisor_id, is_confirmed,first_sent_time,
last_sent_time,revisions, supervisor_comment, project_title,project_for,project_doing_at, 
objective,technological_stacks,modules,actors,functional_requirements)VALUES
(DEFAULT,15103199,9990101,0,1549333576093,1549333576093,1,'Supervisor Comment','Practicum Management System',
'IUBAT','Square Dots','To perform practicum activity through software','java,spring',
'module','actors','functional_requirements');
