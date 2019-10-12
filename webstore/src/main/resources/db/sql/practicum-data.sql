INSERT INTO students VALUES 
	(15103199, 'Md. Touhidul Islam','15103199@iubat.edu','CSE',9990101,'',''),
	(15103198, 'Kamrul Hasan','15103198@iubat.edu','CSE',9990101,'',''),
	(15103191, 'Salman Khan','15103191@iubat.edu','CSE',9990102,'',''),
	(15103192, 'Vin Diesel','15103192@iubat.edu','CSE',9990103,'',''),
	(15103193, 'Shahid Afridi','15103193@iubat.edu','CSE',9990104,'',''),
	(15103194, 'Mahadi hasan','15103194@iubat.edu','CSE',9990104,'','');

INSERT INTO supervisors VALUES 
	(9990101, 'Mr. Saidur Rahman','9990101@@iubat.edu','01911729378','Senior Lecturer','CSE','International University of Business Agriculture and Technology'),
	(9990102, 'Arifa tur rahman','9990102@iubat.edu','019117293xx','Senior Lecturer','CSE','International University of Business Agriculture and Technology'),
	(9990103, 'Krishna Das','9990103@iubat.edu','019117293yy','Senior Lecturer','CSE','International University of Business Agriculture and Technology'),
	(9990104, 'Shaheen Alam','9990104@iubat.edu','019117293zz','Senior Lecturer','CSE','International University of Business Agriculture and Technology'),
	(9990105, 'homayon kabir','9990105@iubat.edu','019117293dd','Senior Lecturer','CSE','International University of Business Agriculture and Technology');


INSERT INTO notices VALUES (102,1510,'All',1349333576093,'Meeting with Co Supervisor','All students need to meet supervisor within October 10'),
(103,1510,'All',1549333576093,'Meeting for VC','All students need to seat for viva with VC');

INSERT INTO project_proposals(tbl_id,student_id,supervisor_id, is_confirmed,first_sent_time,
last_sent_time,revisions, supervisor_comment, project_title,project_for,project_doing_at, 
objective,technological_stacks,modules,actors,functional_requirements, is_submitted)VALUES
(DEFAULT,15103199,9990101,0,1549333576093,1549333576093,0,'','Practicum Management System',
'IUBAT','Square Dots','Overall , the purpose of designing the Practicum Management System is to ease managing
the practicum semester of IUBAT university.It will help Department administrator,supervisors
including company supervisor,students as well as respective users make their practicum activity
smoother.In later it can be extended to use in other universities too.
','java,spring,hsql,sts ide,JSP,Javascript jquery,Git with Github',
'Manage Authentication,Manage Notice,Evaluating Student Performance,Manage Schedule,Manage Comment,Managing Student activity,Managing Supervisor activity,Managing Adminactivity,Manage Email,Chat,Managing Graph visualization,Manage Student Report,Manage Project Proposal','Department coordinator,Department Administrator,Supervisor,Student','Department Administrator Can add supervisor for practicum purposes,
Department Administrator Can add practicum students to the system,
Department Administrator Can assign student to the supervisor in randomly/manually ways,
Department Administrator Can change student supervisor,
Department Administrator Can put notice for others actor/actors,
Department Administrator Can see the supervisors/students details,
Department Administrator Can see the students overall performance/outcome individually/totally,
Department Administrator Can communicate with others with chat-message,
Department Administrator Can generate schedule for practicum presentation randomly or 
prioritize based,
Department Administrator Can use preference setting for different kinds of 
activity :for example- presentation,
Student Can update profile,
Student Can see supervisor details,
Student Can submit project proposals to supervisor,
Student Can submit log evaluation form,view the status,
Student Can make report by selecting software process model-can update report continuously,
Student Can read notice,
Student Can chat with supervisor and with dept. Administrator,
Student Can see the own performance dynamically,
Supervisor Can update profile,
Supervisor Can see students details,
Supervisor Can accept/deny proposal with comment,
Supervisor Can put feedback on daily activity submitted by student,
Supervisor Can see the students performance graph,
Supervisor Can publish notice for students,
Supervisor Can read notice,
Supervisor Can chat with students admin,
Supervisor Can request special presentation schedule for the students,
Supervisor(Office) can review the students activity log and forward it to University supervisor,
Department coordinator Can see all the students status-put comment on it,
Department coordinator Can publish notice',0);
