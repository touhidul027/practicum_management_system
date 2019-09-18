package com.packt.webstore.domain.repository;

import java.util.List;

import com.packt.webstore.domain.Student;
import com.packt.webstore.domain.Supervisor;

public interface StudentRepository {
	public Student getStudent(int id);
	public List<Student> getStudents();
	public abstract Supervisor getStudentSupervisor(int studentId);
}
