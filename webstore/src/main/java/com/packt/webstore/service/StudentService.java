package com.packt.webstore.service;

import java.util.List;

import com.packt.webstore.domain.Student;
import com.packt.webstore.domain.Supervisor;

public interface StudentService {
public Student getStudentById(int id) ;
public List<Student> getStudents();
public abstract Supervisor getStudentSupervisor(int studentId);
}
