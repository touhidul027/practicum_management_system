package com.packt.webstore.service;

import java.util.List;

import com.packt.webstore.domain.Student;
import com.packt.webstore.domain.Supervisor;

public interface StudentService {
public Student getStudentById(int id) ;
public List<Student> getStudents();
public abstract Supervisor getStudentSupervisor(int studentId);
public boolean registerStudent(int studentId, String studentName, String studentEmail, String department);
public Student getStudentByEmail(String userEmail);
}
