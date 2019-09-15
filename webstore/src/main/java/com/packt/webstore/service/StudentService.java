package com.packt.webstore.service;

import java.util.List;

import com.packt.webstore.domain.Student;

public interface StudentService {
public Student getStudentById(int id) ;
public List<Student> getStudents();
}
