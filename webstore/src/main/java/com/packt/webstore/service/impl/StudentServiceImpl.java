package com.packt.webstore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.packt.webstore.domain.Student;
import com.packt.webstore.domain.Supervisor;
import com.packt.webstore.domain.repository.StudentRepository;
import com.packt.webstore.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;

	@Override
	public Student getStudentById(int id) {
		return studentRepository.getStudent(id);
	}

	@Override
	public List<Student> getStudents() {
		return studentRepository.getStudents();
	}

	@Override
	public Supervisor getStudentSupervisor(int studentId) {

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

}
