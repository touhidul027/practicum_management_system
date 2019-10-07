package com.packt.webstore.domain.repository;

import java.util.List;

import com.packt.webstore.domain.Student;
import com.packt.webstore.domain.Supervisor;

public interface StudentRepository {
	public Student getStudent(int id);
	public List<Student> getStudents();
	public abstract Supervisor getStudentSupervisor(long studentId);
	public boolean registerStudent(int studentId, String studentName, String studentEmail, String department);
	public Student getStudentByEmail(String userEmail);
	public boolean updateStudent(int studentId, String cellPhone, String password);
}
