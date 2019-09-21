package com.packt.webstore.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestWrapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.packt.webstore.domain.Student;
import com.packt.webstore.service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {
	@Autowired
	private StudentService studentService;

	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public String studentsPage(Model model, Principal principal) {
		String userEmail = principal.getName() ;
		System.out.println(principal.toString());
		Student student = studentService.getStudentByEmail(userEmail);
		model.addAttribute("student",student);
		return getFullViewName("profile");
	}

	public String getFullViewName(String viewName) {
		return "student/" + viewName;
	}
}