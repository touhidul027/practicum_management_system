package com.packt.webstore.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.packt.webstore.domain.Student;
import com.packt.webstore.service.StudentService;

@RestController
@RequestMapping("/rest/student")
public class StudentRestController {
	@Autowired
	private StudentService studentService;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Student getStudentById(Model model, @PathVariable(value = "id") String id) {
		return studentService.getStudentById(Integer.parseInt(id));
	}

	@RequestMapping(value="/all",method = RequestMethod.GET)
	public List<Student> getStudents(){
		return studentService.getStudents();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody Student add(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String studentId = request.getParameter("studentId");
		System.out.println("invoked.");
		return studentService.getStudentById(Integer.parseInt(studentId));
	}
}
