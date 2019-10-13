package com.packt.webstore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.packt.webstore.domain.Student;
import com.packt.webstore.domain.Supervisor;
import com.packt.webstore.domain.repository.StudentRepository;
import com.packt.webstore.domain.repository.impl.StudentRepositoryImpl;
import com.packt.webstore.service.StudentService;
import org.apache.log4j.Logger;

@Service
public class StudentServiceImpl implements StudentService {
	private static final Logger logger = Logger.getLogger(StudentServiceImpl.class);

	@Autowired
	private StudentRepository studentRepository;

	@Override
	public Student getStudentById(long id) {
		return studentRepository.getStudent(id);
	}

	@Override
	public List<Student> getStudents() {
		return studentRepository.getStudents();
	}

	@Override
	public Supervisor getStudentSupervisor(long studentId) {

		return studentRepository.getStudentSupervisor(studentId);
	}

	@Override
	public boolean registerStudent(int studentId, String studentName, String studentEmail, String department) {
		// TODO Auto-generated method stub
		return studentRepository.registerStudent(studentId, studentName, studentEmail, department);
	}

	@Override
	public Student getStudentByEmail(String userEmail) {
		return studentRepository.getStudentByEmail(userEmail);
	}

	@Override
	public boolean updateStudent(long studentId, String cellPhone, String password) {
		return studentRepository.updateStudent(studentId, cellPhone, password);
	}

	@Override
	public List<Student> getStudentsOfASupervisor(long supervisorId) {
		List<Student> students = studentRepository.getStudentsOfASupervisor(supervisorId);
		for(Student student:students) {
			logger.info(student.getStudentId() + " " + student.getUserName() );
		}
		return students;
	}

}
