package com.packt.webstore.service.impl;

import com.packt.webstore.domain.Student;
import com.packt.webstore.domain.repository.StudentRepository;
import com.packt.webstore.domain.repository.impl.StudentRepositoryImpl;
import com.packt.webstore.service.DeptAdminService;

public class DeptAdminServiceImpl  implements DeptAdminService{

	@Override
	public Student getStudent(int id) {
		// call respected repository
		StudentRepository studentRepository=new StudentRepositoryImpl();
		return studentRepository.getStudent(15103199);
	}

}
